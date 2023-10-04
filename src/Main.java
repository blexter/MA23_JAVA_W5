import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = " ";
        String b = " ";
        String c = " ";

        String d = " ";
        String e = " ";
        String f = " ";

        String g = " ";
        String h = " ";
        String i = " ";
        int position;
        String player = "X";
        boolean gameEnds = false;
        var cnt = 0;
        while (!gameEnds) {
            cnt++;
            if (cnt > 9) {
                gameEnds = true;
                System.out.println("Spelet slutade oavgjort!");
            }
            System.out.println(" " + a + " | " + b + " | " + c + " ");
            System.out.println("---+---+---");
            System.out.println(" " + d + " | " + e + " | " + f + " ");
            System.out.println("---+---+---");
            System.out.println(" " + g + " | " + h + " | " + i + " ");
            System.out.println("Spelare " + player + ", vilken ruta (1-9)?");
            position = sc.nextInt();

            switch (position) {
                case 1:
                    if (a.equals(" ")) {
                        a = player;
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
/*        System.out.println(" " + a + " | " + b +  " | "  + c + " ");
        System.out.println("---+---+---");
        System.out.println(" " + d + " | " + e +  " | "  + f + " ");
        System.out.println("---+---+---");
        System.out.println(" " + g + " | " + h +  " | "  + i + " ");
        System.out.println("Spelar O, vilken ruta (1-9)?");*/
    }

    public static boolean winner(String x, String y, String z, String player) {
        if (x.equals(" "))
            return true;
        if (y.equals(" "))
            return true;
        if (z.equals(" "))
            return true;
        if (x.equals(y)) {
            if (y.equals(z)) {
                System.out.println("We have a winner! Player: " + player);
                return false;
            }
        }
        return true;
    }

    public static boolean play(String a, String b, String c, String d, String e, String f, String g, String h, String i, String player) {

        boolean winner = winner(a, b, c, player);
        if (winner)
            return false;
        winner = winner(d, e, f, player);
        if (winner)
            return false;
        winner = winner(g, h, i, player);
        if (winner)
            return false;
        winner = winner(a, d, g, player);
        if (winner)
            return false;
        winner = winner(b, e, h, player);
        if (winner)
            return false;
        winner = winner(c, f, i, player);
        if (winner)
            return false;
        winner = winner(a, e, i, player);
        if (winner)
            return false;
        winner = winner(c, e, g, player);
        if (winner)
            return false;
        return true;
    }


}