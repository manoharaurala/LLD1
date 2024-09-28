package ParkingLot;

import ParkingLot.controllers.TicketController;
import ParkingLot.dtos.IssueTicketRequestDTO;
import ParkingLot.dtos.IssueTicketResponseDTO;
import ParkingLot.factories.ParkingSpotAssignmentStrategyFactory;
import ParkingLot.models.Ticket;
import ParkingLot.models.enums.ParkingSpotStrategyType;
import ParkingLot.repositories.GateRepository;
import ParkingLot.repositories.VehicleRepository;
import ParkingLot.services.TicketService;
import ParkingLot.strategies.ParkingSpotAssignmentStrategy;

public class ParkingLotApplication {
    public static void main(String[] args) {
        GateRepository gateRepository=new GateRepository();
        VehicleRepository vehicleRepository=new VehicleRepository();
        ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy= ParkingSpotAssignmentStrategyFactory
                .getParkingLotStrategy(ParkingSpotStrategyType.NEAREST);
        TicketService ticketService=new TicketService(gateRepository,vehicleRepository,parkingSpotAssignmentStrategy);
        TicketController ticketController=new TicketController(ticketService);

        IssueTicketRequestDTO requestDto=new IssueTicketRequestDTO();
        requestDto.setGateId(123L);
        requestDto.setOperatorId(345L);
        requestDto.setOwnerName("Shivam");
        requestDto.setVehicleNumber("KA01X1111");

        IssueTicketResponseDTO responseDTO=ticketController.issueTicket(requestDto);
        Ticket ticket = responseDTO.getTicket();
        System.out.println(ticket);


    }
}
