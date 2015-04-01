package tasks;

import java.io.File;

import files.Mp3Folder;

public class Task {

	//TODO: uuid
	Mp3Folder folder;
	String name;
	String path;
	int id;

	public Task(Mp3Folder f) {
		this.folder = f;
		this.path = folder.getPath();
	}

	public void runTask() {
		
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
