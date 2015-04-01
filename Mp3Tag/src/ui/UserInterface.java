package ui;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

import files.Mp3File;

public class UserInterface extends JFrame {
	
	ArrayList<FileDetailsPanel> FileDetailsPanels;
	
	public UserInterface() {
		//Open a FDP and load test song
		FileDetailsPanels.add(new FileDetailsPanel());
		FileDetailsPanels.get(0).loadMp3File(new Mp3File(new File("D:\\Music\\Muse\\Absolution\\1 Intro.mp3")));
		this.add(FileDetailsPanels.get(0));
		this.setEnabled(true);
	}
	
	public void refreshUI() {
		
	}
	
}
