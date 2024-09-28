package ParkingLot.services;

import ParkingLot.exceptions.GateNotFoundException;
import ParkingLot.models.*;
import ParkingLot.repositories.GateRepository;
import ParkingLot.repositories.VehicleRepository;
import ParkingLot.strategies.ParkingSpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private final GateRepository gateRepository;
    private final VehicleRepository vehicleRepository;
    private final ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy) {
        this.gateRepository = gateRepository;
        this.vehicleRepository=vehicleRepository;
        this.parkingSpotAssignmentStrategy=parkingSpotAssignmentStrategy;
    }

    public Ticket issueTicket(String vehicleNumber,
                              String ownerName,
                              long gateId,
                              long operatorId) throws GateNotFoundException {
        Ticket ticket=new Ticket();
        Optional<Gate> gateOptional=gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()){
            throw new GateNotFoundException("Invalid Gate id provided");
        }
        Gate gate= gateOptional.get();
        ticket.setEntryTime(new Date());
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        Optional<Vehicle> vehicleOptional=vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle vehicle=null;
        if(vehicleOptional.isEmpty()){
            //Vehicle is not present in the DB.
            //Create a new Vehicle and save in the DB.
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            vehicle = vehicleRepository.save(vehicle);
        }
        else {
            vehicle=vehicleOptional.get();
        }
        ticket.setVehicle(vehicle);
        ParkingLot parkingLot=gate.getParkingLot();
        ticket.setParkingSpot(parkingSpotAssignmentStrategy.assignParkingSpot(parkingLot,vehicle));

        return ticket;
    }
}
