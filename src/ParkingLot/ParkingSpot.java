package ParkingLot;

import ParkingLot.Vehicle.VechileType;
import ParkingLot.Vehicle.Vehicle;

public class ParkingSpot {
    private final int spotId;
    private final VechileType parkingType;
    private Vehicle parkedVehicle;


    public ParkingSpot(int spotId, VechileType parkingType) {
        this.spotId = spotId;
        this.parkingType = parkingType;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if(isSpotAvailable() && parkingType==vehicle.getVechileType()) {
            parkedVehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Either spot not available or parkingType is different from Vechile type");
        }
    }

    public synchronized void unparkVehicle() {
        parkedVehicle = null;
    }
    public VechileType getParkingType() {
        return parkingType;
    }
    public synchronized boolean isSpotAvailable() {
        return parkedVehicle == null;
    }
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
    public int getSpotId() {
        return spotId;
    }
}
