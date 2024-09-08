import acsse.csc2a.*;
import java.util.Arrays;
import java.util.Random;

/**
 * This class represents the main entry point for the program.
 * It generates alphanumeric IDs for fireworks, creates firework and pyrotechnician objects,
 * organizes firework displays, and prints the details of each display.
 */

public class Main {

    /**
     * This method is the main entry point for the program.
     * It initializes firework, pyrotechnician, and firework display objects,
     * and prints the details of each display.
     * @param args The command-line arguments (not used in this program)
     */
    public static void main(String[] args) {

        // Creating firework objects with generated IDs and specified attributes
        Firework firework1 = new Firework(alphanumericIDGen(), "Sparkling Spectacle", 3, E_COLOUR.GREEN);
        Firework firework2 = new Firework(alphanumericIDGen(), "Colorful Cascade", 5, E_COLOUR.BLUE);
        Firework firework3 = new Firework(alphanumericIDGen(), "Thunderous Finale", 7, E_COLOUR.CYAN);
        Firework firework4 = new Firework(alphanumericIDGen(), "Twilight Twister", 4, E_COLOUR.RED);

        // Creating pyrotechnician objects with names and contact numbers
        PyroTechnicians technician1 = new PyroTechnicians("Hector Mathonsi", "0784529874");
        PyroTechnicians technician2 = new PyroTechnicians("Sfiso Rimana", "0781253694");

        // Creating firework display objects with generated IDs, names, themes, technicians, and fireworks
        FireworkDisplay fireworkDisplay1 = new FireworkDisplay(alphanumericIDGen(), "Starlight Symphony", "Celestial Elegance", technician1, firework1, firework2);
        FireworkDisplay fireworkDisplay2 = new FireworkDisplay(alphanumericIDGen(), "Fiesta Flambeau", "Vibrant Fiesta", technician2, firework3, firework4);

        // Printing details of each firework display
        fireworkDisplay1.printDisplay();
        fireworkDisplay2.printDisplay();
    }

    /**
     * This method generates a unique alphanumeric ID of length 9.
     * It combines 3 lowercase letters, 3 uppercase letters, and 3 digits
     * @return A unique alphanumeric ID
     */
    private static String alphanumericIDGen() {
        char[] ID = new char[9];    // Array to store the generated ID
        Arrays.fill(ID, ' ');   // Filling the array with spaces initially
        Random random = new Random();
        char[][] charID = {         // Arrays containing lowercase letters, uppercase letters, and digits
                {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'},
                {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'G', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'},
                {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}
        };

        // Generating the unique alphanumeric ID
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                int randomCharIndex = random.nextInt(charID[i].length);
                int randomIndex = random.nextInt(ID.length);

                while (ID[randomIndex] != ' ') {
                    randomIndex = random.nextInt(ID.length);
                }

                ID[randomIndex] = charID[i][randomCharIndex];
            }
        }

        return new String(ID);  // Converting the char array to a string and returning it
    }
}