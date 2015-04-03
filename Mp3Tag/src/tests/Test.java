package tests;

import files.*;
import settings.Settings;
import tasks.MoveToLandingTask;
import tasks.RemoveJunkTask;
import tasks.Task;

public class Test {
	
	public static void main(String[] args) {
		Mp3Folder f = new Mp3Folder(Settings.SCAN_DIRECTORY);
		
		Task t = new RemoveJunkTask(f);
		t.run();
		
		Task t3 = new MoveToLandingTask(f);
		t3.run();
	}
	
}