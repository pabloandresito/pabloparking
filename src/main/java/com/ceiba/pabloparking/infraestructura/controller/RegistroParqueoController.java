package com.ceiba.pabloparking.infraestructura.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ceiba.pabloparking.aplicacion.manejador.ManejadorVigilanteRegistrarVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.infraestructura.controller.dto.RegistroParqueoDto;

@Controller
@RequestMapping("/registro-parqueo")
public class RegistroParqueoController {
	
	@Autowired
    private ManejadorVigilanteRegistrarVehiculo manejadorVigilanteRegistrarVehiculo;
	
	@RequestMapping(value = "/list-vehiculos", method = RequestMethod.GET)
	public ResponseEntity<List<RegistroParqueo>> listVehiculos(){
		return new ResponseEntity<>(manejadorVigilanteRegistrarVehiculo.consultarVehiculosIngresados(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/list-carros", method = RequestMethod.GET)
	public ResponseEntity<List<RegistroParqueo>> listCarros(){
		return new ResponseEntity<>(manejadorVigilanteRegistrarVehiculo.consultarCarros(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/list-motos", method = RequestMethod.GET)
	public ResponseEntity<List<RegistroParqueo>> listMotos(){
		return new ResponseEntity<>(manejadorVigilanteRegistrarVehiculo.consultarMotos(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ingresar", method = RequestMethod.POST)
	public ResponseEntity<String> ingresar(@RequestBody RegistroParqueoDto registroParqueoDto){
		LocalDateTime fechaActual = LocalDateTime.now();
		registroParqueoDto.setFechaHoraIngreso(fechaActual);
		manejadorVigilanteRegistrarVehiculo.ejecutar(registroParqueoDto); // TODO probles - Enviar mensaje de respuesta desde el backend
		return new ResponseEntity<>("Urra !!!", HttpStatus.OK);
	}

}
