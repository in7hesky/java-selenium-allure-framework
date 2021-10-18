package exercises;

import java.util.Scanner;

public class Problems {
    public static void main(String[] args) {
        formattedOutput();

    }

    //Java Fundamentals Problem
    public static void formattedOutput() {

        int year, wholeNum;
        String adjective = "";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Year: ");
        year = scanner.nextInt();
        System.out.print("Whole Number: ");
        wholeNum = scanner.nextInt();
        System.out.print("Adjective: ");
        adjective = scanner.next();

        System.out.println(String.format("In a %s winter morning of %d I drank %d cups of coffee",
                adjective, year, wholeNum));
    }

    public static void dollarGame() {
        int pennies,

    }
}
