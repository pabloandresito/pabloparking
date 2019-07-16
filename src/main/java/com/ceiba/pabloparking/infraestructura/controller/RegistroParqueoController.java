package com.ceiba.pabloparking.infraestructura.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ceiba.pabloparking.aplicacion.manejador.ManejadorVigilanteRegistrarVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.infraestructura.controller.dto.RegistroParqueoDto;
import com.ceiba.pabloparking.infraestructura.controller.dto.ResponseApi;

@Controller
@CrossOrigin
@RequestMapping("/registro-parqueo")
public class RegistroParqueoController {
	
	private static final String VEHICULO_INGRESADO_EXITOSAMENTE = "El vehiculo ha sido ingresado al Parqueadero.";
	
	@Autowired
    private ManejadorVigilanteRegistrarVehiculo manejadorVigilanteRegistrarVehiculo;
	
	@GetMapping(value = "/list-vehiculos")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<RegistroParqueo> listVehiculos(){
		  return manejadorVigilanteRegistrarVehiculo.consultarVehiculosIngresados();
		
		
	}
	
	@PostMapping(value = "/ingresar")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseApi ingresar(@RequestBody RegistroParqueoDto registroParqueoDto){
		LocalDateTime fechaHoraIngreso = LocalDateTime.now();
		registroParqueoDto.setFechaHoraIngreso(fechaHoraIngreso);
		manejadorVigilanteRegistrarVehiculo.ejecutar(registroParqueoDto);
		return new ResponseApi(VEHICULO_INGRESADO_EXITOSAMENTE);
	}
}
