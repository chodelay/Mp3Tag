package log;

import settings.Settings;


public class SystemOut {

	public static void printDebug(String string) {
		if (Settings.SYSTEMOUT_DEBUG) {
			System.out.println(string);
		}
	}
	
}
