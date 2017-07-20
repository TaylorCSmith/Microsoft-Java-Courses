
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
        System.out.println();

        System.out.println("Deploy your ships by choosing a number from 0 to 9: ");
        UpdateBoardPlayer(board, 1);

        System.out.println();
        System.out.println("This is what the board looks like now... your ships are the \"@\" symbols");
        PrintBoard(board);
        System.out.println();

        System.out.println("The computer is now deploying ships");
        char[][] computerBoard = CreateComputerBoard();
        UpdateBoardComputer(computerBoard, 1);
        System.out.println();

        System.out.println("It's time for the game!");
        Turn(board, computerBoard);


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

    public static char[][] CreateComputerBoard() {
        char[][] computerBoard =    {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};

        return computerBoard;
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
            int yCord = GetYCord(shipCount);

            if (!CheckCoordinateExist(board, xCord, yCord)) {
                System.out.println("Please enter a position that isn't already filled!");
                UpdateBoardPlayer(board, shipCount);
            } else {
                board[xCord][yCord + 1] = '@';
            }
        }
    }

    public static int GetXCord(int shipCount) {
        int xCord = 0;
        System.out.print("Enter a X coordinate for ship number " + shipCount + ": ");
        xCord = SCAN.nextInt();
        SCAN.nextLine();
        if (!CheckCoordinateRange (xCord)) {
            System.out.print("Please enter a coordinate between 1 and 10! " );
            xCord = SCAN.nextInt();
            SCAN.nextLine();
            CheckCoordinateRange(xCord);
        }
        return xCord;
    }

    public static int GetYCord(int shipCount) {
        int yCord = 0;
        System.out.print("Enter a Y coordinate for ship number " + shipCount + ": ");
        yCord = SCAN.nextInt();
        SCAN.nextLine();

        if (!CheckCoordinateRange(yCord)) {
            System.out.print("Please enter a coordinate between 1 and 10! " );
            yCord = SCAN.nextInt();
            SCAN.nextLine();
            CheckCoordinateRange(yCord);
        }

        return yCord;
    }

    public static boolean CheckCoordinateRange(int coordinate) {
        if (coordinate > -1 && coordinate < 10) {
            return true;
        } else {

            return false;
        }
    }

    public static boolean CheckCoordinateExist(char[][] board, int xCord, int yCord) {
        if (board[xCord + 2][yCord + 2] == '@' || board[xCord][yCord] == 'X' || board[xCord][yCord] == 'P') {
            return false;
        } else {
            return true;
        }
    }

    public static boolean CheckComputerCoordExist(char[][] computerBoard, int xCord, int yCord) {
        if (computerBoard[xCord][yCord] == 'C' || computerBoard[xCord][yCord] == 'X' || computerBoard[xCord][yCord] == 'Z') {
            return false;
        } else {
            return true;
        }
    }

    public static void UpdateBoardComputer(char[][] board, int shipCount) {
        Random ranNumb = new Random();
        int xCord = 0, yCord = 0;
        for (; shipCount<6; shipCount++) {
            xCord = ranNumb.nextInt(9);
            yCord = ranNumb.nextInt(9);

            if(!CheckComputerCoordExist(board,xCord, yCord)) {
                UpdateBoardComputer(board, shipCount);
            } else {
                board[xCord][yCord] = 'C';
                System.out.println("The computer has deployed ship " + shipCount + "!");
            }
        }
    }

    public static void Turn(char[][] playerBoard, char[][] computerBoard) {
        int counter = 1;
        int computerShipsLeft = 5;
        int playerShipsLeft = 5;
        char outcome = ' ';

        for (; computerShipsLeft > 0 && playerShipsLeft > 0; counter++) {
            if (counter%2 == 1) {
                outcome = PlayerTurn(playerBoard, computerBoard);
                switch (outcome) {
                    case 'P':
                        playerShipsLeft -= 1;
                        break;
                    case 'C':
                        computerShipsLeft -=1;
                }
            }
            if (counter%2 == 0) {
                outcome = ComputerTurn(playerBoard, computerBoard);
                switch (outcome) {
                    case 'P':
                        playerShipsLeft -= 1;
                        break;
                    case 'C':
                        computerShipsLeft -=1;
                }
            }

            if (computerShipsLeft == 0) {
                System.out.println("You've won!!!");
                break;
            } else if (playerShipsLeft == 0){
                System.out.println("You lost!!! :(");
                break;
            }

            System.out.println();
            System.out.println("*************");
            System.out.println("You have " + playerShipsLeft + " ships left.");
            System.out.println("The computer has " + computerShipsLeft + " ships left");
            System.out.println();
            PrintBoard(playerBoard);
            System.out.println("*************");
            System.out.println();
        }
    }

    public static char PlayerTurn(char[][] computerBoard, char[][] playerBoard) {
        System.out.print("Enter a X Coordinate: ");
        int xCord = SCAN.nextInt();
        SCAN.nextLine();
        if (!CheckCoordinateRange(xCord)) {
            System.out.println("Choose a coordinate between 0 and 9!");
            PlayerTurn(computerBoard, playerBoard);
        }

        System.out.print("Enter a Y Coordinate: ");
        int yCord = SCAN.nextInt();
        SCAN.nextLine();
        if (!CheckCoordinateRange(xCord)) {
            System.out.println("Choose a coordinate between 0 and 9!");
            PlayerTurn(computerBoard, playerBoard);
        }

        if (computerBoard[xCord][yCord] == 'C') {
            System.out.println("HIT!");
            computerBoard[xCord][yCord] = 'X';
            playerBoard[xCord][yCord] = 'X';
            return 'C';
        } else if (playerBoard[xCord][yCord] == '@'){
            System.out.println("You hit your own ship!");
            playerBoard[xCord][yCord] = 'X';
            return 'P';
        } else {
            System.out.println("You missed!");
            playerBoard[xCord][yCord] = 'O';
            return 'N';
        }
    }

    public static char ComputerTurn(char[][] computerBoard, char[][] playerBoard) {
        Random randNumber = new Random();
        int xCord = randNumber.nextInt(9);
        int yCord = randNumber.nextInt(9);

        if (computerBoard[xCord][yCord] == 'C') {
            System.out.println("The computer hit itself!");
            playerBoard[xCord][yCord] = 'Z';
            computerBoard[xCord][yCord] = 'Z';
            return 'C';

        } else if (playerBoard[xCord][yCord] == '@'){
            System.out.println("The computer has landed a hit!");
            playerBoard[xCord][yCord] = 'Z';
            computerBoard[xCord][yCord] = 'Z';
            return 'P';

        } else if (computerBoard[xCord][yCord] == 'Z'){
            ComputerTurn(computerBoard, playerBoard);

        } else {
            System.out.println("The computer has missed");
            playerBoard[xCord][yCord] = 'G';
            return 'N';
        }
        return 'N';
    }
}