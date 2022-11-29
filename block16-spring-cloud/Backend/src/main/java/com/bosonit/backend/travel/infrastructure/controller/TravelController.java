package com.bosonit.backend.travel.infrastructure.controller;

import com.bosonit.backend.travel.application.TravelService;
import com.bosonit.backend.travel.infrastructure.dto.TravelInputDto;
import com.bosonit.backend.travel.infrastructure.dto.TravelOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class TravelController {
    @Autowired
    TravelService travelService;

    @PostMapping
    public TravelOutputDto addTravel(@RequestBody TravelInputDto travelInputDto){
        return  travelService.createTravel(travelInputDto);
    }

    @PutMapping("/passenger/{travelId}/{passengerId}")
    public TravelOutputDto addPassenger(@PathVariable Long travelId, @PathVariable Long passengerId) throws Exception {
        return travelService.addPassenger(travelId,passengerId);
    }
    @PutMapping("{id}/{status}")
    public TravelOutputDto changeStatus(@PathVariable Long id, @PathVariable boolean status){
        return travelService.changeTravelStatus(id,status);
    }

    @PutMapping("{id}")
    public TravelOutputDto updateTrip(@PathVariable Long id,@RequestBody TravelInputDto travelInputDto){
        return travelService.updateTravel(id, travelInputDto);
    }

    @GetMapping("{id}")
    public TravelOutputDto getById(@PathVariable Long id){
        return travelService.findById(id);
    }

    @GetMapping("passenger/count/{id}")
    public int getTotalPassenger(@PathVariable Long id){
        return travelService.getTotalPassenger(id);
    }



}
