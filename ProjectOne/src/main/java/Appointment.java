import java.util.Date;

public class Appointment {
  private final String appointmentId;
  private Date appointmentDate;;
  private String description;

  public Appointment(String appointmentId, Date appointmentDate, String description) {
    validateAppointmentId(appointmentId);
    validateAppointmentDate(appointmentDate);
    validateDescription(description);

    this.appointmentId = appointmentId;
    this.appointmentDate = appointmentDate;
    this.description = description;
  }

  public String getAppointmentId() {
    return appointmentId;
  }

  public Date getAppointmentDate() {
    return appointmentDate;
  }

  public void setAppointmentDate(Date appointmentDate) {
    validateAppointmentDate(appointmentDate);
    this.appointmentDate = appointmentDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    validateDescription(description);
    this.description = description;
  }

  // Private Validation Methods

  // The appointment object shall have a required unique appointment ID string that cannot be longer than 10 characters. The appointment ID shall not be null and shall not be updatable.
  private void validateAppointmentId(String appointmentId) {
    if (appointmentId == null || appointmentId.length() > 10) {
      throw new IllegalArgumentException("Appointment ID must be a non-null string with a maximum length of 10 characters.");
    }
  }

  // The appointment object shall have a required appointment Date field. The appointment Date field cannot be in the past. The appointment Date field shall not be null.
  // Note: Use java.util.Date for the appointmentDate field and use before(new Date()) to check if the date is in the past.
  private void validateAppointmentDate(Date appointmentDate) {
    if (appointmentDate == null) {
      throw new IllegalArgumentException("Appointment date cannot be null.");
    }
    if (appointmentDate.before(new Date())) {
      throw new IllegalArgumentException("Appointment date cannot be in the past.");
    }
  }

  // The appointment object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.
  private void validateDescription(String description) {
    if (description == null || description.isEmpty()) {
      throw new IllegalArgumentException("Description cannot be null or empty.");
    }
    if (description.length() > 50) {
      throw new IllegalArgumentException("Description cannot exceed 50 characters.");
    }
  }
}
