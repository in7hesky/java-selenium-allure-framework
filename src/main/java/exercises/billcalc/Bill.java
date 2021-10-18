package exercises.billcalc;

// the task from "Overloading methods within a class"

public class Bill {

    public static final double OVERAGE_CHARGE = 0.25;
    public static final double SUBTOTAL_CHARGE = 0.15;
    private static int id_tracker = 0;

    private int id;
    private double baseCost;
    private int allottedMinutes;
    private int usedMinutes;


    public Bill() {
        this(80, 70, 80);
        //for demonstration only
    }

    public Bill(double baseCost, int allottedMinutes,
                int usedMinutes) {
        if (baseCost < 0 || allottedMinutes <= 0 || usedMinutes < 0)
            throw new IllegalArgumentException();

        this.baseCost = baseCost;
        this.allottedMinutes = allottedMinutes;
        this.usedMinutes = usedMinutes;
        this.id = id_tracker++;
    }

    public String getCheck() {
        double overageFee = countOverageFee();
        double subtotalTax = countSubtotalTax(overageFee + baseCost);
        return "--PHONE BILL #" + id + "--" +
                "\nBase Cost: " + baseCost +
                "\nOverage: " + overageFee +
                "\nTax: " + subtotalTax +
                "\nTotal: " + (baseCost + overageFee + subtotalTax) + "$";

    }

    private double countSubtotalTax(double subtotal) {
        return (double) Math.round(subtotal * SUBTOTAL_CHARGE * 10) / 10;
    }

    private double countOverageFee() {
        return allottedMinutes >= usedMinutes ?
                0 : (usedMinutes - allottedMinutes) * OVERAGE_CHARGE;
    }
}
