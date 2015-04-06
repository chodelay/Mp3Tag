package settings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Settings {

	public static final boolean SYSTEMOUT_DEBUG = true;

	public static String SCAN_DIRECTORY = "C:\\Users\\cho\\Downloads\\Seek\\The Avalanche";
	public static String LANDING_DIRECTORY = "C:\\Users\\cho\\Downloads\\Music To Copy";

	public static void initializeSettings() throws FileNotFoundException {
		if (System.getProperty("os.name").startsWith("Mac")) {
			Scanner fs = new Scanner(new File("src/macsettings"));	
			SCAN_DIRECTORY = fs.next();
			LANDING_DIRECTORY = fs.next();
		}
	}
}
