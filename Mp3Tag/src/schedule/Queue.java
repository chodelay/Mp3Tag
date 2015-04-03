package schedule;

import java.util.ArrayList;

import tasks.*;

public class Queue {

  ArrayList<Task> Tasks;
  
  public void addTask(Task task) {
    Tasks.add(task);
  }
  
  public void runTasks() {
    for (Task t: Tasks) {
      t.run();
    }
  }
  
}
