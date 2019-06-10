package com.ceiba.pabloparking.dominio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pabloparking.dominio.repositorio.RepositorioRegistroParqueo;

@Service
public class ServicioVigilanteRegistrarVehiculo {
	
private static final String VEHICULO_YA_INGRESADO_AL_PARQUEADERO = "Ya existe un vehiculo con esta placa ingresado en el parqueadero.";
    
	@Autowired
	private RepositorioRegistroParqueo repositorioRegistroParqueo;

    public Long ejecutar(RegistroParqueo registroParqueo) {
    	validarExistenciaPrevia(registroParqueo);
        return repositorioRegistroParqueo.crear(registroParqueo);
    }
    
    public List<RegistroParqueo> consultarVehiculosIngresados() {
    	return repositorioRegistroParqueo.consultarVehiculosIngresados();
	}

	public List<RegistroParqueo> consultarCarros() {
		return repositorioRegistroParqueo.consultarCarros();
	}

	public List<RegistroParqueo> consultarMotos() {
		return repositorioRegistroParqueo.consultarMotos();
	}

	public void ingresarVehiculo(RegistroParqueo registroParqueo) {
		validarExistenciaPrevia(registroParqueo);
		repositorioRegistroParqueo.crear(registroParqueo);
	}

	private void validarExistenciaPrevia(RegistroParqueo registroParqueo) {
		boolean existe = repositorioRegistroParqueo.existeIngresado(registroParqueo.getPlaca());
    	if(existe) {
    		throw new ExcepcionDuplicidad(VEHICULO_YA_INGRESADO_AL_PARQUEADERO);
    	}
	}
}