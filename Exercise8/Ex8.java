import java.util.Scanner; // Imported Module for taking user input
import java.util.Random;

public class Ex8{

    // General Grid Field
    // 3x3 String Array
    // public static String[][] grid = new String[3][3];

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // New TicTacToe Game
        TicTacToe game = new TicTacToe();

        /*// Selecting difficulty
        game.setDifficulty();

        // Initialising Grid
        System.out.println("Here is the grid:");
        game.initialiseGrid();

        // Player plays the first move
        System.out.println("Input a grid field:");
        String ip = sc.next();
        game.modifyGrid(ip,"Human");
        System.out.println("Now computer will play its part");
        game.computerPlay();


        // 2nd Round
        System.out.println("Input a grid field:");
        ip = sc.next();
        game.modifyGrid(ip,"Human");
        System.out.println("Now computer will play its part");
        game.computerPlay();

        // 3rd Round
        System.out.println("Input a grid field:");
        ip = sc.next();
        game.modifyGrid(ip,"Human");
        System.out.println("Now computer will play its part");
        game.computerPlay(); */

        // Starting the game
        game.gameStart();




    }
    
}