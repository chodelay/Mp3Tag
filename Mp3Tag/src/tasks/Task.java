package tasks;

import log.SystemOut;
import files.Mp3Folder;

public class Task {

	//TODO: uuid
	Mp3Folder folder;
	String name;
	String description;
	String path;
	int id;
	int status;
	
	enum Status {
		CREATED("Created"),
		QUEUED("Queued"),
		RUNNING("Running"),
		FINISHED("Finished");
		
		private String statusDescription;
		
		Status(String statusDescription) {
			this.statusDescription = statusDescription;
		}
	}

	public Task(Mp3Folder f) {
		this.folder = f;
		this.path = folder.getPath();
		SystemOut.printDebug("Created Task " + this.getClass());
		SystemOut.printDebug("Path: " + this.path);
	}

	public void run() {
		System.out.println("++" + Status.RUNNING.statusDescription + " " + this.name);
		this.runTask();
		System.out.println("--" + Status.FINISHED.statusDescription + " " + this.name);
	}
	
	protected void runTask() {

	}
	
	public void finish() {
		System.out.println(Status.FINISHED.statusDescription);
	}
	
  /**************************
   * ACCESSORS
   *************************/
	public Mp3Folder getFolder() {
		return folder;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public int getId() {
		return id;
	}
	
  /**************************
   * MUTATORS
   *************************/
	public void setFolder(Mp3Folder folder) {
		this.folder = folder;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
