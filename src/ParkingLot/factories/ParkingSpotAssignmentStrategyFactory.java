package ParkingLot.factories;

import ParkingLot.models.enums.ParkingSpotStrategyType;
import ParkingLot.strategies.NearestSpotAssignmentStrategy;
import ParkingLot.strategies.ParkingSpotAssignmentStrategy;

public class ParkingSpotAssignmentStrategyFactory {
    public static ParkingSpotAssignmentStrategy getParkingLotStrategy(ParkingSpotStrategyType parkingSpotStrategyType){
        if (parkingSpotStrategyType.equals(ParkingSpotStrategyType.NEAREST)) {
            return new NearestSpotAssignmentStrategy();
        }
        return null;
    }
}
