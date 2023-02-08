import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        printBoard(board);

        while (true) {
            playerMove(board, scanner);
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);

            computerMove(board);
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);
        }
        scanner.close();
    }

    private static void playerMove(char[][] board, Scanner scanner) {
        String input;
        while (true) {
            System.out.println("Where do you want to put the symbol?[1-9]");
            input = scanner.nextLine();
            if (isValidMove(board, input)) {
                break;
            } else
                System.out.println("It is not valid move");
        }
        moving(board, input, 'X');
    }

    private static void computerMove(char[][] board) {
        System.out.println("************");
        Random random = new Random();
        int compInput;
        while (true) {
            compInput = random.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(compInput))) {
                break;
            }
        }
        moving(board, Integer.toString(compInput), 'O');

    }

    public static boolean isValidMove(char[][] board, String position) {
        switch (position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    public static boolean isGameFinished(char[][] board) {
        if (hasVictory(board, 'X')){
            printBoard(board);
            System.out.println("Player won the game!");
            return true;
        }
        if (hasVictory(board,'O')){
            printBoard(board);
            System.out.println("Player lost!");
            return true;
        }
        for (int i =0 ;i <board.length ;i++){
            for (int j =0; j <board[i].length ;j++){
                if (board[i][j] == ' '){
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("Tie!");
        return true;
    }

    public static boolean hasVictory(char [][] board, char symbol){
        if ((board[0][0]==symbol && board[0][1]==symbol && board[0][2]==symbol)||
             (board[1][0]==symbol && board[1][1]==symbol && board[1][2]==symbol)||
             (board[2][0]==symbol && board[2][1]==symbol && board[2][2]==symbol)||

             (board[0][2]==symbol && board[1][1]==symbol && board[2][0]==symbol)||
             (board[0][0]==symbol && board[1][1]==symbol && board[2][2]==symbol)||

             (board[0][0]==symbol && board[1][0]==symbol && board[2][0]==symbol)||
             (board[0][1]==symbol && board[1][1]==symbol && board[2][1]==symbol)||
             (board[0][2]==symbol && board[1][2]==symbol && board[2][2]==symbol)){
            return true;
        }
        return false;
    }

    public static void moving(char[][] board, String position, char symbol) {
        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Move failed!");
                break;
        }

    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }


}
