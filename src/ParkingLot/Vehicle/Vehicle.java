package ParkingLot.Vehicle;

public abstract class Vehicle {
    protected String licensePlate;
    protected VechileType vechileType;

    public Vehicle(String licensePlate, VechileType vechileType) {
        this.licensePlate = licensePlate;
        this.vechileType = vechileType;
    }
    public VechileType getVechileType() {
        return vechileType;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
}
