package ParkingLot.strategies;

import ParkingLot.models.ParkingLot;
import ParkingLot.models.ParkingSpot;
import ParkingLot.models.Vehicle;

public class NearestSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy{

    @Override
    public ParkingSpot assignParkingSpot(ParkingLot parkingLot, Vehicle vehicle) {
        return new ParkingSpot();
    }
}
