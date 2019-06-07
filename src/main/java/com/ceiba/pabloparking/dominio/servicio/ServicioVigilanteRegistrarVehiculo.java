package com.ceiba.pabloparking.dominio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pabloparking.dominio.repositorio.RepositorioRegistroParqueo;

@Service
public class ServicioVigilanteRegistrarVehiculo {
	
private static final String VEHICULO_YA_INGRESADO_AL_PARQUEADERO = "El vehiculo ya se encuentra ingresado en el parqueadero";
    
	@Autowired
	private RepositorioRegistroParqueo repositorioRegistroParqueo;

    public Long ejecutar(RegistroParqueo registroParqueo) {
    	validarExistenciaPrevia(registroParqueo);
        return repositorioRegistroParqueo.crear(registroParqueo);
    }

	private void validarExistenciaPrevia(RegistroParqueo registroParqueo) {
		boolean existe = repositorioRegistroParqueo.existeIngresado(registroParqueo.getPlaca());
    	if(existe) {
    		throw new ExcepcionDuplicidad(VEHICULO_YA_INGRESADO_AL_PARQUEADERO);
    	}
	}

	public List<RegistroParqueo> consultarCarros() {
		return repositorioRegistroParqueo.consultarCarros();
	}

	public List<RegistroParqueo> consultarMotos() {
		return repositorioRegistroParqueo.consultarMotos();
	}

}