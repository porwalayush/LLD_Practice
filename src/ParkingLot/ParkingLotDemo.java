package ParkingLot;

import ParkingLot.Vehicle.Bike;
import ParkingLot.Vehicle.Car;
import ParkingLot.Vehicle.Truck;
import ParkingLot.Vehicle.Vehicle;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getParkingLotInstance();

        // Bikes
        Vehicle bike1 = new Bike("zyx-abc-bike1");
        Vehicle bike2 = new Bike("zyx-abc-bike2");
        Vehicle bike3 = new Bike("zyx-abc-bike3");
        Vehicle bike4 = new Bike("zyx-abc-bike4");
        Vehicle bike5 = new Bike("zyx-abc-bike5");

        // Cars
        Vehicle car1 = new Car("zyx-abc-car1");
        Vehicle car2 = new Car("zyx-abc-car2");
        Vehicle car3 = new Car("zyx-abc-car3");
        Vehicle car4 = new Car("zyx-abc-car4");

        // Truck

        Vehicle truck1 = new Truck("zyx-abc-truck1");

        // Add levels to parking lot
        parkingLot.addLevel(1, 5);
        parkingLot.addLevel(2, 3);

        // Parking vehicles
        parkingLot.parkVehicle(bike1);
        parkingLot.parkVehicle(bike2);
        parkingLot.parkVehicle(bike3);
        parkingLot.parkVehicle(bike4);

        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(car3);
        parkingLot.parkVehicle(car4);


        parkingLot.getAvailability();

        // Unparking Vehicles
        parkingLot.unparkVehicle(bike2);
        parkingLot.parkVehicle(bike4);
        parkingLot.parkVehicle(bike5);
        parkingLot.parkVehicle(truck1);

        parkingLot.getAvailability();


    }
}
