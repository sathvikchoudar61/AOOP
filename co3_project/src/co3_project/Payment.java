package co3_project;


public class Payment {
    public static boolean processPayment(String customerName, double amount) {
        // 
        System.out.println("Payment successful for " + customerName + ": $" + amount);
        return true;
    }
}
