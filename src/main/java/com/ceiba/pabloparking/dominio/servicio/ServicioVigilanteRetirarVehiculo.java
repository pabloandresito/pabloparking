package com.ceiba.pabloparking.dominio.servicio;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.pabloparking.dominio.EstadoVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.repositorio.RepositorioRegistroParqueo;

@Service
public class ServicioVigilanteRetirarVehiculo {
	
	@Autowired
	private RepositorioRegistroParqueo repositorioRegistroParqueo;
	
	public void ejecutar(Long id, LocalDateTime fechaHoraSalida) {
		// Obtenemos el objeto de domio a actualizar
		RegistroParqueo registroParqueoUpdate = repositorioRegistroParqueo.getById(id); // TODO probles - Validar si el vehiculo ya esta retirado
		
		registroParqueoUpdate.setFechaHoraSalida(fechaHoraSalida); // TODO probles - Pendiente de validar fechaHoraSalida valida
		registroParqueoUpdate.setValorParqueo(500d); // TODO probles - Pendiente de calcular el valor a cobrar
		registroParqueoUpdate.setEstadoInOut(EstadoVehiculo.RETIRADO_PARQUEADERO.getIdEstado());
		
		repositorioRegistroParqueo.actualizar(registroParqueoUpdate);
    }
}