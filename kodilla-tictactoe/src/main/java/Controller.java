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

    boolean check(String sign){
        if (checkSingle(0, 1, 2, sign)) {
            return true;
        } else if (checkSingle(3, 4, 5, sign)) {
            return true;
        } else if (checkSingle(6,7,8, sign)) {
            return true;
        } else if (checkSingle(0,3,6, sign)) {
            return true;
        } else if (checkSingle(1,4,7, sign)) {
            return true;
        } else if (checkSingle(2,5,8, sign)) {
            return true;
        } else if (checkSingle(0,4,8, sign)) {
            return true;
        } else if (checkSingle(2,4,6, sign)) {
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


    public void click(FieldButton button) {
        if (button.getText().length() > 0) {
            System.out.println("It's already taken");
            return;
        }
        System.out.println(String.format("Button clicked ! col=%s row=%s",
                button.getCol(),
                button.getRow()));
        button.setText("X");
        if(check("X")){
            System.out.println("You won");
        }

        // Computer move, To Do: draw only free button

        FieldButton compButton = fieldButtons.get(RANDOM.nextInt(9));
        while (compButton.getText().length() < 1) {
            compButton.setText("O");
            if(check("O")){
                System.out.println("Computer won");
            }
        }

    }

}
