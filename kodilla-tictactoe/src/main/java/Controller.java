import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {

    public static final Controller INSTANCE = new Controller();
    private static final Random RANDOM = new Random();

    private final List<FieldButton> fieldButtons = new ArrayList<>();
    private Controller() {
    }


    void addButton(FieldButton fieldButton) {
        fieldButtons.add(fieldButton);
    }


    void playerCheck() {
        if (fieldButtons.get(0).getText().equals("X") && fieldButtons.get(1).getText().equals("X") && fieldButtons.get(2).getText().equals("X")) {
            System.out.println("Wygrałeś");
        } else if (fieldButtons.get(3).getText().equals("X") && fieldButtons.get(4).getText().equals("X") && fieldButtons.get(5).getText().equals("X")){
            System.out.println("Wygrałeś");
        } else if (fieldButtons.get(6).getText().equals("X") && fieldButtons.get(7).getText().equals("X") && fieldButtons.get(8).getText().equals("X")) {
            System.out.println("Wygrałeś");
        } else if (fieldButtons.get(0).getText().equals("X") && fieldButtons.get(3).getText().equals("X") && fieldButtons.get(6).getText().equals("X")) {
            System.out.println("Wygrałeś");
        } else if (fieldButtons.get(1).getText().equals("X") && fieldButtons.get(4).getText().equals("X") && fieldButtons.get(7).getText().equals("X")) {
            System.out.println("Wygrałeś");
        } else if (fieldButtons.get(2).getText().equals("X") && fieldButtons.get(5).getText().equals("X") && fieldButtons.get(8).getText().equals("X")) {
            System.out.println("Wygrałeś");
        } else if (fieldButtons.get(0).getText().equals("X") && fieldButtons.get(4).getText().equals("X") && fieldButtons.get(8).getText().equals("X")) {
            System.out.println("Wygrałeś");
        } else if (fieldButtons.get(2).getText().equals("X") && fieldButtons.get(4).getText().equals("X") && fieldButtons.get(6).getText().equals("X")) {
            System.out.println("Wygrałeś");
        }
}

    void compCheck() {
        if (fieldButtons.get(0).getText().equals("O") && fieldButtons.get(1).getText().equals("O") && fieldButtons.get(2).getText().equals("O")) {
            System.out.println("Przegrałeś");
        } else if (fieldButtons.get(3).getText().equals("O") && fieldButtons.get(4).getText().equals("O") && fieldButtons.get(5).getText().equals("O")){
            System.out.println("Przegrałeś");
        } else if (fieldButtons.get(6).getText().equals("O") && fieldButtons.get(7).getText().equals("O") && fieldButtons.get(8).getText().equals("O")) {
            System.out.println("Przegrałeś");
        } else if (fieldButtons.get(0).getText().equals("O") && fieldButtons.get(3).getText().equals("O") && fieldButtons.get(6).getText().equals("O")) {
            System.out.println("Przegrałeś");
        } else if (fieldButtons.get(1).getText().equals("O") && fieldButtons.get(4).getText().equals("O") && fieldButtons.get(7).getText().equals("O")) {
            System.out.println("Przegrałeś");
        } else if (fieldButtons.get(2).getText().equals("O") && fieldButtons.get(5).getText().equals("O") && fieldButtons.get(8).getText().equals("O")) {
            System.out.println("Przegrałeś");
        } else if (fieldButtons.get(0).getText().equals("O") && fieldButtons.get(4).getText().equals("O") && fieldButtons.get(8).getText().equals("O")) {
            System.out.println("Przegrałeś");
        } else if (fieldButtons.get(2).getText().equals("O") && fieldButtons.get(4).getText().equals("O") && fieldButtons.get(6).getText().equals("O")) {
            System.out.println("Przegrałeś");
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
        playerCheck();

        // Computer move, To Do: draw only free button

        FieldButton compButton = fieldButtons.get(RANDOM.nextInt(9));
        while (compButton.getText().length() < 1) {
            compButton.setText("O");
            compCheck();
        }

    }

}
