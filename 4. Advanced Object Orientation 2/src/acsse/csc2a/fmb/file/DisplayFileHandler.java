package acsse.csc2a.fmb.file;

import acsse.csc2a.fmb.model.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class handles reading data from a text file and constructs a FireworkDisplay object.
 * It provides methods to read the contents of the file, validate the data, and process each line accordingly.
 */
public class DisplayFileHandler{
    // Regular expressions for parsing different lines in the text file
    private static final String DISPLAY_PATTERN = "^(FD\\d{4})\\s+\\[(.*?)\\]\\s+\"(.*?)\"$";
    /**
     * Reads the contents of the specified file and constructs a FireworkDisplay object.
     * @param filename The name of the file to read.
     * @return A FireworkDisplay object constructed from the file data.
     */
    public FireworkDisplay readDisplay(String filename) {
        FireworkDisplay fireworkDisplay = null;
        File displayFile = new File(filename);

        if (!(displayFile.exists())) {
            System.err.println("Error: the provided file is not valid");
            return fireworkDisplay;
        }

        try (Scanner scanner = new Scanner(displayFile)) {
            // Check if file is empty
            if (!scanner.hasNext()) {
                System.err.println("The provided file is empty: " + filename);
                return fireworkDisplay;
            }

            String fireworkDisplayInfo = scanner.nextLine();

            // Validate firework display info
            if (!validate(fireworkDisplayInfo)) {
                return fireworkDisplay;
            }

            // Check if there's pyrotechnician info
            if (!scanner.hasNextLine()) {
                System.err.println("The provided file only has information about display only.");
                return fireworkDisplay;
            }

            String pyroTechnicianInfo = scanner.nextLine();

            // Validate pyrotechnician info
            if (!PyroTechnician.validate(pyroTechnicianInfo)) {
                return fireworkDisplay;
            }

            fireworkDisplay = new FireworkDisplay();
            processLine(fireworkDisplayInfo, fireworkDisplay);
            PyroTechnician.processLine(pyroTechnicianInfo, fireworkDisplay);

            // Process remaining lines for firework details
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (FountainFirework.validate(line)) {
                    FountainFirework.processLine(line, fireworkDisplay);
                } else if (RocketFirework.validate(line)) {
                    RocketFirework.processLine(line, fireworkDisplay);
                } else {
                    System.err.println("Invalid line: " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return fireworkDisplay;
    }

    /**
     * Validates the format of the line based on the DISPLAY_PATTERN.
     * @param line The line to validate.
     * @return True if the line matches the expected format, false otherwise.
     */
    public static boolean validate(String line) {
        return line.matches(DISPLAY_PATTERN);
    }

    /**
     * Processes a line from the input file and updates the FireworkDisplay object accordingly.
     * @param line The line to process.
     * @param fireworkDisplay The FireworkDisplay object to update.
     */
    private void processLine(String line, FireworkDisplay fireworkDisplay) {
        Pattern pattern = Pattern.compile(DISPLAY_PATTERN);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            String displayId = matcher.group(1);
            String displayName = matcher.group(2);
            String displayTheme = matcher.group(3);
            fireworkDisplay.setDisplayID(displayId);
            fireworkDisplay.setDisplayName(displayName);
            fireworkDisplay.setDisplayTheme(displayTheme);
        }

    }
}
