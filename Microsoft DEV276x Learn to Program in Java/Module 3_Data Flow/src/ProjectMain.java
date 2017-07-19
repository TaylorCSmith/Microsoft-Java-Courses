import java.util.*;
import java.util.regex.*;

/* For this project you will be writing methods of encrypting and decrypting text.
Part 1 - Normalize Text
Part 2 - Obfuscation
Part 3 - Unobfuscation
Part 4 - Caesar Cipher
Part 5 - Codegroups
Part 6 - Putting it all together
Part 7 - Hacker Problem_Decrypt
 */


public class ProjectMain {
    private static final Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) {

        // System.out.print("Write a message please: ");
        //String userMessage = SCAN.nextLine();

        // project specified to write separate methods for each modification of the string
        System.out.println((int)'Z');
        String normMessage = NormalizeText("This is some text!!!?#$%Z");
        System.out.println(normMessage);
        String obiMessage = ObifyText(normMessage);
        System.out.println(obiMessage);
        String unobiMessage = UnobifyText(obiMessage);
        System.out.println(unobiMessage);
        String caesarMessage = CaesarifyText(normMessage, 1);
        System.out.println(caesarMessage);

        // work in progress
        String shiftAlphabet = shiftAlphabet(0);
        System.out.println(shiftAlphabet);

        // work in progress
        String[] groupMessage = GroupifyMessage(normMessage, 5);

        System.out.println(groupMessage);
    }

    // Part 1
    private static String NormalizeText(String message) {
        // they didn't say to use regex... but they didn't say you couldn't...
        message = message.replaceAll("\\s", "");
        message = message.replaceAll("\\W", "").toUpperCase();

        return message;
    }

    // Part 2
    private static String ObifyText(String message) {
        message = message.replaceAll("([AEIOU])", "OB$1");

        return message;
    }

    // Part 3
    private static String UnobifyText(String message) {
        message = message.replaceAll("OB", "");

        return message;
    }

    // Part 4
    private static String CaesarifyText(String message, int shift) {
        char[] caesarMessageArray = message.toCharArray();
        char[] key = shiftAlphabet(shift).toCharArray();

        for (int i = 0; i < message.length() - 1; i++) {

        }

        return message;
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String[] GroupifyMessage(String message, int numberPerGroup) {
        char[] msgArray = message.toCharArray();

        // need to find way of correctly sizing array
        String[] newMsgArray = {"A", "B", "C"};

        for (int i = 0; i < message.length(); i++) {
            if (i == 0) {

            }
        }

        return newMsgArray;
    }


}