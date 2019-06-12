package com.ceiba.pabloparking.dominio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.pabloparking.dominio.EstadoVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionMaxCapacidadParqueadero;
import com.ceiba.pabloparking.dominio.repositorio.RepositorioRegistroParqueo;

@Service
public class ServicioVigilanteRegistrarVehiculo {
	
	private static final String VEHICULO_YA_INGRESADO_AL_PARQUEADERO = "Ya existe un vehiculo con esta placa ingresado en el parqueadero.";
	
	public static final int CAPACIDAD_MAX_DE_PARQUEADEROS_CARRO = 20;
	private static final String CAPACIDAD_MAX_DE_CARROS_ALCANZADA = "Se ha llegado a la capacidad máxima de Carros (" + CAPACIDAD_MAX_DE_PARQUEADEROS_CARRO + ") y ya no es posible ingresar nuevos Carros.";
	
	public static final int CAPACIDAD_MAX_DE_PARQUEADEROS_MOTOS = 10;
	private static final String CAPACIDAD_MAX_DE_MOTOS_ALCANZADA = "Se ha llegado a la capacidad máxima de Motos (" + CAPACIDAD_MAX_DE_PARQUEADEROS_MOTOS + ") y ya no es posible ingresar nuevas Motos.";
    
	@Autowired
	private RepositorioRegistroParqueo repositorioRegistroParqueo;

    public Long ejecutar(RegistroParqueo registroParqueo) {
    	validarExistenciaPrevia(registroParqueo);
    	validarCapacidadMaximaParqueadero(registroParqueo);
        return repositorioRegistroParqueo.crear(registroParqueo);
    }
    
    public List<RegistroParqueo> consultarVehiculosIngresados() {
    	return repositorioRegistroParqueo.consultarVehiculosIngresados();
	}

	public void validarExistenciaPrevia(RegistroParqueo registroParqueo) {
		boolean existe = repositorioRegistroParqueo.existeIngresado(registroParqueo.getPlaca());
    	if(existe) {
    		throw new ExcepcionDuplicidad(VEHICULO_YA_INGRESADO_AL_PARQUEADERO);
    	}
	}
	
	public void validarCapacidadMaximaParqueadero(RegistroParqueo registroParqueo) {
		int capacidadMaximaParqueadero = repositorioRegistroParqueo.countByTipoVehiculoAndEstadoInOut(registroParqueo.getTipoVehiculo(), EstadoVehiculo.INGRESADO_PARQUEADERO.getIdEstado());
    	
		if(registroParqueo.getTipoVehiculo() == TipoVehiculo.CARRO.getIdTipoVehiculo() && capacidadMaximaParqueadero >= CAPACIDAD_MAX_DE_PARQUEADEROS_CARRO) {
			throw new ExcepcionMaxCapacidadParqueadero(CAPACIDAD_MAX_DE_CARROS_ALCANZADA);
		}
		
		if(registroParqueo.getTipoVehiculo() == TipoVehiculo.MOTO.getIdTipoVehiculo() && capacidadMaximaParqueadero >= CAPACIDAD_MAX_DE_PARQUEADEROS_MOTOS) {
			throw new ExcepcionMaxCapacidadParqueadero(CAPACIDAD_MAX_DE_MOTOS_ALCANZADA);
		}
	}
}