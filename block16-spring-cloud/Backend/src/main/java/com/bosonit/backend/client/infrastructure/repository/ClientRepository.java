package com.bosonit.backend.client.infrastructure.repository;

import com.bosonit.backend.client.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}