package com.cw.wizbank.scorm.dm.datatypes;

import com.cw.wizbank.scorm.dm.DMTypeValidator;
import com.cw.wizbank.scorm.dm.DMErrorCodes;

import java.io.Serializable;

/**
 * Provides support for the Smallest Permitted Maximum (SPM) value.
 */
public class SPMRangeValidator extends DMTypeValidator implements Serializable {
	/**
	 * Specifies the smallest permitted maximum allowed for a string.
	 */
	private int mSPM = -1;

	/**
	 * Default constructor required for serialization.
	 */
	public SPMRangeValidator() {
		mType = "characterstring";
	}

	/**
	 * Describes the smallest permitted maximum allowed for a string.
	 * 
	 * @param iSPM
	 *            Defines the initial SPM
	 */
	public SPMRangeValidator(int iSPM) {
		mSPM = iSPM;
		mType = "characterstring";
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
		String trunc = iValue;

		if (mSPM > 0 && iValue.length() > mSPM) {
			trunc = trunc.substring(0, mSPM);
		}

		return trunc;
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
	public int validate(String iValue) {
		// Assume the value is valid
		int valid = DMErrorCodes.NO_ERROR;

		if (iValue != null) {
			int spmLength = iValue.length();

			if (mSPM > -1) {
				if (spmLength > mSPM) {
					valid = DMErrorCodes.SPM_EXCEEDED;
				}
			}
		} else {
			// A null value can never be valid
			valid = DMErrorCodes.UNKNOWN_EXCEPTION;
		}

		return valid;
	}

}