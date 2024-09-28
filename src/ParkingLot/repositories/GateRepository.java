package ParkingLot.repositories;

import ParkingLot.models.Gate;

import java.util.HashMap;
import java.util.Optional;

public class GateRepository {
    //Gate Table
    private HashMap<Long,Gate> gates=new HashMap<>();

    //CRUD Operations

    public Optional<Gate> findGateById(long gateId){
        return Optional.of(gates.get(gateId));
    }




}
