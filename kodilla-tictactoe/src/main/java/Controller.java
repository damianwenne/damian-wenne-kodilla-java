import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {

    public static final Controller INSTANCE = new Controller();
    private static final Random RANDOM = new Random();

    private final List<FieldButton> fieldButtons = new ArrayList<>();
    private Map<String, Integer> results = new HashMap<>();
    private Label theWinnerLabel = new Label();
    protected boolean difficult;
    private String savedGameFilePath = "kodilla-tictactoe/src/main/java/savedGameFile.txt";
    protected String winnerListFilePath = "kodilla-tictactoe/src/main/java/winnerListFile.txt";
    public String nickName;
    public int points = 0;

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
        return check(sign, a) && check(sign, b) && check(sign, c);
    }

    private boolean check(String sign, int index) {
        return fieldButtons.get(index).getText().equals(sign);
    }

    void restart() {
        for (int i = 0; i < fieldButtons.size(); i++) {
            fieldButtons.get(i).setText(" ");
        }
    }

    void compMoveEasy() {
        FieldButton compButton = fieldButtons.get(RANDOM.nextInt(9));

            if (!compButton.getText().equals("X") && !compButton.getText().equals("O")) {
                compButton.setText("O");
            } else {
                compMoveEasy();
            }
        }

    public void click(FieldButton button) {
        if (!button.getText().equals(" ")) {
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
            points = points + 1;
            System.out.println("Won");
            saveToWinnerList();
            return;
        }
        System.out.println(difficult);
        System.out.println(nickName);

        try {
            makeCompMove();
        } catch (StackOverflowError e) {
            System.out.println("Game Over");
        }
    }

    private void makeCompMove() {

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (difficult) {
                    compMoveHard();
                } else {
                    compMoveEasy();
                }
                if (check("O")) {
                    winnerPopUp();
                    theWinnerLabel.setText("Computer Won!");
                    System.out.println("Lost");
                }
                resultsSetting();
            }
        }));
        timeline.play();
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
            String dataToSave = fieldButtons.stream()
                    .map(e -> e.getText().replaceAll("X", "0").replaceAll("O", "1").replaceAll(" ", "2"))
                    .collect(Collectors.joining());
            bufferedWriter.write(dataToSave);
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
            String line = bufferedReader.readLine();
            for (int i = 0; i < fieldButtons.size(); i++) {
                FieldButton fieldButton = fieldButtons.get(i);
                String value = line
                        .substring(i, i + 1)
                        .replaceAll("0", "X")
                        .replaceAll("1", "O")
                        .replaceAll("2", " ");
                fieldButton.setText(value);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Saved data not found");
        } catch (NullPointerException e) {
            System.out.println("Null point exception");
        }
    }

    public void resultsSetting() {
        results.put(nickName, points);
    }

    @Override
    public String toString() {
        return nickName + " " + results;
    }

    List<List<Integer>> bars = Arrays.asList(
            Arrays.asList(0, 1, 2),
            Arrays.asList(3, 4, 5),
            Arrays.asList(6, 7, 8),
            Arrays.asList(0, 3, 6),
            Arrays.asList(1, 4, 7),
            Arrays.asList(2, 5, 8),
            Arrays.asList(0, 4, 8),
            Arrays.asList(2, 4, 6)
    );

    public void compMoveHard() {
        boolean advancedComputerMove = false;
        for (List<Integer> bar : bars) {
            int zeros = filter(bar, "O").size();
            int empty = filter(bar, " ").size();

            if (zeros == 2 && empty == 1) {
                FieldButton fieldButton = filter(bar, " ").get(0);
                fieldButton.setText("O");
                advancedComputerMove = true;
                break;
            }
        }
        if(!advancedComputerMove){
            compMoveEasy();
        }
    }

    private List<FieldButton> filter(List<Integer> bar, String s) {
        return bar.stream()
                .map(fieldButtons::get)
                .filter(el -> el.getText().equals(s))
                .collect(Collectors.toList());
    }

    public void saveToWinnerList() {
        try {
            FileWriter fileWriter = new FileWriter(winnerListFilePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String winnerListToSave = "\n" + nickName + " " + points;
            bufferedWriter.write(winnerListToSave);
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Save Data File Error!");
        }
    }


    // TODO
    // sleep
    // draw
    // WinnerBoard
    // X/O select
}

