package acsse.csc2a.fmb.model;

/**
 * Represents an entity super class with its attributes and methods.
 * Manages the xLocation and angle in the entity.
 */
public abstract class Entity implements AbstractVisitable{

    // Attributes
    private int xLocation;
    private double angle;

    // Constructors
    /**
     * Default constructor for entity
     */
    public Entity() {
        this(0, 0);
    }

    /**
     * Parameterised constructor with xLocation and angle.
     * @param xLocation Represents the Entity’s position along the x-axis
     * @param angle Indicates the Entity’s angle of inclination
     */
    public Entity(int xLocation, double angle) {
        this.xLocation = xLocation;
        this.angle = angle;
    }

    // Getters and Setters
    /**
     * Retrieves the entity x location
     * @return  Entity X location
     */
    public int getXLocation() {
        return xLocation;
    }

    /**
     * Sets the entity X location
     * @param xLocation New entity x Location
     */
    public void setXLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    /**
     * Retrieves the entity angle
     * @return  returns entity angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Sets the entity angle
     * @param angle New entity angle
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    // Methods

    // Overridden Methods
    /**
     * Returns a string representation of the object.
     * @return A string containing the entity's firework fields, X location and angle.
     */
    @Override
    public String toString() {
        return "\nX Location: " + getXLocation() + "\nAngle: " + getAngle();
    }

    // Helper Functions





}
