package acsse.csc2a.fmb.model;

/**
 * Represents a FireworkEntity with a firework object.
 * This class defines attributes and methods for FireworkEntity.
 */
public class FireworkEntity extends Entity {
    //
    Firework firework;

    /**
     * Parameterised constructor with firework to initialise the object.
     * @param firework  Firework object
     */
    public FireworkEntity(Firework firework) {
        this.firework = firework;
    }

    /**
     * Parameterised constructor to initialise FireworkEntity the object.
     * @param xLocation Indicates the Firework’s position on the x-axis.
     * @param angle Specifies the Firework’s angle of inclination
     * @param firework  a reference to a Firework.
     */
    public FireworkEntity(int xLocation, double angle, Firework firework) {
        super(xLocation, angle);
        this.firework = firework;
    }

    /**
     * Returns a string representation of the object.
     * @return A string containing the entity's firework fields, X location and angle.
     */
    @Override
    public String toString() {
        return firework.toString() + super.toString();
    }

    /**
     * Retrieves the firework object of entity
     * @return  returns the firework object
     */
    public Firework getFirework() {
        return firework;
    }

    /**
     * Sets the new firework for entity
     * @param firework  New firework object
     */
    public void setFirework(Firework firework) {
        this.firework = firework;
    }
}
