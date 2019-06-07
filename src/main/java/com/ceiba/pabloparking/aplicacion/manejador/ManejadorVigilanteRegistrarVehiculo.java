package com.ceiba.pabloparking.aplicacion.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.pabloparking.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.pabloparking.aplicacion.fabrica.FabricaRegistroParqueo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.servicio.ServicioVigilanteRegistrarVehiculo;

@Component
public class ManejadorVigilanteRegistrarVehiculo {
	
	@Autowired
	private FabricaRegistroParqueo fabricaRegistroParqueo;
	
	@Autowired
	private ServicioVigilanteRegistrarVehiculo servicioVigilanteRegistrarVehiculo;

	public Long ejecutar(ComandoRegistroParqueo comandoRegistroParqueo) {
		RegistroParqueo registroParqueo = fabricaRegistroParqueo.convertirComandoADominio(comandoRegistroParqueo);
		return servicioVigilanteRegistrarVehiculo.ejecutar(registroParqueo);
	}

	public List<RegistroParqueo> consultarCarros() {
		return servicioVigilanteRegistrarVehiculo.consultarCarros();
	}
}
