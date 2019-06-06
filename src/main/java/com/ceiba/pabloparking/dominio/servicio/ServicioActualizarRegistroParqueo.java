package com.ceiba.pabloparking.dominio.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.repositorio.RepositorioRegistroParqueo;

public class ServicioActualizarRegistroParqueo {
	
	@Autowired
	private RepositorioRegistroParqueo repositorioRegistroParqueo;

	public void ejecutar(RegistroParqueo registroParqueo) {
        this.repositorioRegistroParqueo.actualizar(registroParqueo);
    }

}
