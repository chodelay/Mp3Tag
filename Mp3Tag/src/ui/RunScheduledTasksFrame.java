package ui;

import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;

import log.SystemOut;

public class RunScheduledTasksFrame extends JFrame {

	JButton runScheduledTasksButton;
	
	RunScheduledTasksFrame() {
		setElements();
		addElements();
		setConfigurationElements();
		open();
	}
	
	private void setElements() {
		runScheduledTasksButton = new JButton("Run Scheduled Tasks");
		
	}
	
	private void setConfigurationElements() {
		setSize(480, 320);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void addElements() {
		add(runScheduledTasksButton);
	}
	
	private void open() {
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Scheduler.
		SystemOut.printDebug(e.getSource() + " was pressed, running scheduled tasks.");
		
	}
	
}
