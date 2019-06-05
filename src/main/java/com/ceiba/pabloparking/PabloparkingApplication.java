package com.ceiba.pabloparking;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ceiba.pabloparking.aplicacion.builder.ParqueaderoBuilder;
import com.ceiba.pabloparking.dominio.EstadoVehiculo;
import com.ceiba.pabloparking.dominio.Parqueadero;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.infraestructura.persistencia.dao.ParqueaderoDao;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.ParqueaderoEntidad;

@SpringBootApplication
public class PabloparkingApplication {
	
	private static final Logger log = LoggerFactory.getLogger(PabloparkingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PabloparkingApplication.class, args);
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
	public CommandLineRunner demoParqueadero(ParqueaderoDao parqueaderoDao) {
		return (args) -> {
			// save a couple of customers
			parqueaderoDao.save(ParqueaderoBuilder.convertirAEntity(new Parqueadero(TipoVehiculo.CARRO.getIdTipoVehiculo(), "MSP777", 200, null, null, 5000d, EstadoVehiculo.RETIRADO_PARQUEADERO.getIdEstado(), 1l)));
			//parqueaderoDao.save(ParqueaderoBuilder.convertirAEntity(new Parqueadero(TipoVehiculo.MOTO.getIdTipoVehiculo(), "MSP888", null, (new DateTime()), (new DateTime()), 5000d, EstadoVehiculo.RETIRADO_PARQUEADERO.getIdEstado(), 1l)));
			
			// fetch all customers
			log.info("Motos found with findAll():");
			log.info("-------------------------------");
			for (ParqueaderoEntidad parqueaderoEntidad : parqueaderoDao.findAll()) {
				log.info(parqueaderoEntidad.getPlaca());
			}
		};
	}
}
