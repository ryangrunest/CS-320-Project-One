import java.util.HashMap;
import java.util.Map;

public class TaskService {
  private final Map<String, Task> tasks = new HashMap<>();

  // Add a task if the ID is unique
  public boolean addTask(Task task) {
    if (task == null || tasks.containsKey(task.getTaskId())) {
      return false;
    }
    tasks.put(task.getTaskId(), task);
    return true;
  }

  // Delete a task by ID
  public boolean deleteTask(String taskId) {
    return tasks.remove(taskId) != null;
  }

  // Update name
  public boolean updateName(String taskId, String name) {
    Task task = tasks.get(taskId);
    if (task != null) {
      task.setName(name);
      return true;
    }
    return false;
  }

  // Update description
  public boolean updateDescription(String taskId, String description) {
    Task task = tasks.get(taskId);
    if (task != null) {
      task.setDescription(description);
      return true;
    }
    return false;
  }

  // Get a task by ID
  public Task getTask(String taskId) {
    return tasks.get(taskId);
  }
}