import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    private String player = "X";
    private int position;
    private ArrayList<String> values = new ArrayList<>();
    private boolean gameEnds = false;
    public Game() {
    }


    public void play () {
        Scanner sc = new Scanner(System.in);

        for(int y = 0; y < 9; y++) {
            values.add(" ");
        }

        //int position;
        //String player = "X";

        int cnt = 0;
        while (!gameEnds) {
            cnt++;
            if (cnt > 9) {
                //gameEnds = true;
                System.out.println("Spelet slutade oavgjort!");
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
                    /*if (values.get(position-1).equals(" ")) {
                        values.set(position-1, player);
                        gameEnds = play(values, player);
                        flipPlayer(player);
                    } else {
                        System.out.println("Positionen redan använd! Försök igen!");
                        cnt--;
                    }*/
                    play2(cnt);
                    break;
                case 2:
                    if (b.equals(" ")) {
                        b = player;
                        gameEnds = play(a, b, c, d, e, f, g, h, i, player);
                        if (player.equals("X"))
                            player = "O";
                        else
                            player = "X";
                    } else {
                        System.out.println("Positionen redan använd! Försök igen!");
                        cnt--;
                    }
                    break;
                case 3:
                    if (c.equals(" ")) {
                        c = player;
                        gameEnds = play(a, b, c, d, e, f, g, h, i, player);
                        if (player.equals("X"))
                            player = "O";
                        else
                            player = "X";
                    } else {
                        System.out.println("Positionen redan använd! Försök igen!");
                        cnt--;
                    }
                    break;
                case 4:
                    if (d.equals(" ")) {
                        d = player;
                        gameEnds = play(a, b, c, d, e, f, g, h, i, player);
                        if (player.equals("X"))
                            player = "O";
                        else
                            player = "X";
                    } else {
                        System.out.println("Positionen redan använd! Försök igen!");
                        cnt--;
                    }
                    break;
                case 5:
                    if (e.equals(" ")) {
                        e = player;
                        gameEnds = play(a, b, c, d, e, f, g, h, i, player);
                        if (player.equals("X"))
                            player = "O";
                        else
                            player = "X";
                    } else {
                        System.out.println("Positionen redan använd! Försök igen!");
                        cnt--;
                    }
                    break;
                case 6:
                    if (f.equals(" ")) {
                        f = player;
                        gameEnds = play(a, b, c, d, e, f, g, h, i, player);
                        if (player.equals("X"))
                            player = "O";
                        else
                            player = "X";
                    } else {
                        System.out.println("Positionen redan använd! Försök igen!");
                        cnt--;
                    }
                    break;
                case 7:
                    if (g.equals(" ")) {
                        g = player;
                        gameEnds = play(a, b, c, d, e, f, g, h, i, player);
                        if (player.equals("X"))
                            player = "O";
                        else
                            player = "X";
                    } else {
                        System.out.println("Positionen redan använd! Försök igen!");
                        cnt--;
                    }
                    break;
                case 8:
                    if (h.equals(" ")) {
                        h = player;
                        gameEnds = play(a, b, c, d, e, f, g, h, i, player);
                        if (player.equals("X"))
                            player = "O";
                        else
                            player = "X";
                    } else {
                        System.out.println("Positionen redan använd! Försök igen!");
                        cnt--;
                    }
                    break;
                case 9:
                    if (i.equals(" ")) {
                        i = player;
                        gameEnds = play(a, b, c, d, e, f, g, h, i, player);
                        if (player.equals("X"))
                            player = "O";
                        else
                            player = "X";
                    } else {
                        System.out.println("Positionen redan använd! Försök igen!");
                        cnt--;
                    }
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

    public static void flipPlayer (String player){
        if (player.equals("X"))
            player = "O";
        else
            player = "X";
    }
    public void play2 (int cnt){
        if (values.get(position-1).equals(" ")) {
            values.set(position-1, player);
            gameEnds = play(values, player);
            flipPlayer(player);
        } else {
            System.out.println("Positionen redan använd! Försök igen!");
            cnt--;
        }
    }
}
