package com.ceiba.pabloparking.infraestructura.persistencia.dao;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.pabloparking.infraestructura.persistencia.entidad.RegistroParqueoEntidad;

public interface ConexionDBRegistroParqueo extends CrudRepository<RegistroParqueoEntidad, Long> {

}
