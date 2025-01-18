package ParkingLot;

import ParkingLot.Vehicle.VechileType;
import ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {
    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public ParkingLevel(int floor, int totalSlot) {
        this.floor = floor;
        parkingSpots = new ArrayList<>();
        double spotForBikes = 0.5;
        double spotForCars = 0.4;

        int numberOfBikes = (int) (totalSlot * spotForBikes);
        int numberOfCars = (int) (totalSlot * spotForCars);


        for(int i=1;i <=numberOfBikes; i++) {
            parkingSpots.add(new ParkingSpot(i, VechileType.BIKE));
        }
        for(int i=numberOfBikes+1; i <=numberOfBikes+numberOfCars; i++) {
            parkingSpots.add(new ParkingSpot(i, VechileType.CAR));
        }
        for(int i=numberOfBikes+numberOfCars+1; i <=totalSlot; i++) {
            parkingSpots.add(new ParkingSpot(i, VechileType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for(ParkingSpot spot : parkingSpots) {
            if(spot.isSpotAvailable() && spot.getParkingType()==vehicle.getVechileType()){
                spot.parkVehicle(vehicle);
                System.out.println("Parked Vehicle " + vehicle.getLicensePlate() +" at Floor" + floor + " and spot" + spot.getSpotId());
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for(ParkingSpot spot : parkingSpots) {
            if(spot.getParkedVehicle()==vehicle){
                spot.unparkVehicle();
                System.out.println("Unparked vehicle at floor " + floor +" and spot " + spot.getSpotId());
                return true;
            }
        }
        return false;
    }

    public void getLevelAvailability(){
        System.out.println("At Floor :" + floor );
        for(ParkingSpot spot : parkingSpots) {
            if(spot.isSpotAvailable()) {
                System.out.println("Spot: " + spot.getSpotId() + " is available");
            } else {
                System.out.println("Spot: " + spot.getSpotId() + " is not available. Vehicle " + spot.getParkedVehicle().getLicensePlate() + " is Parked");
            }
        }
    }
}
