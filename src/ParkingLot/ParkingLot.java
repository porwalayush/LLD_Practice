package ParkingLot;

import ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    public static ParkingLot instance;
    public List<ParkingLevel> parkingLevels;

    ParkingLot() {
        parkingLevels = new ArrayList<>();
    }

    public static synchronized ParkingLot getParkingLotInstance() {
        if(instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }
    public void parkVehicle(Vehicle vehicle) {
        for(ParkingLevel parkingLevel : parkingLevels) {
            if(parkingLevel.parkVehicle(vehicle)) {
                return;
            }
        }
        System.out.println("Currently, No slots available for " + vehicle.getLicensePlate());
    }

    public void unparkVehicle(Vehicle vehicle) {
        for(ParkingLevel parkingLevel : parkingLevels) {
            if(parkingLevel.unparkVehicle(vehicle)) {
                return;
            }
        }
        System.out.println("First park the vehicle "+ vehicle.getLicensePlate());
    }

    public void addLevel(int floor, int totalSpots) {
        parkingLevels.add(new ParkingLevel(floor, totalSpots));
    }

    public void getAvailability() {
        for(ParkingLevel parkingLevel : parkingLevels) {
            parkingLevel.getLevelAvailability();
        }
    }
}
