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

    boolean pplayerCheck(int a, int b, int c) {
        return fieldButtons.get(a).getText().equals("X") && fieldButtons.get(b).getText().equals("X") && fieldButtons.get(c).getText().equals("X");
    }

    void playerCheck() {
        if (pplayerCheck(0, 1, 2)) {
            System.out.println("Wygrałeś");
        } else if (pplayerCheck(3, 4, 5)) {
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

    boolean ccompCheck(int d, int e, int f) {
        return fieldButtons.get(d).getText().equals("O") && fieldButtons.get(e).getText().equals("O") && fieldButtons.get(f).getText().equals("O");
    }

    void compCheck() {
        if (ccompCheck(0,1,2)) {
            System.out.println("Przegrałeś");
        } else if (fieldButtons.get(3).getText().equals("O") && fieldButtons.get(4).getText().equals("O") && fieldButtons.get(5).getText().equals("O")) {
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

    void restart() {
        for (int i = 0; i < fieldButtons.size(); i++) {
            fieldButtons.get(i).setText("");
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
