//////////////////////////////////////////////////////////////////////
// Author: Allan Poindexter                                         //
//                                                                  //
// Date: 11/10/16                                                   //
// Program Description: Randomly generates a tic-tac-toe game and   //
// displays the results.                                            //
//                                                                  //
// Input: None                                                      //
// Processing:                                                      //
//  -Initialize two int 2D arrays, and assign -1 to all elements    //
//  -Randomly jump through each element and add a 0 or 1            //
//  -Determine who wins                                             //
// Output: The tic tac toe board and a message of who won           //
//////////////////////////////////////////////////////////////////////


import java.util.Random;

public class TicTacToe {

    //New 2D arrays for both tables.
    static int[][] table1 = new int[3][3];
    static int[][] table2 = new int[3][3];

    public static void main(String[] args) {
        setUpTables(); //Sets all the elements to -1

        //Print the results of the game.
        generateGame(table1);
        System.out.println("Table 1 results: ");
        System.out.println();
        printResults(table1);

        System.out.println();
        System.out.println();

        generateGame(table2);
        System.out.println("Table2 results: ");
        System.out.println();
        printResults(table2);

    }


    /** Initialize  both tables*/
    static void setUpTables(){
        for (int i = 0; i < table1.length; i++)
        {
            for (int j = 0; j < table1[i].length; j++){
                table1[i][j] = -1;
                table2[i][j] = -1;
            }
        }
    }

    /** Randomly generate a game of tic tac toe and assign a 0 or 1 to elements
     * of an array */
    static void generateGame(int[][] table){
        Random randIndex = new Random();    //Random spot in the array
        int numberOfBlanks = 9; //Number of possible moves

        Random firstZeroOne = new Random(); //Determines if 0's or 1's go first.
        int lastNumber = firstZeroOne.nextInt(2); //Remebers who went last.

        /* Use randIndex to randomly jump through the 2D array, rather than
        sequentially.*/
        while (numberOfBlanks > 0){
            int index1 = randIndex.nextInt(3);
            int index2 = randIndex.nextInt(3);

            //Is a space blank?
            if (table[index1][index2] == -1){
                if (lastNumber != 0){   //Did player 0 already go?
                    table[index1][index2] = 0;
                    lastNumber = 0;
                } else if (lastNumber != 1){    //Did player 1 already go?
                    table[index1][index2] = 1;
                    lastNumber = 1;
                }
                //The number of moves left drops by one
                numberOfBlanks--;
            }
        }
    }

    /* Print the results of the game */
    static void printResults(int[][] table) {
        //Print the Table results

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++)
                System.out.print(table[i][j]);
            System.out.println();
        }

        System.out.println();

        for (int player = 0; player <= 1; player++) {
        //First Row and First Column, and First Diagonal
            if (table[0][0] == player){
                //First Row Match
                if (table[0][1] == table[0][0] &&
                    table[0][2] == table[0][0])
                    System.out.println(player + " wins in the first row.");

                //First column Match
                if (table[1][0] == table[0][0] &&
                    table[2][0] == table[0][0])
                    System.out.println(player + " wins in the first column.");

                //First Diagonal Match
                if (table[1][1] == table[0][0] &&
                    table[2][2] == table[0][0])
                    System.out.println(player + " wins in the first diagonal.");

            }

            //Second Row
            if (table[1][0] == player &&
                table[1][1] == table[1][0] &&
                table[1][2] == table[1][0])
                System.out.println(player + " wins in the second row");

            //Third Row, and Second Diagonal
            if ( table[2][0] == player){
                //Third Row Match
                if (table[2][1] == table[2][0] &&
                    table[2][2] == table[2][0])
                    System.out.println(player + " wins the third row");

                //Second Diagonal Match
                if (table[1][1] == table[2][0] &&
                    table[0][2] == table[2][0])
                    System.out.println(player + " wins the second diagonal");
            }

            //Second Column
            if (table[0][1] == player &&
                table[1][1] == table[0][1] &&
                table[2][1] == table[0][1])
                System.out.println(player + " wins the second column");

            //Third Column
            if (table[0][2] == player &&
                table[1][2] == table[0][2] &&
                table[2][2] == table[0][2])
                System.out.println(player + " wins the third column");
        }
    }
}
