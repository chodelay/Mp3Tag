package tasks;

import java.io.File;
import log.SystemOut;
import settings.Settings;
import files.Mp3File;
import files.Mp3Folder;

public class MoveToLandingTask extends Task {
	
	public MoveToLandingTask(Mp3Folder f) {
		super(f);
		this.name = "Move To Landing";
		this.description = "Moves processed files to landing directory.";
	}
	
	protected void runTask() {
		super.runTask();
		
		String landingDirectory = Settings.LANDING_DIRECTORY;
		if (!(new File(landingDirectory+"\\"+folder.getAlbumArtist()).exists())) {
			new File(landingDirectory+"\\"+folder.getAlbumArtist()).mkdir();
		}
		if (!(new File(landingDirectory+"\\"+folder.getAlbumArtist()+"\\"+folder.getAlbum()).exists())) {
			new File(landingDirectory+"\\"+folder.getAlbumArtist()+"\\"+folder.getAlbum()).mkdir();
		}
		
		String fullLandingDirectory = Settings.LANDING_DIRECTORY+"\\"+folder.getAlbumArtist()+"\\"+folder.getAlbum()+"\\";
		// Move files
		for (Mp3File f : folder.getMp3Files()) {
			f.renameTo(new File(fullLandingDirectory+f.getTrack()+" "+f.getTitle()+".mp3"));
			SystemOut.printDebug("Moving " + f.getAbsolutePath() + " to " + fullLandingDirectory+f.getTrack()+" "+f.getTitle()+".mp3");
		}
	}
	
}