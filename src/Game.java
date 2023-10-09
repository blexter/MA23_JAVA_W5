import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Game {
    protected ArrayList<Player> players = new ArrayList<>();
    private int activePlayer;
    private int position;
    private int size = 9;
    private boolean gameEnds = false;
    private Board board;
    private int cnt;
    private ArrayList<Integer> positions;
    public Game() {
    }


    public void play () {
        Scanner sc = new Scanner(System.in);
        boolean play = true;





        //Get player names
        System.out.println("Ange namn för spelare 1: ");
        String name = sc.nextLine();
        players.add(new Player(name, "X"));

        System.out.println("Vill du spela mot datorn? (J/N)");
        String answer = sc.nextLine();
        if(answer.equals("J")) {
            //Skapa datorspelare
            players.add(new Player("Dator", "O"));
            sc.nextLine();
        } else {
            System.out.println("Ange namn för spelare 2: ");
            name = sc.nextLine();
            players.add(new Player(name, "O"));
        }

        do {
            board = new Board(size);
            positions = new ArrayList<>();
            cnt = 0;
            for(int i = 1; i <= size; i++){
                positions.add(i);
            }
            while (!gameEnds) {
                cnt++;
                if (cnt > 9) {
                    System.out.println("Spelet slutade oavgjort!");
                    break;
                }
                System.out.println(" " + board.getValues().get(0) + " | " + board.getValues().get(1) + " | " + board.getValues().get(2) + " ");
                System.out.println("---+---+---");
                System.out.println(" " + board.getValues().get(3) + " | " + board.getValues().get(4) + " | " + board.getValues().get(5) + " ");
                System.out.println("---+---+---");
                System.out.println(" " + board.getValues().get(6) + " | " + board.getValues().get(7) + " | " + board.getValues().get(8) + " ");
                if(players.get(activePlayer).getName().equals("Dator")){
                    Random rnd = new Random();
                    position = positions.get(rnd.nextInt(positions.size()));
                    positions.remove(Integer.valueOf(position));
                }
                else {
                    System.out.println("Spelare " + players.get(activePlayer).getName() + ", vilken ruta (1-9)?");
                    position = sc.nextInt();
                }
                //Instead of a huge Swtichstatement i check if the input is between 1-9 and play if so.
                Boolean validInput = false;
                while (!validInput) {
                    int digit = position % 10;
                    if (digit < 1 || digit > 9) {
                        validInput = false;
                        break;
                    }
                    validInput = true;
                    positions.remove(Integer.valueOf(position));
                }

                //If position is correct, do the move
                if (validInput)
                    play2();
                else {
                    //If incorrect position, print and exit
                    System.out.println("Försök igen!");
                    break;
                }
            }

            //Asks if you wanna play another round
            System.out.println("Spela ett varv till? (J/N)");
            sc.nextLine();
            answer = sc.nextLine();
            if(!answer.equals("J")) {
                play = false;


            }
            gameEnds = false;
        } while (play);

        System.out.println("Spelare: " + players.get(0).getName() + " vann: " + players.get(0).getWins() + " gånger! Grattis!");
        System.out.println("Spelare: " + players.get(1).getName() + " vann: " + players.get(1).getWins() + " gånger! Grattis!");
    }
    public boolean winner(String x, String y, String z, String player) {
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
                System.out.println("Vi har en vinnare! Spelare: " + players.get(activePlayer).getName());
                players.get(activePlayer).setWins();
                return true;
            }
        }
        return false;
    }

    public boolean play(ArrayList<String> values, String player) {
        boolean winner = false;
        //Call method to check if the marker is the same in a row horizontal
        for(int x = 0; x < 3; x++) {
            winner = winner(values.get(x), values.get(x+1), values.get(x+2), player);
            if (winner)
                return true;
            x++;
            x++;
        }

        //Call method to check if the marker is the same in a row vertical
        for(int x = 0; x < 3; x++) {
            winner = winner(values.get(x), values.get(x+3), values.get(x+6), player);
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

    public void flipPlayer (){
        //Flips so next player is the opposite after every turn of the game
        if (activePlayer == 0)
            activePlayer = 1;
        else
            activePlayer = 0;
    }
    public void play2 (){
        //Check if position is available and if so write the correct marker to that position
        if (board.getValues().get(position-1).equals(" ")) {
            board.getValues().set(position-1, players.get(activePlayer).getMarker());

            //Call method to check if we have a winner and the game should end.
            gameEnds = play(board.getValues(), players.get(activePlayer).getMarker());

            //Call to flip which player next
            flipPlayer();

            //print if position already in use
        } else {
            System.out.println("Positionen redan använd! Försök igen!");
            cnt--;
        }
    }
}
