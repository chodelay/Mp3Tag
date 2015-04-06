package tests;

import java.io.File;
import java.io.FileNotFoundException;

import log.SystemOut;
import files.*;
import schedule.Scheduler;
import settings.Constants;
import settings.Settings;

public class Test {
	
	static boolean exit = false;
	
	public static void main(String[] args) {
		// LOAD SETTINGS FILE
		try {
			Settings.initializeSettings();
		} catch (FileNotFoundException e) {
			SystemOut.printDebug("Settings file not found. Terminating.");
			exit = true;
		}
		
		Constants.setOSConstants();
		
		// Scan Scan Directory and Subdirectories
		if (!exit) {
			FolderScanner fs = new FolderScanner(new File(Settings.SCAN_DIRECTORY));
		}
		
		while (Scheduler.hasTasks()) {
			Scheduler.runTasks();
		}
	}
	
}
