package tasks;

import schedule.Scheduler;
import files.Classifier;
import files.Mp3Folder;

public class TaskDecider {

  public static void createJobs(Mp3Folder f) {
  	if (f.isCompilation()) {
      compilationJobs(f);
    } else {
      albumJobs(f);
    }
  }
  
  private static void compilationJobs(Mp3Folder f) {
    Scheduler.addTask(new RemoveJunkTask(f));
    Scheduler.addTask(new MoveToLandingTask(f));
  }
  
  private static void albumJobs(Mp3Folder f) {
    boolean hasAllArtistTags = f.cl.hasAnyArtistTags(f);
    boolean hasAllAlbumArtistTags = f.cl.hasAllAlbumArtistTags(f);
    boolean hasAllAlbumTags = f.cl.hasAllAlbumTags(f);
    boolean hasAllTrackTags = f.cl.hasAllTrackTags(f);
    
    // Remove junk tags
    Scheduler.addTask(new RemoveJunkTask(f));
    
    if (hasAllArtistTags && hasAllAlbumArtistTags) {
    
    // If has all album artist tags but not all artist
    	// make all artist tags = to albumartist
    } else if (!hasAllArtistTags && hasAllAlbumArtistTags) {
      Scheduler.addTask(new MakeArtistAlbumArtistTask(f));
    } else if (hasAllArtistTags && !hasAllAlbumArtistTags) {
      Scheduler.addTask(new MakeAlbumArtistArtistTask(f));
    } else if (!hasAllArtistTags && !hasAllAlbumArtistTags) {
    	Scheduler.addTask(new MakeArtistSameTask(f));
    	Scheduler.addTask(new MakeAlbumArtistSameTask(f));
    }
    
    Scheduler.addTask(new MoveToLandingTask(f));
    // If Year Missing
    
    
  }
  
  //if artist tags missing
  
  //if album artist tags missing
  
  //if track numbers missing
  
  //if 
  
}
