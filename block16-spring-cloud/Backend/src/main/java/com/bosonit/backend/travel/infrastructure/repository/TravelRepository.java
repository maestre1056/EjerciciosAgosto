package com.bosonit.backend.travel.infrastructure.repository;

import com.bosonit.backend.travel.domain.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
}