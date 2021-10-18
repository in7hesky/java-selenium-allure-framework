package exercises.cakes;

public class TasteTester {
    public static void main(String[] args) {
        Cake cake = new Cake();
        cake.setFlavor("Strawberries");
        cake.setPrice(200);

        WeddingCake weddingCake = new WeddingCake();
        weddingCake.setFlavor("Milky");
        weddingCake.setPrice(400);

        BirthdayCake birthdayCake = new BirthdayCake();
        birthdayCake.setPrice(300);
        birthdayCake.setFlavor("Jammy");

        System.out.println("Cake: " + cake.getPrice() + " " + cake.getFlavor() +
                "\nWeddingCake: " + weddingCake.getPrice() + " " + weddingCake.getFlavor() +
                "\nBirthdayCake: " + birthdayCake.getPrice() + " " + birthdayCake.getFlavor());
    }
}
