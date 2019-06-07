package com.ceiba.pabloparking.dominio.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.pabloparking.dominio.repositorio.RepositorioRegistroParqueo;

@Service
public class ServicioEliminarRegistroParqueo {
	
	@Autowired
	private RepositorioRegistroParqueo repositorioRegistroParqueo;
	
	public void ejecutar(Long id) {
        this.repositorioRegistroParqueo.eliminar(id);
    }

}
