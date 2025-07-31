import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
  private final Map<String, Appointment> appointments = new HashMap<>();

  // The appointment service shall be able to add appointments with a unique
  // appointment ID.
  public boolean addAppointment(Appointment appointment) {
    if (appointment == null || appointments.containsKey(appointment.getAppointmentId())) {
      return false;
    }
    appointments.put(appointment.getAppointmentId(), appointment);
    return true;
  }

  // The appointment service shall be able to delete appointments per appointment
  // ID.
  public boolean deleteAppointment(String appointmentId) {
    return appointments.remove(appointmentId) != null;
  }

  // get appointment by ID
  public Appointment getAppointment(String appointmentId) {
    return appointments.get(appointmentId);
  }

  // update appointment date
  public boolean updateAppointmentDate(String appointmentId, Date appointmentDate) {
    Appointment appointment = appointments.get(appointmentId);
    if (appointment != null) {
      appointment.setAppointmentDate(appointmentDate);
      return true;
    }

    return false;
  }

  // update appointment description
  public boolean updateAppointmentDescription(String appointmentId, String description) {
    Appointment appointment = appointments.get(appointmentId);
    if (appointment != null) {
      appointment.setDescription(description);
      return true;
    }

    return false;
  }
}
