package exercises.fruits;

public class Apple extends Fruit {
    public Apple(int calories) {
        this.calories = calories;
    }

    @Override
    public void makeJuice() {
        System.out.println("Apple juice is made");
    }

    public void removeSeeds() {
        System.out.println("Seeds have been removed");
    }
}
