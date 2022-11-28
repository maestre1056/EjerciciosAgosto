package com.bosonit.backend.travel.infrastructure.dto;

import com.bosonit.backend.client.infrastructure.dto.ClientOutputDto;
import com.bosonit.backend.travel.domain.Travel;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TravelOutputDto {
    Long idTravel;
    String origin;
    String destination;
    LocalDateTime departureDate;
    LocalDateTime arrivalDate;
    Boolean status;
    List<ClientOutputDto> passengers;

    public TravelOutputDto(Travel travel){
        setIdTravel(travel.getIdTravel());
        setOrigin(travel.getOrigin());
        setDestination(travel.getDestination());
        setDepartureDate(travel.getDepartureDate());
        setArrivalDate(travel.getArrivalDate());
        setStatus(travel.getStatus());
        setPassengers(travel.getPassenger().stream().map(ClientOutputDto::new).toList());
    }
}
