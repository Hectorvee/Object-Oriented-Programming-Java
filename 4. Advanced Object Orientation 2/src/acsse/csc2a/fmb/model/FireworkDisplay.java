package acsse.csc2a.fmb.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a firework display with its attributes and methods.
 * Manages the display ID, name, theme, lead technician, and fireworks included in the display.
 */
public class FireworkDisplay implements IDisplayable {

    // Attributes
    private String displayID;
    private String displayName;
    private String displayTheme;
    private PyroTechnician leadTechnician;
    private List<Firework> fireworks;

    // Constructors

    /**
     * Default constructor.
     * Initializes attributes with default values.
     */
    public FireworkDisplay() {
        this("NoID", "NoName", "NoTheme", null);
    }

    /**
     * Constructs a FireworkDisplay object with the given parameters.
     * @param displayID       The ID of the firework display.
     * @param displayName     The name of the firework display.
     * @param displayTheme    The theme of the firework display.
     * @param leadTechnician  The lead technician responsible for the display.
     */
    public FireworkDisplay(String displayID, String displayName, String displayTheme, PyroTechnician leadTechnician) {
        this.displayID = displayID;
        this.displayName = displayName;
        this.displayTheme = displayTheme;
        this.leadTechnician = leadTechnician;
        fireworks = new ArrayList<>();

    }

    // Methods

    /**
     * Overrides the toString method to provide a string representation of the FireworkDisplay object.
     * @return A string containing the attributes of the FireworkDisplay object.
     */
    @Override
    public String toString() {
        return "FireworkDisplay{" +
                "displayID='" + displayID + '\'' +
                ", displayName='" + displayName + '\'' +
                ", displayTheme='" + displayTheme + '\'' +
                ", leadTechnician=" + leadTechnician +
                ", fireworks=" + fireworks +
                '}';
    }

    // Getters
    /**
     * Gets the ID of the firework display.
     * @return The display ID.
     */
    public String getDisplayID() {
        return displayID;
    }

    /**
     * Gets the name of the firework display.
     * @return The display name.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Gets the theme of the firework display.
     * @return The display theme.
     */
    public String getDisplayTheme() {
        return displayTheme;
    }

    /**
     * Gets the lead technician responsible for the firework display.
     * @return The lead technician.
     */
    public PyroTechnician getLeadTechnician() {
        return leadTechnician;
    }

    /**
     * Gets the array of fireworks included in the display.
     * @return The array of fireworks.
     */
    public List<Firework> getFirework() {
        return fireworks;
    }

    // Setters

    /**
     * A method to set the Display's ID
     * @param displayID A unique alpha-numeric Identifier
     */
    public void setDisplayID(String displayID) {
        this.displayID = displayID;
    }
    /**
     * Sets the display name.
     * @param newDisplayName The new display name to set.
     */
    public void setDisplayName(String newDisplayName) {

        if (newDisplayName.isEmpty()) {
            System.err.println("Display name is empty");
            System.exit(ErrorConstantsCodes.ERROR_STRING_EMPTY);
        }

        displayName = newDisplayName;

    }

    /**
     * Sets the display theme.
     * @param newDisplayTheme The new display theme to set.
     */
    public void setDisplayTheme(String newDisplayTheme) {

        if (newDisplayTheme.isEmpty()) {
            System.err.println("Display theme is empty");
            System.exit(ErrorConstantsCodes.ERROR_STRING_EMPTY);
        }

        this.displayTheme = newDisplayTheme;
    }

    /**
     * Sets the lead technician responsible for the display.
     * @param leadTechnician The new lead technician.
     */
    public void setLeadTechnician(PyroTechnician leadTechnician) {
        this.leadTechnician = leadTechnician;
    }

    /**
     * Prints the details of the firework display and its fireworks.
     */
    @Override
    public void display() {

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\n--- acsse.csc2a.fmb.model.Firework Display Details ---");
        System.out.println("acsse.csc2a.fmb.model.Firework Display ID     :" + displayID);
        System.out.println("acsse.csc2a.fmb.model.Firework Display Name   :" + displayName);
        System.out.println("acsse.csc2a.fmb.model.Firework Display Theme  :" + displayTheme);
        System.out.println();

        System.out.println("\n--- Lead Technician Details ---");
        System.out.println("Technician Name         :" + leadTechnician.getFullName());
        System.out.println("Technician Phone Number :" + leadTechnician.getPhoneNumber());

        System.out.println("\n--- acsse.csc2a.fmb.model.Firework Details ---");

        for (Firework firework: fireworks) {
            System.out.println("acsse.csc2a.fmb.model.Firework ID             :" + firework.getFireworkID());
            System.out.println("acsse.csc2a.fmb.model.Firework Name           :" + firework.getFireworkName());
            System.out.println("acsse.csc2a.fmb.model.Firework Fuse Length    :" + firework.getFireworkFuseLength() + " inches");
            System.out.println("acsse.csc2a.fmb.model.Firework Color          :" + firework.getFireWorkEColour());
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
    }

    // Helper functions

    /**
     * Adds a firework to the display.
     *
     * @param firework The firework to add.
     */
    public void addFireWork(Firework firework) {
        fireworks.add(firework);
    }

    /**
     * Removes the last firework from the display.
     */
    public void removeFireWork() {
        if (!fireworks.isEmpty()) {
            fireworks.removeLast();
        }
    }

}
