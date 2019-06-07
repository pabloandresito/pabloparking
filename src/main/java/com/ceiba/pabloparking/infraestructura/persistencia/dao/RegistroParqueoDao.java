package com.ceiba.pabloparking.infraestructura.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.pabloparking.aplicacion.fabrica.FabricaRegistroParqueo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.repositorio.RepositorioRegistroParqueo;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.RegistroParqueoEntidad;

@Component
public class RegistroParqueoDao implements RepositorioRegistroParqueo {
	
	@Autowired
	private ConexionDBRegistroParqueo conexionDBRegistroParqueo;
	
	@Autowired
	private FabricaRegistroParqueo fabricaRegistroParqueo;
	
	@Override
	public Long crear(RegistroParqueo registroParqueo) {
		RegistroParqueoEntidad registroParqueoEntidadResultado = conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(registroParqueo));
		return registroParqueoEntidadResultado != null ? registroParqueoEntidadResultado.getId() : null;
	}

	@Override
	public void actualizar(RegistroParqueo registroParqueo) {
		conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(registroParqueo));
	}

	@Override
	public void eliminar(Long idRegistroParqueo) {
		conexionDBRegistroParqueo.deleteById(idRegistroParqueo);
	}

	@Override
	public boolean existeIngresado(String placa) {
		// TODO probles - Pendiente de implementación
		return false;
	}

	@Override
	public List<RegistroParqueo> consultarCarros() {
		Iterable<RegistroParqueoEntidad> listRegistroParqueoMotosEntidad = conexionDBRegistroParqueo.findAll();
		
		List<RegistroParqueo> listRegistroParqueo = new ArrayList<RegistroParqueo>();
		for (RegistroParqueoEntidad registroParqueoEntidad : listRegistroParqueoMotosEntidad) {
			listRegistroParqueo.add(fabricaRegistroParqueo.convertirEntityADominio(registroParqueoEntidad));
		}
		return listRegistroParqueo;
	}

}
