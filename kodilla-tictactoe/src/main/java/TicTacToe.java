import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Top
        Label topText = new Label("Tic Tac Toe");
        topText.setFont(new Font("Calibri", 60));

        //Center
        Controller controller = Controller.INSTANCE;
        FieldButton field11 = new FieldButton(1,1);
        controller.addButton(field11);
        FieldButton field12 = new FieldButton(1,2);
        controller.addButton(field12);
        FieldButton field13 = new FieldButton(1,3);
        controller.addButton(field13);
        FieldButton field21 = new FieldButton(2,1);
        controller.addButton(field21);
        FieldButton field22 = new FieldButton(2,2);
        controller.addButton(field22);
        FieldButton field23 = new FieldButton(2,3);
        controller.addButton(field23);
        FieldButton field31 = new FieldButton(3,1);
        controller.addButton(field31);
        FieldButton field32 = new FieldButton(3,2);
        controller.addButton(field32);
        FieldButton field33 = new FieldButton(3,3);
        controller.addButton(field33);

        GridPane gridPane = new GridPane();
        gridPane.add(field11, 0, 0);
        gridPane.add(field12, 1, 0);
        gridPane.add(field13, 2, 0);
        gridPane.add(field21, 0, 1);
        gridPane.add(field22, 1, 1);
        gridPane.add(field23, 2, 1);
        gridPane.add(field31, 0, 2);
        gridPane.add(field32, 1, 2);
        gridPane.add(field33, 2, 2);

        // Left
        Button saveButton = new Button("Save");
        saveButton.setMinWidth(55);
        Button restartButton = new Button("Restart");
        restartButton.setMinWidth(55);
        Button oButton = new Button("O");
        oButton.setMinSize(55, 55);
        Button xButton = new Button("X");
        xButton.setMinSize(55, 55);
        VBox leftMenu = new VBox();
        leftMenu.getChildren().addAll(oButton, xButton, saveButton, restartButton);
        leftMenu.setPadding(new Insets(0, 5, 5, 5));
        leftMenu.setSpacing(5);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setTop(topText);
        borderPane.setLeft(leftMenu);

        Scene scene = new Scene(borderPane, 800, 600);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}