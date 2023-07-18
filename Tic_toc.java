//hello this is a code for Tic toc game in java programing language
import java .util.*;
public class Tic_toc {
   static Scanner input=new Scanner (System.in);
    public static void main(String[] args) {
        char[][] board=new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col <board[row].length; col++) {
                board[row][col]= '.';
            }
        }
        char player='x';
        boolean gameover=false;
        boolean boardfilled=false;
        while(!gameover&&!boardfilled){
            print_board(board);
            int row= enter_row(player);
            int col=enter_column(player);
            if (board[row][col]=='.'){
                board[row][col]=player;
                gameover=have_won(board,player);
                if (gameover){
                    System.out.println(" hurray player "+player+" has won !");
                } else{
                    player=(player=='x')?'o':'x';
                }

                }   else{
                System.out.println(" in that index element exist . enter again   ");
            }
            boardfilled=isfilled(board);
        }
        print_board(board);

    }

    //function to check whether the player have won oe not
    public static boolean have_won(char[][]board,char player){
      //for loop to check the element present in  row box is equal or not
        for (int row = 0; row < board.length; row++) {
            if (board[row][0]==player&&board[row][1]==player&&board[row][2]==player){
                return true;
            }
        }
        //for loop to check the element present in  column box is equal or not
        for (int col = 0; col < board.length; col++) {
            if (board[0][col]==player&&board[1][col]==player&&board[2][col]==player){
                return true;
            }
        }
        //to check whether the diagonal elements are same
        if (board[0][0]==player&&board[1][1]==player&&board[2][2]==player){
            return true;
        }
        //same to check the diagonal elements are equal
        if (board[0][2]==player&&board[1][1]==player&&board[2][0]==player){
            return true;
        }
        return false;
    }
    //function to print the board
    public static void print_board(char[][]board){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                System.out.print(board[row][col] +" | ");
            }
            System.out.println();
        }

    }
   //function to input the row index
    public static int enter_row(char player){
        boolean s=false;
        int row=0;
        while(!s){
            System.out.print("Player "+player+" enter the row index  : ");
            row= input.nextInt();
            if (row<3){
                s=true;
            }
            else{
                System.out.println("the number should be less then 3");
            }
        }
        return row;
    }
    //function to input the column index
    public static int enter_column(char player){
        boolean s=false;
        int column=0;
        while(!s){
            System.out.print("Player "+player+" enter the column index  : ");
            column= input.nextInt();
            if (column<3){
                s=true;
            }
            else{
                System.out.println("the number should be less then 3");
            }
        }
        return column;
    }
//fuction is filled is used to check whether the box is filled
    public static boolean isfilled(char[][]board){
        int elments=0;
        for (char[] row : board) {
            for (int column = 0; column < board.length; column++) {
                if (row[column] == 'x' || row[column] == 'o') {
                    elments++;
                }
            }
        }
        if (elments==9){
            System.out.println("this match is Draw !");
            return true;
        }
        return false;
    }
}

