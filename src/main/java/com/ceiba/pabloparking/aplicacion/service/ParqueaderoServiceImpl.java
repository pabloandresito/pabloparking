package com.ceiba.pabloparking.aplicacion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.pabloparking.aplicacion.builder.ParqueaderoBuilder;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.infraestructura.persistencia.dao.ConexionDBRegistroParqueo;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.RegistroParqueoEntidad;

@Service
public class ParqueaderoServiceImpl implements ParqueaderoService {
	
	@Autowired
	ConexionDBRegistroParqueo conexionDBRegistroParqueo;

	@Override
	public List<RegistroParqueo> consultarCarros() {
		Iterable<RegistroParqueoEntidad> listRegistroParqueoCarrosEntidad = conexionDBRegistroParqueo.findAll();
		
		List<RegistroParqueo> listRegistroParqueo = new ArrayList<RegistroParqueo>();
		for (RegistroParqueoEntidad registroParqueoEntidad : listRegistroParqueoCarrosEntidad) {
			listRegistroParqueo.add(ParqueaderoBuilder.convertirADominio(registroParqueoEntidad));
		}
		return listRegistroParqueo;
	}

	@Override
	public List<RegistroParqueo> consultarMotos() {
		Iterable<RegistroParqueoEntidad> listRegistroParqueoMotosEntidad = conexionDBRegistroParqueo.findAll();
		
		List<RegistroParqueo> listRegistroParqueo = new ArrayList<RegistroParqueo>();
		for (RegistroParqueoEntidad registroParqueoEntidad : listRegistroParqueoMotosEntidad) {
			listRegistroParqueo.add(ParqueaderoBuilder.convertirADominio(registroParqueoEntidad));
		}
		return listRegistroParqueo;
	}

}
