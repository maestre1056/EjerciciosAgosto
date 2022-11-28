package com.bosonit.backend.travel.infrastructure.repository;

import com.bosonit.backend.travel.domain.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepository extends JpaRepository<Travel, Long> {
}