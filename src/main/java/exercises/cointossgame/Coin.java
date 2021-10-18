package exercises.cointossgame;

import java.util.Random;

public class Coin {

    private Side side;

    public void flip() {
        side = Side.values()[new Random().nextInt(2)];
    }

    public Side getSide() {
        return side;
    }

}
