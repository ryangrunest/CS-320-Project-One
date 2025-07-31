import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

public class AppointmentTest {

  // Helper method to get a future date
  private Date getFutureDate() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, 1);
    return cal.getTime();
  }

  // Helper method to get a past date
  private Date getPastDate() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);
    return cal.getTime();
  }

  @Test
  void testValidAppointmentCreation() {
    Date futureDate = getFutureDate();
    Appointment appointment = new Appointment("A123", futureDate, "Checkup");
    assertEquals("A123", appointment.getAppointmentId());
    assertEquals(futureDate, appointment.getAppointmentDate());
    assertEquals("Checkup", appointment.getDescription());
  }

  @Test
  void testAppointmentIdNull() {
    Date futureDate = getFutureDate();
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Appointment(null, futureDate, "Checkup");
    });
    assertTrue(ex.getMessage().contains("Appointment ID"));
  }

  @Test
  void testAppointmentIdTooLong() {
    Date futureDate = getFutureDate();
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Appointment("12345678901", futureDate, "Checkup");
    });
    assertTrue(ex.getMessage().contains("Appointment ID"));
  }

  @Test
  void testAppointmentDateNull() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Appointment("A123", null, "Checkup");
    });
    assertTrue(ex.getMessage().contains("Appointment date cannot be null"));
  }

  @Test
  void testAppointmentDateInPast() {
    Date pastDate = getPastDate();
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Appointment("A123", pastDate, "Checkup");
    });
    assertTrue(ex.getMessage().contains("Appointment date cannot be in the past"));
  }

  @Test
  void testDescriptionNull() {
    Date futureDate = getFutureDate();
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Appointment("A123", futureDate, null);
    });
    assertTrue(ex.getMessage().contains("Description cannot be null"));
  }

  @Test
  void testDescriptionEmpty() {
    Date futureDate = getFutureDate();
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Appointment("A123", futureDate, "");
    });
    assertTrue(ex.getMessage().contains("Description cannot be null or empty"));
  }

  @Test
  void testDescriptionTooLong() {
    Date futureDate = getFutureDate();
    String longDesc = "This description is definitely longer than fifty characters, which is not allowed.";
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      new Appointment("A123", futureDate, longDesc);
    });
    assertTrue(ex.getMessage().contains("Description cannot exceed 50 characters"));
  }

  @Test
  void testSetAppointmentDateValid() {
    Date futureDate = getFutureDate();
    Appointment appointment = new Appointment("A123", futureDate, "Checkup");
    Date anotherFutureDate = getFutureDate();
    appointment.setAppointmentDate(anotherFutureDate);
    assertEquals(anotherFutureDate, appointment.getAppointmentDate());
  }

  @Test
  void testSetAppointmentDateInvalid() {
    Date futureDate = getFutureDate();
    Appointment appointment = new Appointment("A123", futureDate, "Checkup");
    Date pastDate = getPastDate();
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      appointment.setAppointmentDate(pastDate);
    });
    assertTrue(ex.getMessage().contains("Appointment date cannot be in the past"));
  }

  @Test
  void testSetDescriptionValid() {
    Date futureDate = getFutureDate();
    Appointment appointment = new Appointment("A123", futureDate, "Checkup");
    appointment.setDescription("Follow-up");
    assertEquals("Follow-up", appointment.getDescription());
  }

  @Test
  void testSetDescriptionInvalid() {
    Date futureDate = getFutureDate();
    Appointment appointment = new Appointment("A123", futureDate, "Checkup");
    Exception ex = assertThrows(IllegalArgumentException.class, () -> {
      appointment.setDescription("");
    });
    assertTrue(ex.getMessage().contains("Description cannot be null or empty"));
  }
}