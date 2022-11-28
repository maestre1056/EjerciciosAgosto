package com.bosonit.backend.travel.infrastructure.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TravelInputDto {
    private String origin;
    private String destination;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private boolean status;

    public boolean getStatus() {
        return false;
    }
}
