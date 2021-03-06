package com.ceiba.pabloparking;

import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ceiba.pabloparking.aplicacion.fabrica.FabricaRegistroParqueo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.infraestructura.persistencia.dao.ConexionDBRegistroParqueo;

@SpringBootApplication
public class PabloparkingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PabloparkingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demoParqueadero(ConexionDBRegistroParqueo conexionDBRegistroParqueo, FabricaRegistroParqueo fabricaRegistroParqueo) {
		return args -> {
			// save a couple of cars
			LocalDateTime fechaHoraIngreso = LocalDateTime.of(2019, Month.MAY, 4, 11, 23, 1);
			conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(new RegistroParqueo(null, TipoVehiculo.CARRO.getIdTipoVehiculo(), "CSP777", null, fechaHoraIngreso)));
			
			fechaHoraIngreso = LocalDateTime.of(2019, Month.JUNE, 10, 9, 0, 1);
			conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(new RegistroParqueo(null, TipoVehiculo.CARRO.getIdTipoVehiculo(), "CSP888", null, fechaHoraIngreso)));
			
			fechaHoraIngreso = LocalDateTime.of(2019, Month.JUNE, 10, 11, 0, 1);
			conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(new RegistroParqueo(null, TipoVehiculo.CARRO.getIdTipoVehiculo(), "CSP999", null, fechaHoraIngreso)));
			
			fechaHoraIngreso = LocalDateTime.of(2019, Month.JUNE, 10, 10, 45, 1);
			conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(new RegistroParqueo(null, TipoVehiculo.CARRO.getIdTipoVehiculo(), "CSP666", null, fechaHoraIngreso)));
			
			fechaHoraIngreso = LocalDateTime.of(2019, Month.JUNE, 10, 10, 50, 1);
			conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(new RegistroParqueo(null, TipoVehiculo.CARRO.getIdTipoVehiculo(), "CSP555", null, fechaHoraIngreso)));
			
			fechaHoraIngreso = LocalDateTime.of(2019, Month.JUNE, 12, 13, 4, 5);
			conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(new RegistroParqueo(null, TipoVehiculo.CARRO.getIdTipoVehiculo(), "CGG454", null, fechaHoraIngreso)));
			
			// save a couple of Bikes
			fechaHoraIngreso = LocalDateTime.of(2019, Month.JUNE, 11, 4, 34, 15);
			conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(new RegistroParqueo(null, TipoVehiculo.MOTO.getIdTipoVehiculo(), "MSQ999", 600, fechaHoraIngreso)));
			
			fechaHoraIngreso = LocalDateTime.of(2019, Month.JUNE, 1, 2, 3, 45);
			conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(new RegistroParqueo(null, TipoVehiculo.MOTO.getIdTipoVehiculo(), "MSQ111", 650, fechaHoraIngreso)));
			
			// fetch all cars and bike
			conexionDBRegistroParqueo.findAll();
		};
	}
}
