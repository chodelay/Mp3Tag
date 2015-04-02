package files;

import log.SystemOut;

public class Classifier {

	public static boolean hasAllArtistTags(Mp3Folder folder) {
		for (int i = 0; i < folder.getNumberOfFiles(); i++) {
			Mp3File f = folder.getMp3Files().get(i);
			if (f.getArtist().contentEquals("")) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean hasAllAlbumArtistTags(Mp3Folder folder) {
		for (int i = 0; i < folder.getNumberOfFiles(); i++) {
			Mp3File f = folder.getMp3Files().get(i);
			if (f.getArtist().contentEquals("")) {
				return false;
			}
		}
		return true;
	}
	
//	public static boolean hasNoArtistTags(Mp3Folder folder) {
//		for (int i = 0; i < folder.getNumberOfFiles(); i++) {
//			Mp3File f = folder.getMp3Files().get(i);
//			if (f.getArtist().contentEquals("")) {
//				return false;
//			}
//		}
//		return true;
//	}
		
	public static boolean hasAllAlbumTags(Mp3Folder folder) {
		for (int i = 0; i < folder.getNumberOfFiles(); i++) {
			Mp3File f = folder.getMp3Files().get(i);
			if (f.getArtist().contentEquals("")) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isCompilation(Mp3Folder folder) {
		SystemOut.printDebug("Analysing " + folder.getAbsolutePath() + " to check if compilation");
		int certainty = 0;
		for (int i = 0; i < folder.getNumberOfFiles(); i++) {
			Mp3File f = folder.getMp3Files().get(i);
			if (f.getArtist().contentEquals(f.getAlbumArtist())) {
				certainty++;
			}
		}
		if (certainty <= folder.getNumberOfFiles()/3) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean isComplete(Mp3Folder folder) {
		//TODO: iterate over and mark track numbers or find "incomplete" tag
		int numberOfFiles = folder.getNumberOfFiles();
		return false;
	}
	
	
	
}
