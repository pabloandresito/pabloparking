package com.ceiba.pabloparking.aplicacion.builder;

import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.ParqueaderoEntidad;

public class ParqueaderoBuilder {

	public static RegistroParqueo convertirADominio(ParqueaderoEntidad parqueaderoEntidad) {
		
		RegistroParqueo parqueadero = null;
		
		if(parqueaderoEntidad != null) {
			parqueadero = new RegistroParqueo(parqueaderoEntidad.getId(),
												parqueaderoEntidad.getTipoVehiculo(), 
												parqueaderoEntidad.getPlaca(), 
												parqueaderoEntidad.getCilindraje(), 
												parqueaderoEntidad.getFechaHoraIngreso());
		}
		
		return parqueadero;
	}
	
	public static ParqueaderoEntidad convertirAEntity(RegistroParqueo parqueadero) {
		
		ParqueaderoEntidad parqueaderoEntidad = new ParqueaderoEntidad();
		
		parqueaderoEntidad.setId(parqueadero.getId());
		parqueaderoEntidad.setTipoVehiculo(parqueadero.getTipoVehiculo());
		parqueaderoEntidad.setPlaca(parqueadero.getPlaca());
		parqueaderoEntidad.setCilindraje(parqueadero.getCilindraje());
		parqueaderoEntidad.setFechaHoraIngreso(parqueadero.getFechaHoraIngreso());
		parqueaderoEntidad.setFechaHoraSalida(parqueadero.getFechaHoraSalida()); 
		parqueaderoEntidad.setValorParqueo(parqueadero.getValorParqueo()); 
		parqueaderoEntidad.setEstadoInOut(parqueadero.getEstadoInOut());
		
		return parqueaderoEntidad;
	}

}
