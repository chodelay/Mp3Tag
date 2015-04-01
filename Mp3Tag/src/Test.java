

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import ui.UserInterface;
import files.Mp3File;

public class Test {
	
	public static void main(String[] args) {
//		ArrayList<Mp3File> mp3Files = new ArrayList<Mp3File>();
//		Scanner scanner = new Scanner(System.in);
//		File folder = new File(scanner.nextLine());
//		
//		File[] files = folder.listFiles();
//		for (File file: files) {
//			if (file.getName().endsWith("mp3")) {
//				mp3Files.add(new Mp3File(file));
//			}
//		}
//		for (Mp3File mf: mp3Files) {
//			System.out.print(mf.getTrack() + " ");
//			System.out.println(mf.getTitle());
//		}
//		scanner.close();
		
		UserInterface ui = new UserInterface();
		ui.setEnabled(true);
	}
	
}
