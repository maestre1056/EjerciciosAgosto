package com.bosonit.BackendFrontend.trip.feing;

import com.bosonit.BackendFrontend.trip.infrastructure.TravelOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "trip-frontend",url = "http://localhost:8080")
public interface TripService {

    @GetMapping("trip/{id}")
    public TravelOutputDto getById(@PathVariable Long id);

    @PutMapping("trip/passenger/{idTravel}/{idPassenger}")
    public TravelOutputDto addPassenger(@PathVariable Long idTravel , @PathVariable Long idPassenger );
}
