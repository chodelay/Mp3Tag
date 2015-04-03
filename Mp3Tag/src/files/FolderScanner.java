package files;

import java.io.File;

public class FolderScanner {

	public FolderScanner(File folder) {
		for (File f : folder.listFiles()) {
			if (f.isDirectory()) {
				new FolderScanner(f);
			} else if (new Mp3Folder(f.getAbsolutePath()).hasMp3Files) {
				//add Mp3folder to queue
			}
		}
	}
	
}
