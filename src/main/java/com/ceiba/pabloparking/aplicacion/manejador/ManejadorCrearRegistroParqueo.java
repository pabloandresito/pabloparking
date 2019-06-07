package com.ceiba.pabloparking.aplicacion.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.pabloparking.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.pabloparking.aplicacion.fabrica.FabricaRegistroParqueo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.servicio.ServicioCrearRegistroParqueo;

@Component
public class ManejadorCrearRegistroParqueo {
	
	@Autowired
	private FabricaRegistroParqueo fabricaRegistroParqueo;
	
	@Autowired
	private ServicioCrearRegistroParqueo servicioCrearRegistroParqueo;

	public Long ejecutar(ComandoRegistroParqueo comandoRegistroParqueo) {
		RegistroParqueo registroParqueo = fabricaRegistroParqueo.convertirComandoADominio(comandoRegistroParqueo);
		return servicioCrearRegistroParqueo.ejecutar(registroParqueo);
	}

}