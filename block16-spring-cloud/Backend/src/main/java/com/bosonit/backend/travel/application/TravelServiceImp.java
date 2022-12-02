package com.bosonit.backend.travel.application;

import com.bosonit.backend.client.domain.Client;
import com.bosonit.backend.client.infrastructure.repository.ClientRepository;
import com.bosonit.backend.exception.EntityNotFoundException;
import com.bosonit.backend.travel.domain.Travel;
import com.bosonit.backend.travel.infrastructure.dto.TravelInputDto;
import com.bosonit.backend.travel.infrastructure.dto.TravelOutputDto;
import com.bosonit.backend.travel.infrastructure.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelServiceImp implements TravelService{
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TravelRepository travelRepository;

    @Override
    public TravelOutputDto createTravel(TravelInputDto travelInputDto) {
        Travel travel = new Travel(travelInputDto);
        travelRepository.save(travel);
        return new TravelOutputDto(travel);
    }

    @Override
    public TravelOutputDto updateTravel(Long id, TravelInputDto travelInputDto) {
        Optional<Travel> travelOpt= travelRepository.findById(id);
        if(travelOpt.isEmpty())
            throw new EntityNotFoundException("Travel does not exist",404);
        Travel travel = travelOpt.get();
        travel.setOrigin(travelInputDto.getOrigin());
        travel.setDestination(travelInputDto.getDestination());
        travel.setDepartureDate(travelInputDto.getDepartureDate());
        travel.setArrivalDate(travelInputDto.getArrivalDate());
        travel.setStatus(travelInputDto.getStatus());

        travelRepository.save(travel);

        return new TravelOutputDto(travel);
    }

    @Override
    public TravelOutputDto findById(Long id) {
        Optional<Travel> travelOpt= travelRepository.findById(id);
        if (travelOpt.isEmpty())
            throw  new  EntityNotFoundException("Travel does not exist",404);

        return new TravelOutputDto(travelOpt.get());
    }

    @Override
    public String deleteTravel(Long id) {
        Optional<Travel> travelOpt= travelRepository.findById(id);
        if (travelOpt.isEmpty())
            throw  new  EntityNotFoundException("Travel does not exist",404);
        travelRepository.deleteById(id);

        return "Viaje borrado";
    }

    @Override
    public TravelOutputDto addPassenger(Long travelId, Long passengerId) throws Exception {
        Travel travel = travelRepository.findById(travelId).orElseThrow(()->new EntityNotFoundException("Travel does not exist",404));
        Client client = clientRepository.findById(passengerId).orElseThrow(()->new EntityNotFoundException("Passenger does not exist",404));


        if(travel.getPassenger().contains(client))
            throw new Exception("The passenger is already in travel");
        if(travel.getPassenger().size()>40)
            throw new Exception("There are too many people in this travel. It´s full");
        if(!travel.getStatus())
           throw new Exception("The selected trip is not available");
        client.setTravel(travel);
        clientRepository.save(client);
        travel.getPassenger().add(client);

        return new TravelOutputDto(travel);
    }

    @Override
    public Integer getTotalPassenger(Long travel) {
        return travelRepository.findById(travel).orElseThrow(()->new EntityNotFoundException("Travel does not exist",404))
                .getPassenger().size();
    }

    @Override
    public TravelOutputDto changeTravelStatus(Long travelId, Boolean newStatus) {
        Travel travel = travelRepository.findById(travelId).orElseThrow(()->new EntityNotFoundException("Travel does not exist",404));
        travel.setStatus(newStatus);
        travelRepository.save(travel);

        return new TravelOutputDto(travel);
    }

    @Override
    public Boolean getTravelStatus(Long travelId) {

        return travelRepository.findById(travelId).orElseThrow(()->new  EntityNotFoundException("Travel does not exist",404))
                .getStatus();
    }
}
