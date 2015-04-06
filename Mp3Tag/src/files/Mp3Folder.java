package files;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

import log.SystemOut;

public class Mp3Folder extends File {

	private static final long serialVersionUID = 1L;
	
	ArrayList<Mp3File> Mp3Files;
	int numberOfMp3Files;
	String path;
	
	boolean isComplete;
	boolean isCompilation;
	boolean isProcessable;
	boolean hasMp3Files;
	
	public Classifier cl;
	
	String artist;
	String album;
	String albumArtist;
	String year;

	public Mp3Folder(String string) {
		super(string);
		this.path = string;
		loadFolder(this);
		cl = new Classifier(this);
		if (cl.isComplete(this)) {
			SystemOut.printDebug(path + " is not a complete album");
			isComplete = false;
		} else {
			SystemOut.printDebug("Generated Mp3 Folder from " + path + " with " + Mp3Files.size() + " mp3 files.");
			classify(cl);
		}
	}
	
	private void classify(Classifier cl) {
		

		if (cl.isCompilation(this)) {
		
			if (cl.hasAllAlbumArtistTags) {
				albumArtist = Mp3Files.get(0).getAlbumArtist();
			}
			if (cl.hasAllAlbumTags) {
				album = Mp3Files.get(0).getArtist();
			}
			if (cl.hasAnyAlbumArtistTags) {
				for (Mp3File f : Mp3Files) {
					if (!f.getArtist().isEmpty() && artist.isEmpty()) {
						albumArtist = f.getArtist();
					}
				}
			}
			if (cl.hasAnyArtistTags) {
				for (Mp3File f : Mp3Files) {
					if (!f.getArtist().isEmpty() && artist.isEmpty()) {
						artist = f.getArtist();
					}
				}
			}
			if (cl.hasAnyAlbumTags) {
				for (Mp3File f : Mp3Files) {
					if (!f.getArtist().isEmpty() && artist.isEmpty()) {
						album = f.getAlbum();
					}
				}
			}
		}
	}
	
	private void loadFolder(File folder) {
		Mp3Files = new ArrayList<Mp3File>();
		if (folder.isDirectory()) {
			for (File f : folder.listFiles()) {
				if (f.getName().toLowerCase().endsWith("mp3")) {
					Mp3Files.add(new Mp3File(f.getAbsolutePath()));
				}
			}
			
		} else {
			//log failure
		}
	}
	
	public int getNumberOfFiles() {
		return numberOfMp3Files;
	}
	
	public ArrayList<Mp3File> getMp3Files() {
		return Mp3Files;
	}

	public boolean isComplete() {
		return isComplete;
	}
	
	public String getPath() {
		return path;
	}
	
	public String getArtist() {
		return artist;
	}

	public String getAlbumArtist() {
		return albumArtist;
	}

	public String getAlbum() {
		return album;
	}
	
	public boolean isCompilation() {
	  return isCompilation;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setAlbumArtist(String albumArtist) {
		this.albumArtist = albumArtist;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

}
