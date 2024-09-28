package ParkingLot.repositories;

import ParkingLot.models.Vehicle;

import java.util.HashMap;
import java.util.Optional;

public class VehicleRepository {
    //Output Vehicle object will have id present.
    public Vehicle save(Vehicle vehicle) {
        return vehicle;
    }

    public Optional<Vehicle> findByVehicleId(Long id) {
        return Optional.empty();
    }

    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) {
        return Optional.empty();
    }
}
