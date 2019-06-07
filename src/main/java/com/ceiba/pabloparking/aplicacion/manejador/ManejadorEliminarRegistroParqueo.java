package com.ceiba.pabloparking.aplicacion.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.pabloparking.dominio.servicio.ServicioEliminarRegistroParqueo;

@Component
public class ManejadorEliminarRegistroParqueo {
	
	@Autowired
	private ServicioEliminarRegistroParqueo servicioEliminarRegistroParqueo;

	public void ejecutar(Long idRegistroParqueo) {
		servicioEliminarRegistroParqueo.ejecutar(idRegistroParqueo);
	}

}
