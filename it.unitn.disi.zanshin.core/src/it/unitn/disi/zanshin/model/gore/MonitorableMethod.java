/**
 */
package it.unitn.disi.zanshin.model.gore;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Monitorable Method</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see it.unitn.disi.zanshin.model.gore.GorePackage#getMonitorableMethod()
 * @model
 * @generated
 */
public enum MonitorableMethod implements Enumerator {
	/**
	 * The '<em><b>START</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_VALUE
	 * @generated
	 * @ordered
	 */
	START(0, "START", "start"),

	/**
	 * The '<em><b>END</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #END_VALUE
	 * @generated
	 * @ordered
	 */
	END(1, "END", "end"),

	/**
	 * The '<em><b>SUCCESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUCCESS_VALUE
	 * @generated
	 * @ordered
	 */
	SUCCESS(2, "SUCCESS", "success"),

	/**
	 * The '<em><b>FAIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAIL_VALUE
	 * @generated
	 * @ordered
	 */
	FAIL(3, "FAIL", "fail"),

	/**
	 * The '<em><b>CANCEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CANCEL_VALUE
	 * @generated
	 * @ordered
	 */
	CANCEL(4, "CANCEL", "cancel");

	/**
	 * The '<em><b>START</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>START</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #START
	 * @model literal="start"
	 * @generated
	 * @ordered
	 */
	public static final int START_VALUE = 0;

	/**
	 * The '<em><b>END</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>END</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #END
	 * @model literal="end"
	 * @generated
	 * @ordered
	 */
	public static final int END_VALUE = 1;

	/**
	 * The '<em><b>SUCCESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUCCESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUCCESS
	 * @model literal="success"
	 * @generated
	 * @ordered
	 */
	public static final int SUCCESS_VALUE = 2;

	/**
	 * The '<em><b>FAIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FAIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAIL
	 * @model literal="fail"
	 * @generated
	 * @ordered
	 */
	public static final int FAIL_VALUE = 3;

	/**
	 * The '<em><b>CANCEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CANCEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CANCEL
	 * @model literal="cancel"
	 * @generated
	 * @ordered
	 */
	public static final int CANCEL_VALUE = 4;

	/**
	 * An array of all the '<em><b>Monitorable Method</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MonitorableMethod[] VALUES_ARRAY =
		new MonitorableMethod[] {
			START,
			END,
			SUCCESS,
			FAIL,
			CANCEL,
		};

	/**
	 * A public read-only list of all the '<em><b>Monitorable Method</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MonitorableMethod> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Monitorable Method</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MonitorableMethod get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MonitorableMethod result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Monitorable Method</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MonitorableMethod getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MonitorableMethod result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Monitorable Method</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MonitorableMethod get(int value) {
		switch (value) {
			case START_VALUE: return START;
			case END_VALUE: return END;
			case SUCCESS_VALUE: return SUCCESS;
			case FAIL_VALUE: return FAIL;
			case CANCEL_VALUE: return CANCEL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private MonitorableMethod(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //MonitorableMethod
