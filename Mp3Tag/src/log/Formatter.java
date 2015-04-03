package log;

public class Formatter {

  public static String padZeros(String string, int length) {
    while (string.length() < length) {
      string = "0" + string;
    }
    return string;
  }
  
}
