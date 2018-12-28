package com.cw.wizbank.scorm.dm;

import java.io.Serializable;
import java.util.Vector;

/**
 * DMTypeValidator
 */
public abstract class DMTypeValidator implements Serializable {

	/**
	 * Describes the data type being validated.
	 */
	protected String mType = null;

	/**
	 * Compares two valid data model elements for equality.
	 * 
	 * @param iFirst
	 *            The first value being compared.
	 * 
	 * @param iSecond
	 *            The second value being compared.
	 * 
	 * @param iDelimiters
	 *            The common set of delimiters associated with the values being
	 *            compared.
	 * 
	 * @return Returns <code>true</code> if the two values are equal, otherwise
	 *         <code>false</code>.
	 */
	public boolean compare(String iFirst, String iSecond, Vector iDelimiters) {
		boolean equal = true;

		if (iFirst == null || iSecond == null) {
			equal = false;
		} else {
			equal = iFirst.equals(iSecond);
		}

		return equal;
	}

	/**
	 * Provides a human-readable description of the type.
	 * 
	 * @return Returns a <code>String</code> that describes the data type being
	 *         validated.
	 */
	public String getTypeName() {
		return mType;
	}

	/**
	 * Truncates the value to meet the DataType's SPM
	 * 
	 * @param iValue
	 *            The value to be truncated
	 * 
	 * @return Returns the value truncated at the DataType's SPM
	 */
	public String trunc(String iValue) {
		return iValue;
	}

	/**
	 * Validates the provided string against a known format.
	 * 
	 * @param iValue
	 *            The value being validated.
	 * 
	 * @return An abstract data model error code indicating the result of this
	 *         operation.
	 */
	public abstract int validate(String iValue);

}
