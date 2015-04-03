package tasks;

import java.io.File;
import java.util.ArrayList;

import files.Mp3File;
import files.Mp3Folder;

public class FolderScannerTask extends Task {
	
	public FolderScannerTask(Mp3Folder f) {
		super(f);
		this.name = "Remove Junk";
		this.description = "Removes track total, disc total and comment from tags.";
	}
	
	protected void runTask() {
		super.runTask();
		for (Mp3File f : folder.getMp3Files()) {
			f.setComment("");
			f.setTrackTotal("");
			f.setDiscTotal("");
			f.writeToFile();
		}
	}


	
}
