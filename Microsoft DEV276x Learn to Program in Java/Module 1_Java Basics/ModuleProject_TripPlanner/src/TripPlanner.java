import java.util.Scanner;

public class TripPlanner {

    // I am aware that this is not the optimal place for class variables/constants...
    // However, I just put them here to get more practice with them.
    private static final int DAYS_TO_HOURS = 24;
    private static final int HOURS_TO_MINUTES = 60;
    private static final double KMSQUARED_TO_MILESSQUARED = 0.386102;
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        TripIntroduction();
        System.out.println();
        System.out.println("***********");
        System.out.println();

        TripTimeandBudget();
        System.out.println();
        System.out.println("***********");
        System.out.println();

        TripTimeDifference();
        System.out.println();
        System.out.println("***********");
        System.out.println();

        TripCountryArea();
        System.out.println();
        System.out.println("***********");
        System.out.println();
    }

    private static void TripIntroduction() {
        System.out.println("Welcome to the vacation planner!");
        System.out.print("What is your name? ");
        String personName = scan.nextLine();

        System.out.print("Nice to meet you " + personName + ", where are you traveling to? ");
        String destination = scan.nextLine();

        System.out.print("Great! " + destination + " sounds like a great trip!");
    }

    private static void TripTimeandBudget() {
        System.out.print("How many days are you going to spend traveling? ");
        int tripTimeInDays = scan.nextInt();
        scan.nextLine();

        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        double tripCostInUSD = scan.nextInt();
        scan.nextLine();

        System.out.print("What is the currency symbol for your travel destination? ");
        String tripCurrencySymbol = scan.nextLine();

        System.out.print("How many " + tripCurrencySymbol + " are there in 1 USD? ");
        double tripCurrencyToUSD = scan.nextDouble();
        scan.nextLine();

        System.out.println();

        System.out.println("If you are travelling for " + tripTimeInDays + " days that is the same as " + (tripTimeInDays * DAYS_TO_HOURS) +
                " hours or " + (tripTimeInDays * DAYS_TO_HOURS * HOURS_TO_MINUTES) + " minutes");
        System.out.println("If you are going to spend $" + tripCostInUSD + " USD that means that per day you can spend up to " +
                (tripCostInUSD/tripTimeInDays) + " USD");
        System.out.println("Your total budget in " + tripCurrencySymbol + " is " + (tripCostInUSD*tripCurrencyToUSD) + " " +
                tripCurrencySymbol + ", which per day is " + ((tripCostInUSD)));
    }

    private static void TripTimeDifference() {
        System.out.print("What is the time difference, in hours, between your home and destination? ");
        int tripTimeDifference = scan.nextInt();
        scan.nextLine();


        int tripNoonAnswer = (12 + tripTimeDifference);
        if (tripTimeDifference>24) {
            tripNoonAnswer = ((tripNoonAnswer - 24) + tripNoonAnswer%24);
        }

        // I am aware of other methods of displaying times, but the problem is worded in such a way to
        // imply the use of the method shown below
        System.out.println("That means that when it is midnight at home it will be " +
                (tripTimeDifference) + ":00 in your travel destination and when it is noon at home it will be " +
                (tripNoonAnswer) + ":00");

    }

    private static void TripCountryArea() {
        System.out.print("What is the square area of your destination country in km2? ");
        double tripCountryKMTwo = scan.nextInt();
        scan.nextLine();

        // Math.round is used to round the converted number to two decimal places
        double tripCountryMilesTwo = Math.round((tripCountryKMTwo*KMSQUARED_TO_MILESSQUARED)*100.0)/100.0;

        System.out.println("In miles2 that is " + tripCountryMilesTwo);

    }
}