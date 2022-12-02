package com.bosonit.backend.travel.domain;

import com.bosonit.backend.client.domain.Client;
import com.bosonit.backend.travel.infrastructure.dto.TravelInputDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_travel", nullable = false)
    private Long idTravel;

    private String origin;

    private String destination;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    @OneToMany(mappedBy = "travel")
    private List<Client> passenger=new ArrayList<>();
    @Column(columnDefinition = "boolean default false")
    private boolean status;



    public Travel(TravelInputDto travelInputDto){
        setOrigin(travelInputDto.getOrigin());
        setDestination(travelInputDto.getDestination());
        setDepartureDate(travelInputDto.getDepartureDate());
        setArrivalDate(travelInputDto.getArrivalDate());
        setStatus(travelInputDto.getStatus());
    }


    public Long getIdTravel() {
        return idTravel;
    }

    public void setIdTravel(Long idTravel) {
        this.idTravel = idTravel;
    }

    public boolean getStatus(){
        return this.status;
    }
}
