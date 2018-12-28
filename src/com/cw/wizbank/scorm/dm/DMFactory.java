package com.cw.wizbank.scorm.dm;

import com.cw.wizbank.scorm.dm.SCORM_2004_DM;

/**
 * Factory pattern used to create datamodel objects based on a value passed in
 * during runtime
 */
public class DMFactory {
	/**
	 * Enumeration of the run-time data model's supported by the SCORM<br>
	 * <br>
	 * Unknown <br>
	 * <b>-1</b> <br>
	 * <br>
	 * [DATA MODEL IMPLEMENTATION CONSTANT]
	 */
	public static final int DM_UNKNOWN = -1;

	/**
	 * Enumeration of the run-time data model's supported by the SCORM<br>
	 * <br>
	 * SCORM 2004 Data Model <br>
	 * <b>1</b> <br>
	 * <br>
	 * [DATA MODEL IMPLEMENTATION CONSTANT]
	 */
	public static final int DM_SCORM_2004 = 1;

	/**
	 * Enumeration of the run-time data model's supported by the SCORM<br>
	 * <br>
	 * SCORM 2004 Navigation Data Model <br>
	 * <b>2</b> <br>
	 * <br>
	 * [DATA MODEL IMPLEMENTATION CONSTANT]
	 */
	public static final int DM_SCORM_NAV = 2;

	/**
	 * Builds the appropriate datamodel based on the type requested.
	 * 
	 * @param iType
	 *            enumerated type of datamodel element <br>
	 *            <ul>
	 *            <li>SCORM 2004 DM = 1</li>
	 *            <li>SCORM NAV = 2</li> <b>not implemented</b>
	 *            </ul>
	 * 
	 * @return The appropriate datamodel.
	 */
	public static DataModel createDM(int iType) {
		DataModel dm = null;

		switch (iType) {
		case DM_SCORM_2004: {
			dm = new SCORM_2004_DM();
			break;
		}
		case DM_SCORM_NAV: {
			//not implemented
			dm = null;
			break;
		}
		default: {
			// Do nothing -- error case
		}
		}
		return dm;
	}

}
