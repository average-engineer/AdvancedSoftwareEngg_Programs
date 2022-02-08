// Class for a game of Tic Tac Toe

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class TicTacToe {

    private String[][] grid = new String[3][3];

    private String diff; // Difficulty of the tic tac toe game as choosen by the player

    private Scanner playerIP = new Scanner(System.in); // Variable for taking player input

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
        // Scanner playerIP = new Scanner(System.in);
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
        System.out.println("Creating the Grid:");
        initialiseGrid();

        // GAMEPLAY:
        // Human player plays first and then the computer for every round
        // Max number of times human player can play -> 5
        // Max number of times computer can play -> 4
        // One Round -> Human and Computer play once each
        // Each round can be represented by a loop which can terminate when the game ends

        // WHEN DOES THE GAME END?
        // Situation 1: Either Human player or computer wins
        // Situation 2: There is no remaining valid (empty) space in the playing grid

        // Checking for situation 1:
        // We have to keep track of every X and O being played on the grid
        // Minimum number of times a player has to play in order to win -> 3
        // If a player has won, the grid positions they have populated will have 0,1,2 for rows and/or columns


        // Checking for situation 2:
        // A counter variable which updates everytime a blank field in the grid is encountered
        // If counter = 0 after all fields have been checked, then there are no more blank fields and the match is over


        // The loop will go on as long as no player has won the game and there are valid fields still available on the grid
        // The loop ends as soon as one of the player wins or there is no valid fields left
        while((!checkWin("Human"))&&(!checkWin("Computer"))&&validFieldsAvailable()){
            // Each round begins with te computer asking the player to make a move
            System.out.println("Player make your move:");
            // Taking the player input
            // Scanner playerIP = new Scanner(System.in);
            String humanIP = playerIP.next();
            // The grid is modfified according to the human input
            modifyGrid(humanIP, "Human");

            // Now the computer plays
            System.out.println("Now the Computer will make a move");
            computerPlay();
        }

        // Once the loop ends, we have to flash a message based on who wins or if it is a tie

        // If the human wins
        if(checkWin("Human")){
            System.out.println("Congratulations, you win!");
        }

        // If the computer wins
        else if(checkWin("Computer")){
            System.out.println("Sorry, you lose!");
        }

        // If the game is a tie
        // No valid fields are avalilable and there is no winner
        else if(!validFieldsAvailable()){
            System.out.println("A STRANGE GAME");
            System.out.println("THE ONLY WINNING MOVE IS NOT TO PLAY");
        }

        // Then the game reloops and we are at the start again: Shall we play a game?
        gameStart();

    }



    // Method to check for a possible winner
    // Checks for a particular player (can be a Human or the Computer)
    // Returns true if the player has won
    // Input Parameter -> Player Type (Human or Computer)
    public boolean checkWin(String player){

        // Strings for storing the row and column 
        String rowStr = "";
        String colStr = "";
        // Looping over the entire grid
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){

                // Checking the populated grids based on the Player type
                if(player.equals("Human")){
                    if(grid[i][j].equals(" X ")){
                        rowStr = rowStr.concat(String.valueOf(i));
                        colStr = colStr.concat(String.valueOf(j));
                    }
                }

                else if(player.equals("Computer")){
                    if(grid[i][j].equals(" O ")){
                        rowStr = rowStr.concat(String.valueOf(i));
                        colStr = colStr.concat(String.valueOf(j));
                    }
                }
            }
        }

        // Boolean conditions
        // Row string contains all 0,1,2
        boolean rowStrAll = rowStr.contains("0")&&rowStr.contains("1")&&rowStr.contains("2");
        // Column string contains all 0,1,2
        boolean colStrAll = colStr.contains("0")&&colStr.contains("1")&&colStr.contains("2");

        // Row string contains only 0
        boolean rowStr0 = rowStr.contains("0")&&(!rowStr.contains("1"))&&(!rowStr.contains("2"));
        // Row string contains only 1
        boolean rowStr1 = rowStr.contains("1")&&(!rowStr.contains("0"))&&(!rowStr.contains("2"));
        // Row string contains only 2
        boolean rowStr2 = rowStr.contains("2")&&(!rowStr.contains("1"))&&(!rowStr.contains("0"));

        // Column string contains only 0
        boolean colStr0 = colStr.contains("0")&&(!colStr.contains("1"))&&(!colStr.contains("2"));
        // Column string contains only 1
        boolean colStr1 = colStr.contains("1")&&(!colStr.contains("0"))&&(!colStr.contains("2"));
        // Column string contains only 2
        boolean colStr2 = colStr.contains("2")&&(!colStr.contains("1"))&&(!colStr.contains("0"));

        
        // WINNING CONDITIONS
        
        // Condition for straight row win
        // Row remains constant (0,1 or 2) and column string has all 3 (0,1, and 2)
        boolean stRowWin = (rowStr0||rowStr1||rowStr2)&&colStrAll;

        // Condition for straight col win
        // Column remains constant (0,1 or 2) and row string has all 3 (0,1, and 2)
        boolean stColWin = (colStr0||colStr1||colStr2)&&rowStrAll;

        // Condition for diagonal win
        // Both column and row string contain all 3 (0,1,2)
        // In order to maintain the order, rowStr == colStr
        boolean diagWin = rowStrAll&&colStrAll&&(rowStr.equals(colStr));

        // WINNING CONDITIONS

        if(stRowWin||stColWin||diagWin){
            return true;
        }

        return false;

    }


    // Method to check if the game has no more valid fields left 
    // Returns true if valid fields are left
    public boolean validFieldsAvailable(){


        // Counter variable for keeping track of valid fields
        int count = 0;
        // Looping over the entire grid and checking if any valid fields are there
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if((!grid[i][j].equals(" X ")) && (!grid[i][j].equals(" O "))){ // Condition for a valid field
                    count = count + 1; // Updating the counter variable
                }
            }
        }

        // If the counter variable hasn't updated, then there are no valid fields left
        if(count == 0){
            return false;
        }

        return true;
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
        // Scanner playerIP = new Scanner(System.in);
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
