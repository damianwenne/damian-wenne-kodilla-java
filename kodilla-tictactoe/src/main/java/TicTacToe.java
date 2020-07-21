
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        Button field11 = new Button();
        Button field12 = new Button();
        Button field13 = new Button();
        Button field21 = new Button();
        Button field22 = new Button();
        Button field23 = new Button();
        Button field31 = new Button();
        Button field32 = new Button();
        Button field33 = new Button();
        field11.setPrefSize(150,150);
        field12.setPrefSize(150,150);
        field13.setPrefSize(150,150);
        field21.setPrefSize(150,150);
        field22.setPrefSize(150,150);
        field23.setPrefSize(150,150);
        field31.setPrefSize(150,150);
        field32.setPrefSize(150,150);
        field33.setPrefSize(150,150);
        GridPane gridPane = new GridPane();
        gridPane.add(field11,0,0);
        gridPane.add(field12,1,0);
        gridPane.add(field13,2,0);
        gridPane.add(field21,0,1);
        gridPane.add(field22,1,1);
        gridPane.add(field23,2,1);
        gridPane.add(field31,0,2);
        gridPane.add(field32,1,2);
        gridPane.add(field33,2,2);
        field11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                field11.setText("X");
            }
        });
        field12.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                field12.setText("X");
            }
        });
        field13.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                field13.setText("X");
            }
        });
        field21.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                field21.setText("X");
            }
        });
        field22.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                field22.setText("X");
            }
        });
        field23.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                field23.setText("X");
            }
        });
        field31.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                field31.setText("X");
            }
        });
        field32.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                field32.setText("X");
            }
        });
        field33.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                field33.setText("X");
            }
        });

        // Left
        Button saveButton = new Button("Save");
        saveButton.setMinWidth(55);
        Button restartButton = new Button("Restart");
        restartButton.setMinWidth(55);
        Button oButton = new Button("O");
        oButton.setMinSize(55,55);
        Button xButton = new Button("X");
        xButton.setMinSize(55,55);
        VBox leftMenu = new VBox();
        leftMenu.getChildren().addAll(oButton, xButton,saveButton,restartButton);
        leftMenu.setPadding(new Insets(0,5,5,5));
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
