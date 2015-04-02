

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Scanner;

import files.*;
import tasks.MakeArtistAlbumArtistTask;
import tasks.MoveToLandingTask;
import tasks.RemoveJunkTask;
import tasks.Task;
import ui.UserInterface;
import files.Mp3File;

public class Test {
	
	public static void main(String[] args) {
		String path = "";
		Mp3Folder f = new Mp3Folder("D:\\temp");
		
		Task t = new RemoveJunkTask(f);
		t.run();
		
		Task t2 = new MakeArtistAlbumArtistTask(f);
		t2.run();
		
		Task t3 = new MoveToLandingTask(f);
		t3.run();
	}
	
}
