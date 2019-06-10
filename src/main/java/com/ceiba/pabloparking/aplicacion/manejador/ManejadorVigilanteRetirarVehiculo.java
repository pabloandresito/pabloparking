package com.ceiba.pabloparking.aplicacion.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.pabloparking.dominio.servicio.ServicioVigilanteRetirarVehiculo;
import com.ceiba.pabloparking.infraestructura.controller.dto.RegistroParqueoDto;

@Component
public class ManejadorVigilanteRetirarVehiculo {
	
	@Autowired
	private ServicioVigilanteRetirarVehiculo servicioVigilanteRetirarVehiculo;

	public void ejecutar(RegistroParqueoDto registroParqueoDto) {
		servicioVigilanteRetirarVehiculo.ejecutar(registroParqueoDto.getId(), registroParqueoDto.getFechaHoraSalida());
	}	
}
