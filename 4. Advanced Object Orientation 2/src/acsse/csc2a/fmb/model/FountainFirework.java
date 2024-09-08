package acsse.csc2a.fmb.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a Fountain Firework, a type of Firework that displays dynamic transition colours.
 * Extends the Firework class and implements the IDisplayable interface.
 * (Firework Management Bureau)
 */
public class FountainFirework extends Firework {

    // Attributes specific to FountainFirework
    private double duration;
    private E_COLOUR[] transitionColours;

    // Regular expression pattern for validating FountainFirework data format
    private static final String FOUNTAIN_PATTERN = "^(FF\\d{6})\\s+(.*?)\\s+(\\d+(\\.\\d+)?)\\s+(RED|ORANGE|GREEN|BLUE|YELLOW|MAGENTA|WHITE|CYAN)\\s+(\\d+)\\s+\\[((?:RED|ORANGE|GREEN|BLUE|YELLOW|MAGENTA|WHITE|CYAN)(?:\\|(?:RED|ORANGE|GREEN|BLUE|YELLOW|MAGENTA|WHITE|CYAN))*)\\]$";

    /**
     * Constructs a FountainFirework object with specified attributes.
     * @param fireworkID Unique identifier for the firework.
     * @param fireworkName Name of the firework.
     * @param fireworkFuseLength Length of the fuse in seconds.
     * @param fireWorkEColour Colour of the firework.
     * @param duration Duration of the fountain display in seconds.
     * @param transitionColours Array of transition colours during the fountain display.
     */

    public FountainFirework(String fireworkID, String fireworkName, double fireworkFuseLength, E_COLOUR fireWorkEColour, double duration, E_COLOUR[] transitionColours) {
        super(fireworkID, fireworkName, fireworkFuseLength, fireWorkEColour);
        this.duration = duration;
        this.transitionColours = transitionColours;
    }

    /**
     * Returns the textual representation of the FountainFirework object.
     * @return A string containing the details of the FountainFirework object.
     */
    @Override
    public String toString() {
        return super.toString() + ", duration=" + duration +
                ", transitionColours=" + Arrays.toString(transitionColours) +
                '}';
    }

    /**
     * Displays the textual representation of the FountainFirework object to the console.
     */
    @Override
    public void display() {
        System.out.println(this);
    }

    /**
     * Getter for duration attribute.
     * @return The duration of the fountain display in seconds.
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Setter for duration attribute.
     * @param duration The duration of the fountain display in seconds.
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Getter for transitionColours attribute.
     * @return Array of transition colours during the fountain display.
     */
    public E_COLOUR[] getTransitionColours() {
        return transitionColours;
    }

    /**
     * Setter for transitionColours attribute.
     * @param transitionColours Array of transition colours during the fountain display.
     */
    public void setTransitionColours(E_COLOUR[] transitionColours) {
        this.transitionColours = transitionColours;
    }

    /**
     * Getter for the FOUNTAIN_PATTERN regular expression.
     * @return The regular expression pattern for FountainFirework validation.
     */
    public static String getFountainPattern() {
        return FOUNTAIN_PATTERN;
    }

    /**
     * Validates if the provided line matches the FountainFirework data format.
     * @param line The line to validate.
     * @return true if the line matches the format, false otherwise.
     */
    public static boolean validate(String line) {
        return line.matches(FOUNTAIN_PATTERN);
    }

    /**
     * Processes the provided line to instantiate a FountainFirework object and add it to the FireworkDisplay.
     * @param line The line containing FountainFirework data.
     * @param fireworkDisplay The FireworkDisplay to add the instantiated FountainFirework object to.
     */
    public static void processLine(String line, FireworkDisplay fireworkDisplay) {
        // Compile the regular expression pattern for FountainFirework
        Pattern pattern = Pattern.compile(FOUNTAIN_PATTERN);

        // Create a matcher to match the input line with the FountainFirework pattern
        Matcher matcher = pattern.matcher(line);

        // Check if the line matches the FountainFirework pattern
        if (matcher.find()) {
            // Extract information from the matched groups
            String fireworkId = matcher.group(1);
            String fireworkName = matcher.group(2);
            double fuseLength = Double.parseDouble(matcher.group(3));
            String fireworkColour = matcher.group(5);
            int duration = Integer.parseInt(matcher.group(6));
            String transitionColoursString = matcher.group(7);

            // Split the transition colors string by '|' to get individual colors
            String[] transitionColoursArray = transitionColoursString.split("\\|");

            // Create an array to hold the E_COLOUR values of transition colors
            E_COLOUR[] transitionColours = new E_COLOUR[transitionColoursArray.length];

            // Convert the string representation of colors to E_COLOUR enum values
            for (int i = 0; i < transitionColoursArray.length; i++) {
                transitionColours[i] = E_COLOUR.valueOf(transitionColoursArray[i]);
            }

            // Convert the string representation of the primary color to E_COLOUR enum value
            E_COLOUR fColour = E_COLOUR.valueOf(fireworkColour);

            // Create a new FountainFirework object with extracted information
            FountainFirework fountainFirework = new FountainFirework(fireworkId, fireworkName, fuseLength, fColour, duration, transitionColours);

            // Add the FountainFirework object to the FireworkDisplay
            fireworkDisplay.addFireWork(fountainFirework);
        }
    }
}
