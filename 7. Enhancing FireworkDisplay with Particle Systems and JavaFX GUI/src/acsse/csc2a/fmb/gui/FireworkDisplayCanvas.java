package acsse.csc2a.fmb.gui;

import java.util.ArrayList;

import acsse.csc2a.fmb.model.Entity;
import acsse.csc2a.fmb.model.FireworkEntity;
import acsse.csc2a.fmb.model.FountainFirework;
import acsse.csc2a.fmb.model.RocketFirework;
import acsse.csc2a.fmb.particles.FountainParticleSystem;
import acsse.csc2a.fmb.particles.RocketParticleSystem;
import acsse.csc2a.fmb.pattern.EntityVisitor;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class FireworkDisplayCanvas extends Canvas {
	// Attributes
	private ArrayList<FireworkEntity> entities = null;
	private static final int NUM_ROWS = 15;
	private static final int NUM_COLS = 15;
	private static final int CELL_SIZE = 50;
	private static final int SIZE = NUM_ROWS * CELL_SIZE;
	private EntityVisitor visitor = null;
	private RocketParticleSystem rocketParticleSystem = new RocketParticleSystem();
	private FountainParticleSystem fountainParticleSystem = new FountainParticleSystem();
	private long lastNanoTime = System.nanoTime();



	/**
	 * Default constructor to set the size of the canvas
	 */
	public FireworkDisplayCanvas() {
		setWidth(SIZE);
		setHeight(SIZE);
		// Create a Visitor to draw the FireworkEntities
		visitor = new EntityVisitor(SIZE, CELL_SIZE);

	}

	/**
	 * 
	 * Method to set the FireworkEntity array for drawing
	 * 
	 * @param fireworkEntities ArrayList of FireworkEntity objects
	 */
	public void setFireworkEntities(ArrayList<FireworkEntity> fireworkEntities) {
		this.entities = fireworkEntities;
		setParticleSystem(fireworkEntities);
		// Redraw the canvas to show the FireworkDisplayCanvas objects
		redrawCanvas();
	}

	/**
	 * Sets up the particle systems based on the provided list of firework entities.
	 * @param fireworkEntities The list of firework entities to set up particle systems for.
	 */
	private void setParticleSystem(ArrayList<FireworkEntity> fireworkEntities) {
		// Iterate over each firework entity
		for (FireworkEntity entity: fireworkEntities) {
			if (entity.getFirework() instanceof RocketFirework rocketFirework) {
				rocketParticleSystem.addFirework(entity.getXLocation()*CELL_SIZE, SIZE, rocketFirework);
			} else if (entity.getFirework() instanceof FountainFirework fountainFirework) {
				fountainParticleSystem.addFirework(entity.getXLocation()*CELL_SIZE, SIZE, fountainFirework);
			}
		}
	}

	/**
	 * Starts the simulation by continuously updating and showing the particle systems using an AnimationTimer.
	 */
	public void startSimulation() {
		// Create an AnimationTimer to continuously update the simulation
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long currentNanoTime) {
				// Convert nanoseconds to seconds
				double elapsedTime = (currentNanoTime - lastNanoTime) / 1e9;
				lastNanoTime = currentNanoTime;

				// Update and show the particle systems
				GraphicsContext gc = getGraphicsContext2D();
				rocketParticleSystem.updateAndShow(gc, elapsedTime);
				fountainParticleSystem.updateAndShow(gc, elapsedTime);
			}
		};
		timer.start();
	}

	/**
	 * Method to draw FireworkEntity objects on the canvas
	 */
	public void redrawCanvas() {
		// GraphicsContext
		GraphicsContext gc = getGraphicsContext2D();

		// provide the visitor with the context
		visitor.setGraphicsContext(gc);

		// clear the canvas
		gc.clearRect(0, 0, getWidth(), getHeight());

		// Draw the grid
		gc.setStroke(Color.WHITE);
		gc.setFill(Color.BLACK);
		// Begin drawing Grid
		for (int r = 0; r < 15; r++) {
			for (int c = 0; c < 15; c++) {
				// Draw Rectangle
				// you need to multiply the row and column by cell_size to get to the correct
				// pixel location
				gc.strokeRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
				gc.fillRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
			}
		}

		// Draw each FireworkEntity using the visitor
		for (Entity entity : entities) {
			entity.accept(visitor);
		}
	}
}