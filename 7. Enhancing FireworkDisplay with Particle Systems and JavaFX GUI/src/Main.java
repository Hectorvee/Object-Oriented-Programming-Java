import acsse.csc2a.fmb.gui.FireworkDisplayPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Main class is the entry point of the Firework Management Bureau application.
 * It extends the Application class from JavaFX, allowing it to create and manage the application's UI.
 */
public class Main extends Application {

    /**
     * The main method is the entry point of the application.
     * It launches the JavaFX application by calling the launch() method.
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        launch(args); // Launch the JavaFX Application
    }

    /**
     * The start method is called when the application is launched.
     * It sets up the primary stage and initializes the user interface.
     * @param primaryStage The primary stage of the application
     * @throws Exception If an error occurs during initialization
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instantiate an instance of the FireworkDisplayPane
        FireworkDisplayPane fireworkDisplayPane = new FireworkDisplayPane();

        // Add the FireworkDisplayPane instance to a Scene
        Scene scene = new Scene(fireworkDisplayPane, 950, 625);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Firework Management Bureau");
        primaryStage.show();
    }
}
