package schedule;

import java.util.ArrayList;

import log.SystemOut;
import tasks.Task;

public class Scheduler {
	
	static ArrayList<Task> Tasks;
	
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
      Tasks.remove(t);
    }
  }
  
  public static boolean hasTasks() {
  	return !(Tasks.size() == 0) && Tasks != null;
  }
	
	// TIMERS
}
