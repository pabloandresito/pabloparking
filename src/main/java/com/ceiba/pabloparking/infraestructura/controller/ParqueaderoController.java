package com.ceiba.pabloparking.infraestructura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ceiba.pabloparking.aplicacion.manejador.ManejadorVigilanteRegistrarVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;

@Controller
@RequestMapping("/parqueadero") // TODO probles - Cambiar el nombre de la petición de "parqueadero" a "registroParqueo" o también puede ser "vigilanteparqueadero"
public class ParqueaderoController {
	
	@Autowired
    private ManejadorVigilanteRegistrarVehiculo manejadorVigilanteRegistrarVehiculo;
	
	@RequestMapping(value = "/list-carros", method = RequestMethod.GET)
	public ResponseEntity<List<RegistroParqueo>> listCarros(){
		return new ResponseEntity<>(manejadorVigilanteRegistrarVehiculo.consultarCarros(), HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/list-motos", method = RequestMethod.GET)
//	public ResponseEntity<List<RegistroParqueo>> listMotos(){
//		return new ResponseEntity<>(manejadorVigilanteRegistrarVehiculo.consultarMotos(), HttpStatus.OK);
//	} // TODO probles - Descomentariar y arreglar 

}
