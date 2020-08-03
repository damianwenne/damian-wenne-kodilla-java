import javafx.scene.control.Button;

public class FieldButton extends Button {
    private int col, row;

    public FieldButton(int row, int col) {
        setPrefSize(150,150);
        setOnAction(event -> Controller.INSTANCE.click(this));
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
