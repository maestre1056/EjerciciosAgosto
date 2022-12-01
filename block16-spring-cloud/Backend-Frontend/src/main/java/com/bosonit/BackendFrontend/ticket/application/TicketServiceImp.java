package com.bosonit.BackendFrontend.ticket.application;

import com.bosonit.BackendFrontend.client.domain.Client;
import com.bosonit.BackendFrontend.client.feing.ClientService;
import com.bosonit.BackendFrontend.client.infrastrucutre.ClientOutputDto;
import com.bosonit.BackendFrontend.ticket.domain.Ticket;
import com.bosonit.BackendFrontend.ticket.infrastructure.controller.dto.TicketOutputDto;
import com.bosonit.BackendFrontend.ticket.infrastructure.repository.TicketRepository;
import com.bosonit.BackendFrontend.trip.domain.Travel;
import com.bosonit.BackendFrontend.trip.feing.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImp {

    @Autowired
    private final ClientService clientService;

    @Autowired
    private final TripService tripService;

    @Autowired
    private TicketRepository ticketRepository;

    public Object genTicket(Long idTravel, Long idPassenger){
        Client client =new Client(clientService.getById(idPassenger));

        Travel travel = new Travel(tripService.getById(idTravel));

        tripService.addPassenger(idTravel,idPassenger);

        Ticket ticket = new Ticket(client,travel);
        return new TicketOutputDto(ticketRepository.save(ticket));
    }

    public List<TicketOutputDto> getAll(){
        return ticketRepository.findAll().stream().map(TicketOutputDto::new).toList();
    }
}
