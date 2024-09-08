package acsse.csc2a.fmb.file;

import acsse.csc2a.fmb.model.Entity;
import acsse.csc2a.fmb.model.Firework;
import acsse.csc2a.fmb.model.FireworkDisplay;
import acsse.csc2a.fmb.model.FireworkEntity;

import java.io.*;
import java.util.ArrayList;

/**
 * Represents a OrchestrationFileHandler with a readLayout to process data.
 * It also provides functionality for creating entities.
 */
public class OrchestrationFileHandler {

    /**
     * Read the binary file and load the necessary data in entities
     * @param filename  the filename of the binary file
     * @param fireworkDisplay FireworkDisplay object
     * @return ArrayList of entities
     */
    public ArrayList<FireworkEntity> readLayout(String filename, FireworkDisplay fireworkDisplay) {
        ArrayList<FireworkEntity> entities = new ArrayList<>();

        try (
                // Create a file input stream
                FileInputStream fileInputStream = new FileInputStream(filename);
                // Buffer the input stream
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                // Filter the stream
                DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
                )
        {

            // Read the firework display ID form the binary and assign the firework display object with new ID
            String fireworkDisplayId = dataInputStream.readUTF();
            fireworkDisplay.setDisplayID(fireworkDisplayId);

            /**
             * Read the Firework’s Unique Identifier, position on the x-axis and angle of inclination
             * Create the new entity object with this data
             * Populate an ArrayList of Entities and return it
             */
            while ((dataInputStream.available()) > 0) {
                String fireworkId = dataInputStream.readUTF();
                int xLocation = dataInputStream.readInt();
                double angle = dataInputStream.readDouble();

                Firework firework = fireworkDisplay.getFirework(fireworkId);

                FireworkEntity fireworkEntity = new FireworkEntity(xLocation, angle, firework);
                entities.add(fireworkEntity);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return entities;
    }
}
