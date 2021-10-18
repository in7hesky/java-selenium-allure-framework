package exercises.billcalc;

public class BillRunner {
    public static void main(String[] args) {
        Bill first_bill = new Bill(); // default values
        Bill second_bill = new Bill(200, 30, 100);

        System.out.println(first_bill.getCheck());
        System.out.println(second_bill.getCheck());

        Bill third_bill = new Bill(-2, 20, 20); //throws a runtime exception
    }
}
