package acsse.csc2a;

/**
 * Represents a PyroTechnician with a full name and phone number.
 */
public class PyroTechnicians {

    // Attributes
    private final String fullName;
    private String phoneNumber;

    // Constructors

    /**
     * Default constructor initializing the PyroTechnician with empty name and zero phone number.
     */
    public PyroTechnicians() {
        this(" ", "0");     // Calls the parameterized constructor with default values
    }

    /**
     * Parameterized constructor initializing the PyroTechnician with the specified name and phone number.
     * @param name      name The full name of the PyroTechnician
     * @param number    number  The phone number of the PyroTechnician
     */
    public PyroTechnicians(String name, String number) {
        this.fullName = name;
        this.phoneNumber = number;
    }

    // Methods

    /**
     * Retrieves the full name of the PyroTechnician.
     * @return The full name of the PyroTechnician
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Retrieves the phone number of the PyroTechnician.
     * @return The phone number of the PyroTechnician
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set new phone number
     * @param newNumber new number for the technician
     */
    public void setPhoneNumber(String newNumber) {
        phoneNumber = newNumber;
    }
}
