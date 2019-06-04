package com.ceiba.pabloparking.infraestructura.persistencia.dao;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.pabloparking.infraestructura.persistencia.entidad.MotoEntidad;

public interface MotoDao extends CrudRepository<MotoEntidad, Long> {
	
	public MotoEntidad findByPlaca(String placa);

}
