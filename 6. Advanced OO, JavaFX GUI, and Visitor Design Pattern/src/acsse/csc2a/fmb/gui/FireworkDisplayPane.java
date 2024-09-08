package acsse.csc2a.fmb.gui;

import acsse.csc2a.fmb.file.OrchestratorFileHandler;
import acsse.csc2a.fmb.model.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * FireworkDisplayPane is a custom JavaFX component that represents the main display pane for managing firework displays.
 * It provides functionality for opening layout files, displaying firework information, and updating the display.
 */
public class FireworkDisplayPane extends StackPane {

    // Attributes
    private DisplayBundle displayBundle;
    private final FireworkDisplayCanvas canvas = new FireworkDisplayCanvas();
    private final Accordion accordion = new Accordion();
    private final BorderPane pane = new BorderPane();
    private final Pattern fileNamePattern = Pattern.compile("layout_\\d+\\.dat");

    // Constructors

    /**
     * Initialize the pane layout
     */
    public FireworkDisplayPane() {
        pane.setLeft(initializeAccordion());
        pane.setCenter(canvas);
        pane.setTop(getMenu());
        getChildren().add(pane);
    }

    // Getters and Setters

    // Methods

    // Overridden Methods

    // Helper Functions

    /**
     * Creates and returns an HBox containing a MenuBar with a single Menu and a MenuItem.
     * The MenuItem is configured to handle file selection.
     * @return The constructed HBox containing the MenuBar.
     */
    private HBox getMenu() {
        // Create a MenuBar
        MenuBar menuBar = new MenuBar();

        // Create a Menu and add it to the MenuBar
        Menu menu = new Menu("Menu");
        menuBar.getMenus().add(menu);

        // Create a MenuItem for opening files
        MenuItem fileItem = new MenuItem("Open");
        fileItem.setOnAction(
                actionEvent -> handleFileChooser()
        );


        menu.getItems().add(fileItem);
        HBox root = new HBox(menuBar);

        // Set the background color of the HBox
        root.setStyle("-fx-background-color: #222831");

        return root;
    }

    /**
     * Handles the file chooser dialog for selecting a file.
     */
    private void handleFileChooser() {
        // Create a file chooser dialog
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose file");

        // Show the file chooser dialog and wait for user input
        File file = fileChooser.showOpenDialog(new Stage());

        /*
         * If a file is selected, and it is valid
         * Initialize a file handler
         * Define the directory for display files
         * Read the layout file and retrieve display bundle
         * Set firework entities on the canvas and redraw
         * Update the layout pane
         */

        if (file != null && validateFile(file)) {
            OrchestratorFileHandler fileHandler = new OrchestratorFileHandler();
            String displaysFilePath = "data/displays/";
            displayBundle = fileHandler.readLayoutFile(file.toString(), displaysFilePath);
            canvas.setFireworkEntities(displayBundle.getEntities());
            canvas.setVisitor(new ConcreteVisitor(canvas.getGraphicsContext()));
            canvas.drawEntities();
            pane.setLeft(updateAccordion());
            pane.setCenter(null);
            pane.setCenter(canvas);
        }
    }

    /**
     * Validates a file based on a specified pattern.
     * @param file The file to be validated.
     * @return true if the file is valid, false otherwise.
     */
    private boolean validateFile(File file) {
        // Create a Matcher object to match the file name against a pattern
        Matcher matcher = fileNamePattern.matcher(file.getName());

        // Check if the file name matches the specified pattern
        if (!matcher.matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Invalid Error");
            alert.setHeaderText("An error has occurred");
            alert.setContentText("Invalid file selected.");
            alert.showAndWait();
            return false;
        }

        return true;
    }

