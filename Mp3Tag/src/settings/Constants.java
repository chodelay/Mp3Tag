package settings;

public class Constants {

	public static String DELIMITER = "\\";

  public static void setOSConstants() {
  	if (System.getProperty("os.name").startsWith("Mac")) {
  		DELIMITER = "/";
  	}
  }
	
}
