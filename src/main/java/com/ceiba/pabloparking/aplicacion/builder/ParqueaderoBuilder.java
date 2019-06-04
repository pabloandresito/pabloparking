package com.ceiba.pabloparking.aplicacion.builder;

import com.ceiba.pabloparking.dominio.Parqueadero;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.ParqueaderoEntidad;

public class ParqueaderoBuilder {

	public static Parqueadero convertirADominio(ParqueaderoEntidad parqueaderoEntidad) {
		
		Parqueadero parqueadero = null;
		
		if(parqueaderoEntidad != null) {
			parqueadero = new Parqueadero(parqueaderoEntidad.getTipoVehiculo(), parqueaderoEntidad.getPlaca(), parqueaderoEntidad.getCilindraje(), 
											parqueaderoEntidad.getFechaHoraIngreso(), parqueaderoEntidad.getFechaHoraSalida(), parqueaderoEntidad.getValorParqueo(), 
											parqueaderoEntidad.getEstadoInOut(), parqueaderoEntidad.getIdVigilante());
		}
		
		return parqueadero;
	}
	
	public static ParqueaderoEntidad convertirAEntity(Parqueadero parqueadero) {
		
		ParqueaderoEntidad parqueaderoEntidad = new ParqueaderoEntidad();
		
		parqueaderoEntidad.setTipoVehiculo(parqueadero.getTipoVehiculo());
		parqueaderoEntidad.setPlaca(parqueadero.getPlaca());
		parqueaderoEntidad.setCilindraje(parqueadero.getCilindraje());
		parqueaderoEntidad.setFechaHoraIngreso(parqueadero.getFechaHoraIngreso());
		parqueaderoEntidad.setFechaHoraSalida(parqueadero.getFechaHoraSalida()); 
		parqueaderoEntidad.setValorParqueo(parqueadero.getValorParqueo()); 
		parqueaderoEntidad.setEstadoInOut(parqueadero.getEstadoInOut());
		parqueaderoEntidad.setIdVigilante(parqueadero.getIdVigilante());
		
		return parqueaderoEntidad;
	}

}