    /**
     * Initializes and configures the accordion with titled panes containing content.
     * @return A VBox containing the configured accordion.
     */
    private VBox initializeAccordion() {
        // Create some content for the titled panes
        GridPane fireworkDisplayGrid = new GridPane();
        fireworkDisplayGrid.add(new Label("Firework Display Information"), 0, 0);

        // Create a grid pane for technician information
        GridPane technicianGrid = new GridPane();
        technicianGrid.add(new Label("PyroTechnician Information"), 0, 0);

        // Create a VBox for displaying firework information
        VBox fireWorkGrid = new VBox();
        GridPane firework = new GridPane();
        firework.add(new Label("Fireworks Information"), 0, 0);
        fireWorkGrid.getChildren().addAll(firework);

        // Create titled panes with their titles and content
        TitledPane fireworkDisplayPane = new TitledPane("Firework Display", fireworkDisplayGrid);
        TitledPane technicianPane = new TitledPane("Lead PyroTechnician", technicianGrid);
        TitledPane fireWorkPane = new TitledPane("Fireworks", fireWorkGrid);

        // Add the titled panes to the accordion
        accordion.getPanes().addAll(fireworkDisplayPane, technicianPane, fireWorkPane);

        // Create a root pane
        VBox vBox = new VBox();
        vBox.getChildren().add(accordion);
        vBox.setStyle("-fx-background-color: #31363F");

        return vBox;
    }

    /**
     * Updates the accordion with new content.
     * @return A VBox containing the updated accordion.
     */
    private VBox updateAccordion() {
        // Get the GridPane for firework display
        GridPane fireworkDisplayGrid = getFireworkDisplayPane();

        // Get the GridPane for technician
        GridPane technicianGrid = getTechnicianPane();

        // Get the VBox for firework display
        VBox fireWorkPane = getFirWorkPane();

        // Create a ScrollPane for firework grid
        ScrollPane fireWorkGrid = new ScrollPane();
        fireWorkGrid.setContent(fireWorkPane);
        fireWorkGrid.setFitToWidth(true);

        // Create titled panes with their titles and content
        TitledPane newFireworkDisplayPane = new TitledPane("Firework Display", fireworkDisplayGrid);
        TitledPane newTechnicianPane = new TitledPane("Lead PyroTechnician", technicianGrid);
        TitledPane newFireWorksPane = new TitledPane("Fireworks", fireWorkGrid);

        // Add the titled panes in the accordion pane
        accordion.getPanes().clear();
        accordion.getPanes().addAll(newFireworkDisplayPane, newTechnicianPane, newFireWorksPane);

        // Create a root pane
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #31363F"); // Set background color
        root.getChildren().add(accordion);

        return root;
    }

    /**
     * Creates and returns a GridPane for displaying firework information.
     * This method initializes labels and text fields with firework display details.
     * @return The GridPane containing firework display information.
     */
    private GridPane getFireworkDisplayPane() {
        // Create a new GridPane
        GridPane fireworkDisplayGrid = new GridPane();
        double totalDuration = displayBundle.getDisplay().getDuration();

        // Initialize labels for display information
        Label displayIDLabel = new Label("Display ID:");
        Label displayNameLabel = new Label("Display Name:");
        Label displayThemeLabel = new Label("Display Theme:");
        Label displayDurationLabel = new Label("Display Total Duration:");

        // Initialize text fields with display details from displayBundle
        TextField displayIDTextField = new TextField(displayBundle.getDisplay().getDisplayID());
        displayIDTextField.setEditable(false);
        TextField displayNameTextField = new TextField(displayBundle.getDisplay().getDisplayName());
        displayNameTextField.setEditable(false);
        TextField displayThemeTextField = new TextField(displayBundle.getDisplay().getDisplayTheme());
        displayThemeTextField.setEditable(false);
        TextField displayDurationTextField = new TextField(String.valueOf(Math.round(totalDuration)));
        displayDurationTextField.setEditable(false);

        // Add labels and text fields to the GridPane
        fireworkDisplayGrid.add(displayIDLabel, 0, 0);
        fireworkDisplayGrid.add(displayIDTextField, 1, 0);

        fireworkDisplayGrid.add(displayNameLabel, 0, 1);
        fireworkDisplayGrid.add(displayNameTextField, 1, 1);

        fireworkDisplayGrid.add(displayThemeLabel, 0, 2);
        fireworkDisplayGrid.add(displayThemeTextField, 1, 2);

        fireworkDisplayGrid.add(displayDurationLabel, 0, 3);
        fireworkDisplayGrid.add(displayDurationTextField, 1, 3);
        return fireworkDisplayGrid;
    }

