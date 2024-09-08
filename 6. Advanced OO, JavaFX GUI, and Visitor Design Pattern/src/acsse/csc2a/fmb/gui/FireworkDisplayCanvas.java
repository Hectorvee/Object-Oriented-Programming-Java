package acsse.csc2a.fmb.gui;

import acsse.csc2a.fmb.model.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * This class represents a canvas for displaying fireworks.
 * It extends the Canvas class from JavaFX and provides methods for drawing entities on the canvas.
 */
public class FireworkDisplayCanvas extends Canvas {

    // Attributes
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    public static final int CELL_SIZE = 40;
    public static final int CANVAS_WIDTH = WIDTH * CELL_SIZE;
    public static final int CANVAS_HEIGHT = HEIGHT * CELL_SIZE;
    private final GraphicsContext gc = this.getGraphicsContext2D(); // GraphicsContext for drawing on the canvas
    private ArrayList<FireworkEntity> fireworkEntities; // List of firework entities to be drawn on the canvas
    private AbstractVisitor visitor; // Visitor object for drawing entities


    // Constructors

    /**
     * Constructor for FireworkDisplayCanvas.
     * Initializes the canvas and draws the grid.
     */
    public FireworkDisplayCanvas() {
        redrawCanvas();
    }

    // Methods

    /**
     * Redraws the canvas with the grid.
     */
    public void redrawCanvas() {
        this.setWidth(CANVAS_WIDTH);
        this.setHeight(CANVAS_HEIGHT);
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        drawGrid(gc);
    }

    /**
     * Draws all the firework entities on the canvas.
     */
    public void drawEntities() {
        redrawCanvas();
        for (FireworkEntity entity : fireworkEntities) {
            entity.accept(visitor);
        }
    }

    // Getters and Setters

    /**
     * Sets the list of firework entities to be drawn on the canvas.
     * @param fireworkEntities The list of firework entities
     */
    public void setFireworkEntities(ArrayList<FireworkEntity> fireworkEntities) {
        this.fireworkEntities = fireworkEntities;
    }

    /**
     * Gets the list of firework entities currently set to be drawn on the canvas.
     * @return The list of firework entities
     */
    public ArrayList<FireworkEntity> getFireworkEntities() {
        return fireworkEntities;
    }

    /**
     * Sets the visitor object to be used for drawing entities on the canvas.
     * @param visitor The visitor object
     */
    public void setVisitor(AbstractVisitor visitor) {
        this.visitor = visitor;
    }

    /**
     * Gets the GraphicsContext for drawing on the canvas.
     *
     * @return The GraphicsContext object
     */
    public GraphicsContext getGraphicsContext() {
        return gc;
    }

    // Override Methods

    // Helper Methods

    /**
     * Draws the grid on the canvas.
     * @param gc The GraphicsContext object for drawing
     */
    private void drawGrid(GraphicsContext gc) {
        Color fillColor = Color.web("#EEEEEE");
        Color lineColor = Color.web("#31363F");
        for (int row = 0; row<HEIGHT; row++) {
            for (int col = 0; col<WIDTH; col++) {
                gc.setFill(fillColor);
                gc.setStroke(lineColor);
                gc.strokeRect(row*CELL_SIZE, col*CELL_SIZE, CELL_SIZE, CELL_SIZE);
                gc.fillRect(row*CELL_SIZE, col*CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

}
