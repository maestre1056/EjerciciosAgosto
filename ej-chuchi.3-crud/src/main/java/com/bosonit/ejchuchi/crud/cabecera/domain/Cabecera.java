package com.bosonit.ejchuchi.crud.cabecera.domain;

import com.bosonit.ejchuchi.crud.cliente.domain.Cliente;
import com.bosonit.ejchuchi.crud.lineas.domain.Lineas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cabecera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id_cabecera;
    Double importe;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "LINEAS_FRA")
    List<Lineas> lineas;

    public Cabecera(Double importe, Cliente cliente) {
        this.importe = importe;
        this.cliente = cliente;
    }
}
