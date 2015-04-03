package files;

import java.io.File;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;

public class Mp3File extends File {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1474248911769075890L;
	String name;
	AudioFile af;
	Tag tag;					Tag originalTag;

  public Mp3File(String path) {
  	super(path);
  	this.name = path;
  	try {
  		af = AudioFileIO.read(this);
  		tag = af.getTag();
  		originalTag = af.getTag();
  	} catch (Exception e) {
  		System.out.println("Unable to create AudioFile from File.");
  	}
  }
  
  /**************************
   * ACCESSORS
   *************************/
  public String getArtist() { return tag.getFirst(FieldKey.ARTIST); }
  public String getAlbumArtist() { return tag.getFirst(FieldKey.ALBUM_ARTIST); }
  public String getAlbum() {	return tag.getFirst(FieldKey.ALBUM);  }
  public String getTitle() { 	return tag.getFirst(FieldKey.TITLE);  }
  public String getTrack() {	return tag.getFirst(FieldKey.TRACK);  }
  public String getTrackTotal() {	return tag.getFirst(FieldKey.TRACK_TOTAL);  }
  public String getDisc() {return tag.getFirst(FieldKey.DISC_NO);  }
  public String getDiscTotal() { return tag.getFirst(FieldKey.DISC_TOTAL); }
  public String getYear() {	return tag.getFirst(FieldKey.YEAR);  }
  public String getComment() { return tag.getFirst(FieldKey.COMMENT);   }
  public String getGenre() {return tag.getFirst(FieldKey.GENRE);   }
  
  /**************************
   * MUTATORS

   *************************/
  public void setArtist(String input) {
  	try {
			tag.setField(FieldKey.ARTIST, input);
		} catch (KeyNotFoundException | FieldDataInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void setAlbumArtist(String input) {
  	try {
			tag.setField(FieldKey.ALBUM_ARTIST, input);
		} catch (KeyNotFoundException | FieldDataInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void setAlbum(String input) {
  	try {
			tag.setField(FieldKey.ALBUM, input);
		} catch (KeyNotFoundException | FieldDataInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void setTitle(String input) {
  	try {
			tag.setField(FieldKey.TITLE, input);
		} catch (KeyNotFoundException | FieldDataInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void setTrack(int input) {
  	try {
    	String inputAsString = String.valueOf(input);
			tag.setField(FieldKey.TRACK, inputAsString);
		} catch (KeyNotFoundException | FieldDataInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void setTrackTotal(String string) {
  	try {
			tag.setField(FieldKey.TRACK_TOTAL, string);
		} catch (KeyNotFoundException | FieldDataInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void setDisc(int input) {
  	try {
    	String inputAsString = String.valueOf(input);
			tag.setField(FieldKey.DISC_NO, inputAsString);
		} catch (KeyNotFoundException | FieldDataInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void setDiscTotal(String string) {
  	try {
			tag.setField(FieldKey.DISC_TOTAL, string);
		} catch (KeyNotFoundException | FieldDataInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void setYear(int input) {
  	try {
    	String inputAsString = String.valueOf(input);
			tag.setField(FieldKey.YEAR, inputAsString);
		} catch (KeyNotFoundException | FieldDataInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void setComment(String input) {
  	try {
			tag.setField(FieldKey.COMMENT, input);
		} catch (KeyNotFoundException | FieldDataInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public void setGenre(String input) {
  	try {
			tag.setField(FieldKey.GENRE, input);
		} catch (KeyNotFoundException | FieldDataInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  /**********************
   * TAG FUNCTIONS
   *********************/
  public void writeToFile() {
  	System.out.println("Writing file " + name);
  	af.setTag(tag);
  	try {
			af.commit();
		} catch (CannotWriteException e) {
			System.out.println("Cannot write to file.");
			e.printStackTrace();
		}
  }
  
  public boolean hasTagChanged() {
  	return tag.equals(originalTag);
  }
  
  public void revertChanges() {
  	tag = af.getTag();
  }
  
    
}