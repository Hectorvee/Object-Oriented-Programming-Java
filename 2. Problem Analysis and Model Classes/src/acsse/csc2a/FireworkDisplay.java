package acsse.csc2a;

/**
 * This class manages the display ID, name, theme, lead technician, and fireworks included in the display.
 * Represents a firework display with its attributes and methods.
 */
public class FireworkDisplay {

    // Attributes
    private final String displayID;
    private String displayName;
    private String displayTheme;
    private PyroTechnicians leadTechnician;
    private Firework[] fireworks;

    // Constructors

    /**
     * Constructs a FireworkDisplay object with the given parameters.
     * @param displayID       The ID of the firework display.
     * @param displayName     The name of the firework display.
     * @param displayTheme    The theme of the firework display.
     * @param leadTechnician  The lead technician responsible for the display.
     * @param arrFirework     An array of Firework objects representing the fireworks in the display.
     */
    public FireworkDisplay(String displayID, String displayName, String displayTheme, PyroTechnicians leadTechnician, Firework... arrFirework) {
        this.displayID = displayID;
        this.displayName = displayName;
        this.displayTheme = displayTheme;
        this.leadTechnician = leadTechnician;
        addFireWorks(arrFirework);

    }

    // Methods

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
    public PyroTechnicians getLeadTechnician() {
        return leadTechnician;
    }

    /**
     * Gets the array of fireworks included in the display.
     * @return The array of fireworks.
     */
    public Firework[] getFirework() {
        return fireworks;
    }

    // Setters
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
    public void setLeadTechnician(PyroTechnicians leadTechnician) {
        this.leadTechnician = leadTechnician;
    }

    /**
     * Prints the details of the firework display and its fireworks.
     */
    public void printDisplay() {

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\n--- Firework Display Details ---");
        System.out.println("Firework Display ID     :" + displayID);
        System.out.println("Firework Display Name   :" + displayName);
        System.out.println("Firework Display Theme  :" + displayTheme);
        System.out.println();

        System.out.println("\n--- Lead Technician Details ---");
        System.out.println("Technician Name         :" + leadTechnician.getFullName());
        System.out.println("Technician Phone Number :" + leadTechnician.getPhoneNumber());

        System.out.println("\n--- Firework Details ---");

        for (Firework firework: fireworks) {
            System.out.println("Firework ID             :" + firework.getFireworkID());
            System.out.println("Firework Name           :" + firework.getFireworkName());
            System.out.println("Firework Fuse Length    :" + firework.getFireworkFuseLength() + " inches");
            System.out.println("Firework Color          :" + firework.getFireWorkEColour());
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
    }

    // Helper functions

    /**
     * Adds the given fireworks to the display.
     * @param arrFireworks An array of Firework objects to add to the display.
     */
    private void addFireWorks(Firework[] arrFireworks) {

        fireworks = new Firework[arrFireworks.length];
        System.arraycopy(arrFireworks, 0, fireworks, 0, arrFireworks.length);
    }

}
