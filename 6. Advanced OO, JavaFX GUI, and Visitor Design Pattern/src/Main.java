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
        launch(args);
    }

    /**
     * The start method is called when the application is launched.
     * It sets up the primary stage and initializes the user interface.
     * @param primaryStage The primary stage of the application
     * @throws Exception If an error occurs during initialization
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FireworkDisplayPane displayPane = new FireworkDisplayPane();
        Scene scene = new Scene(displayPane, 950, 625);
        primaryStage.setTitle("Firework Management Bureau");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}