package it.unitn.disi.zanshin.core.internal.services;

import it.unitn.disi.zanshin.core.CoreUtils;
import it.unitn.disi.zanshin.services.IModelManagementService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

/**
 * TODO: document this type.
 * 
 * @author Vitor E. Silva Souza (vitorsouza@gmail.com)
 * @version 1.0
 */
public class ModelManagementService implements IModelManagementService {
	/** Path for the generator file for the base packages eca, goalmodel and LTL. */
	private static final String BASE_GENMODEL_FILE_PATH = "it.unitn.disi.zanshin.core/META-INF/zanshin.genmodel"; //$NON-NLS-1$

	/** TODO: document this field. */
	private ResourceSet resourceSet;

	/** TODO: document this field. */
	private GenModel baseGenModel;

	/**
	 * TODO: document this method.
	 * 
	 * @throws IOException
	 * @throws CoreException 
	 */
	private void init() throws IOException, CoreException {
		CoreUtils.log.debug("Initializing Zanshin Model Management Service"); //$NON-NLS-1$

		// Initializes the ECore and GenModel models.
		EcorePackage.eINSTANCE.eClass();
		GenModelPackage.eINSTANCE.eClass();

		// Creates a resource set for this service.
		resourceSet = new ResourceSetImpl();
		resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());

		// Registers a factory for generator models.
		Resource.Factory.Registry registry = resourceSet.getResourceFactoryRegistry();
		Map<String, Object> m = registry.getExtensionToFactoryMap();
		m.put(IModelManagementService.GENMODEL_FILE_EXTENSION, new XMIResourceFactoryImpl());
		m.put(IModelManagementService.MODEL_FILE_EXTENSION, new XMIResourceFactoryImpl());

		// Loads Zanshin's generator model.
		URI genModelURI = URI.createPlatformPluginURI(BASE_GENMODEL_FILE_PATH, false);
		Resource baseGenModelResource = resourceSet.getResource(genModelURI, true);
		baseGenModelResource.load(Collections.EMPTY_MAP);

		// Obtains Zanshin's models from the generator model.
		baseGenModel = (GenModel) baseGenModelResource.getContents().get(0);
		for (GenPackage genPkg : baseGenModel.getGenPackages()) {
			EPackage ePkg = genPkg.getEcorePackage();

			// If it's a proxy, loads the proper package.
			if (ePkg.eIsProxy()) {
				URI modelURI = EcoreUtil.getURI(ePkg);
				Resource resource = readModel(modelURI);
				ePkg = (EPackage) resource.getContents().get(0);
			}
			String nsURI = ePkg.getNsURI();

			// Checks if the package is already registered. If not, registers the package globally.
			if (!EPackage.Registry.INSTANCE.containsKey(nsURI)) {
				CoreUtils.log.debug("Registering base model package {0} under the namespace: {1}", ePkg.getName(), nsURI); //$NON-NLS-1$
				resourceSet.getPackageRegistry().put(nsURI, ePkg);
			}
		}
		
