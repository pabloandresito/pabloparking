package com.ceiba.pabloparking.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.pabloparking.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.infraestructura.controller.dto.RegistroParqueoDto;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.RegistroParqueoEntidad;

@Component
public class FabricaRegistroParqueo {
	
	public RegistroParqueo convertirComandoADominio(ComandoRegistroParqueo comandoRegistroParqueo) {
		RegistroParqueo registroParqueo = null;
		if(comandoRegistroParqueo != null) {
			registroParqueo = new RegistroParqueo(comandoRegistroParqueo.getId(), 
													comandoRegistroParqueo.getTipoVehiculo(), 
													comandoRegistroParqueo.getPlaca(), 
													comandoRegistroParqueo.getCilindraje(), 
													comandoRegistroParqueo.getFechaHoraIngreso());
			
			// Se complementan los dem�s atributos que no tenia en cuenta el constructor
			
			if(comandoRegistroParqueo.getFechaHoraSalida() != null) {
				registroParqueo.setFechaHoraSalida(comandoRegistroParqueo.getFechaHoraSalida());
			}
			
			if(comandoRegistroParqueo.getValorParqueo() != null) {
				registroParqueo.setValorParqueo(comandoRegistroParqueo.getValorParqueo());
			}
			
			if(comandoRegistroParqueo.getEstadoInOut() != null) {
				registroParqueo.setEstadoInOut(comandoRegistroParqueo.getEstadoInOut());
			}
		}
		return registroParqueo;
	}
	
	public RegistroParqueo convertirEntityADominio(RegistroParqueoEntidad registroParqueoEntidad) {
		RegistroParqueo registroParqueo = null;
		if(registroParqueoEntidad != null) {
			registroParqueo = new RegistroParqueo(registroParqueoEntidad.getId(), 
													registroParqueoEntidad.getTipoVehiculo(), 
													registroParqueoEntidad.getPlaca(), 
													registroParqueoEntidad.getCilindraje(), 
													registroParqueoEntidad.getFechaHoraIngreso());
		}
		
		// Se complementan los dem�s atributos que no tenia en cuenta el constructor

		if(registroParqueoEntidad.getFechaHoraSalida() != null) {
			registroParqueo.setFechaHoraSalida(registroParqueoEntidad.getFechaHoraSalida());
		}
		
		if(registroParqueoEntidad.getValorParqueo() != null) {
			registroParqueo.setValorParqueo(registroParqueoEntidad.getValorParqueo());
		}
		
		if(registroParqueoEntidad.getEstadoInOut() != null) {
			registroParqueo.setEstadoInOut(registroParqueoEntidad.getEstadoInOut());
		}
		return registroParqueo;
	}

	public RegistroParqueoEntidad convertirDominoAEntity(RegistroParqueo registroParqueo) {
		
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

	public RegistroParqueo convertirDtoADominio(RegistroParqueoDto registroParqueoDto) {
		RegistroParqueo registroParqueo = null;
		if(registroParqueoDto != null) {
			registroParqueo = new RegistroParqueo(registroParqueoDto.getId(), 
													registroParqueoDto.getTipoVehiculo(), 
													registroParqueoDto.getPlaca(), 
													registroParqueoDto.getCilindraje(), 
													registroParqueoDto.getFechaHoraIngreso());
			
			// Se complementan los demás atributos que no tenia en cuenta el constructor
			
			if(registroParqueoDto.getFechaHoraSalida() != null) {
				registroParqueo.setFechaHoraSalida(registroParqueoDto.getFechaHoraSalida());
			}
			
			if(registroParqueoDto.getValorParqueo() != null) {
				registroParqueo.setValorParqueo(registroParqueoDto.getValorParqueo());
			}
			
			if(registroParqueoDto.getEstadoInOut() != null) {
				registroParqueo.setEstadoInOut(registroParqueoDto.getEstadoInOut());
			}
		}
		return registroParqueo;
	}
}