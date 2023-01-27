package TicTacToe;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        System.out.println("Zasady - Wygrywa ten, który pierwszy zdobędzie 3 swoje znaki wzdłuż kolumn/wierszy/skosów, zaczyna X ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz ilosc kolumn i wierszy wiekszy od 2 ");
        int numberOfColRow = scanner.nextInt();
        while (numberOfColRow < 2){
            System.out.println("Kolumny i wiersze maja byc wieksze od 2");
            numberOfColRow = scanner.nextInt();
        }
        char[][] board = new char [numberOfColRow][numberOfColRow];
        moveCounting(numberOfColRow,board);


    }
    private static boolean checkWinOColumns(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean victory = true;
            for (int j = 0; j< board.length; j++){
                if (board[j][i] != 'O') {
                    victory = false;
                    break;
                }
            }
            if (victory){
                return true;
            }
        }
        return false;
    }
    private static boolean checkWinXColumns(char[][] board) {
        for (int i = 0; i < 3; i++) {
            boolean victory = true;
            for (int j = 0; j< 3; j++){
                if (board[j][i] != 'X') {
                    victory = false;
                    break;
                }
            }
            if (victory){
                return true;
            }
        }
        return false;
    }
    private static boolean checkWinXRows(char[][] board) {
        for (int i = 0; i < 3; i++) {
            boolean victory = true;
            for (int j = 0; j< 3; j++){
                if (board[i][j] != 'X') {
                    victory = false;
                    break;
                }
            }
            if (victory){
                return true;
            }
        }
        return false;
    }
    private static boolean checkWinORows(char[][] board) {
        for (int i = 0; i < 3; i++) {
            boolean victory = true;
            for (int j = 0; j< 3; j++){
                if (board[i][j] != 'O') {
                    victory = false;
                    break;
                }
            }
            if (victory){
                return true;
            }
        }
        return false;
    }

    private static boolean checkWinXCross1(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][i] != 'X'){
                return false;
            }
        }
        return true;
    }
    private static boolean checkWinXCross2(char[][] board) {
        for (int i = 0; i< 3; i++) {
            if (board[i][board.length - i - 1] != 'X'){
                return false;
            }
        }
        return true;
    }
    private static boolean checkWinOCross1(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][i] != 'O'){
                return false;
            }
        }

        return true;
    }
    private static boolean checkWinXOCross2(char[][] board) {
        for (int i = 0; i< 3; i++) {
            if (board[i][board.length - i - 1] != 'O'){
                return false;
            }
        }
        return true;
    }



    private static boolean checkWin(char[][] board){
        if (checkWinOColumns(board)){
            System.out.println("Wygrał gracz O!");
            return true;
        }
        if (checkWinXColumns(board)){
            System.out.println("Wygrał gracz O!");
            return true;
        }
        if (checkWinORows(board)){
            System.out.println("Wygrał gracz O!");
            return true;
        }
        if (checkWinXRows(board)){
            System.out.println("Wygrał gracz X!");
            return true;
        }
        if (checkWinXCross1(board)){
            System.out.println("Wygrał gracz X!");
            return true;
        }
        if (checkWinXCross2(board)){
            System.out.println("Wygrał gracz X!");
            return true;
        }
        if (checkWinOCross1(board)){
            System.out.println("Wygrał gracz O!");
            return true;
        }
        if (checkWinXOCross2(board)){
            System.out.println("Wygrał gracz O!");
            return true;
        }
        else return false;
    }

    private static boolean moveChecker(char[][] board, char playerChoose){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz wiersz, na którym chcesz wpisać znak");
        int Row = scanner.nextInt();
        while (Row < 0 || Row >= board.length)
        {
            System.out.println("Wpisz liczbę od 0 do " + (board.length-1));
            Row = scanner.nextInt();
        }

        System.out.println("Wpisz kolumne, na którym chcesz wpisać znak");
        int Column = scanner.nextInt();
        while (Column < 0  || Column >= board.length)
        {
            System.out.println("Wpisz liczbę od 0 do " + (board.length-1));
            Column = scanner.nextInt();
        }
        if (board[Row][Column] == 0){
            board[Row][Column] = playerChoose;
            return true;}
        else {
            return false;
        }
    }

    private static void moveCounting(int numberOfColRow, char[][] board){
        int CountingCheck = 0;
        char playerChoose = 'X';
        boardMaking(board);
        while (CountingCheck < numberOfColRow * numberOfColRow){

            if (moveChecker(board, playerChoose)){
                if (playerChoose == 'X'){
                    playerChoose = 'O';
                }
                else {
                    playerChoose = 'X';
                }
                boardMaking(board);
                CountingCheck++;
            }
            else System.out.println("Wpisałeś złe pole");
            if (checkWin(board)){
                break;
            }

        }
        if (CountingCheck == numberOfColRow * numberOfColRow && !checkWin(board)){
            System.out.println("Remis");
        }

    }
    private static void boardMaking(char[][] board){

        int numberOfColRow = board.length;
        System.out.print("\t");
        for (int i = 0; i<numberOfColRow; i++){
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i<numberOfColRow;i++){
            System.out.print(i + ":\t");
            for (int j = 0; j<numberOfColRow;j++){
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
