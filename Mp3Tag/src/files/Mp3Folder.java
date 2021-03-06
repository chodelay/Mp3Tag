package files;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

public class Mp3Folder extends File {

	private static final long serialVersionUID = 1L;
	
	ArrayList<Mp3File> Mp3Files;
	int numberOfMp3Files;
	String path;
	
	String albumArtist;
	String artist;
	String album;
	
	public Mp3Folder(String string) {
		super(string);
		this.path = string;
		loadFolder(this);
		System.out.println("Generated Mp3 Folder from " + path);
	}
	
	private void loadFolder(File folder) {
		if (folder.exists() && folder.isDirectory()) {
			Mp3Files = new ArrayList<Mp3File>();
			
			for (File f : folder.listFiles()) {
				if (f.getName().toLowerCase().endsWith("mp3")) {
					Mp3Files.add(new Mp3File(f.getAbsolutePath()));
				}
			}
					
			numberOfMp3Files = Mp3Files.size();
			
		} else {
			//log failure
		}
	}
	
	public int getNumberOfFiles() {
		return numberOfMp3Files;
	}
	
	public ArrayList<Mp3File> getMp3Files() {
		return Mp3Files;
	}
	
}
