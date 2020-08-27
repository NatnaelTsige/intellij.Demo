package com.company;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe");
        System.out.println();
        boolean Status = false;
        Scanner input = new Scanner(System.in);
    }

    public static void Board(int move[]) {
        String write = "";
        System.out.println();
        for (int i=1;i<=9;i++){
            if (move[i]==-1){
                write = "X";
            }
            else if (move[i]==1){
                write = "O";
            }
            if (move[i]==0){
                write = " ";
            }

            if (i==3||i==6){
                System.out.println(write);

                System.out.println("----" + "-" + "----");

            }
            else if (i==9){System.out.println( write  ); }

            else{ System.out.print(write +" | " ); }
        }
        System.out.println();
    }


    public static void TheGame() {
        Scanner scan = new Scanner(System.in);
        String decision = "";
        do {
            int[] board = new int[10];

            for (int i = 0; i < board.length; i++) {
                board[i] = 0;
            }
            int turn = 0;
            System.out.println("The game will now start");
            System.out.println();
            Board(board);

            while (turn < 9) {
                System.out.print("Player 1: Please choose a number (1-9) > ");
                int FirstPlayer = scan.nextInt();
                while (board[FirstPlayer] == 1 || board[FirstPlayer] == -1) {
                    System.out.print("That space is claimed. Please choose another space. > ");
                    FirstPlayer = scan.nextInt();
                }
                board[FirstPlayer] = -1;
                turn++;
                Board(board);
                if (check(board) == true) {
                    break;
                }
                System.out.print("Player 2: Please choose a number (1-9) > ");
                int SecondPlayer = scan.nextInt();
                while (board[SecondPlayer] == 1 || board[SecondPlayer] == -1) {
                    System.out.print("That space is claimed. Please choose another space. > ");
                    SecondPlayer = scan.nextInt();
                }
                board[SecondPlayer] = 1;
                turn++;
                Board(board);
                if (check(board)) {
                    break;
                }
                else if (turn == 9)
                    System.out.println("Game draw.");
            }

            System.out.print("Do you want to play again? > ");
            decision = scan.next();

        } while (decision.toLowerCase().startsWith("y"));

    }
    public static boolean check(int board[]) {
        if (board[1] + board[2] + board[3] == -3 ||
                board[1] + board[4] + board[7] == -3 ||
                board[1] + board[5] + board[9] == -3 ||
                board[2] + board[5] + board[8] == -3 ||
                board[3] + board[5] + board[7] == -3 ||
                board[3] + board[6] + board[9] == -3 ||
                board[4] + board[5] + board[6] == -3 ||
                board[7] + board[8] + board[9] == -3) {
            System.out.println("Player 1 has won!");
            return true;
        }
        else if (board[1] + board[2] + board[3] == 3 ||
                board[1] + board[4] + board[7] == 3 ||
                board[1] + board[5] + board[9] == 3 ||
                board[2] + board[5] + board[8] == 3 ||
                board[3] + board[5] + board[7] == 3 ||
                board[3] + board[6] + board[9] == 3 ||
                board[4] + board[5] + board[6] == 3 ||
                board[7] + board[8] + board[9] == 3) {
            System.out.println("Player 2 has won!");
            return true;
        }
        return false;
    }
}
