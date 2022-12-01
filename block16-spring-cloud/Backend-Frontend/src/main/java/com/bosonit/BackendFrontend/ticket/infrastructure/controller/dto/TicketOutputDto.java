package com.bosonit.BackendFrontend.ticket.infrastructure.controller.dto;

import com.bosonit.BackendFrontend.ticket.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketOutputDto {
    private Long idTicket;

    private Long idPassenger;

    private String passengerName;

    private String passengerSurname;

    private String passengerEmail;

    private String originTrip;

    private String destinationTrip;

    private LocalDateTime departureDate;

    private LocalDateTime arrivalDate;

    public TicketOutputDto(Ticket ticket){
        setIdTicket(ticket.getIdTicket());
        setIdPassenger(ticket.getPassengerId());
        setPassengerName(ticket.getPassengerName());
        setPassengerSurname(ticket.getPassengerSurname());
        setPassengerEmail(ticket.getPassengerEmail());
        setOriginTrip(ticket.getTripOrigin());
        setDestinationTrip(ticket.getTripDestination());
        setDepartureDate(ticket.getDepartureDate());
        setArrivalDate(ticket.getArrivalDate());
    }
}
