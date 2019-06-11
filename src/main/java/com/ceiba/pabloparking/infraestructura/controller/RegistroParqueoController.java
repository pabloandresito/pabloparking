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
	
	private static final String VEHICULO_INGRESADO_EXITOSAMENTE = "El vehiculo ha sido ingresado al Parqueadero.";
	
	@Autowired
    private ManejadorVigilanteRegistrarVehiculo manejadorVigilanteRegistrarVehiculo;
	
	@RequestMapping(value = "/list-vehiculos", method = RequestMethod.GET)
	public ResponseEntity<List<RegistroParqueo>> listVehiculos(){
		return new ResponseEntity<>(manejadorVigilanteRegistrarVehiculo.consultarVehiculosIngresados(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ingresar", method = RequestMethod.POST)
	public ResponseEntity<String> ingresar(@RequestBody RegistroParqueoDto registroParqueoDto){
		LocalDateTime fechaHoraIngreso = LocalDateTime.now();
		registroParqueoDto.setFechaHoraIngreso(fechaHoraIngreso);
		manejadorVigilanteRegistrarVehiculo.ejecutar(registroParqueoDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(VEHICULO_INGRESADO_EXITOSAMENTE);
	}
}
