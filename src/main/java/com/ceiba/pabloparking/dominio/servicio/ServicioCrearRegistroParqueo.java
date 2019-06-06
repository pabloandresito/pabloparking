package com.ceiba.pabloparking.dominio.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pabloparking.dominio.repositorio.RepositorioRegistroParqueo;

public class ServicioCrearRegistroParqueo {

	private static final String VEHICULO_YA_INGRESADO_AL_PARQUEADERO = "El vehiculo ya se encuentra ingresado en el parqueadero";
    
	@Autowired
	private RepositorioRegistroParqueo repositorioRegistroParqueo;

    public Long ejecutar(RegistroParqueo registroParqueo) {
    	validarExistenciaPrevia(registroParqueo);
        return this.repositorioRegistroParqueo.crear(registroParqueo);
    }

	private void validarExistenciaPrevia(RegistroParqueo registroParqueo) {
		boolean existe = this.repositorioRegistroParqueo.existeIngresado(registroParqueo.getPlaca());
    	if(existe) {
    		throw new ExcepcionDuplicidad(VEHICULO_YA_INGRESADO_AL_PARQUEADERO);
    	}
	}
}