		// Disables auto-build for model projects.
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceDescription description = workspace.getDescription();
		description.setAutoBuilding(false);
		workspace.setDescription(description);
	}

	/** @see it.unitn.disi.zanshin.services.IModelManagementService#createModelProject(java.lang.String) */
	@Override
	public IProject createModelProject(String projectName) throws CoreException {
		CoreUtils.log.debug("Creating a model project in the workspace: {0}", projectName); //$NON-NLS-1$
		IProgressMonitor monitor = new NullProgressMonitor();

		// Creates the reference to a project in the workspace for the target system.
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);

		// If the project exists, deletes it.
		if (project.exists())
			project.delete(true, true, monitor);

		// Creates a new project and opens it.
		project.create(monitor);
		project.open(monitor);

		// Creates the project's subfolders.
		for (String subdir : PROJECT_SUBDIRS) {
			IFolder folder = project.getFolder(subdir);
			folder.create(true, true, monitor);
		}

		// Adds the Java project nature to the project so we can compile classes later.
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = JavaCore.NATURE_ID;
		description.setNatureIds(newNatures);
		project.setDescription(description, monitor);

		// Sets the classpath of the Java project so we can compile classes later.
		IJavaProject javaProject = JavaCore.create(project);
		IClasspathEntry[] classpath = new IClasspathEntry[1];
		
		// Adds the source folder to the classpath.
		IFolder sourceFolder = project.getFolder(SOURCES_PROJECT_SUBDIR);
		classpath[0] = JavaCore.newSourceEntry(sourceFolder.getFullPath());
		javaProject.setRawClasspath(classpath, monitor);
		
		// Sets the project's classes folder, in which Java classes will be compiled.
		IFolder classesFolder = project.getFolder(CLASSES_PROJECT_SUBDIR);
		javaProject.setOutputLocation(classesFolder.getFullPath(), monitor);
		
		// Returns the created project.
		CoreUtils.log.info("Created model project {0} in location: {1}", projectName, project.getLocation()); //$NON-NLS-1$
		return project;
	}

	/**
	 * @see it.unitn.disi.zanshin.services.IModelManagementService#createModel(org.eclipse.core.resources.IProject,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public IFile createModel(IProject project, String modelName, String contents) throws CoreException {
		CoreUtils.log.debug("Creating a new model file in project {0} with name: {1}", project.getName(), modelName); //$NON-NLS-1$
		IProgressMonitor monitor = new NullProgressMonitor();

		// Creates the reference to the model file in the project.
		IFolder modelFolder = project.getFolder(MODELS_PROJECT_SUBDIR);
		IFile modelFile = modelFolder.getFile(modelName);

		// If the file already exists, deletes it.
		if (modelFile.exists())
			modelFile.delete(true, monitor);

		// Creates a new file with the specified contents.
		InputStream inputStream = new ByteArrayInputStream(contents.getBytes());
		modelFile.create(inputStream, true, monitor);

		// Returns the file descriptor.
		CoreUtils.log.info("Created model file in project {0} in location: {1}", project.getName(), modelFile.getLocation()); //$NON-NLS-1$
		return modelFile;
	}

	/** @see it.unitn.disi.zanshin.services.IModelManagementService#readModel(org.eclipse.core.resources.IFile) */
	@Override
	public Resource readModel(IFile modelFile) throws IOException, CoreException {
		return readModel(URI.createURI(modelFile.getLocation().toString()));
	}

	/**
	 * TODO: document this method.
	 * 
	 * @param modelURI
	 * @return
	 * @throws IOException
	 * @throws CoreException 
	 */
	private Resource readModel(URI modelURI) throws IOException, CoreException {
		CoreUtils.log.debug("Reading a model from location: {0}", modelURI); //$NON-NLS-1$

		// If the service's resource set has not been initialized yet, initializes it now.
		if (resourceSet == null)
			init();

		// Loads the model file as a resource and returns.
		return resourceSet.getResource(modelURI, true);
	}

	/**
	 * @see it.unitn.disi.zanshin.services.IModelManagementService#createGenModelFile(org.eclipse.emf.ecore.EPackage,
	 *      java.lang.String, java.lang.String, org.eclipse.core.resources.IFolder, org.eclipse.core.resources.IFolder)
	 */
	@Override
	public Resource createGenModelFile(IFile modelFile, String basePackage) throws IOException, CoreException {
		// If the service's resource set has not been initialized yet, initializes it now.
		if (resourceSet == null)
			init();

		CoreUtils.log.debug("Creating a generator model for {0} with base package: {1}", modelFile.getName(), basePackage); //$NON-NLS-1$

		// Retrieves the target dir (where the sources should be generated).
		IProject project = modelFile.getProject();
		IFolder targetDir = project.getFolder(SOURCES_PROJECT_SUBDIR);

		// Determines the paths and URIs.
		IPath ecorePath = modelFile.getLocation();
		IPath genModelPath = ecorePath.removeFileExtension().addFileExtension(GENMODEL_FILE_EXTENSION);
		URI ecoreURI = URI.createFileURI(ecorePath.toString());
		URI genModelURI = URI.createFileURI(genModelPath.toString());

		// Retrieves the model package.
		Resource resource = resourceSet.getResource(ecoreURI, true);
		EPackage ePackage = (EPackage) resource.getContents().get(0);

		// Initializes the generator model and its resource.
		Resource genModelResource = resourceSet.createResource(genModelURI);
		GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		genModelResource.getContents().add(genModel);
		resourceSet.getResources().add(genModelResource);

		// Indicates where the classes should be generated (uses file system path, not URI).
		genModel.setModelDirectory(targetDir.getFullPath().toString());

		// Indicates the name of the model file whose classes should be generated.
		String modelFileName = ePackage.eResource().getURI().lastSegment();
		genModel.getForeignModel().add(modelFileName);

		// Finishes the generator model configuration (model name, base package).
		genModel.initialize(Collections.singleton(ePackage));
		genModel.setModelName(genModelURI.trimFileExtension().lastSegment());
		GenPackage genPackage = genModel.getGenPackages().get(0);
		genPackage.setBasePackage(basePackage);

		// Adds a reference to the base generator model for Zanshin.
		for (GenPackage pkg : baseGenModel.getGenPackages())
			genModel.getUsedGenPackages().add(pkg);

		// Generates the genmodel file and returns.
		genModelResource.save(Collections.EMPTY_MAP);
		CoreUtils.log.info("Generator model created in location: {0}", genModelPath); //$NON-NLS-1$
		CoreUtils.log.info("Generator model should generate files in the following location: {0}", targetDir.getLocation()); //$NON-NLS-1$
		return genModelResource;
	}

	/**
	 * @see it.unitn.disi.zanshin.services.IModelManagementService#generateClasses(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.emf.ecore.resource.Resource)
	 */
	@Override
	public void generateClasses(Resource genModelResource) {
		CoreUtils.log.debug("Generating classes from generator model..."); //$NON-NLS-1$
		IProgressMonitor monitor = new NullProgressMonitor();

		// Retrieves the genmodel object from the genmodel resource and checks that it's valid.
		GenModel genModel = (GenModel) genModelResource.getContents().get(0);
		IStatus status = genModel.validate();
		if (!status.isOK()) {
			Diagnostic diagnostic = genModel.diagnose();
			throw new IllegalStateException("Genmodel file is not valid. Diagnostic message is: " + diagnostic.getMessage()); //$NON-NLS-1$
		}

		// Creates a generator from the genmodel file and configures the generation.
		Generator generator = new Generator();
		generator.setInput(genModel);
		genModel.setForceOverwrite(true);
		genModel.reconcile();
		genModel.setCanGenerate(true);
		genModel.setValidateModel(true);
		genModel.setUpdateClasspath(false);
		genModel.setCodeFormatting(true);

		// Generates the source code following the instructions contained in the genmodel file.
		generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, CodeGenUtil.EclipseUtil.createMonitor(monitor, 1));
		CoreUtils.log.info("Source files for model classes generated in the location specified in the generator model."); //$NON-NLS-1$
	}
}
