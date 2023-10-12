import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    protected ArrayList<Player> players = new ArrayList<>();
    private boolean gameEnds = false;
    private Board board;

    public Game() {
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        boolean play = true;
        try {
            // Get player names and create players
            // Create player 1
            System.out.println("Ange namn för spelare 1: ");
            String name = sc.nextLine();
            players.add(new Player(name, "X"));

            System.out.println("Vill du spela mot datorn? (J/N)");
            if (sc.nextLine().equals("J")) {
                // Create computerplayer
                players.add(new Player("Dator", "O"));
            } else {
                // Create player 2
                System.out.println("Ange namn för spelare 2: ");
                name = sc.nextLine();
                players.add(new Player(name, "O"));
            }
        } catch (Exception ex) {
            System.out.println("Du angav ett ogiltigt värde, error: " + ex.getMessage());
            sc.nextLine();
        }

        do {
            // Create instance of Board()
            board = new Board(3);

            while (!gameEnds) {

                // Call method to check if all availible spaces of board is taken
                if (board.deadGame() && !gameEnds) {
                    board.printBoard();
                    System.out.println("Spelet slutade oavgjort!");
                    break;
                }

                // Print current board
                board.printBoard();

                // Set initial position to never valid move
                int position = -1;

                try {

                    // If computerplayer random a valid int and play it
                    if (players.get(board.getActivePlayer()).getName().equals("Dator")) {
                        // Call method to get random move
                        position = board.getComputerMove();
                        System.out.println("Spelare " + players.get(board.getActivePlayer()).getName() + ", vilken ruta (1-9)?");
                        System.out.println(position);
                    } else {
                        //If human player
                        System.out.println("Spelare " + players.get(board.getActivePlayer()).getName() + ", vilken ruta (1-9)?");
                        position = sc.nextInt();
                        sc.nextLine();
                    }
                    if (board.play(position, players.get(board.getActivePlayer()).getMarker())) {
                        //If position is correct, do the move
                        gameEnds = board.play(players.get(board.getActivePlayer()));
                        board.flipPlayer();
                    } else {
                        //If incorrect position, print to user
                        System.out.println("Försök igen!");
                    }
                } catch (Exception ex) {
                    System.out.println("Du angav ett ogiltigt värde, error: " + ex.getMessage());
                    sc.nextLine();
                }
            }

            //Asks if you wanna play another round
            System.out.println("Spela ett varv till? (J/N)");

            // If Yes, restart the game
            if (!sc.nextLine().equals("J")) {
                play = false;
            }

            // Or End the game
            gameEnds = false;

        }
        while (play);

        //Print result of the game
        System.out.println("Spelare: " + players.get(0).getName() + " vann: " + players.get(0).getWins() + " gånger! Grattis!");
        System.out.println("Spelare: " + players.get(1).getName() + " vann: " + players.get(1).getWins() + " gånger! Grattis!");

    }

}
