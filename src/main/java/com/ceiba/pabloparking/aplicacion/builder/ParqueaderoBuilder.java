package com.ceiba.pabloparking.aplicacion.builder;

import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.RegistroParqueoEntidad;

public class ParqueaderoBuilder {

	public static RegistroParqueo convertirADominio(RegistroParqueoEntidad parqueaderoEntidad) {
		
		RegistroParqueo registroParqueo = null;
		
		if(parqueaderoEntidad != null) {
			registroParqueo = new RegistroParqueo(parqueaderoEntidad.getId(),
												parqueaderoEntidad.getTipoVehiculo(), 
												parqueaderoEntidad.getPlaca(), 
												parqueaderoEntidad.getCilindraje(), 
												parqueaderoEntidad.getFechaHoraIngreso());
		}
		
		return registroParqueo;
	}
	
	public static RegistroParqueoEntidad convertirAEntity(RegistroParqueo registroParqueo) {
		
		RegistroParqueoEntidad registroParqueoEntidad = new RegistroParqueoEntidad();
		
		registroParqueoEntidad.setId(registroParqueo.getId());
		registroParqueoEntidad.setTipoVehiculo(registroParqueo.getTipoVehiculo());
		registroParqueoEntidad.setPlaca(registroParqueo.getPlaca());
		registroParqueoEntidad.setCilindraje(registroParqueo.getCilindraje());
		registroParqueoEntidad.setFechaHoraIngreso(registroParqueo.getFechaHoraIngreso());
		registroParqueoEntidad.setFechaHoraSalida(registroParqueo.getFechaHoraSalida()); 
		registroParqueoEntidad.setValorParqueo(registroParqueo.getValorParqueo()); 
		registroParqueoEntidad.setEstadoInOut(registroParqueo.getEstadoInOut());
		
		return registroParqueoEntidad;
	}

}
