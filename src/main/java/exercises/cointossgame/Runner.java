package exercises.cointossgame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {


    public static void main(String[] args) {
        Player human = new Player("Anton");
        Player robot = new Player("Robot");
        Coin coin = new Coin();

        System.out.print("Guess: ");
        int guess = makeGuess();

        human.setGuess(Side.values()[guess]);
        robot.setGuess(Side.values()[(guess - 1) * -1]);

        coin.flip();
        System.out.println("You've chosen: " + human.getGuess());
        System.out.println("Coin's side: " + coin.getSide());

        String winner = "";
        if (coin.getSide() == human.getGuess()) {
            winner = human.getName();
        } else {
            winner = robot.getName();
        }

        System.out.println("The winner is: " + winner);
    }

    private static int makeGuess(){
        int guess = -1;
        while(true) {
            try {
                guess = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Numbers 0 to 1 only!");
                continue;
            }
            if(guess == 0 || guess == 1) {
                break;
            }
            System.out.println("Wrong Input!");
        }
        return guess;
    }
}
