/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package it.unitn.disi.zanshin.model.eca;

import it.unitn.disi.zanshin.model.gore.AggregationLevel;
import it.unitn.disi.zanshin.model.gore.Requirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relax Replace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.unitn.disi.zanshin.model.eca.RelaxReplace#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link it.unitn.disi.zanshin.model.eca.RelaxReplace#getCopy <em>Copy</em>}</li>
 *   <li>{@link it.unitn.disi.zanshin.model.eca.RelaxReplace#getLevel <em>Level</em>}</li>
 *   <li>{@link it.unitn.disi.zanshin.model.eca.RelaxReplace#getNewRequirement <em>New Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.unitn.disi.zanshin.model.eca.EcaPackage#getRelaxReplace()
 * @model
 * @generated
 */
public interface RelaxReplace extends AdaptationStrategy {
	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement</em>' reference.
	 * @see #setRequirement(Requirement)
	 * @see it.unitn.disi.zanshin.model.eca.EcaPackage#getRelaxReplace_Requirement()
	 * @model
	 * @generated
	 */
	Requirement getRequirement();

	/**
	 * Sets the value of the '{@link it.unitn.disi.zanshin.model.eca.RelaxReplace#getRequirement <em>Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' reference.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(Requirement value);

	/**
	 * Returns the value of the '<em><b>Copy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copy</em>' attribute.
	 * @see #setCopy(Boolean)
	 * @see it.unitn.disi.zanshin.model.eca.EcaPackage#getRelaxReplace_Copy()
	 * @model
	 * @generated
	 */
	Boolean getCopy();

	/**
	 * Sets the value of the '{@link it.unitn.disi.zanshin.model.eca.RelaxReplace#getCopy <em>Copy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Copy</em>' attribute.
	 * @see #getCopy()
	 * @generated
	 */
	void setCopy(Boolean value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The literals are from the enumeration {@link it.unitn.disi.zanshin.model.gore.AggregationLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see it.unitn.disi.zanshin.model.gore.AggregationLevel
	 * @see #setLevel(AggregationLevel)
	 * @see it.unitn.disi.zanshin.model.eca.EcaPackage#getRelaxReplace_Level()
	 * @model
	 * @generated
	 */
	AggregationLevel getLevel();

	/**
	 * Sets the value of the '{@link it.unitn.disi.zanshin.model.eca.RelaxReplace#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see it.unitn.disi.zanshin.model.gore.AggregationLevel
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(AggregationLevel value);

	/**
	 * Returns the value of the '<em><b>New Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Requirement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Requirement</em>' reference.
	 * @see #setNewRequirement(Requirement)
	 * @see it.unitn.disi.zanshin.model.eca.EcaPackage#getRelaxReplace_NewRequirement()
	 * @model
	 * @generated
	 */
	Requirement getNewRequirement();

	/**
	 * Sets the value of the '{@link it.unitn.disi.zanshin.model.eca.RelaxReplace#getNewRequirement <em>New Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Requirement</em>' reference.
	 * @see #getNewRequirement()
	 * @generated
	 */
	void setNewRequirement(Requirement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='String strategyName = getClass().getInterfaces()[0].getSimpleName();\n\n// Obtains a reference to the target system\'s controller and checks if it exists (if it has been registered).\nit.unitn.disi.zanshin.services.ITargetSystemControllerService controller = it.unitn.disi.zanshin.core.Activator.getControllerService();\nif (controller == null) {\n\tit.unitn.disi.zanshin.core.CoreUtils.log.warn(\"Attempting to apply {0}, but the target system\'s controller has not yet been registered!\", strategyName); //$NON-NLS-1$\n\treturn;\n}\n\n// Retrieve the strategy\'s attributes.\nit.unitn.disi.zanshin.model.eca.EcaAwReq awreq = getAwReq();\n\n// Attribute requirement defaults to the AwReq\'s target.\nif (requirement == null) {\n\tsetRequirement(awreq.getTarget());\n\tif (requirement == null) {\n\t\tit.unitn.disi.zanshin.core.CoreUtils.log.warn(\"Strategy {0} is missing mandatory attribute \\\"requirement\\\" and cannot be executed. Cannot use the default value because the referred AwReq doesn\'t have a target set.\", strategyName); //$NON-NLS-1$\n\t\treturn;\n\t}\n}\n\n// Attribute copy defaults to TRUE.\nif (copy == null) copy = Boolean.TRUE;\n\n// Attribute level defaults to INSTANCE.\nif (level == null) level = it.unitn.disi.zanshin.model.gore.AggregationLevel.INSTANCE;\n\n// Attribute newRequirement is mandatory.\nif (newRequirement == null) {\n\tit.unitn.disi.zanshin.core.CoreUtils.log.warn(\"Strategy {0} is missing mandatory attribute \\\"newRequirement\\\" and cannot be executed.\", strategyName); //$NON-NLS-1$\n\treturn;\n}\n\n// Executes the Relax by Replacing strategy.\nstrategyName += \"(\" + requirement.eClass().getName() + \"; \" + copy + \"; \" + level + \"; \" + newRequirement.eClass().getName() + \")\"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$\nit.unitn.disi.zanshin.core.CoreUtils.log.info(\"{0} Applying strategy {1}...\", session.getId(), strategyName); //$NON-NLS-1$\nif ((level == it.unitn.disi.zanshin.model.gore.AggregationLevel.CLASS) || (level == it.unitn.disi.zanshin.model.gore.AggregationLevel.BOTH)) {\n\tcontroller.disable(requirement.eClass());\n\tcontroller.enable(newRequirement.eClass());\n}\nif ((level == it.unitn.disi.zanshin.model.gore.AggregationLevel.INSTANCE) || (level == it.unitn.disi.zanshin.model.gore.AggregationLevel.BOTH)) {\n\tif ((copy) && (requirement instanceof it.unitn.disi.zanshin.model.gore.PerformativeRequirement) && (newRequirement instanceof it.unitn.disi.zanshin.model.gore.PerformativeRequirement)) \n\t\tcontroller.copyData((it.unitn.disi.zanshin.model.gore.PerformativeRequirement) requirement, (it.unitn.disi.zanshin.model.gore.PerformativeRequirement) newRequirement);\n\tcontroller.terminate(requirement);\n\tif (requirement instanceof it.unitn.disi.zanshin.model.gore.PerformativeRequirement)\n\t\tcontroller.rollback((it.unitn.disi.zanshin.model.gore.PerformativeRequirement) requirement);\n\tcontroller.initiate(newRequirement);\n}'"
	 * @generated
	 */
	void execute(AdaptationSession session);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// This method is not supposed to be called.\nit.unitn.disi.zanshin.core.CoreUtils.log.debug(\"Method AdaptationStrategyImpl.updateReferences() has been called, indicating it has not been overridden by the subclass {0}. Make sure this is on purpose...\", eClass().getName()); //$NON-NLS-1$'"
	 * @generated
	 */
	void updateReferences();

} // RelaxReplace
