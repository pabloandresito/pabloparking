package com.ceiba.pabloparking.aplicacion.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.servicio.ServicioVigilanteRetirarVehiculo;
import com.ceiba.pabloparking.infraestructura.controller.dto.RegistroParqueoDto;

@Component
public class ManejadorVigilanteRetirarVehiculo {
	
	@Autowired
	private ServicioVigilanteRetirarVehiculo servicioVigilanteRetirarVehiculo;

	public String ejecutar(RegistroParqueoDto registroParqueoDto) {
		return servicioVigilanteRetirarVehiculo.ejecutar(registroParqueoDto.getId(), registroParqueoDto.getFechaHoraSalida());
	}
	
	public List<RegistroParqueo> consultarVehiculosRetirados() {
		return servicioVigilanteRetirarVehiculo.consultarVehiculosRetirados();
	}
}
