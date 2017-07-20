
import java.util.*;

public class ProjectMain {

    private static final Scanner SCAN = new Scanner(System.in);

    public static void main(String[] arg) {
        Scanner scan  = new Scanner(System.in);

        System.out.println("**** Welcome to the BattleShips Game ****");
        System.out.println();

        System.out.println("Right now... the seas are empty");
        System.out.println();

        char[][] board = CreateBoard();
        PrintBoard(board);
        System.out.println();

        System.out.println("Let's change that!");

        UpdateBoardPlayer(board, 1);

        PrintBoard(board);

    }

    public static char[][] CreateBoard() {
        // since the starting board will always be the same... might as well define it this way opposed to using for loops or something... keep it simple
        char[][] board =    {{' ', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', ' '},
                            {'0', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '0'},
                            {'1', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '1'},
                            {'2', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '2'},
                            {'3', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '3'},
                            {'4', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '4'},
                            {'5', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '5'},
                            {'6', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '6'},
                            {'7', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '7'},
                            {'8', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '8'},
                            {'9', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', '9'},
                            {' ', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', ' '}};
        return board;
    }

    public static void PrintBoard(char[][] board) {
        for(int x=0; x<12; x++){
            for(int y=0; y<14; y++){
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
    }

    // since it's an array... doesn't need to return the new board...
    public static void UpdateBoardPlayer(char[][] board, int shipCount) {

        for (; shipCount < 6; shipCount++) {
            int xCord = GetXCord(shipCount);
            int yCord = GetYcord(shipCount);

            if (!CheckCoordinateExist(board, xCord, yCord)) {
                System.out.println("Please enter a position that isn't already filled!");
                UpdateBoardPlayer(board, shipCount);
            } else {
                board[xCord + 2][yCord + 2] = '@';
            }
        }
    }

    public static int GetXCord(int shipCount) {
        int xCord = 0;
        System.out.print("Enter a X coordinate for ship number " + shipCount + ": ");
        xCord = SCAN.nextInt();
        SCAN.nextLine();
        if (!CheckCoordinateRange (xCord)) {
            xCord = SCAN.nextInt();
            SCAN.nextLine();
            CheckCoordinateRange(xCord);
        }
        return xCord;
    }

    public static int GetYcord(int shipCount) {
        int yCord = 0;
        System.out.print("Enter a Y coordinate for ship number " + shipCount + ": ");
        yCord = SCAN.nextInt();
        SCAN.nextLine();

        if (!CheckCoordinateRange(yCord)) {
            yCord = SCAN.nextInt();
            SCAN.nextLine();
            CheckCoordinateRange(yCord);
        }

        return yCord;
    }

    public static boolean CheckCoordinateRange(int coordinate) {
        if (coordinate > 0 && coordinate < 10) {
            return true;
        } else {
            System.out.print("Please enter a coordinate between 1 and 10! " );
            return false;
        }
    }

    public static boolean CheckCoordinateExist(char[][] board, int xCord, int yCord) {
        if (board[xCord + 2][yCord + 2] == '@') {
            return false;
        } else {
            return true;
        }
    }
}