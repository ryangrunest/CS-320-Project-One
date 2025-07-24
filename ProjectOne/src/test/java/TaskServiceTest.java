import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService service;
    private Task task;

    @BeforeEach
    void setUp() {
        service = new TaskService();
        task = new Task("T1", "Sample Task", "Sample Description");
    }

    @Test
    void testAddTaskSuccess() {
        assertTrue(service.addTask(task));
        assertEquals(task, service.getTask("T1"));
    }

    @Test
    void testAddTaskDuplicateId() {
        service.addTask(task);
        Task duplicate = new Task("T1", "Another Task", "Another Description");
        assertFalse(service.addTask(duplicate));
    }

    @Test
    void testDeleteTaskSuccess() {
        service.addTask(task);
        assertTrue(service.deleteTask("T1"));
        assertNull(service.getTask("T1"));
    }

    @Test
    void testDeleteTaskNotFound() {
        assertFalse(service.deleteTask("X999"));
    }

    @Test
    void testUpdateNameSuccess() {
        service.addTask(task);
        assertTrue(service.updateName("T1", "Updated Name"));
        assertEquals("Updated Name", service.getTask("T1").getName());
    }

    @Test
    void testUpdateNameNotFound() {
        assertFalse(service.updateName("X999", "No Task"));
    }

    @Test
    void testUpdateDescriptionSuccess() {
        service.addTask(task);
        assertTrue(service.updateDescription("T1", "Updated Description"));
        assertEquals("Updated Description", service.getTask("T1").getDescription());
    }

    @Test
    void testUpdateDescriptionNotFound() {
        assertFalse(service.updateDescription("X999", "No Description"));
    }
}