package files;

import log.SystemOut;
import files.Mp3File;

public class Classifier {
	
	boolean hasAllArtistTags;			boolean hasAllAlbumArtistTags;
	boolean hasAllAlbumTags;			boolean hasAllTrackTags;
	boolean hasAllYearTags;				boolean hasAllGenreTags;

	boolean hasAnyArtistTags;			boolean hasAnyAlbumArtistTags;
	boolean hasAnyAlbumTags;			boolean hasAnyTrackTags;
	boolean hasAnyYearTags;				boolean hasAnyGenreTags;
	

	
	public Classifier(Mp3Folder f) {
		hasAllArtistTags = hasAllArtistTags(f);
		hasAllAlbumArtistTags = hasAllAlbumArtistTags(f);
		hasAllAlbumTags = hasAllAlbumTags(f);
		hasAllTrackTags = hasAllTrackTags(f);
		hasAllYearTags = hasAllYearTags(f);
		hasAllGenreTags = hasAllGenreTags(f);
		hasAnyArtistTags = hasAnyArtistTags(f);
		hasAnyAlbumArtistTags = hasAnyAlbumArtistTags(f);
		hasAnyAlbumTags = hasAnyAlbumTags(f);
		hasAnyTrackTags = hasAnyTrackTags(f);
		hasAnyYearTags = hasAnyYearTags(f);
		hasAnyGenreTags = hasAnyGenreTags(f);
	}

	public boolean hasAllArtistTags(Mp3Folder folder) {
		for (Mp3File f : folder.getMp3Files()) {
		  if (f.getArtist().isEmpty()) {
		    SystemOut.printDebug(f.getName() + " has no artist tag.");
		    return false;
		  }
		}
		return true;
	}

	public boolean hasAllAlbumArtistTags(Mp3Folder folder) {
    for (Mp3File f : folder.getMp3Files()) {
      if (f.getAlbumArtist().isEmpty()) {
        SystemOut.printDebug(f.getName() + " has no album artist tag.");
        return false;
      }
    }
    return true;
	}
		
	public boolean hasAllAlbumTags(Mp3Folder folder) {
		for (int i = 0; i < folder.getNumberOfFiles(); i++) {
			Mp3File f = folder.getMp3Files().get(i);
			if (f.getArtist().contentEquals("")) {
			  SystemOut.printDebug(f.getName() + " has no album tag.");
				return false;
			}
		}
		return true;
	}
	
	public boolean hasAllTrackTags(Mp3Folder folder) {
		for (int i = 0; i < folder.getNumberOfFiles(); i++) {
			Mp3File f = folder.getMp3Files().get(i);
			if (f.getTrack().contentEquals("")) {
			  SystemOut.printDebug(f.getName() + " has no track tag.");
				return false;
			}
		}
		return true;
	}
	
	public boolean hasAllYearTags(Mp3Folder folder) {
		for (int i = 0; i < folder.getNumberOfFiles(); i++) {
			Mp3File f = folder.getMp3Files().get(i);
			if (f.getYear().contentEquals("")) {
			  SystemOut.printDebug(f.getName() + " has no year tag.");
				return false;
			}
		}
		return true;
	}	
	
	public boolean hasAllGenreTags(Mp3Folder folder) {
		for (int i = 0; i < folder.getNumberOfFiles(); i++) {
			Mp3File f = folder.getMp3Files().get(i);
			if (f.getGenre().contentEquals("")) {
			  SystemOut.printDebug(f.getName() + " has no genre tag.");
				return false;
			}
		}
		return true;
	}
	
	public boolean hasAnyArtistTags(Mp3Folder folder) {
		for (Mp3File f : folder.getMp3Files()) {
		  if (!f.getArtist().isEmpty()) {
		    SystemOut.printDebug(f.getName() + " has an artist tag.");
		    return true;
		  }
		}
		return false;
	}

	public boolean hasAnyAlbumArtistTags(Mp3Folder folder) {
    for (Mp3File f : folder.getMp3Files()) {
      if (!f.getAlbumArtist().isEmpty()) {
        SystemOut.printDebug(f.getName() + " has no album artist tag.");
		    return true;
		  }
		}
		return false;
	}
		
	public boolean hasAnyAlbumTags(Mp3Folder folder) {
		for (int i = 0; i < folder.getNumberOfFiles(); i++) {
			Mp3File f = folder.getMp3Files().get(i);
			if (!f.getArtist().contentEquals("")) {
			  SystemOut.printDebug(f.getName() + " has no album tag.");
		    return true;
		  }
		}
		return false;
	}
	
	public boolean hasAnyTrackTags(Mp3Folder folder) {
		for (int i = 0; i < folder.getNumberOfFiles(); i++) {
			Mp3File f = folder.getMp3Files().get(i);
			if (!f.getTrack().contentEquals("")) {
			  SystemOut.printDebug(f.getName() + " has no track tag.");
		    return true;
		  }
		}
		return false;
	}
	
	public boolean hasAnyYearTags(Mp3Folder folder) {
		for (int i = 0; i < folder.getNumberOfFiles(); i++) {
			Mp3File f = folder.getMp3Files().get(i);
			if (!f.getYear().contentEquals("")) {
			  SystemOut.printDebug(f.getName() + " has no year tag.");
		    return true;
		  }
		}
		return false;
	}	
	
	public boolean hasAnyGenreTags(Mp3Folder folder) {
		for (int i = 0; i < folder.getNumberOfFiles(); i++) {
			Mp3File f = folder.getMp3Files().get(i);
			if (!f.getGenre().contentEquals("")) {
			  SystemOut.printDebug(f.getName() + " has no genre tag.");
		    return true;
		  }
		}
		return false;
	}

	
	
	
	public boolean isCompilation(Mp3Folder folder) {
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
	
	public boolean isComplete(Mp3Folder folder) {
		//TODO: iterate over and mark track numbers or find "incomplete" tag
		int numberOfFiles = folder.getNumberOfFiles();
		return false;
	}
	
	
	
}
