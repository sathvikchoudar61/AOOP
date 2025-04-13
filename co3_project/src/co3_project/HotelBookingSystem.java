package co3_project;
public class HotelBookingSystem {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();

        Thread customer1 = new BookingThread(bookingSystem, "Alice", 100.0);
        Thread customer2 = new BookingThread(bookingSystem, "Bob", 120.0);
        Thread customer3 = new BookingThread(bookingSystem, "Charlie", 90.0);
        Thread customer4 = new BookingThread(bookingSystem, "David", 110.0);
        Thread customer5 = new BookingThread(bookingSystem, "Eve", 130.0);
        Thread customer6 = new BookingThread(bookingSystem, "Frank", 80.0); 
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();
        customer6.start();
        try {
            customer1.join();
            customer2.join();
            customer3.join();
            customer4.join();
            customer5.join();
            customer6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bookingSystem.showBookings();
    }
}

