/****
 * Name: Samar Khajuria
 * Student Number: T00714740
 * Assignment Number: 2
 * Program Description: ColorCircleApp is a JavaFX application enabling users to
 * dynamically change the color and size of a circle through radio buttons and 
 * a slider. The user-friendly interface provides interactive color selection 
 * and size adjustment, accompanied by a warning sound for clicks outside the 
 * control area.
 ****/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorCircleApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a VBox as the root layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(15, 20, 10, 10));
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

        // Instruction text
        Text instructionsText = new Text("Change the circle color using the radio buttons.\n" +
                "Change the scale of the circle between 0-100% using the slider.");
        instructionsText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        instructionsText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        // Add instruction text to the top
        root.getChildren().add(instructionsText);

        // HBox for radio buttons and circle
        HBox radioAndCircleBox = new HBox(20);
        radioAndCircleBox.setAlignment(Pos.CENTER_LEFT);

        // Radio buttons for color selection
        RadioButton rbOrange = new RadioButton("Orange");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbBlue = new RadioButton("Blue");
        ToggleGroup colorGroup = new ToggleGroup();
        rbOrange.setToggleGroup(colorGroup);
        rbYellow.setToggleGroup(colorGroup);
        rbBlue.setToggleGroup(colorGroup);

        // Add radio buttons to the VBox
        VBox radioBox = new VBox(5);
        radioBox.getChildren().addAll(rbOrange, rbYellow, rbBlue);
        radioAndCircleBox.getChildren().add(radioBox);

        // Circle to display the selected color and size
        Circle circle = new Circle(20);
        circle.setFill(Color.BLUE); // Default color
        radioAndCircleBox.getChildren().add(circle);

        // VBox for slider
        VBox sliderBox = new VBox(10);
        sliderBox.setAlignment(Pos.BOTTOM_CENTER);

        // Slider for size adjustment
        Slider sizeSlider = new Slider(0, 100, 25); // Default size 25%
        sizeSlider.setShowTickLabels(true);
        sizeSlider.setShowTickMarks(true);

        // Warning sound
        AudioClip warningSound = new AudioClip(getClass().getResource("alarm.mp3").toExternalForm());

        // Event handling for radio buttons
        rbOrange.setOnAction(e -> circle.setFill(Color.ORANGE));
        rbYellow.setOnAction(e -> circle.setFill(Color.YELLOW));
        rbBlue.setOnAction(e -> circle.setFill(Color.BLUE));

        // Event handling for the slider
        sizeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double scale = newValue.doubleValue() / 50; // Assuming the original size is 50
            circle.setScaleX(scale);
            circle.setScaleY(scale);
        });

        // Event handling for mouse clicks outside the controls
        root.setOnMouseClicked(e -> {
            if (!rbOrange.isHover() && !rbYellow.isHover() && !rbBlue.isHover() && !sizeSlider.isHover()) {
                warningSound.play();
            }
        });

        // Add all controls to the root layout
        root.getChildren().addAll(radioAndCircleBox, sizeSlider);

        // Warning message in red
        Text warningText = new Text("Select the radio buttons or the slider only. You'll hear a warning sound if the mouse is clicked elsewhere.");
        warningText.setFill(Color.RED);
        root.getChildren().add(warningText);

        // Create the scene and show the stage with a default size of 500x500
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Changing Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

