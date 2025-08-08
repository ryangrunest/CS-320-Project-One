public class Contact {
  private final String contactId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;

  public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
    validateContactId(contactId);
    validateFirstName(firstName);
    validateLastName(lastName);
    validatePhoneNumber(phoneNumber);
    validateAddress(address);

    this.contactId = contactId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }

  public String getContactId() {
    return contactId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String setFirstName(String firstName) {
    validateFirstName(firstName);
    this.firstName = firstName;
    return this.firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String setLastName(String lastName) {
    validateLastName(lastName);
    this.lastName = lastName;
    return this.lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String setPhoneNumber(String phoneNumber) {
    validatePhoneNumber(phoneNumber);
    this.phoneNumber = phoneNumber;
    return this.phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public String setAddress(String address) {
    validateAddress(address);
    this.address = address;
    return this.address;
  }

  // --- Private validation methods ---

  // The contact object shall have a required unique contact ID string that cannot
  // be longer than 10 characters.
  // The contact ID shall not be null and shall not be updatable.
  private void validateContactId(String contactId) {
    if (contactId == null || contactId.isEmpty()) {
      throw new IllegalArgumentException("Contact ID cannot be null or empty");
    }
    if (contactId.length() > 10) {
      throw new IllegalArgumentException("Contact ID cannot exceed 10 characters");
    }
  }

  // The contact object shall have a required firstName String field that cannot
  // be longer than 10 characters.
  // The firstName field shall not be null.
  private void validateFirstName(String firstName) {
    if (firstName == null || firstName.isEmpty()) {
      throw new IllegalArgumentException("First name cannot be null or empty");
    }
    if (firstName.length() > 10) {
      throw new IllegalArgumentException("First name cannot exceed 10 characters");
    }
  }

  // The contact object shall have a required lastName String field that cannot be
  // longer than 10 characters.
  // The lastName field shall not be null.
  private void validateLastName(String lastName) {
    if (lastName == null || lastName.isEmpty()) {
      throw new IllegalArgumentException("Last name cannot be null or empty");
    }
    if (lastName.length() > 10) {
      throw new IllegalArgumentException("Last name cannot exceed 10 characters");
    }
  }

  // The contact object shall have a required phone String field that must be
  // exactly 10 digits.
  // The phone field shall not be null.
  private void validatePhoneNumber(String phoneNumber) {
    if (phoneNumber == null || phoneNumber.isEmpty()) {
      throw new IllegalArgumentException("Phone number cannot be null or empty");
    }
    if (!phoneNumber.matches("\\d{10}")) {
      throw new IllegalArgumentException("Phone number must be exactly 10 digits");
    }
  }

  // The contact object shall have a required address field that must be no longer
  // than 30 characters.
  // The address field shall not be null.
  private void validateAddress(String address) {
    if (address == null || address.isEmpty()) {
      throw new IllegalArgumentException("Address cannot be null or empty");
    }
    if (address.length() > 30) {
      throw new IllegalArgumentException("Address cannot exceed 30 characters");
    }
  }
}
