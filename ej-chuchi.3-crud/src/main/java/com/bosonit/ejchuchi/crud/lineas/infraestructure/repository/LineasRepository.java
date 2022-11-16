package com.bosonit.ejchuchi.crud.lineas.infraestructure.repository;

import com.bosonit.ejchuchi.crud.lineas.domain.Lineas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineasRepository extends JpaRepository<Lineas,Integer> {
}
