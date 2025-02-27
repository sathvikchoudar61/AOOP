package p1;

public class Client {
    public static void main(String[] args) {
        GameLevelManager levelManager = GameLevelManager.getInstance();
        System.out.println("Current Game Level: " + levelManager.getLevel());
        levelManager.setLevel("Hard");
        System.out.println("Updated Game Level: " + levelManager.getLevel());

        Vehicle vehicle = VehicleFactory.getVehicle("bike");
        if (vehicle != null) {
            vehicle.requestRide();
        }

        RideFactory carFactory = new CarFactory();
        Vehicle myCar = carFactory.createVehicle();
        myCar.requestRide();

        RideFactory bikeFactory = new BikeFactory();
        Vehicle myBike = bikeFactory.createVehicle();
        myBike.requestRide();
    }
}
