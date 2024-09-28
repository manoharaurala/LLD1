package ParkingLot.models;

import ParkingLot.models.enums.ParkingSpotStatus;
import ParkingLot.models.enums.VehicleType;

import java.util.List;

public class ParkingSpot extends BaseModel{
    private long spotNumber;
    private ParkingFloor parkingFloor;
    private ParkingSpotStatus parkingSpotStatus;

    public long getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(long spotNumber) {
        this.spotNumber = spotNumber;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    private List<VehicleType> supportedVehicleTypes;

}
