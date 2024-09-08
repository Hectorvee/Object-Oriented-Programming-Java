package acsse.csc2a.fmb.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a rocket firework object, a type of firework that releases star spores upon explosion.
 * Inherits attributes and methods from the Firework class and implements the IDisplayable interface.
 * Provides additional attributes and functionality specific to rocket fireworks.
 */
public class RocketFirework extends Firework implements IDisplayable {

    // Additional attributes specific to rocket fireworks
    private E_COLOUR blackPowderColour;
    private int starCount;
    private double starRadius;

    // Regular expression pattern to validate rocket firework data
    private static final String ROCKET_PATTERN = "^(FR\\d{6})\\s+(.*?)\\s+(\\d+(\\.\\d+)?)\\s+(RED|ORANGE|GREEN|BLUE|YELLOW|MAGENTA|WHITE|CYAN)\\s+(\\d+)\\s+(\\d+(\\.\\d+)?)\\s+(RED|ORANGE|GREEN|BLUE|YELLOW|MAGENTA|WHITE|CYAN)$";
    /**
     * Constructs a RocketFirework object with specified attributes.
     * @param fireworkID Unique identifier for the firework.
     * @param fireworkName Name of the firework.
     * @param fireworkFuseLength Length of the fuse in seconds.
     * @param fireWorkEColour Colour of the firework.
     * @param blackPowderColour Colour of the smoke trail produced by the rocket.
     * @param starCount Count of star spores released by the rocket.
     * @param starRadius Radius of the star spores' coverage.
     */
    public RocketFirework(String fireworkID, String fireworkName, double fireworkFuseLength, E_COLOUR fireWorkEColour, E_COLOUR blackPowderColour, int starCount, double starRadius) {
        super(fireworkID, fireworkName, fireworkFuseLength, fireWorkEColour);
        this.blackPowderColour = blackPowderColour;
        this.starCount = starCount;
        this.starRadius = starRadius;
    }

    /**
     * Returns the textual representation of the RocketFirework object.
     * @return A string containing the details of the RocketFirework object.
     */
    @Override
    public String toString() {
        return super.toString() + ", blackPowderColour=" + blackPowderColour +
                ", starCount=" + starCount +
                ", starRadius=" + starRadius +
                '}';
    }

    /**
     * Displays the textual representation of the RocketFirework object to the console.
     */
    @Override
    public void display() {
        System.out.println(this);
    }

    /**
     * Gets the colour of the smoke trail produced by the rocket.
     * @return The colour of the smoke trail.
     */
    public E_COLOUR getBlackPowderColour() {
        return blackPowderColour;
    }

    /**
     * Sets the colour of the smoke trail produced by the rocket.
     * @param blackPowderColour The new colour for the smoke trail.
     */
    public void setBlackPowderColour(E_COLOUR blackPowderColour) {
        this.blackPowderColour = blackPowderColour;
    }

    /**
     * Gets the count of star spores released by the rocket.
     * @return The count of star spores.
     */
    public int getStarCount() {
        return starCount;
    }

    /**
     * Sets the count of star spores released by the rocket.
     * @param starCount The new count of star spores.
     */
    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    /**
     * Gets the radius of the star spores' coverage.
     * @return The radius of the star spores' coverage.
     */
    public double getStarRadius() {
        return starRadius;
    }

    /**
     * Sets the radius of the star spores' coverage.
     * @param starRadius The new radius of the star spores' coverage.
     */
    public void setStarRadius(double starRadius) {
        this.starRadius = starRadius;
    }

    // Static methods for pattern validation and line processing

    /**
     * Gets the regular expression pattern used to validate rocket firework data.
     * @return The regular expression pattern.
     */
    public static String getRocketPattern() {
        return ROCKET_PATTERN;
    }

    /**
     * Validates the provided line against the rocket firework pattern.
     * @param line The line to validate.
     * @return True if the line matches the pattern, false otherwise.
     */
    public static boolean validate(String line) {
        return line.matches(ROCKET_PATTERN);
    }

    /**
     * Processes the provided line to create a RocketFirework object and adds it to the FireworkDisplay.
     * @param line The line containing rocket firework data.
     * @param fireworkDisplay The FireworkDisplay object to add the rocket firework to.
     */
    public static void processLine(String line, FireworkDisplay fireworkDisplay) {
        // Compile the regular expression pattern for rocket fireworks
        Pattern pattern = Pattern.compile(ROCKET_PATTERN);

        // Create a matcher object to match the input line with the rocket pattern
        Matcher matcher = pattern.matcher(line);

        // If the line matches the rocket pattern
        if (matcher.find()) {
            // Extract the attributes from the matched groups
            String fireworkId = matcher.group(1);
            String fireworkName = matcher.group(2);
            double fuseLength = Double.parseDouble(matcher.group(3));
            String fireworkColour = matcher.group(5);
            int starCount = Integer.parseInt(matcher.group(6));
            double starRadius = Double.parseDouble(matcher.group(7));
            String blackPowderColour = matcher.group(9);

            // Convert string representations of colours to E_COLOUR enum values
            E_COLOUR fColour = E_COLOUR.valueOf(fireworkColour);
            E_COLOUR bpColour = E_COLOUR.valueOf(blackPowderColour);

            // Instantiate a RocketFirework object with the extracted attributes
            RocketFirework rocketFirework = new RocketFirework(fireworkId, fireworkName, fuseLength, fColour, bpColour, starCount, starRadius);

            // Add the RocketFirework object to the FireworkDisplay
            fireworkDisplay.addFireWork(rocketFirework);
        }
    }
}
