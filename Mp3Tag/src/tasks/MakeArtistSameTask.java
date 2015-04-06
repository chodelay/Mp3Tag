package tasks;

import log.SystemOut;
import files.Mp3File;
import files.Mp3Folder;

public class MakeArtistSameTask extends Task {
	
	public MakeArtistSameTask(Mp3Folder f) {
		super(f);
		this.name = "Make Album Artist Equal Artist";
		this.description = "Changes the album artist tag to the value of the artist tag.";
	}
	
	protected void runTask() {
		super.runTask();
		String albumArtist = folder.getAlbumArtist();
		for (Mp3File f : folder.getMp3Files()) {
			SystemOut.printDebug("Setting artist: " + folder.getArtist());
			f.setArtist(folder.getArtist());
			f.writeToFile();
		}
	}
}
