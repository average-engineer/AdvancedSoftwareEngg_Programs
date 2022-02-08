// Class for a game of Tic Tac Toe

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class TicTacToe {

    private String[][] grid = new String[3][3];

    private String diff; // Difficulty of the tic tac toe game as choosen by the player

    // Method to initialise the grid on the console
    public void initialiseGrid(){

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){


                if(i!= 2){
                    grid[i][j] = "___";
                }

                else if(i == 2){
                    grid[i][j] = "   ";
                }        
            }
        }

        // Printing out the grid
        printGrid();
    
    }

    // Game initiliasation
    public void gameStart(){
        System.out.println("Shall we play a game?");
        Scanner playerIP = new Scanner(System.in);
        String ans = playerIP.next();

        if(ans.equals("yes")){
            gameplayControl();
        }

        else if(ans.equals("no")){
            System.out.print("Alright :(");
        }
    }


    // Method to initiate and control the gameplay of a tictactoe game
    public void gameplayControl(){
        // The player has to first choose the difficulty
        setDifficulty();

        // Starting the game by initialising the grid
        System.out.println("Starting the game");
        for(int i = 0; i < 10; i++){
            System.out.println("Creating the grid: "+ (10*i) + "%");

        }
        initialiseGrid();
        System.out.println("Player make your move:");


    }






    // Method to modify the grid based on the way it is populated by the players
    public void modifyGrid(String ip, String Player){
        // Interpreting the grid position based on the input
        int[] gridPos = interpretGridPos(ip);
        int row = gridPos[0];
        int col = gridPos[1];

        // Populating the specific grid fields with the user input/computer input
            // If Human is playing
        if(Player.equals("Human")){
            grid[row][col] = " X ";
        }

        // If Computer is playing
        else if(Player.equals("Computer")){
            grid[row][col] = " O ";
        }

        // Printing the modified grid
        printGrid();
    }

    // Method to print out the grid
    public void printGrid(){
        System.out.println("    A  B  C");
        for(int i = 0; i < 3; i++){
            System.out.println((i+1) + "  " + grid[i][0] + "|" + grid[i][1] + "|" + grid[i][2]);
        }
    }

    // Programming how the computer plays the game
    // Strategy for playing will depend on what level the player chooses

    // STRATEGY FOR EASY:
    // The computer will make random but valid moves
    // Basically it will populate all those fields which are blank (dont have either O or X)
    // It has to choose randomly between the remaining empty fields

    // Basically the main task is to decide the appropriate row and column

    public void computerPlay(){

        // We first need to iterate over the entire grid and check if the fields are populated
        // The row and col numbers of the unpopulated fields (and valid fields) are stored
        // The row and col numbers are stored in a Hash Map (row -> keys, col -> values)

        HashMap<Integer,Integer> validFields = new HashMap<Integer,Integer>();

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(!grid[i][j].equals(" X ") && !grid[i][j].equals(" O ")){
                    validFields.put(i,j); // Storing the row and column numbers of all valid fields
                }
            }
        }

        // Size of the hmap will give us the total number of valid (ie empty) fields
        // int totValid = validFields.size();
        // We now iterate over the hmap and stop randomly
        // To choose the random stopping point:
        Random randStop = new Random();
        int stopPoint = randStop.nextInt(0,validFields.size()); // this gives us the randomised stopping point

        // Now we iterate over the hmap and stop when a counter variable becomes equal to the randomised stopping point
        int count = 0;

        // The row and col number which is chosen by the computer
        int row = -1;
        int col = -1;
        for(Map.Entry<Integer,Integer> entry: validFields.entrySet()){
            // Checking if the counter value is equal to the random stopping point
            if(count == stopPoint){
                row = entry.getKey(); // Key will contain the row number
                col = entry.getValue(); // Value will contain the column number
            }

            count = count + 1;
        }

        // Now interpreting the grid field poistion from the row number and column number
        String gridPos = interpretGridPosInv(row, col);

        // Now modfifying the grid based on the obtained position on which the computer will play
        modifyGrid(gridPos, "Computer");

    }




    // Method to set the difficulty of the game according to the level chosen by the player
    // EASY or HARD
    // This method also makes the player input the difficulty level and interprets it as a string
    public void setDifficulty(){
        Scanner playerIP = new Scanner(System.in);
        System.out.println("Choose Difficulty:");
        this.diff = playerIP.next(); // Setting the dificulty level
    }

    // Method to interpret the grid position
    // Deciding the row and column based on the input grid field (eg: A2 -> row = 0, col = 1)
    // Returns an integer array
    public int[] interpretGridPos(String ip){
        // Intepreting the User Input (eg. B2 -> 2nd row and 2nd columns -> grid[1][1])
        // A, B, C -> 1st, 2nd, 3rd columns
        // Splitting the user input string

        // Deciding the row and column number of the grid field tp populate based on the user input
        // Converting String to int: int Int = Integer.parseInt(String str)
        int row = -1;
        int col = -1;

        String[] userIP = null;

        userIP = ip.split("");
        row = Integer.parseInt(userIP[1]) - 1;
        String colstr = userIP[0];
        switch(colstr){
            case "A": col = 0; break;
            case "B": col = 1; break;
            case "C": col = 2; break;
        }
        
        // Array to be returned
        int[] returnArray = {row, col};

        return returnArray;
    }

    // Method which does inverse of what the above method does
    // Deciding the input grid field based on row and column (eg: row = 0, col = 1 -> A2)
    public String interpretGridPosInv(int row, int col){
        String rowStr = null;
        String colStr = null;

        // Interpreting row number
        switch(row){
            case 0: rowStr = "1"; break;
            case 1: rowStr = "2"; break;
            case 2: rowStr = "3"; break;
        }

        // Interpreting column number
        switch(col){
            case 0: colStr = "A"; break;
            case 1: colStr = "B"; break;
            case 2: colStr = "C"; break;
        }

        String gridPos = colStr.concat(rowStr); // A2 for example

        return gridPos;
    }
    
}
