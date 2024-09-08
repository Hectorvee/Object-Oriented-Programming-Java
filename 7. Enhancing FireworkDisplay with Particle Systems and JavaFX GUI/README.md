# Practical: Enhancing FireworkDisplay with Particle Systems and JavaFX GUI

## Overview

In this practical, you will enhance the FireworkDisplay visualization using particle systems. Your task includes integrating the provided particle systems to animate fireworks, adding a simulation button, and updating your `Main` class to launch the enhanced JavaFX application.

## Objectives

1. **Update FireworkDisplayCanvas**:
   - Integrate particle systems for Rocket and Fountain fireworks.
   - Implement an animation timer to run the simulation.
   - Set the background color to black for better visibility.

2. **Update FireworkDisplayPane**:
   - Add a "Simulate" button to start the firework simulation.

3. **Update Main Class**:
   - Modify to extend `Application` and launch the JavaFX application with the updated `FireworkDisplayPane`.

## Components

### FireworkDisplayCanvas Class

- **Package**: `acsse.csc2a.fmb.gui`
- **Updates**:
  - **Attributes**:
    - `RocketFireworkSystem` and `FountainFireworkSystem` references.
  - **Methods**:
    - **addFireworkEntity(FireworkEntity entity)**: Add each firework to its corresponding particle system (Rocket or Fountain).
    - **startSimulation()**: 
      - Use `AnimationTimer` to repeatedly call `updateAndShow` on the particle systems.
      - Convert animation time from nanoseconds to seconds for the particle systems.
    - **redrawCanvas()**:
      - Ensure the canvas background is set to black.

**Example Code Snippet:**

```java
public class FireworkDisplayCanvas extends Canvas {
    private RocketFireworkSystem rocketSystem;
    private FountainFireworkSystem fountainSystem;

    public FireworkDisplayCanvas() {
        rocketSystem = new RocketFireworkSystem();
        fountainSystem = new FountainFireworkSystem();
        setBackground(Color.BLACK);
    }

    public void addFireworkEntity(FireworkEntity entity) {
        if (entity instanceof RocketFirework) {
            rocketSystem.addFirework((RocketFirework) entity);
        } else if (entity instanceof FountainFirework) {
            fountainSystem.addFirework((FountainFirework) entity);
        }
    }

    public void startSimulation() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double elapsedTime = now / 1_000_000_000.0; // Convert to seconds
                rocketSystem.updateAndShow(elapsedTime);
                fountainSystem.updateAndShow(elapsedTime);
            }
        };
        timer.start();
    }

    private void setBackground(Color color) {
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, getWidth(), getHeight());
    }

    // Implement redrawCanvas method as described in the previous practical
}
```

### FireworkDisplayPane Class

- **Package**: `acsse.csc2a.fmb.gui`
- **Updates**:
    - **Components**:
        - Add a `Button` named "Simulate" at the bottom of the `BorderPane`.
        - Set the button's action to call the `startSimulation` method of the `FireworkDisplayCanvas`.

**Example Code Snippet:**

```java
public class FireworkDisplayPane extends BorderPane {
    private FireworkDisplayCanvas displayCanvas;

    public FireworkDisplayPane() {
        displayCanvas = new FireworkDisplayCanvas();
        setCenter(displayCanvas);

        Button simulateButton = new Button("Simulate");
        simulateButton.setOnAction(e -> displayCanvas.startSimulation());

        setBottom(simulateButton);
    }

    // Other methods and components for displaying FireworkDisplay information
}
```

### Main Class

- **Updates**:
    - Extend `Application` and implement the `start` method.
    - Remove unnecessary imports.
    - Instantiate `FireworkDisplayPane`, add it to a `Scene`, and display it on the `Stage`.

**Example Code Snippet:**

```java
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        FireworkDisplayPane root = new FireworkDisplayPane();
        Scene scene = new Scene(root, 800, 600); // Adjust size as needed

        primaryStage.setTitle("Firework Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

## Provided Files

- **p08.jar**: Contains particle systems for Rocket and Fountain fireworks.
- **Ensure**:
    - All relevant classes are placed in the `acsse.csc2a.fmb` subpackages.

## Hints

- Explore JavaFX's `AnimationTimer` for real-time animations.
- Review the provided documentation and `p08.jar` for integration details.

## Summary

This practical involves enhancing the FireworkDisplay visualization with JavaFX and particle systems. Ensure your application is well-organized, and the simulation runs smoothly with real-time updates. If you have any questions or need further clarification, feel free to ask!
