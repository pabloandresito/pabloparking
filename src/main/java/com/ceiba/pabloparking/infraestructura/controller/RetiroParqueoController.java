package com.ceiba.pabloparking.infraestructura.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceiba.pabloparking.aplicacion.manejador.ManejadorVigilanteRetirarVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.infraestructura.controller.dto.RegistroParqueoDto;

@Controller
@RequestMapping("/retiro-parqueo")
public class RetiroParqueoController {
	
	@Autowired
    private ManejadorVigilanteRetirarVehiculo manejadorVigilanteRetirarVehiculo;
	
	@GetMapping("/load")
    public String load() {
        return "vehiculos-retirados";
    }
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<RegistroParqueo>> list(){
		return new ResponseEntity<>(manejadorVigilanteRetirarVehiculo.consultarVehiculosRetirados(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/retirar")
	public ResponseEntity<Map<String, String>> retirar(@RequestBody RegistroParqueoDto registroParqueoDto){
		LocalDateTime fechaHoraSalida = LocalDateTime.now();
		registroParqueoDto.setFechaHoraSalida(fechaHoraSalida);
		String mensaje = manejadorVigilanteRetirarVehiculo.ejecutar(registroParqueoDto);
		
		Map<String, String> mapResponse = new HashMap<>();
		mapResponse.put("message", mensaje);
		
		return ResponseEntity.ok().body(mapResponse);
	}
}
