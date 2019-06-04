package com.ceiba.pabloparking.infraestructura.persistencia.dao;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.pabloparking.infraestructura.persistencia.entidad.ParqueaderoEntidad;

public interface ParqueaderoDao extends CrudRepository<ParqueaderoEntidad, Long> {

}
