package acsse.csc2a.fmb.gui;

import java.io.File;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import acsse.csc2a.fmb.file.DisplayFileHandler;
import acsse.csc2a.fmb.file.OrchestratorFileHandler;
import acsse.csc2a.fmb.model.*;
import acsse.csc2a.utils.Helper;

/**
 * @author Mr J Orfao
 * @version P07 Custom FireworkDisplayPane that will Place the Accordian to the
 *          left and the Canvas to the Right
 */
public class FireworkDisplayPane extends StackPane {
	// instance variables
	private DisplayBundle displayBundle = null;
	private MenuBar menuBar = null;
	private BorderPane borderPane = null;
	private FireworkDisplayCanvas fireworkCanvas = null;
	private OrchestratorFileHandler orchestratorHandler = new OrchestratorFileHandler();

	public FireworkDisplayPane() {
		// create a BorderPane as a Foundation Layout
		borderPane = new BorderPane();
		// Create our FireworkCanvas
		fireworkCanvas = new FireworkDisplayCanvas();
		CreateMenuBar();
		createSimulateButton();
		// place the MenuBar at the top
		borderPane.setTop(menuBar);

		getChildren().add(borderPane);
	}

	private void createSimulateButton() {
		// Create the Simulate button
		Button simulateButton = new Button("Simulate");

		// Set the action for the button
		simulateButton.setOnAction(e -> fireworkCanvas.startSimulation());

		// Create a HBox to contain the button and add padding
		HBox buttonContainer = new HBox(simulateButton);
		buttonContainer.setPadding(new Insets(10));

		// Set the HBox to the bottom of the BorderPane
		borderPane.setBottom(buttonContainer);
	}

	private void CreateMenuBar() {
		// Create the Menu Bar
		menuBar = new MenuBar();
		// Create a File Menu
		Menu menu = new Menu("File");
		// Add the Menu to the Menu Bar
		menuBar.getMenus().add(menu);
		// Create a Menu Item to open a FireworkDisplay Layout file
		MenuItem mi1 = new MenuItem("Open Firework Display Layout");
		// Don't forget to add that to our Menu that we placed in the Menu bar
		menu.getItems().add(mi1);
		// Create an action to handle when it is clicked
		mi1.setOnAction(e -> {
			// create a FileChooser so the user can select the file
			final FileChooser fc = new FileChooser();
			fc.setTitle("Choose FireworkDisplay Layout File");
			fc.setInitialDirectory(new File("data/layouts/"));
			// Actually show the Dialog
			File file = fc.showOpenDialog(getScene().getWindow());
			// If the user selected a file
			if (file != null) {
				// Delegate reading the file
				displayBundle = orchestratorHandler.readLayoutFile(file.getAbsolutePath(), "data/displays");
				// Recreate the Accordion
				createChildren();
				// Setup the Canvas
				setFireworkEntities(displayBundle.getEntities());
			}
		});
	}

	public void setFireworkEntities(ArrayList<FireworkEntity> fireworkEntities) {
		// Place the canvas in the middle
		borderPane.setCenter(fireworkCanvas);
		// Tell the canvas to redraw with the provided entities
		fireworkCanvas.setFireworkEntities(fireworkEntities);
	}

	private void createChildren() {
		// If we did receive a display bundle that exists
		if (displayBundle != null) {
			// Create the accordion
			Accordion accordion = new Accordion();
			FireworkDisplay display = displayBundle.getDisplay();
			// Provide the TitlePane with a Title and get its elements
			TitledPane tpDisplay = new TitledPane("Firework Display Information", createDisplayGrid(display));
			TitledPane tpLeadTechnician = new TitledPane("Lead PyroTechnician",
					createPyroTechnicianGrid(display.getLeadTechnician()));
			// Create the Firework TitlePane differently as we want to populate the entities
			// using it
			TitledPane tpFireworks = new TitledPane();
			tpFireworks.setText("Fireworks");
			// we are going to place all the fireworks in a vertical box
			VBox vbFirework = new VBox();
			// add the firework title panes to the vertical box
			displayBundle.getEntities()
					.forEach(fe -> vbFirework.getChildren().add(createFireworkGrid(fe.getFirework())));
			// place the vertical box in a scroll pane so we can view the content that would
			// go offscreen.
			// place the scrollPane in the firework Title Pane
			tpFireworks.setContent(new ScrollPane(vbFirework));
			// add the TitlePanes to the accordion
			accordion.getPanes().addAll(tpDisplay, tpLeadTechnician, tpFireworks);
			// place the accordion on the left
			borderPane.setLeft(accordion);
			// make clear out the children and make the border pane the only node
			getChildren().setAll(borderPane);
		}
	}

	private GridPane createFireworkGrid(Firework firework) {
		// create a GridPane to place the Firework Info in
		GridPane grid = new GridPane();
		// Spacing between rows
		grid.setVgap(4);
		// Spacing within the grid
		grid.setPadding(new Insets(5));
		// not needed but I thought it would be great
		Color backgroundColor = Helper.getColorFromAttribute(firework.getColour());
		grid.setStyle("-fx-background-color: #" + backgroundColor.toString().substring(2) + ";");
		// Use labels and TextFields to show the information. Could have just used
		// labels.
		// NB: grid.add(<node>, col, row)
		grid.add(new Label("ID: "), 0, 0);
		grid.add(new TextField(firework.getFireworkID()), 1, 0);
		grid.add(new Label("Name: "), 0, 1);
		grid.add(new TextField(firework.getFireworkName()), 1, 1);
		grid.add(new Label("Fuse Length: "), 0, 2);
		// you have to cast the primitive double to Double to use the toString()
		grid.add(new TextField(((Double) (firework.getFuseLength())).toString()), 1, 2);
		return grid;
	}

	private GridPane createPyroTechnicianGrid(PyroTechnician technician) {
		// Create a GridPane to place the PyroTechnician Info in
		GridPane grid = new GridPane();
		// Spacing between rows
		grid.setVgap(4);
		// Spacing within the grid
		grid.setPadding(new Insets(5));
		// Use labels and TextFields to show the information. Could have just used
		// labels.
		// NB: grid.add(<node>, col, row)
		grid.add(new Label("Full Name: "), 0, 0);
		grid.add(new TextField(technician.getFullName()), 1, 0);
		grid.add(new Label("Phone Number: "), 0, 1);
		grid.add(new TextField(technician.getPhoneNumber()), 1, 1);

		return grid;
	}

	private GridPane createDisplayGrid(FireworkDisplay display) {
		// Create a GridPane to place the PyroTechnician Info in
		GridPane grid = new GridPane();
		// Spacing between rows
		grid.setVgap(4);
		// Spacing within the grid
		grid.setPadding(new Insets(5));
		// Use labels and TextFields to show the information. Could have just used
		// labels.
		// NB: grid.add(<node>, col, row)
		grid.add(new Label("ID: "), 0, 0);
		grid.add(new TextField(display.getDisplayID()), 1, 0);
		grid.add(new Label("Name: "), 0, 1);
		grid.add(new TextField(display.getDisplayName()), 1, 1);
		grid.add(new Label("Theme: "), 0, 2);
		grid.add(new TextField(display.getDisplayTheme()), 1, 2);
		grid.add(new Label("Duration: "), 0, 3);
		// you have to cast the primitive double to Double to use the toString()
		grid.add(new TextField(((Double) display.getDuration()).toString()), 1, 3);
		return grid;
	}

}
