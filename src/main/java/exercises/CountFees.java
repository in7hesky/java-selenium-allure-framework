package exercises;

import java.util.Scanner;

/**
 * Not really a class, it's just a placeholder for multiple methods.
 */
public class CountFees {

    public static final Scanner scanner = new Scanner(System.in);

    public static void countFees() {
        System.out.print("Enter base cost of the plan: ");
        double planFee = scanner.nextDouble();
        System.out.print("Enter overage minutes amount: ");
        int overageMinutes = scanner.nextInt();

        double overageFee = countOverageFee(overageMinutes);
        double subtotalTax = countSubtotalTax(planFee + overageFee);

        System.out.println("--Phone Bill Statement--\n" +
                "Plan: " + planFee + "\nOverage: " + overageFee + "\nTax: " + subtotalTax +
                "\nTotal: " + countFinalTotal(planFee, overageFee, subtotalTax) + "$" );
    }

    private static double countFinalTotal(double planFee, double overageFee, double subtotalTax) {
        return planFee + overageFee + subtotalTax;
    }

    private static double countOverageFee(int minutes) {
        double chargeForMinute = 0.25;
        return minutes * chargeForMinute;
    }

    private static double countSubtotalTax(double subtotal) {
        double charge = 0.15;
        return (double)Math.round(subtotal * 0.15 * 10) / 10;
    }
}
