package com.bosonit.backend.travel.application;

import com.bosonit.backend.travel.infrastructure.dto.TravelInputDto;
import com.bosonit.backend.travel.infrastructure.dto.TravelOutputDto;

public interface TravelService {
    public TravelOutputDto createTravel(TravelInputDto travelInputDto);
    public TravelOutputDto updateTravel(Long id, TravelInputDto travelInputDto);
    public TravelOutputDto findById(Long id);
    public String deleteTravel(Long id);
    public TravelOutputDto addPassenger(Long travelId, Long passengerId) throws Exception;
    public Integer getTotalPassenger(Long travel);
    public TravelOutputDto changeTravelStatus(Long travelId, Boolean newStatus);
    public Boolean getTravelStatus(Long travelId);
}
