package cmupdaterapp.utils;

import cmupdaterapp.misc.Log;

public class StringUtils
{
	private static final String TAG = "StringUtils";
	
	/**
	 * Compare two versions. Will strip off any alphabets in the version number
	 * and then do a number comparison
	 * 
	 * @param newVersion
	 *            new version to be compared
	 * @param oldVersion
	 *            old version to be compared
	 * @return true if newVersion is greater then oldVersion,
	 * false on exceptions or newVersion=oldVersion and newVersion is lower then oldVersion
	 */
	public static boolean compareVersions(String newVersion, String oldVersion)
	{
		String sNewVersion = newVersion.replaceAll("[^0-9]", "");
		String sOldVersion = oldVersion.replaceAll("[^0-9]", "");
		Log.d(TAG, "sNewVersion:"+sNewVersion+":::sOldVersion:"+sOldVersion);
		long lNewVersion;
		long lOldVersion;
		try
		{
			lNewVersion = Long.parseLong(sNewVersion);
			lOldVersion = Long.parseLong(sOldVersion);
		}
		catch(NumberFormatException ex)
		{
			Log.e(TAG, "Exception on Parsing Version String. newVersion: "+newVersion+" oldVersion: "+oldVersion);
			return false;
		}
		if (lNewVersion == lOldVersion)
			return false;
		else if (lNewVersion > lOldVersion)
			return true;
		else
			return false;
	}
}