package acsse.csc2a.fmb.file;

import java.io.File;
import java.io.IOException;
import acsse.csc2a.fmb.model.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisplayFileHandler {
    // Regular expressions for parsing different lines in the text file
    private static final String DISPLAY_PATTERN = "^FD(\\d{4})\\s+\\[(.*?)\\]\\s+\"(.*?)\"$";
    private static final String TECHNICIAN_PATTERN = "^([A-Z][a-z]+)-([A-Z][a-z]+)\\s+(\\d{3}-\\d{3}-\\d{4})$";
    private static final String FIREWORK_PATTERN = "^FW_(\\d{6})\\s+(.*?)\\s+(\\d+(\\.\\d+)?)\\s+(RED|ORANGE|GREEN|BLUE|YELLOW|MAGENTA|WHITE|CYAN)$";

    /**
     * Reads the contents of the specified file and constructs a FireworkDisplay object.
     * @param filename The name of the file to read.
     * @return A FireworkDisplay object constructed from the file data.
     */
    public FireworkDisplay readDisplay(String filename) {
        FireworkDisplay fireworkDisplay = new FireworkDisplay();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                processLine(scanner.nextLine(), fireworkDisplay);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return fireworkDisplay;
    }

    /**
     * Processes a line from the input file and updates the FireworkDisplay object accordingly.
     * @param line The line to process.
     * @param fireworkDisplay The FireworkDisplay object to update.
     */
    private void processLine(String line, FireworkDisplay fireworkDisplay) {
        if (line.matches(DISPLAY_PATTERN)) {
            // Process Firework Display line
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
        } else if (line.matches(TECHNICIAN_PATTERN)) {
            // Process PyroTechnician line
            Pattern pattern = Pattern.compile(TECHNICIAN_PATTERN);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String firstName = matcher.group(1);
                String lastName = matcher.group(2);
                String phoneNumber = matcher.group(3);
                PyroTechnician technician = new PyroTechnician(firstName, lastName, phoneNumber);
                fireworkDisplay.setLeadTechnician(technician);
            }
        } else if (line.matches(FIREWORK_PATTERN)) {
            // Process Firework line
            Pattern pattern = Pattern.compile(FIREWORK_PATTERN);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String fireworkId = matcher.group(1);
                String fireworkName = matcher.group(2);
                double fuseLength = Double.parseDouble(matcher.group(3));
                String fireworkColour = matcher.group(4);
                E_COLOUR colour = E_COLOUR.valueOf(fireworkColour);
                Firework firework = new Firework(fireworkId, fireworkName, fuseLength, colour);
                fireworkDisplay.addFireWork(firework);
            }
        } else {
            System.err.println("Invalid line: " + line);
        }
    }
}
