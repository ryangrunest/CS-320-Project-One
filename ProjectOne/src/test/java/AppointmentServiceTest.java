import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

public class AppointmentServiceTest {
  private AppointmentService service;
  private Appointment appointment;

  // Helper to get a future date
  private Date getFutureDate() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, 1);
    return cal.getTime();
  }

  @BeforeEach
  void setUp() {
    service = new AppointmentService();
    appointment = new Appointment("A1", getFutureDate(), "Initial Description");
  }

  @Test
  void testAddAppointmentSuccess() {
    assertTrue(service.addAppointment(appointment));
  }

  @Test
  void testAddAppointmentDuplicateId() {
    service.addAppointment(appointment);
    Appointment duplicate = new Appointment("A1", getFutureDate(), "Another Description");
    assertFalse(service.addAppointment(duplicate));
  }

  @Test
  void testDeleteAppointmentSuccess() {
    service.addAppointment(appointment);
    assertTrue(service.deleteAppointment("A1"));
  }

  @Test
  void testDeleteAppointmentNotFound() {
    assertFalse(service.deleteAppointment("X999"));
  }

  @Test
  void testUpdateAppointmentDateSuccess() {
    service.addAppointment(appointment);
    Date newDate = getFutureDate();
    assertTrue(service.updateAppointmentDate("A1", newDate));
    assertEquals(newDate, service.getAppointment("A1").getAppointmentDate());
  }

  @Test
  void testUpdateAppointmentDateNotFound() {
    Date newDate = getFutureDate();
    assertFalse(service.updateAppointmentDate("X999", newDate));
  }

  @Test
  void testUpdateAppointmentDescriptionSuccess() {
    service.addAppointment(appointment);
    assertTrue(service.updateAppointmentDescription("A1", "Updated Description"));
    assertEquals("Updated Description",
        service.getAppointment("A1").getDescription());
  }

  @Test
  void testUpdateAppointmentDescriptionNotFound() {
    assertFalse(service.updateAppointmentDescription("X999", "No Description"));
  }
}