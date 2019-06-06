package com.ceiba.pabloparking.aplicacion.service;

import java.util.List;

import com.ceiba.pabloparking.dominio.RegistroParqueo;

public interface ParqueaderoService {
	
	public List<RegistroParqueo> consultarCarros();
	
	public List<RegistroParqueo> consultarMotos();

}
