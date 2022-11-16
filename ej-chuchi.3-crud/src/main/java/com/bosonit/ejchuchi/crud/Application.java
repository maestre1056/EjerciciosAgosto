package com.bosonit.ejchuchi.crud;

import com.bosonit.ejchuchi.crud.cabecera.domain.Cabecera;
import com.bosonit.ejchuchi.crud.cabecera.infraestructure.controller.CabeceraRepository;
import com.bosonit.ejchuchi.crud.cliente.domain.Cliente;
import com.bosonit.ejchuchi.crud.cliente.infraestructure.repository.ClienteRepository;
import com.bosonit.ejchuchi.crud.lineas.domain.Lineas;
import com.bosonit.ejchuchi.crud.lineas.infraestructure.repository.LineasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Autowired
	CabeceraRepository cabeceraRepository;

	@Autowired
	LineasRepository lineasRepository;

	@Autowired
	ClienteRepository clienteRepository;
	@Override
	public void run(String... args) throws Exception {
		Cliente cliente = new Cliente();
		cliente.setNombre("Antonio");
		clienteRepository.save(cliente);

		Cabecera cabecera = new Cabecera();
		cabecera.setImporte(10.5);
		cabecera.setCliente(cliente);

		List<Lineas> lineasList = new ArrayList<>();

		Lineas lineas = new Lineas();
		lineas.setProNombre("manetcas");
		lineas.setCantidad(15.4);
		lineas.setPrecio(105.7);

		Lineas lineas1 = new Lineas();
		lineas1.setProNombre("hijoputer");
		lineas1.setCantidad(15.4);
		lineas1.setPrecio(105.7);

		lineasList.add(lineas);
		lineasList.add(lineas1);

		cabecera.setLineas(lineasList);
		cabeceraRepository.save(cabecera);
	}
}
