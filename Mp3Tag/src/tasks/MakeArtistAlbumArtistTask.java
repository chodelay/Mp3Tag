package tasks;

import java.io.File;
import java.util.ArrayList;

import files.Mp3File;
import files.Mp3Folder;

public class MakeArtistAlbumArtistTask extends Task {
	
	public MakeArtistAlbumArtistTask(Mp3Folder f) {
		super(f);
		this.name = "Make Arist Equal Album Artist";
		this.description = "Changes the album artist tag to the value of the artist tag.";
	}
	
	protected void runTask() {
		super.runTask();
		for (Mp3File f : folder.getMp3Files()) {
			f.setArtist(f.getAlbumArtist());
			f.writeToFile();
		}
	}
	
}
