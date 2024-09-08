import acsse.csc2a.fmb.model.*;
import acsse.csc2a.fmb.file.DisplayFileHandler;
import java.nio.file.Paths;

public class Main {
    /**
     * Main method to read firework display data from a text file and display valid firework displays.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Create a new DisplayFileHandler instance
        DisplayFileHandler fileHandler = new DisplayFileHandler();

        // Read firework display data from the specified text file
        String path = Paths.get("data", "clean_1.txt").toAbsolutePath().toString();
        FireworkDisplay fireworkDisplay = fileHandler.readDisplay(path);

        // Display valid firework displays and fireworks
        System.out.println("Valid Firework Displays:");
        fireworkDisplay.printDisplay();
    }
}

