package ParkingLot.strategies;

import ParkingLot.models.ParkingLot;
import ParkingLot.models.ParkingSpot;
import ParkingLot.models.Vehicle;

public interface ParkingSpotAssignmentStrategy {
    ParkingSpot assignParkingSpot(ParkingLot parkingLot, Vehicle vehicle);
}
