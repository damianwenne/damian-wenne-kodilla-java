import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {

    public static final Controller INSTANCE = new Controller();
    private static final Random RANDOM = new Random();

    private final List<FieldButton> fieldButtons = new ArrayList<>();

    private Controller() {
    }

    void addButton(FieldButton fieldButton){
        fieldButtons.add(fieldButton);
    }

    public void click(FieldButton button) {
        if(button.getText().length() > 0){
            System.out.println("It's already taken");
            return;
        }
        System.out.println(String.format("Button clicked ! col=%s row=%s",
                button.getCol(),
                button.getRow()));
        button.setText("X");

        /**
         * todo : check if player won
         */

        /**
         * computer move
         * todo : draw only free buttons
         */
        FieldButton compButton = fieldButtons.get(RANDOM.nextInt(9));
        compButton.setText("Y");

        /**
         * todo: check if computer won
         */
    }
}
