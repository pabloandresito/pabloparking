package com.ceiba.pabloparking.dominio.repositorio;

import java.util.List;

import com.ceiba.pabloparking.dominio.RegistroParqueo;

public interface RepositorioRegistroParqueo {
	
	/**
	 * Permite obtener el RegistroParqueo por id
	 * @param id
	 * @return
	 */
	RegistroParqueo getById(Long id);
	
	/**
	 * Permite crear un RegistroParqueo
	 * @param registroParqueo
	 * @return el id generado
	 */
    Long crear(RegistroParqueo registroParqueo);
    
    /**
	 * Permite actualizar un registroParqueo
	 * @param registroParqueo
	 */
    void actualizar(RegistroParqueo registroParqueo);
   
    /**
     * Permite validar si existe un carro en el parqueadero con una placa especifica y que este ingresado (No Retirado)
     * @param placa
     * @return si existe o no
     */
	boolean existeIngresado(String placa);
	
	/**
	 * Permite consultar la lista de vehiculos (Carros y Motos) que estan ingresados al parqueadero
	 * @return java.util.List<RegistroParqueo>
	 */
	List<RegistroParqueo> consultarVehiculosIngresados();
	
	/**
	 * Permite consultar la lista de vehiculos (Carros y Motos) que estan retirados del parqueadero
	 * @return java.util.List<RegistroParqueo>
	 */
	List<RegistroParqueo> consultarVehiculosRetirados();
		
	/**
	 * Permite hacer un count por tipoVehiculo y estadoVehiculoInOut
	 * @param tipoVehiculo
	 * @param idEstadoInOut
	 * @return int - count
	 */
	int countByTipoVehiculoAndEstadoInOut(Integer tipoVehiculo, Integer idEstadoInOut);
}
