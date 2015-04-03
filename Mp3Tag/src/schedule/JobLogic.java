package schedule;

import tasks.MakeAlbumArtistArtistTask;
import tasks.MakeArtistAlbumArtistTask;
import tasks.RemoveJunkTask;
import files.Classifier;
import files.Mp3Folder;

public class JobLogic {

  public void createJobs(Mp3Folder f) {
    if (f.isCompilation()) {
      compilationJobs(f);
    } else {
      albumJobs(f);
    }
  }
  
  private void compilationJobs(Mp3Folder f) {
    
  }
  
  private void albumJobs(Mp3Folder f) {
    Queue q = new Queue();
    boolean hasAllArtistTags = Classifier.hasAllArtistTags(f);
    boolean hasAllAlbumArtistTags = Classifier.hasAllAlbumArtistTags(f);
    boolean hasAllAlbumTags = Classifier.hasAllAlbumTags(f);
    
    // Remove junk tags
    q.addTask(new RemoveJunkTask(f));
    
    // Album hasn't got complete artist or album artist tags
    // Tag as unprocessable? Queue task awaiting input?
    if (!(hasAllArtistTags && hasAllAlbumArtistTags)) {
      
    } else if (!hasAllArtistTags && hasAllAlbumArtistTags) {
      q.addTask(new MakeArtistAlbumArtistTask(f));
    } else if (hasAllArtistTags && !hasAllAlbumArtistTags) {
      q.addTask(new MakeAlbumArtistArtistTask(f));
    }
    
    // If Track Numbers Missing
    
    // If Year Missing
    
    // If 
    
  }
  
  //if artist tags missing
  
  //if album artist tags missing
  
  //if track numbers missing
  
  //if 
  
}
