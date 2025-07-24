public class Task {
  private final String taskId;
  private String name;
  private String description;

  public Task(String taskId, String name, String description) {
    validateTaskId(taskId);
    validateName(name);
    validateDescription(description);

    this.taskId = taskId;
    this.name = name;
    this.description = description;
  }

  public String getTaskId() {
    return taskId;
  }

  public String getName() {
    return name;
  }

  public String setName(String name) {
    validateName(name);
    this.name = name;
    return this.name;
  }

  public String getDescription() {
    return description;
  }

  public String setDescription(String description) {
    validateDescription(description);
    this.description = description;
    return this.description;
  }

  // The task object shall have a required unique task ID String that cannot be longer than 10 characters. The task ID shall not be null and shall not be updatable.
  private void validateTaskId(String taskId) {
    if (taskId == null || taskId.length() > 10) {
      throw new IllegalArgumentException("Task ID must be a non-null string with a maximum length of 10 characters.");
    }
  }

  // The task object shall have a required name String field that cannot be longer than 20 characters. The name field shall not be null.
  private void validateName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    if (name.length() > 20) {
      throw new IllegalArgumentException("Name cannot exceed 20 characters");
    }
  }

  // The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.
  private void validateDescription(String description) {
    if (description == null || description.isEmpty()) {
      throw new IllegalArgumentException("Description cannot be null or empty");
    }
    if (description.length() > 50) {
      throw new IllegalArgumentException("Description cannot exceed 50 characters");
    }
  }
}