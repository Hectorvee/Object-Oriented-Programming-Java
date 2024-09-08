package acsse.csc2a.fmb.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a PyroTechnician with a full name and phone number.
 * This class defines attributes and methods for managing PyroTechnician objects.
 * It also provides functionality for validating technician data from input lines.
 */
public class PyroTechnician implements IDisplayable {

    // Attributes
    private final String fullName;
    private String phoneNumber;
    private static final String TECHNICIAN_PATTERN = "^([A-Z][a-z]+)-([A-Z][a-z]+)\\s+(\\d{3}-\\d{3}-\\d{4})$";

    // Constructors

    /**
     * Constructs a PyroTechnician with default values.
     * Default values are "NoFirstName", "NoLastName", and "NoPhoneNumber".
     */
    public PyroTechnician() {
        this("NoFirstName", "NoLastName", "NoPhoneNumber");
    }

    /**
     * Constructs a PyroTechnician with the specified name and phone number.
     * @param firstName The first name of the PyroTechnician.
     * @param lastName The last name of the PyroTechnician.
     * @param number The phone number of the PyroTechnician.
     */
    public PyroTechnician(String firstName, String lastName, String number) {
        this.fullName = firstName + "-" + lastName;
        this.phoneNumber = number;
    }

    // Methods
    /**
     * Returns a string representation of the object.
     * @return A string containing the full name and phone number of the object.
     */
    @Override
    public String toString() {
        return "Full Name: " + fullName + ", Phone Number: " + phoneNumber;
    }

    /**
     * Displays the textual representation of the object to the console.
     */
    @Override
    public void display() {
        System.out.println(this);
    }

    /**
     * Retrieves the full name of the acsse.csc2a.fmb.model.PyroTechnician.
     * @return The full name of the acsse.csc2a.fmb.model.PyroTechnician
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Retrieves the phone number of the acsse.csc2a.fmb.model.PyroTechnician.
     * @return The phone number of the acsse.csc2a.fmb.model.PyroTechnician
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

    public static String getTechnicianPattern() {
        return TECHNICIAN_PATTERN;
    }

    /**
     * Validates the input line against the PyroTechnician regular expression pattern.
     * @param line The input line to validate.
     * @return true if the input line matches the pattern, otherwise false.
     */
    public static boolean validate(String line) {
        return line.matches(TECHNICIAN_PATTERN);
    }

    /**
     * Processes the input line to instantiate a PyroTechnician object.
     * If the line matches the PyroTechnician pattern, a new PyroTechnician object is created and added to the FireworkDisplay.
     * @param line The input line to process.
     * @param fireworkDisplay The FireworkDisplay to which the PyroTechnician will be added.
     */
    public static void processLine(String line, FireworkDisplay fireworkDisplay) {
        Pattern pattern = Pattern.compile(TECHNICIAN_PATTERN);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            String firstName = matcher.group(1);
            String lastName = matcher.group(2);
            String phoneNumber = matcher.group(3);
            PyroTechnician technician = new PyroTechnician(firstName, lastName, phoneNumber);
            fireworkDisplay.setLeadTechnician(technician);
        }
    }
}
