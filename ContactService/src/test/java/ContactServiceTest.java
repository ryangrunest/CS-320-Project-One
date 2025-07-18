import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    void testAddContactSuccess() {
        assertTrue(service.addContact(contact));
    }

    @Test
    void testAddContactDuplicateId() {
        service.addContact(contact);
        Contact duplicate = new Contact("12345", "Jane", "Smith", "0987654321", "456 Elm St");
        assertFalse(service.addContact(duplicate));
    }

    @Test
    void testDeleteContactSuccess() {
        service.addContact(contact);
        assertTrue(service.deleteContact("12345"));
    }

    @Test
    void testDeleteContactNotFound() {
        assertFalse(service.deleteContact("99999"));
    }

    @Test
    void testUpdateFirstNameSuccess() {
        service.addContact(contact);
        assertTrue(service.updateFirstName("12345", "Jane"));
        assertEquals("Jane", service.getContact("12345").getFirstName());
    }

    @Test
    void testUpdateFirstNameNotFound() {
        assertFalse(service.updateFirstName("99999", "Jane"));
    }

    @Test
    void testUpdateLastNameSuccess() {
        service.addContact(contact);
        assertTrue(service.updateLastName("12345", "Smith"));
        assertEquals("Smith", service.getContact("12345").getLastName());
    }

    @Test
    void testUpdatePhoneNumberSuccess() {
        service.addContact(contact);
        assertTrue(service.updatePhoneNumber("12345", "0987654321"));
        assertEquals("0987654321", service.getContact("12345").getPhoneNumber());
    }

    @Test
    void testUpdateAddressSuccess() {
        service.addContact(contact);
        assertTrue(service.updateAddress("12345", "456 Elm St"));
        assertEquals("456 Elm St", service.getContact("12345").getAddress());
    }

    @Test
    void testUpdateFieldNotFound() {
        assertFalse(service.updateLastName("99999", "Smith"));
        assertFalse(service.updatePhoneNumber("99999", "1112223333"));
        assertFalse(service.updateAddress("99999", "789 Oak St"));
    }
}