package tasks;

import java.io.File;

import log.SystemOut;
import settings.Constants;
import settings.Settings;
import files.Mp3File;
import files.Mp3Folder;
import log.Formatter;

public class MoveToLandingTask extends Task {
	
	public MoveToLandingTask(Mp3Folder f) {
		super(f);
		this.name = "Move To Landing";
		this.description = "Moves processed files to landing directory.";
	}
	
	protected void runTask() {
		super.runTask();
		
		// Prepare directory variables
		String delimiter = Constants.DELIMITER;
		String landingDirectory = Settings.LANDING_DIRECTORY;
		if (System.getProperty("os.name").startsWith("Mac")) {
			delimiter = "/";
		}

		String fullLandingDirectory = Settings.LANDING_DIRECTORY+delimiter+folder.getAlbumArtist()+delimiter+folder.getAlbum()+delimiter;
	
		// Create album artist folder if doesn't exist
		if (!(new File(landingDirectory+delimiter+folder.getAlbumArtist()).exists())) {
			new File(landingDirectory+delimiter+folder.getAlbumArtist()).mkdir();
		}
		// Create album folder if doesn't exist
		if (!(new File(landingDirectory+delimiter+folder.getAlbumArtist()+delimiter+folder.getAlbum()).exists())) {
			new File(landingDirectory+delimiter+folder.getAlbumArtist()+delimiter+folder.getAlbum()).mkdir();
		}
			
		// Move files
		for (Mp3File f : folder.getMp3Files()) {
			f.renameTo(new File(fullLandingDirectory+Formatter.padZeros(f.getTrack(),2)+" "+f.getTitle()+".mp3"));
			SystemOut.printDebug("Moving " + f.getAbsolutePath() + " to\n"
			                   + fullLandingDirectory+Formatter.padZeros(f.getTrack(),2)+" "+f.getTitle()+".mp3");
		}
	}
	
	
}