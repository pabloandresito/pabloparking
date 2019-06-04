package com.ceiba.pabloparking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ceiba.pabloparking.aplicacion.builder.MotoBuilder;
import com.ceiba.pabloparking.dominio.Moto;
import com.ceiba.pabloparking.infraestructura.persistencia.dao.MotoDao;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.MotoEntidad;

@SpringBootApplication
public class PabloparkingApplication {
	
	private static final Logger log = LoggerFactory.getLogger(PabloparkingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PabloparkingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(MotoDao motoDao) {
		return (args) -> {
			// save a couple of customers
			motoDao.save(MotoBuilder.convertirAEntity(new Moto("MSP555", 300)));
			motoDao.save(MotoBuilder.convertirAEntity(new Moto("MSP666", 200)));
			motoDao.save(MotoBuilder.convertirAEntity(new Moto("MSP777", 100)));
			
			// fetch all customers
			log.info("Motos found with findAll():");
			log.info("-------------------------------");
			for (MotoEntidad motoEntidad : motoDao.findAll()) {
				log.info(motoEntidad.getPlaca());
			}
			log.info("");

			// fetch an individual customer by ID
			MotoEntidad motoEntidadConsulta = motoDao.findByPlaca("MSP707");
			
			if(motoEntidadConsulta != null) {
				log.info("Moto found with findByPlaca:");
				log.info("--------------------------------");
				log.info(motoEntidadConsulta.getPlaca());
				log.info("");
			} else {
				log.info("Moto not found with findByPlaca");
			}			
		};
	}
}
