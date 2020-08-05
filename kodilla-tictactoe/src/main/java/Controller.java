import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Controller {

    public static final Controller INSTANCE = new Controller();
    private static final Random RANDOM = new Random();

    private final List<FieldButton> fieldButtons = new ArrayList<>();
    private Label theWinnerLabel = new Label();
    private String savedGameFilePath = "kodilla-tictactoe/src/main/java/savedGameFile.txt";

    private Controller() {
    }

    void addButton(FieldButton fieldButton) {
        fieldButtons.add(fieldButton);
    }

    boolean check(String sign) {
        if (checkSingle(0, 1, 2, sign)) {
            return true;
        } else if (checkSingle(3, 4, 5, sign)) {
            return true;
        } else if (checkSingle(6, 7, 8, sign)) {
            return true;
        } else if (checkSingle(0, 3, 6, sign)) {
            return true;
        } else if (checkSingle(1, 4, 7, sign)) {
            return true;
        } else if (checkSingle(2, 5, 8, sign)) {
            return true;
        } else if (checkSingle(0, 4, 8, sign)) {
            return true;
        } else if (checkSingle(2, 4, 6, sign)) {
            return true;
        }
        return false;
    }

    boolean checkSingle(int a, int b, int c, String sign) {
        return fieldButtons.get(a).getText().equals(sign)
                && fieldButtons.get(b).getText().equals(sign)
                && fieldButtons.get(c).getText().equals(sign);
    }

    void restart() {
        for (int i = 0; i < fieldButtons.size(); i++) {
            fieldButtons.get(i).setText("");
        }
    }

    void compMove() {
        FieldButton compButton = fieldButtons.get(RANDOM.nextInt(9));
        try {
            Thread.sleep(1);
            if (compButton.getText().length() < 1) {
                compButton.setText("O");
            } else {
                compMove();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void click(FieldButton button) {
        if (button.getText().length() > 0) {
            System.out.println("It's already taken");
            return;
        }
        System.out.println(String.format("Button clicked ! col=%s row=%s",
                button.getCol(),
                button.getRow()));
        button.setText("X");
        if (check("X")) {
            winnerPopUp();
            theWinnerLabel.setText("You Won!");
            System.out.println("Won");
        }

        try {
            compMove();
        } catch (StackOverflowError e) {
            System.out.println("Game Over");
        }

        if (check("O")) {
            winnerPopUp();
            theWinnerLabel.setText("Computer Won!");
            System.out.println("Lost");
        }
    }

    private void winnerPopUp() {
        Stage winnerPopUpWindow = new Stage();

        winnerPopUpWindow.initModality(Modality.APPLICATION_MODAL);
        winnerPopUpWindow.setMinWidth(250);
        winnerPopUpWindow.setMinHeight(200);
        winnerPopUpWindow.setTitle("Game Over!");
        Button okToCloseButton = new Button("OK");
        okToCloseButton.addEventHandler(ActionEvent.ACTION, (e) -> {
            winnerPopUpWindow.close();
            restart();
        });

        theWinnerLabel.setFont(new Font(30));
        VBox winnerPopUpVBoxLayout = new VBox(10);
        winnerPopUpVBoxLayout.getChildren().addAll(theWinnerLabel, okToCloseButton);
        winnerPopUpVBoxLayout.setAlignment(Pos.CENTER);

        Scene winnerPopUpScene = new Scene(winnerPopUpVBoxLayout);
        winnerPopUpWindow.setScene(winnerPopUpScene);
        winnerPopUpWindow.setOnCloseRequest(e -> restart());
        winnerPopUpWindow.show();
    }


    public void saveGame() {
        try {
            FileWriter fileWriter = new FileWriter(savedGameFilePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(fieldButtons.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Save Data File Error!");
        }
    }

    public void loadGame() {

        try {
            File file = new File(savedGameFilePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.toString();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }

    // TODO
    // save/load
    // sleep
    // draw
    // WinnerBoard
    // Difficulty levels
    // X/O select
    // Name input

}

