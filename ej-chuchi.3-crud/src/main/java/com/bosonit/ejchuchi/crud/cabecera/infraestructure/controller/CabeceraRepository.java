package com.bosonit.ejchuchi.crud.cabecera.infraestructure.controller;

import com.bosonit.ejchuchi.crud.cabecera.domain.Cabecera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabeceraRepository extends JpaRepository<Cabecera,Integer> {
}
