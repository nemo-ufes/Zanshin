/**
 */
package it.unitn.disi.zanshin.model.gore.impl;

import it.unitn.disi.zanshin.model.gore.DomainAssumption;
import it.unitn.disi.zanshin.model.gore.GOREElement;
import it.unitn.disi.zanshin.model.gore.GoalOrientedRequirement;
import it.unitn.disi.zanshin.model.gore.GorePackage;
import it.unitn.disi.zanshin.model.gore.RefinementType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal Oriented Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.unitn.disi.zanshin.model.gore.impl.GoalOrientedRequirementImpl#getAssumptions <em>Assumptions</em>}</li>
 *   <li>{@link it.unitn.disi.zanshin.model.gore.impl.GoalOrientedRequirementImpl#getRefinementType <em>Refinement Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GoalOrientedRequirementImpl extends GOREElementImpl implements GoalOrientedRequirement {
	/**
	 * The cached value of the '{@link #getAssumptions() <em>Assumptions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssumptions()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainAssumption> assumptions;

	/**
	 * The default value of the '{@link #getRefinementType() <em>Refinement Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinementType()
	 * @generated
	 * @ordered
	 */
	protected static final RefinementType REFINEMENT_TYPE_EDEFAULT = RefinementType.AND;

	/**
	 * The cached value of the '{@link #getRefinementType() <em>Refinement Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefinementType()
	 * @generated
	 * @ordered
	 */
	protected RefinementType refinementType = REFINEMENT_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GoalOrientedRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GorePackage.Literals.GOAL_ORIENTED_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DomainAssumption> getAssumptions() {
		if (assumptions == null) {
			assumptions = new EObjectResolvingEList<DomainAssumption>(DomainAssumption.class, this, GorePackage.GOAL_ORIENTED_REQUIREMENT__ASSUMPTIONS);
		}
		return assumptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefinementType getRefinementType() {
		return refinementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinementType(RefinementType newRefinementType) {
		RefinementType oldRefinementType = refinementType;
		refinementType = newRefinementType == null ? REFINEMENT_TYPE_EDEFAULT : newRefinementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GorePackage.GOAL_ORIENTED_REQUIREMENT__REFINEMENT_TYPE, oldRefinementType, refinementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GOREElement> getChildren() {
		EList<GOREElement> children = new org.eclipse.emf.common.util.BasicEList<>();
		EList<AwReq> awreqs = super.getAwreqs();
		EList<DomainAssumption> domainAssumptions = this.getAssumptions();
						
		for(GOREElement child : awreqs){
			children.add(child);
		}
						
		for(GOREElement child : domainAssumptions){
			children.add(child);
		}
						
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GorePackage.GOAL_ORIENTED_REQUIREMENT__ASSUMPTIONS:
				return getAssumptions();
			case GorePackage.GOAL_ORIENTED_REQUIREMENT__REFINEMENT_TYPE:
				return getRefinementType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GorePackage.GOAL_ORIENTED_REQUIREMENT__ASSUMPTIONS:
				getAssumptions().clear();
				getAssumptions().addAll((Collection<? extends DomainAssumption>)newValue);
				return;
			case GorePackage.GOAL_ORIENTED_REQUIREMENT__REFINEMENT_TYPE:
				setRefinementType((RefinementType)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GorePackage.GOAL_ORIENTED_REQUIREMENT__ASSUMPTIONS:
				getAssumptions().clear();
				return;
			case GorePackage.GOAL_ORIENTED_REQUIREMENT__REFINEMENT_TYPE:
				setRefinementType(REFINEMENT_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GorePackage.GOAL_ORIENTED_REQUIREMENT__ASSUMPTIONS:
				return assumptions != null && !assumptions.isEmpty();
			case GorePackage.GOAL_ORIENTED_REQUIREMENT__REFINEMENT_TYPE:
				return refinementType != REFINEMENT_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (refinementType: ");
		result.append(refinementType);
		result.append(')');
		return result.toString();
	}

} //GoalOrientedRequirementImpl
