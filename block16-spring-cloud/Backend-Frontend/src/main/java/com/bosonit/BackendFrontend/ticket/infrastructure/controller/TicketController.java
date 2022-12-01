package com.bosonit.BackendFrontend.ticket.infrastructure.controller;

import com.bosonit.BackendFrontend.ticket.application.TicketServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    TicketServiceImp ticketServiceImp;

    @PostMapping("ticket/{idTravel}/{idPassenger}")
    public Object getClient(@PathVariable Long idTravel,@PathVariable Long idPassenger){
      return   ticketServiceImp.genTicket(idTravel,idPassenger);
    }
}
