import java.util.ArrayList;

public class Board {
    private ArrayList<String> values = new ArrayList<>();
    private int size = 9;

    public Board(int size) {
        createBoard(size);
    }

    public void createBoard(int size){
        for(int y = 0; y < size; y++) {
            values.add(" ");
        }
    }

    public ArrayList<String> getValues() {
        return values;
    }
}
