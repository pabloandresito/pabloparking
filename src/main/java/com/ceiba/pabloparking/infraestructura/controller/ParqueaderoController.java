package com.ceiba.pabloparking.infraestructura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ceiba.pabloparking.aplicacion.service.ParqueaderoService;
import com.ceiba.pabloparking.dominio.RegistroParqueo;

@Controller
@RequestMapping("/parqueadero")
public class ParqueaderoController {
	
	@Autowired
    private ParqueaderoService parqueaderoService;
	
	@RequestMapping(value = "/list-carros", method = RequestMethod.GET)
	public ResponseEntity<List<RegistroParqueo>> listCarros(){
		return new ResponseEntity<>(parqueaderoService.consultarCarros(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/list-motos", method = RequestMethod.GET)
	public ResponseEntity<List<RegistroParqueo>> listMotos(){
		return new ResponseEntity<>(parqueaderoService.consultarMotos(), HttpStatus.OK);
	}

}
