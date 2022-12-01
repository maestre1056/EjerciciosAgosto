package com.bosonit.BackendFrontend.ticket.domain;

import com.bosonit.BackendFrontend.client.domain.Client;
import com.bosonit.BackendFrontend.trip.domain.Travel;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idTicket;

    private Long passengerId;
    private String passengerName;
    private String passengerLastName;
    @Column(unique = true)
    private String passengerEmail;
    private String tripOrigin;
    private String tripDestination;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;


    public Ticket (Client client, Travel travel){
        setPassengerId(client.getIdClient());
        setPassengerName(client.getName());
        setPassengerLastName(client.getLastName());
        setPassengerEmail(client.getEmail());
        setTripOrigin(travel.getOrigin());
        setTripDestination(travel.getDestination());
        setDepartureDate(travel.getDepartureDate());
        setArrivalDate(travel.getArrivalDate());
    }



    public Long getId() {
        return idTicket;
    }

    public void setId(Long id) {
        this.idTicket = id;
    }
}
