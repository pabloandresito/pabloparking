package com.ceiba.pabloparking.infraestructura.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ceiba.pabloparking.aplicacion.manejador.ManejadorVigilanteRetirarVehiculo;
import com.ceiba.pabloparking.infraestructura.controller.dto.RegistroParqueoDto;

@Controller
@RequestMapping("/retiro-parqueo")
public class RetiroParqueoController {
	
	@Autowired
    private ManejadorVigilanteRetirarVehiculo manejadorVigilanteRetirarVehiculo;
	
	@RequestMapping(value = "/retirar", method = RequestMethod.POST)
	public ResponseEntity<String> retirar(@RequestBody RegistroParqueoDto registroParqueoDto){
		LocalDateTime fechaHoraSalida = LocalDateTime.now();
		registroParqueoDto.setFechaHoraSalida(fechaHoraSalida);
		manejadorVigilanteRetirarVehiculo.ejecutar(registroParqueoDto); // TODO probles - Enviar mensaje de respuesta desde el backend
		
		return ResponseEntity.status(HttpStatus.OK).body("Todo ok");
	}
}
