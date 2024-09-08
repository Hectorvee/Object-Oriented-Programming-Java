import acsse.csc2a.fmb.file.*;
import acsse.csc2a.fmb.model.*;

import java.util.ArrayList;

/**
 * The Main class serves as the entry point for the program.
 * It creates the FireworkDisplay object to then loads the fireworks
 * It invokes the readLayout method of the OrchestrationFileHandler class to execute the program logic.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("*************************************************************\n");
        System.out.println("*                    Loading FireWorks                      *\n");
        System.out.println("*************************************************************\n");

        // Creates the FireworkDisplay object and load the fireworks
        FireworkDisplay fireworkDisplay = DisplayFileHandler.readDisplay("data/displays/FD0001.txt");

        // Creates the OrchestrationFileHandler object
        OrchestrationFileHandler file = new OrchestrationFileHandler();

        // ArrayList of entities
        ArrayList<FireworkEntity> entities = file.readLayout("data/layouts/layout_1.dat", fireworkDisplay);

        System.out.println("*************************************************************\n");
        System.out.println("*                    Displaying Entities                    *\n");
        System.out.println("*************************************************************\n");

        // Displaying entities
        int count = 1;
        for (FireworkEntity entity: entities) {
            System.out.println("*********************** Entity " + count + " ******************************");
            System.out.println(entity);
            System.out.println();
            count++;
        }
    }
}