package co3_project;

public class BookingThread extends Thread {
    private BookingSystem bookingSystem;
    private String customerName;
    private double paymentAmount;

    public BookingThread(BookingSystem bookingSystem, String customerName, double paymentAmount) {
        this.bookingSystem = bookingSystem;
        this.customerName = customerName;
        this.paymentAmount = paymentAmount;
    }

    @Override
    public void run() {
        bookingSystem.bookRoom(customerName, paymentAmount);
    }
}
