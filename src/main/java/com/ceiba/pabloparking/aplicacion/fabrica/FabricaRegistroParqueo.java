package com.ceiba.pabloparking.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.pabloparking.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;

@Component
public class FabricaRegistroParqueo {
	
	public RegistroParqueo crear(ComandoRegistroParqueo comandoRegistroParqueo) {
		return new RegistroParqueo(comandoRegistroParqueo.getId(), 
									comandoRegistroParqueo.getTipoVehiculo(), 
									comandoRegistroParqueo.getPlaca(), 
									comandoRegistroParqueo.getCilindraje(), 
									comandoRegistroParqueo.getFechaHoraIngreso());
	}

}