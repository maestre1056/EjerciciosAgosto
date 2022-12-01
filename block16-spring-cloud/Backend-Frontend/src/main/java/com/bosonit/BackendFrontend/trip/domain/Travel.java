package com.bosonit.BackendFrontend.trip.domain;

import com.bosonit.BackendFrontend.trip.infrastructure.TravelOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Travel {

    private Long idTravel;

    private String origin;

    private String destination;

    private LocalDateTime departureDate;

    private LocalDateTime arrivalDate;

    private Boolean status;


    public Travel(TravelOutputDto travelOutputDto) {
        setIdTravel(travelOutputDto.getIdTravel());
        setOrigin(travelOutputDto.getOrigin());
        setDestination(travelOutputDto.getDestination());
        setDepartureDate(travelOutputDto.getDepartureDate());
        setArrivalDate(travelOutputDto.getArrivalDate());
        setStatus(travelOutputDto.getStatus());
    }


}