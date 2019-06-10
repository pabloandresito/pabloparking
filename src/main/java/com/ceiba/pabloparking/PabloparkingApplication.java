package com.ceiba.pabloparking;

import java.time.LocalDateTime;
import java.time.Month;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ceiba.pabloparking.aplicacion.fabrica.FabricaRegistroParqueo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.infraestructura.persistencia.dao.ConexionDBRegistroParqueo;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.RegistroParqueoEntidad;

@SpringBootApplication
public class PabloparkingApplication {
	
	private static final Logger log = LoggerFactory.getLogger(PabloparkingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PabloparkingApplication.class, args); // TODO probles - Pendiente de cuadrar archivo de sonar
	}
	
//	@Bean
//	public CommandLineRunner demo(MotoDao motoDao) {
//		return (args) -> {
//			// save a couple of customers
//			motoDao.save(MotoBuilder.convertirAEntity(new Moto("MSP555", 300)));
//			motoDao.save(MotoBuilder.convertirAEntity(new Moto("MSP666", 200)));
//			motoDao.save(MotoBuilder.convertirAEntity(new Moto("MSP777", 100)));
//			
//			// fetch all customers
//			log.info("Motos found with findAll():");
//			log.info("-------------------------------");
//			for (MotoEntidad motoEntidad : motoDao.findAll()) {
//				log.info(motoEntidad.getPlaca());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			MotoEntidad motoEntidadConsulta = motoDao.findByPlaca("MSP707");
//			
//			if(motoEntidadConsulta != null) {
//				log.info("Moto found with findByPlaca:");
//				log.info("--------------------------------");
//				log.info(motoEntidadConsulta.getPlaca());
//				log.info("");
//			} else {
//				log.info("Moto not found with findByPlaca");
//			}			
//		};
//	}
	
	@Bean
	public CommandLineRunner demoParqueadero(ConexionDBRegistroParqueo conexionDBRegistroParqueo, FabricaRegistroParqueo fabricaRegistroParqueo) {
		return (args) -> {
			// save a couple of customers
			LocalDateTime fechaHoraIngreso = LocalDateTime.of(2019, Month.MAY, 4, 11, 23, 1);
			conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(new RegistroParqueo(TipoVehiculo.CARRO.getIdTipoVehiculo(), "CSP777", null, fechaHoraIngreso)));
			
			fechaHoraIngreso = LocalDateTime.of(2019, Month.JUNE, 12, 4, 34, 15);
			conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(new RegistroParqueo(TipoVehiculo.MOTO.getIdTipoVehiculo(), "MSQ999", 600, fechaHoraIngreso)));
			
			fechaHoraIngreso = LocalDateTime.of(2019, Month.JUNE, 13, 2, 3, 45);
			conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(new RegistroParqueo(TipoVehiculo.MOTO.getIdTipoVehiculo(), "MSQ111", 650, fechaHoraIngreso)));
			
			// fetch all customers
			log.info("Motos found with findAll():");
			log.info("-------------------------------");
			for (RegistroParqueoEntidad parqueaderoEntidad : conexionDBRegistroParqueo.findAll()) {
				log.info(parqueaderoEntidad.getPlaca());
			}
		};
	}
}
