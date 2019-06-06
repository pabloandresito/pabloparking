package com.ceiba.pabloparking.aplicacion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.pabloparking.aplicacion.builder.ParqueaderoBuilder;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.infraestructura.persistencia.dao.ParqueaderoDao;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.ParqueaderoEntidad;

@Service
public class ParqueaderoServiceImpl implements ParqueaderoService {
	
	@Autowired
	ParqueaderoDao parqueaderoDao;

	@Override
	public List<RegistroParqueo> consultarCarros() {
		Iterable<ParqueaderoEntidad> listCarrosParqueadosEntidad =  parqueaderoDao.findAll();
		
		List<RegistroParqueo> listCarrosParqueados = new ArrayList<RegistroParqueo>();
		for (ParqueaderoEntidad parqueaderoEntidad : listCarrosParqueadosEntidad) {
			listCarrosParqueados.add(ParqueaderoBuilder.convertirADominio(parqueaderoEntidad));
		}
		return listCarrosParqueados;
	}

	@Override
	public List<RegistroParqueo> consultarMotos() {
		Iterable<ParqueaderoEntidad> listMotosParqueadasEntidad =  parqueaderoDao.findAll();
		
		List<RegistroParqueo> listMotosParqueadas = new ArrayList<RegistroParqueo>();
		for (ParqueaderoEntidad parqueaderoEntidad : listMotosParqueadasEntidad) {
			listMotosParqueadas.add(ParqueaderoBuilder.convertirADominio(parqueaderoEntidad));
		}
		return listMotosParqueadas;
	}

}
