package exercises;

import java.util.Random;
import java.util.Scanner;

public class Problems {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //formattedOutput();
        //dollarGame();
        //rollADie();
        //countFees();
        //printDayOfTheWeek();
        //validatePassword("in7hesky", "Nadezhni&par0l");
    }

    //1. Java Fundamentals Problem
    public static void formattedOutput() {

        int year, wholeNum;
        String adjective = "";

        System.out.print("Year: ");
        year = scanner.nextInt();
        System.out.print("Whole Number: ");
        wholeNum = scanner.nextInt();
        System.out.print("Adjective: ");
        adjective = scanner.next();

        System.out.printf("In a %s winter morning of %d I drank %d cups of coffee%n",
                adjective, year, wholeNum);
    }

    //2. Relational and Logical Operators Problem
    public static void dollarGame() {
        double target = 100;
        double[] valuesInCents = {1, 5, 10, 25};
        // 0.01, 0.05, 0.10, 0.25
        System.out.println("Choose amount of:\npennies, nickels, dimes, quarters\naccordingly: ");
        double totalInDollars = 0;
        for (int i = 0; i < 4; i++) {
            totalInDollars += scanner.nextInt() * valuesInCents[i];
        };

        if (totalInDollars == target) {
            System.out.println("You win");
        } else if (target < totalInDollars) {
            System.out.println("Too much money: " + (totalInDollars - target));
        } else {
            System.out.println("Not enough money: " + (target - totalInDollars));
        }
    }

    //3. Loops Problem
    public static void rollADie() {
        int spaces = 20;
        int currentPosition = 0;
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            currentPosition += random.nextInt(6) + 1;

            if (currentPosition > 20)
                break;

            System.out.println("You're on space " + currentPosition + " \\ Left to win: " + (spaces - currentPosition));
            if (currentPosition == spaces) {
                System.out.println("You win");
                return;
            }
        }

        System.out.println("You lost");

    }

    //4. Variables Scope Problem
    public static void countFees() {
        CountFees.countFees();
    }

    //5. Overloading Methods within a Class [billcalc package] ...

    //6. Useful Trick for Arrays Problem
    public static void printDayOfTheWeek() {
        String [] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.print("Choose a day: ");
        try {
            System.out.println(weekdays[scanner.nextInt() - 1]);
        } catch (Exception e) {
            System.out.println("Incorrect input. Only numbers 1 to 7 are appropriate!");
        }
    }

    //7. Strings Problem (Validator class)
    public static void validatePassword(String username, String password) {
        Validator validator = new Validator(username, password);
        if (validator.meetsAllRequirements()) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }

    //8. Access Limitations & Multiple Inheritance [cakes package]

    //9. Polymorphism Problem [fruits package]

    //10. Abstraction & Interfaces Problem [animals package]

    //11. Looping through Collections and Maps [grades package]

    //12. Throwing Exceptions Task
    public static void divideByZero() {
        try {
            int c = 30 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Division is fun");
        }
    }

    //13. Final - [cointossgame package]
}
