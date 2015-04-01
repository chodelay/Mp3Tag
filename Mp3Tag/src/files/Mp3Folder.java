package files;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

public class Mp3Folder extends File {

	private static final long serialVersionUID = 1L;
	
	ArrayList<Mp3File> Mp3Files;
	int numberOfMp3Files;

	public Mp3Folder(URI path) {
		super(path);
		loadFolder(this);
	}
	
	private void loadFolder(File folder) {
		if (folder.exists() && folder.isDirectory()) {
			Mp3Files = new ArrayList<Mp3File>();
			
			for (int i = 0; i < folder.listFiles().length; i++) {
				File tempFile = new File(folder.list()[i]);
				if (tempFile.getName().endsWith("mp3")) {
					Mp3Files.add(new Mp3File(tempFile));
				}
			}
			
			numberOfMp3Files = Mp3Files.size();
			
		} else {
			//log failure
		}
	}
	
}
