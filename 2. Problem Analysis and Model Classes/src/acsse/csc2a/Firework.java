package acsse.csc2a;

/**
 * Represents a firework object.
 */
public class Firework {

    // Attributes
    private final String fireworkID;
    private String fireworkName;
    private double fireworkFuseLength;
    private E_COLOUR fireWorkEColour;

    // Constructors

    /**
     * Constructs a Firework object with specified attributes.
     * @param fireworkID Unique identifier for the firework.
     * @param fireworkName Name of the firework.
     * @param fireworkFuseLength Length of the fuse in seconds.
     * @param fireWorkEColour Colour of the firework.
     */
    public Firework(String fireworkID, String fireworkName, double fireworkFuseLength, E_COLOUR fireWorkEColour) {
        this.fireworkID = fireworkID;
        this.fireworkName = fireworkName;
        this.fireworkFuseLength = fireworkFuseLength;
        this.fireWorkEColour = fireWorkEColour;
    }

    // Methods

    // Getters

    /**
     * Gets the firework's unique identifier.
     * @return The firework's unique identifier.
     */
    public String getFireworkID() {
        return fireworkID;
    }

    /**
     * Gets the firework's name.
     * @return The firework's name.
     */
    public String getFireworkName() {
        return fireworkName;
    }

    /**
     * Gets the length of the firework's fuse.
     * @return The length of the firework's fuse in seconds.
     */
    public double getFireworkFuseLength() {
        return fireworkFuseLength;
    }

    /**
     * Gets the colour of the firework.
     * @return The colour of the firework.
     */
    public E_COLOUR getFireWorkEColour() {
        return fireWorkEColour;
    }

    // Setters

    /**
     * Sets the name of the firework.
     * @param newFireworkName The new name for the firework.
     */
    public void setFireworkName (String newFireworkName) {

        if (newFireworkName.isEmpty()) {
            System.err.println("Firework name is empty");
            System.exit(ErrorConstantsCodes.ERROR_STRING_EMPTY);
        }

        fireworkName = newFireworkName;
    }

    /**
     * Sets the length of the firework's fuse.
     * @param newFireworkFuseLength The new length of the firework's fuse in seconds.
     */
    public void setFireworkFuseLength(double newFireworkFuseLength) {

        if (newFireworkFuseLength < 0) {
            System.err.println("Firework fuse length cannot be a negative number");
            System.exit(ErrorConstantsCodes.ERROR_NEGATIVE_NUMBER);
        }

        fireworkFuseLength = newFireworkFuseLength;
    }

    /**
     * Sets the colour of the firework.
     * @param newFireWorkEColour The new colour for the firework.
     */
    public void setFireWorkEColour(E_COLOUR newFireWorkEColour) {

        fireWorkEColour = newFireWorkEColour;
    }
}