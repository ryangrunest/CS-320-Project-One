import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

  @Test
  void testValidTaskCreation() {
    Task task = new Task("T123", "Test Task", "This is a test description.");
    assertEquals("T123", task.getTaskId());
    assertEquals("Test Task", task.getName());
    assertEquals("This is a test description.", task.getDescription());
  }

  @Test
  void testTaskIdNull() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Task(null, "Name", "Description");
    });
    assertTrue(ex.getMessage().contains("Task ID"));
  }

  @Test
  void testTaskIdTooLong() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Task("12345678901", "Name", "Description");
    });
    assertTrue(ex.getMessage().contains("Task ID"));
  }

  @Test
  void testNameNull() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Task("T1", null, "Description");
    });
    assertTrue(ex.getMessage().contains("Name cannot be null"));
  }

  @Test
  void testNameEmpty() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Task("T1", "", "Description");
    });
    assertTrue(ex.getMessage().contains("Name cannot be null or empty"));
  }

  @Test
  void testNameTooLong() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Task("T1", "ThisNameIsWayTooLongForTheLimit", "Description");
    });
    assertTrue(ex.getMessage().contains("Name cannot exceed 20 characters"));
  }

  @Test
  void testDescriptionNull() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Task("T1", "Name", null);
    });
    assertTrue(ex.getMessage().contains("Description cannot be null"));
  }

  @Test
  void testDescriptionEmpty() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Task("T1", "Name", "");
    });
    assertTrue(ex.getMessage().contains("Description cannot be null or empty"));
  }

  @Test
  void testDescriptionTooLong() {
    String longDesc = "This description is definitely longer than fifty characters, which is not allowed.";
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Task("T1", "Name", longDesc);
    });
    assertTrue(ex.getMessage().contains("Description cannot exceed 50 characters"));
  }

  @Test
  void testSetNameValid() {
    Task task = new Task("T1", "Name", "Description");
    task.setName("New Name");
    assertEquals("New Name", task.getName());
  }

  @Test
  void testSetNameInvalid() {
    Task task = new Task("T1", "Name", "Description");
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      task.setName(null);
    });
    assertTrue(ex.getMessage().contains("Name cannot be null"));
  }

  @Test
  void testSetDescriptionValid() {
    Task task = new Task("T1", "Name", "Description");
    task.setDescription("New Description");
    assertEquals("New Description", task.getDescription());
  }

  @Test
  void testSetDescriptionInvalid() {
    Task task = new Task("T1", "Name", "Description");
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      task.setDescription("");
    });
    assertTrue(ex.getMessage().contains("Description cannot be null or empty"));
  }
}