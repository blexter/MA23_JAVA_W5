import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    protected String player = "X";
    private int position;
    private ArrayList<String> values = new ArrayList<>();
    private boolean gameEnds = false;

    private int cnt = 0;
    public Game() {
    }


    public void play () {
        Scanner sc = new Scanner(System.in);

        for(int y = 0; y < 9; y++) {
            values.add(" ");
        }

        while (!gameEnds) {
            cnt++;
            if (cnt > 9) {
                System.out.println("Spelet slutade oavgjort!");
                break;
            }
            System.out.println(" " + values.get(0) + " | " + values.get(1) + " | " + values.get(2) + " ");
            System.out.println("---+---+---");
            System.out.println(" " + values.get(3) + " | " + values.get(4) + " | " + values.get(5) + " ");
            System.out.println("---+---+---");
            System.out.println(" " + values.get(6) + " | " + values.get(7) + " | " + values.get(8) + " ");
            System.out.println("Spelare " + player + ", vilken ruta (1-9)?");
            position = sc.nextInt();

            switch (position) {
                case 1:
                    play2();
                    break;
                case 2:
                    play2();
                    break;
                case 3:
                    play2();
                    break;
                case 4:
                    play2();
                    break;
                case 5:
                    play2();
                    break;
                case 6:
                    play2();
                    break;
                case 7:
                    play2();
                    break;
                case 8:
                    play2();
                    break;
                case 9:
                    play2();
                    break;
                default:
                    System.out.println("Försök igen!");
                    break;
            }
        }

    }
    public static boolean winner(String x, String y, String z, String player) {
        if (x.equals(" "))
            return false;
        if (y.equals(" "))
            return false;
        if (z.equals(" "))
            return false;
        if (x.equals(y)) {
            if (y.equals(z)) {
                System.out.println("We have a winner! Player: " + player);
                return true;
            }
        }
        return false;
    }

    public static boolean play(ArrayList<String> values, String player) {
        boolean winner = false;
        for(int x = 0; x < 3; x++) {
            winner = winner(values.get(x), values.get(x+1), values.get(x+2), player);
            if (winner)
                return true;
            x++;
            x++;
        }
        for(int x = 0; x < 3; x++) {
            winner = winner(values.get(x), values.get(x+3), values.get(x+6), player);
            if (winner)
                return true;
        }
        winner = winner(values.get(0), values.get(4), values.get(8), player);
        if (winner)
            return true;
        winner = winner(values.get(2), values.get(4), values.get(6), player);
        if (winner)
            return true;

        return false;

    }

    public void flipPlayer (){
        if (player.equals("X"))
            player = "O";
        else
            player = "X";
    }
    public void play2 (){
        if (values.get(position-1).equals(" ")) {
            values.set(position-1, player);
            gameEnds = play(values, player);
            flipPlayer();
        } else {
            System.out.println("Positionen redan använd! Försök igen!");
            cnt--;
        }
    }
}
