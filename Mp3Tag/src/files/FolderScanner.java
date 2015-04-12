package files;

import java.io.File;

import tasks.TaskDecider;

public class FolderScanner {

	String path;
	File folder;
	
	public FolderScanner(File folder) {
		this.folder = folder;
		run();
	}
	
	private void run() {
		for (File f : folder.listFiles()) {
			if (f.isDirectory()) {
				new FolderScanner(f);
			} else if (f.getName().toLowerCase().endsWith("mp3")) {
				TaskDecider.createJobs(new Mp3Folder(f.getParent()));
			}
		}
	}
}
