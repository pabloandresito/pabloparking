package com.ceiba.pabloparking.aplicacion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.pabloparking.aplicacion.builder.ParqueaderoBuilder;
import com.ceiba.pabloparking.dominio.Parqueadero;
import com.ceiba.pabloparking.infraestructura.persistencia.dao.ParqueaderoDao;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.ParqueaderoEntidad;

@Service
public class ParqueaderoServiceImpl implements ParqueaderoService {
	
	@Autowired
	ParqueaderoDao parqueaderoDao;

	@Override
	public List<Parqueadero> consultarCarros() {
		Iterable<ParqueaderoEntidad> listCarrosParqueadosEntidad =  parqueaderoDao.findAll();
		
		List<Parqueadero> listCarrosParqueados = new ArrayList<Parqueadero>();
		for (ParqueaderoEntidad parqueaderoEntidad : listCarrosParqueadosEntidad) {
			listCarrosParqueados.add(ParqueaderoBuilder.convertirADominio(parqueaderoEntidad));
		}
		return listCarrosParqueados;
	}

	@Override
	public List<Parqueadero> consultarMotos() {
		Iterable<ParqueaderoEntidad> listMotosParqueadasEntidad =  parqueaderoDao.findAll();
		
		List<Parqueadero> listMotosParqueadas = new ArrayList<Parqueadero>();
		for (ParqueaderoEntidad parqueaderoEntidad : listMotosParqueadasEntidad) {
			listMotosParqueadas.add(ParqueaderoBuilder.convertirADominio(parqueaderoEntidad));
		}
		return listMotosParqueadas;
	}

}
