import jdk.jshell.spi.ExecutionControlProvider;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;


public class Game {
    protected ArrayList<Player> players = new ArrayList<>();
    private boolean gameEnds = false;
    private Board board;

    public Game() {
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        boolean play = true;

        //Get player names
        System.out.println("Ange namn för spelare 1: ");
        String name = sc.nextLine();
        players.add(new Player(name, "X"));

        System.out.println("Vill du spela mot datorn? (J/N)");
        String answer = sc.nextLine();
        if (answer.equals("J")) {
            //Skapa datorspelare
            players.add(new Player("Dator", "O"));
        } else {
            System.out.println("Ange namn för spelare 2: ");
            name = sc.nextLine();
            players.add(new Player(name, "O"));
        }

        do {
            board = new Board(3);

            while (!gameEnds) {

                if (board.deadGame() && !gameEnds) {
                    board.printBoard();
                    System.out.println("Spelet slutade oavgjort!");
                    break;
                }

                board.printBoard();

                int position = -1;
                //If computerplayer random a valid int and play it
                if (players.get(board.getActivePlayer()).getName().equals("Dator")) {
                    position = board.getComputerMove();
                    System.out.println("Spelare " + players.get(board.getActivePlayer()).getName() + ", vilken ruta (1-9)?");
                    System.out.println(position);
                } else {
                    //If human player
                    System.out.println("Spelare " + players.get(board.getActivePlayer()).getName() + ", vilken ruta (1-9)?");
                    position = sc.nextInt();
                    sc.nextLine();
                }
                try {
                    if (board.play(position, players.get(board.getActivePlayer()).getMarker())) {
                        //If position is correct, do the move
                        gameEnds = board.play(players.get(board.getActivePlayer()));
                        board.flipPlayer();
                    } else {
                        //If incorrect position, print and exit
                        System.out.println("Försök igen!");
                    }
                } catch (Exception ex) {
                    System.out.println("Du angav ett ogiltigt värde, error: " + ex.getMessage());
                    sc.nextLine();
                }
            }

            //Asks if you wanna play another round
            System.out.println("Spela ett varv till? (J/N)");
            answer = sc.nextLine();

            if (!answer.equals("J")) {
                play = false;
            }

            gameEnds = false;

        }
        while (play);

        //Print result of the game
        System.out.println("Spelare: " + players.get(0).getName() + " vann: " + players.get(0).getWins() + " gånger! Grattis!");
        System.out.println("Spelare: " + players.get(1).getName() + " vann: " + players.get(1).getWins() + " gånger! Grattis!");

    }

}
