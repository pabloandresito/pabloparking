package com.ceiba.pabloparking.aplicacion.service;

import java.util.List;

import com.ceiba.pabloparking.dominio.Parqueadero;

public interface ParqueaderoService {
	
	public List<Parqueadero> consultarCarros();
	
	public List<Parqueadero> consultarMotos();

}
