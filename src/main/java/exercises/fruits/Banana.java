package exercises.fruits;

public class Banana extends Fruit{
    public Banana(int calories) {
        this.calories = calories;
    }

    @Override
    public void makeJuice() {
        System.out.println("Banana juice is made");
    }

    public void peel() {
        System.out.println("Banana has been peeled");
    }
}
