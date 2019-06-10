package com.ceiba.pabloparking.infraestructura.persistencia.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.pabloparking.infraestructura.persistencia.entidad.RegistroParqueoEntidad;

public interface ConexionDBRegistroParqueo extends CrudRepository<RegistroParqueoEntidad, Long> {
	
	List<RegistroParqueoEntidad> findByEstadoInOutOrderByIdDesc(Integer idEstadoInOut);

	RegistroParqueoEntidad findByPlacaAndEstadoInOut(String placa, Integer idEstadoInOut);
	
	int countByTipoVehiculoAndEstadoInOut(Integer tipoVehiculo, Integer idEstadoInOut);
}
