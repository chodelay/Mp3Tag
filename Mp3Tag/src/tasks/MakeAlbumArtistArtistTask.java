package tasks;

import java.io.File;
import java.util.ArrayList;

import files.Mp3File;
import files.Mp3Folder;

public class MakeAlbumArtistArtistTask extends Task {
	
	public MakeAlbumArtistArtistTask(Mp3Folder f) {
		super(f);
		this.name = "Make Album Artist Equal Artist";
		this.description = "Changes the album artist tag to the value of the artist tag.";
	}
	
	protected void runTask() {
		super.runTask();
		for (Mp3File f : folder.getMp3Files()) {
			f.setAlbumArtist(f.getArtist());
			f.writeToFile();
		}
	}
	
}
