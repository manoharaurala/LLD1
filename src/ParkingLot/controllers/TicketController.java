package ParkingLot.controllers;

import ParkingLot.dtos.DeleteTicketRequestDTO;
import ParkingLot.dtos.DeleteTicketResponseDTO;
import ParkingLot.dtos.IssueTicketRequestDTO;
import ParkingLot.dtos.IssueTicketResponseDTO;
import ParkingLot.models.Gate;
import ParkingLot.models.Ticket;
import ParkingLot.models.enums.ResponseStatus;
import ParkingLot.models.enums.VehicleType;
import ParkingLot.services.TicketService;

public class TicketController {
    private final TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO issueTicketRequestDTO){
        IssueTicketResponseDTO issueTicketResponseDTO=new IssueTicketResponseDTO();
        try {
            Ticket ticket = ticketService.issueTicket(issueTicketRequestDTO.getVehicleNumber(),
                    issueTicketRequestDTO.getOwnerName(),
                    issueTicketRequestDTO.getGateId(),
                    issueTicketRequestDTO.getOperatorId());
            issueTicketResponseDTO.setTicket(ticket);
            issueTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e){
            issueTicketResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }

        return issueTicketResponseDTO;

    }

    public DeleteTicketResponseDTO deleteTicket(DeleteTicketRequestDTO deleteTicketRequestDTO){
        return null;
    }
}
