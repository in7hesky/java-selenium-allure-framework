package exercises.fruits;

public class Market {
    public static void main(String[] args) {
        Fruit banana = new Banana(300);
        Apple apple = new Apple(200);

        banana.makeJuice();
        apple.makeJuice();
        apple.removeSeeds();
        //banana.peel(); won't work
    }
}
