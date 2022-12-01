package com.bosonit.BackendFrontend.trip.infrastructure;

import com.bosonit.BackendFrontend.trip.domain.Travel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TravelOutputDto {
    private Long idTravel;
    private String origin;
    private String destination;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private Boolean status;



}
