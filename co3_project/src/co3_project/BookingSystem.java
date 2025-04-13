package co3_project;

public class BookingSystem {
    private Database database;

    public BookingSystem() {
        this.database = Database.getInstance();
    }

    public synchronized boolean bookRoom(String customerName, double paymentAmount) {
        Room room = database.getAvailableRoom();
        if (room != null && room.bookRoom()) {
            if (Payment.processPayment(customerName, paymentAmount)) {
                Booking booking = new Booking(customerName, room);
                database.addBooking(booking);
                System.out.println("Booking confirmed: " + booking);
                return true;
            } else {
                room.cancelBooking(); 
                System.out.println("Booking canceled for " + customerName + " due to payment failure.");
            }
        } else {
            System.out.println("No rooms available for " + customerName);
        }
        return false;
    }

    public void showBookings() {
        System.out.println("\nFinal Bookings:");
        for (Booking booking : database.getBookings()) {
            System.out.println(booking);
        }
    }
}
