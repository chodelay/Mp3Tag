package schedule;

import java.util.ArrayList;

import log.SystemOut;
import tasks.Task;

public class Scheduler {
	
	static ArrayList<Task> Tasks = new ArrayList<Task>();
	
  public static void addTask(Task task) {
    Tasks.add(task);
  }
  
  public static void runTask() {
  	SystemOut.printDebug("Scheduler is launching: " + Tasks.get(0).getName());
  	Tasks.get(0).run();
  	Tasks.remove(0);
  }
  
  public static void runTasks() {
    for (Task t: Tasks) {
    	SystemOut.printDebug("Scheduler is launching: " + t.getName());
      t.run();
    }
    Tasks = new ArrayList<Task>();
  }
  
  public static boolean hasTasks() {
  	return Tasks != null && !(Tasks.size() == 0);
  }
	
	// TIMERS
}
