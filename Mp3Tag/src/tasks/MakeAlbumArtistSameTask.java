package tasks;

import log.SystemOut;
import files.Mp3File;
import files.Mp3Folder;

public class MakeAlbumArtistSameTask extends Task {
	
	public MakeAlbumArtistSameTask(Mp3Folder f) {
		super(f);
		this.name = "Make Album Artist Equal Artist";
		this.description = "Changes the album artist tag to the value of the artist tag.";
	}
	
	protected void runTask() {
		super.runTask();
		String albumArtist = folder.getAlbumArtist();
		for (Mp3File f : folder.getMp3Files()) {
			if (!f.getAlbumArtist().contentEquals(f.getArtist())) {
				SystemOut.printDebug("Setting album artist " + f.getAlbumArtist() + " to artist " + f.getArtist());
				f.setAlbumArtist(f.getArtist());
				f.writeToFile();
			}
		}
	}
}
