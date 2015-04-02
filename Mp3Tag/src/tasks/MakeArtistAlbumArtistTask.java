package tasks;

import log.SystemOut;
import files.Mp3File;
import files.Mp3Folder;

public class MakeArtistAlbumArtistTask extends Task {
	
	public MakeArtistAlbumArtistTask(Mp3Folder f) {
		super(f);
		this.name = "Make Artist Equal Album Artist";
		this.description = "Changes the album artist tag to the value of the artist tag.";
	}
	
	protected void runTask() {
		super.runTask();
		for (Mp3File f : folder.getMp3Files()) {
			if (!f.getAlbumArtist().contentEquals(f.getArtist())) {
				SystemOut.printDebug("Setting artist " + f.getArtist() + " to album artist " + f.getAlbumArtist());
				f.setArtist(f.getAlbumArtist());
				f.writeToFile();
			}
		}
	}
	
}
