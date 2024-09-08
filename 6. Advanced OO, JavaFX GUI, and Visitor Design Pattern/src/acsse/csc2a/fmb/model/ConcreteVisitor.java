package acsse.csc2a.fmb.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static acsse.csc2a.fmb.gui.FireworkDisplayCanvas.CANVAS_HEIGHT;
import static acsse.csc2a.fmb.gui.FireworkDisplayCanvas.CELL_SIZE;

/**
 * ConcreteVisitor class implements the AbstractVisitor interface
 * to visit FireworkEntity objects and draw them on the canvas.
 * It provides methods for visiting FireworkEntity objects and
 * drawing the corresponding shapes based on their attributes.
 */
public class ConcreteVisitor implements AbstractVisitor{

    private final GraphicsContext gc;

    /**
     * Constructs a ConcreteVisitor object with the specified GraphicsContext.
     * @param gc The GraphicsContext used for drawing on the canvas
     */
    public ConcreteVisitor(GraphicsContext gc) {
        this.gc = gc;
    }

    /**
     * Visits a FireworkEntity object and draws the corresponding shape on the canvas.
     * @param fireworkEntity The FireworkEntity to be visited and drawn
     */
    @Override
    public void visit(FireworkEntity fireworkEntity) {
        double angle = fireworkEntity.getAngle() - 90;
        // Draw the shape based on angle and type of firework

        // Save the current transformation
        gc.save();

        // Translate to the center of the shape
        double centerX = (fireworkEntity.getXLocation() * CELL_SIZE) + ((double) CELL_SIZE / 2);
        double centerY = CANVAS_HEIGHT - ((double) CELL_SIZE / 2);
        gc.translate(centerX, centerY);

        // Rotate based on the angle
        gc.rotate(angle);
        if (fireworkEntity.getFirework() instanceof RocketFirework rocketFirework) {
            gc.setStroke(Color.valueOf(String.valueOf(rocketFirework.getColour())));
            gc.setFill(Color.valueOf(String.valueOf(rocketFirework.getColour())));

            gc.fillRect(-10, -15, 20, 30); // Adjust the coordinates relative to the center
        } else if (fireworkEntity.getFirework() instanceof FountainFirework fountainFirework) {
            gc.setStroke(Color.valueOf(String.valueOf(fountainFirework.getColour())));
            gc.setFill(Color.valueOf(String.valueOf(fountainFirework.getColour())));

            gc.fillOval(-15, -15, 30, 30); // Adjust the coordinates relative to the center

        }

        // Restore the original transformation
        gc.restore();
    }
}
