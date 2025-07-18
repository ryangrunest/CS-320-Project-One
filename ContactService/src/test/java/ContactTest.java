import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {
    
    @Test
    void testValidContact() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Test Street");
        assertEquals("ID123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Test Street", contact.getAddress());
    }
    
    // Contact ID tests
    @Test
    void testContactIdNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Test Street");
        });
        assertTrue(exception.getMessage().contains("Contact ID cannot be null"));
    }
    
    @Test
    void testContactIdEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("", "John", "Doe", "1234567890", "123 Test Street");
        });
        assertTrue(exception.getMessage().contains("Contact ID cannot be null or empty"));
    }
    
    @Test
    void testContactIdTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Test Street");
        });
        assertTrue(exception.getMessage().contains("Contact ID cannot exceed 10 characters"));
    }
    
    // First name tests
    @Test
    void testFirstNameNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", null, "Doe", "1234567890", "123 Test Street");
        });
        assertTrue(exception.getMessage().contains("First name cannot be null"));
    }
    
    @Test
    void testFirstNameEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "", "Doe", "1234567890", "123 Test Street");
        });
        assertTrue(exception.getMessage().contains("First name cannot be null or empty"));
    }
    
    @Test
    void testFirstNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "JohnJacobJingleheimer", "Doe", "1234567890", "123 Test Street");
        });
        assertTrue(exception.getMessage().contains("First name cannot exceed 10 characters"));
    }
    
    // Last name tests
    @Test
    void testLastNameNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", null, "1234567890", "123 Test Street");
        });
        assertTrue(exception.getMessage().contains("Last name cannot be null"));
    }
    
    @Test
    void testLastNameEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "", "1234567890", "123 Test Street");
        });
        assertTrue(exception.getMessage().contains("Last name cannot be null or empty"));
    }
    
    @Test
    void testLastNameTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "DoeJohnsonSmith", "1234567890", "123 Test Street");
        });
        assertTrue(exception.getMessage().contains("Last name cannot exceed 10 characters"));
    }
    
    // Phone number tests
    @Test
    void testPhoneNumberNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "Doe", null, "123 Test Street");
        });
        assertTrue(exception.getMessage().contains("Phone number cannot be null"));
    }
    
    @Test
    void testPhoneNumberEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "Doe", "", "123 Test Street");
        });
        assertTrue(exception.getMessage().contains("Phone number cannot be null or empty"));
    }
    
    @Test
    void testPhoneNumberTooShort() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "Doe", "123456789", "123 Test Street");
        });
        assertTrue(exception.getMessage().contains("Phone number must be exactly 10 digits"));
    }
    
    @Test
    void testPhoneNumberTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "Doe", "12345678901", "123 Test Street");
        });
        assertTrue(exception.getMessage().contains("Phone number must be exactly 10 digits"));
    }
    
    @Test
    void testPhoneNumberNonDigits() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "Doe", "123-456-789", "123 Test Street");
        });
        assertTrue(exception.getMessage().contains("Phone number must be exactly 10 digits"));
    }
    
    // Address tests
    @Test
    void testAddressNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "Doe", "1234567890", null);
        });
        assertTrue(exception.getMessage().contains("Address cannot be null"));
    }
    
    @Test
    void testAddressEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "Doe", "1234567890", "");
        });
        assertTrue(exception.getMessage().contains("Address cannot be null or empty"));
    }
    
    @Test
    void testAddressTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("ID123", "John", "Doe", "1234567890", 
                    "123 This Address Is Way Too Long For The Requirements Boulevard Avenue");
        });
        assertTrue(exception.getMessage().contains("Address cannot exceed 30 characters"));
    }
    
    // Setter tests
    @Test
    void testSetFirstName() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Test Street");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }
    
    @Test
    void testSetLastName() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Test Street");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }
    
    @Test
    void testSetPhoneNumber() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Test Street");
        contact.setPhoneNumber("9876543210");
        assertEquals("9876543210", contact.getPhoneNumber());
    }
    
    @Test
    void testSetAddress() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Test Street");
        contact.setAddress("456 Other Avenue");
        assertEquals("456 Other Avenue", contact.getAddress());
    }
    
    @Test
    void testInvalidSetters() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Test Street");
        
        Exception firstNameException = assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
        assertTrue(firstNameException.getMessage().contains("First name cannot be null"));
        
        Exception lastNameException = assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
        assertTrue(lastNameException.getMessage().contains("Last name cannot be null"));
        
        Exception phoneException = assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("not-a-number");
        });
        assertTrue(phoneException.getMessage().contains("Phone number must be exactly 10 digits"));
        
        Exception addressException = assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
        assertTrue(addressException.getMessage().contains("Address cannot be null"));
    }
}