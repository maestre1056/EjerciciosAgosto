package com.bosonit.ejchuchi.crud.lineas.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lineas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id_lineas;
    public String proNombre;
    public Double cantidad;
    public Double precio;

    public Lineas(String proNombre, Double cantidad, Double precio) {
        this.proNombre = proNombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
}
