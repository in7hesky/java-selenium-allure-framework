package exercises.animals;

public class Farm {
    public static void main(String[] args) {
        Pig pig = new Pig();
        Duck duck = new Duck();
        pig.makeSound();
        duck.makeSound();
        pig.eat();
        duck.eat();
    }
}
