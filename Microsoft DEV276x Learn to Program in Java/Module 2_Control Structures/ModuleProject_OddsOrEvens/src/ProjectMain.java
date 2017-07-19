import java.util.*;

public class ProjectMain {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final Random RAND = new Random();

    public static void main(String[] args) {
        System.out.println("Lets lay a game called \"Odds and Evens\"");

        System.out.print("What's your name? ");
        String playerName = SCAN.nextLine();

        System.out.print("Hi " + playerName + ", which do you choose? (O)dds or (E)vens? ");
        String playerChoice = SCAN.nextLine();

        if (playerChoice.equals("O")) {
            System.out.println(playerName + " has picked odds! The computer will be evens.");
        } else if (playerChoice.equals("E")) {
            System.out.println(playerName + " has picked evens! The computer will be odds.");
        }

        System.out.println("----------------------------");

        playGame(playerName, playerChoice);

    }

    private static void playGame(String playerName, String playerChoice) {
        System.out.print("How many \"fingers\" do you put out? ");
        int playerFingers = SCAN.nextInt();
        SCAN.nextLine();

        Random rand = new Random();

        int computerFingers = RAND.nextInt(6);
        System.out.println("The computer players " + computerFingers + " \"fingers\"");
        System.out.println("----------------------------");
        System.out.println();

        int combinedFingers = playerFingers + computerFingers;
        System.out.println(playerFingers + " + " + computerFingers + " = " + combinedFingers);

        boolean oddOrEven = (combinedFingers % 2) == 0;
        String oddOrEvenResult = "";
        if (oddOrEven) {
            oddOrEvenResult = "even";
        } else {
            oddOrEvenResult = "odd";
        }
        System.out.println(combinedFingers + " is ..." + oddOrEvenResult);

        if ((playerChoice.equals("O") && oddOrEvenResult.equals("odd")) || (playerChoice.equals("E") && oddOrEvenResult.equals("even"))) {
            System.out.println("That means that " + playerName + " wins! :)");
        } else {
            System.out.println("That means that the computer wins! :(");
        }
        System.out.println("----------------------------");
    }
}