    /**
     * This method creates and returns a GridPane containing labels and text fields
     * for displaying information about a PyroTechnician.
     * @return GridPane containing technician information
     */
    private GridPane getTechnicianPane() {
        // Create a new GridPane to organize components
        GridPane technicianGrid = new GridPane();

        // Labels for technician information
        Label technicianFullNameLabel = new Label("PyroTechnician Full Name:");
        Label technicianPhoneNumberLabel = new Label("PyroTechnician Phone Number:");

        // Text fields to display technician information
        // Set text fields to display lead technician's full name and phone number
        TextField technicianFullNameTextField = new TextField(displayBundle.getDisplay().getLeadTechnician().getFullName());
        technicianFullNameTextField.setEditable(false);
        TextField technicianPhoneNumberTextField = new TextField(displayBundle.getDisplay().getLeadTechnician().getPhoneNumber());
        technicianPhoneNumberTextField.setEditable(false);

        // Add labels and text fields to the grid
        technicianGrid.add(technicianFullNameLabel, 0, 0);
        technicianGrid.add(technicianFullNameTextField, 1, 0);

        technicianGrid.add(technicianPhoneNumberLabel, 0, 1);
        technicianGrid.add(technicianPhoneNumberTextField, 1, 1);
        return technicianGrid;
    }

    /**
     * Creates and populates a VBox containing information about firework entities.
     * @return The VBox containing information about the firework entities.
     */
    private VBox getFirWorkPane() {
        // Create a vertical box to hold the firework information
        VBox fireWorkPane = new VBox();
        int count = 0;  // Counter for alternating grid colors

        // Iterate through each firework entity in the display bundle
        for (FireworkEntity entity: displayBundle.getEntities()) {
            GridPane fireworkGrid = new GridPane();
            Firework firework = entity.getFirework();

            // Add labels for firework type
            if (firework instanceof RocketFirework) {
                fireworkGrid.add(new Label("Firework Type:"), 0, 0);
                fireworkGrid.add(new Label("Rocket Firework"), 1, 0);
            } else if (firework instanceof FountainFirework) {
                fireworkGrid.add(new Label("Firework Type:"), 0, 0);
                fireworkGrid.add(new Label("Fountain Firework"), 1, 0);
            }

            // Add labels for firework ID, name, fuse length, and color
            fireworkGrid.add(new Label("Firework ID: "), 0, 1);
            fireworkGrid.add(new Label(firework.getFireworkID()), 1, 1);

            fireworkGrid.add(new Label("Firework Name:"), 0, 2);
            fireworkGrid.add(new Label(firework.getFireworkName()), 1, 2);

            fireworkGrid.add(new Label("Fuse Length:"), 0, 3);
            fireworkGrid.add(new Label(String.valueOf(firework.getFuseLength())), 1, 3);

            fireworkGrid.add(new Label("Color:"), 0, 4);
            fireworkGrid.add(new Label(String.valueOf(firework.getColour())), 1, 4);

            // Alternate background color of grid rows
            count++;
            if (count%2==0) {
                fireworkGrid.setStyle("-fx-background-color: #EEEEEE");
            } else {
                fireworkGrid.setStyle("-fx-background-color: #76ABAE");
            }

            // Add the firework grid to the VBox
            fireWorkPane.getChildren().add(fireworkGrid);

        }

        return fireWorkPane;
    }

}
