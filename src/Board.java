import java.util.ArrayList;
import java.util.Random;

public class Board {
    private ArrayList<String> values;
    private int size;
    private int cnt;
    private int activePlayer;
    private ArrayList<Integer> positions;

    public Board(int size) {
        this.size = size * size;
        this.cnt = 0;
        this.activePlayer = 0;
        this.positions = new ArrayList<>();
        createBoard();
    }

    public void createBoard() {
        // Create array with gameboard
        values = new ArrayList<>();
        for (int y = 0; y < size; y++) {
            values.add(" ");
            positions.add(y + 1);
        }
    }

    public void printBoard() {
        //Print gameboard
        System.out.println(" " + values.get(0) + " | " + values.get(1) + " | " + values.get(2) + " ");
        System.out.println("---+---+---");
        System.out.println(" " + values.get(3) + " | " + values.get(4) + " | " + values.get(5) + " ");
        System.out.println("---+---+---");
        System.out.println(" " + values.get(6) + " | " + values.get(7) + " | " + values.get(8) + " ");

    }

    public boolean play(int position, String marker) {
        // Checks that positions (which is available positons has the requested position
        // and that the position in the gameboard array is equals to " "
        if (positions.contains(position) && values.get(position - 1).equals(" ")) {

            // If correct, change the value in the right position in the array to active players marker
            values.set(position - 1, marker);

            // Remove the postition from remaining postions
            positions.remove(Integer.valueOf(position));
            return true;
        }
        return false;
    }

    public int getComputerMove() {
        // Return availible position for computer
        Random rnd = new Random();
        return positions.get(rnd.nextInt(positions.size()));

    }

    public boolean deadGame() {
        // Check if the game is draw
        return positions.isEmpty();
    }

    public void flipPlayer() {
        //Flips so next player is the opposite after every turn of the game
        if (activePlayer == 0)
            activePlayer = 1;
        else
            activePlayer = 0;
    }

    public int getActivePlayer() {
        return activePlayer;
    }

    public boolean winner(String x, String y, String z, Player player) {
        //Compare different values in the positions to check if theres a winner
        if (x.equals(" "))
            return false;
        if (y.equals(" "))
            return false;
        if (z.equals(" "))
            return false;
        if (x.equals(y)) {
            if (y.equals(z)) {
                //If all ifstatments is true - we have a winner
                printBoard();
                System.out.println("Vi har en vinnare! Spelare: " + player.getName());
                player.setWins();
                return true;
            }
        }
        return false;
    }

    public boolean play(Player player) {
        boolean winner = false;
        //Call method to check if the marker is the same in a row horizontal
        int y = 0;
        for (int x = 0; x < 3; x++) {
            winner = winner(values.get(y), values.get(y + 1), values.get(y + 2), player);
            if (winner)
                return true;
            y = y + 3;
        }

        //Call method to check if the marker is the same in a row vertical
        for (int x = 0; x < 3; x++) {
            winner = winner(values.get(x), values.get(x + 3), values.get(x + 6), player);
            if (winner)
                return true;
        }

        //Call method to check if the marker is the same in a row diagonal from top left
        winner = winner(values.get(0), values.get(4), values.get(8), player);
        if (winner)
            return true;

        //Call method to check if the marker is the same in a row diagonal from top right
        winner = winner(values.get(2), values.get(4), values.get(6), player);
        if (winner)
            return true;

        return false;

    }

}
