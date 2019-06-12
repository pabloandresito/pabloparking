package com.ceiba.pabloparking.infraestructura.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ceiba.pabloparking.aplicacion.manejador.ManejadorVigilanteRegistrarVehiculo;
import com.ceiba.pabloparking.aplicacion.manejador.ManejadorVigilanteRetirarVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.infraestructura.controller.dto.RegistroParqueoDto;

@Controller
@RequestMapping("/retiro-parqueo")
public class RetiroParqueoController {
	
	@Autowired
    private ManejadorVigilanteRetirarVehiculo manejadorVigilanteRetirarVehiculo;
	
	//TODO probles cambiar bean
	@Autowired
    private ManejadorVigilanteRegistrarVehiculo manejadorVigilanteRegistrarVehiculo;
	
	@RequestMapping("/load")
    public String load() {
        return "vehiculos-retirados";
    }
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<RegistroParqueo>> list(){
		return new ResponseEntity<>(manejadorVigilanteRegistrarVehiculo.consultarVehiculosIngresados(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retirar", method = RequestMethod.POST)
	public ResponseEntity<Map<String, String>> retirar(@RequestBody RegistroParqueoDto registroParqueoDto){
		LocalDateTime fechaHoraSalida = LocalDateTime.now();
		registroParqueoDto.setFechaHoraSalida(fechaHoraSalida);
		String mensaje = manejadorVigilanteRetirarVehiculo.ejecutar(registroParqueoDto);
		
		Map<String, String> mapResponse = new HashMap<String, String>();
		mapResponse.put("message", mensaje);
		
		return ResponseEntity.ok().body(mapResponse);
	}
}
