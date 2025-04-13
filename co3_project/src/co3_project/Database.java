package co3_project;


import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database instance;
    private List<Room> rooms;
    private List<Booking> bookings;

    private Database() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        rooms.add(new Room(101));
        rooms.add(new Room(102));
        rooms.add(new Room(103));
        rooms.add(new Room(104));
        rooms.add(new Room(105));
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public synchronized void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public synchronized Room getAvailableRoom() {
        for (Room room : rooms) {
            if (!room.isBooked()) {
                return room;
            }
        }
        return null;
    }
}
