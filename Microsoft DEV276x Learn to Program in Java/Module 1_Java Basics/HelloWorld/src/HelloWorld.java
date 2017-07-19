import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("What is your name? ");
        String personName = scan.nextLine();

        System.out.println("Hello World");
        System.out.println("Hello " + personName);

    }
}
