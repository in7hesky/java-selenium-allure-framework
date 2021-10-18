package exercises.cointossgame;

public class Player {
    private String name;
    private Side guess;

    public Player(String name) {
        this.name = name;
    }

    public void setGuess(Side guess) {
        this.guess = guess;
    }

    public String getName() {
        return name;
    }

    public Side getGuess() {
        return guess;
    }
}
