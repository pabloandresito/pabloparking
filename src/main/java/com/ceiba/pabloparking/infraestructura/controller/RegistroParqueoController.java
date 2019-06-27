package com.ceiba.pabloparking.infraestructura.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceiba.pabloparking.aplicacion.manejador.ManejadorVigilanteRegistrarVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.infraestructura.controller.dto.RegistroParqueoDto;

@Controller
@CrossOrigin
@RequestMapping("/registro-parqueo")
public class RegistroParqueoController {
	
	private static final String VEHICULO_INGRESADO_EXITOSAMENTE = "El vehiculo ha sido ingresado al Parqueadero.";
	
	@Autowired
    private ManejadorVigilanteRegistrarVehiculo manejadorVigilanteRegistrarVehiculo;
	
	@GetMapping(value = "/list-vehiculos")
	public ResponseEntity<List<RegistroParqueo>> listVehiculos(){
		return new ResponseEntity<>(manejadorVigilanteRegistrarVehiculo.consultarVehiculosIngresados(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/ingresar")
	public ResponseEntity<Map<String, String>> ingresar(@RequestBody RegistroParqueoDto registroParqueoDto){
		LocalDateTime fechaHoraIngreso = LocalDateTime.now();
		registroParqueoDto.setFechaHoraIngreso(fechaHoraIngreso);
		manejadorVigilanteRegistrarVehiculo.ejecutar(registroParqueoDto);
		
		Map<String, String> mapResponse = new HashMap<>();
		mapResponse.put("message", VEHICULO_INGRESADO_EXITOSAMENTE);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(mapResponse);
	}
}
