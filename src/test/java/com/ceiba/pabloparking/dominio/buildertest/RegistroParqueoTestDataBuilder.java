package com.ceiba.pabloparking.dominio.buildertest;

import java.time.LocalDateTime;
import java.time.Month;

import com.ceiba.pabloparking.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.pabloparking.dominio.EstadoVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.infraestructura.controller.dto.RegistroParqueoDto;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.RegistroParqueoEntidad;

public class RegistroParqueoTestDataBuilder {
	
	private static final Long ID = null;
	private static final Integer TIPOVEHICULO = TipoVehiculo.MOTO.getIdTipoVehiculo();
	private static final String PLACA = "RRR888";
	private static final Integer CILINDRAJE = 300;
	
	// Especificar indicando año, mes, día, horas, minutos, segundos y milisegundos
	private static final LocalDateTime FECHAHORAINGRESO = LocalDateTime.of(2019, Month.JUNE, 4, 11, 23, 1);
	
	// Especificar indicando año, mes, día, horas, minutos, segundos y milisegundos
	private static final LocalDateTime FECHAHORASALIDA = LocalDateTime.of(2019, Month.JUNE, 12, 13, 30, 40);
	
	private static final Double VALORPARQUEO = 6000d;
	private static final Integer ESTADOINOUT = EstadoVehiculo.RETIRADO_PARQUEADERO.getIdEstado();
	
	private Long id;
	private Integer tipoVehiculo;
	private String placa;
	private Integer cilindraje;
	private LocalDateTime fechaHoraIngreso;
	private LocalDateTime fechaHoraSalida;
	private Double valorParqueo;
	private Integer estadoInOut;
	
	public RegistroParqueoTestDataBuilder() {
		this.id = ID;
		this.tipoVehiculo = TIPOVEHICULO;
		this.placa = PLACA;
		this.cilindraje = CILINDRAJE;
		this.fechaHoraIngreso = FECHAHORAINGRESO;
		this.fechaHoraSalida = FECHAHORASALIDA;
		this.valorParqueo = VALORPARQUEO;
		this.estadoInOut = ESTADOINOUT;
	}
	
	public RegistroParqueoTestDataBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public RegistroParqueoTestDataBuilder withTipoVehiculo(Integer tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}

	public RegistroParqueoTestDataBuilder withPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public RegistroParqueoTestDataBuilder withCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}

	public RegistroParqueoTestDataBuilder withFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
		this.fechaHoraIngreso = fechaHoraIngreso;
		return this;
	}

	public RegistroParqueoTestDataBuilder withFechaHoraSalida(LocalDateTime fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
		return this;
	}

	public RegistroParqueoTestDataBuilder withValorParqueo(Double valorParqueo) {
		this.valorParqueo = valorParqueo;
		return this;
	}

	public RegistroParqueoTestDataBuilder withEstadoInOut(Integer estadoInOut) {
		this.estadoInOut = estadoInOut;
		return this;
	}

	public RegistroParqueo build() {
		RegistroParqueo registroParqueo = new RegistroParqueo(this.id, this.tipoVehiculo, this.placa, this.cilindraje, this.fechaHoraIngreso);
		
		if(this.fechaHoraSalida != null) {
			registroParqueo.setFechaHoraSalida(this.fechaHoraSalida);
		}
		
		if(this.valorParqueo != null) {
			registroParqueo.setValorParqueo(this.valorParqueo);
		}
		
		if(this.estadoInOut != null) {
			registroParqueo.setEstadoInOut(this.estadoInOut);
		}
		
		return registroParqueo;
	}
	
	public RegistroParqueoEntidad buildEntity() {
		
		RegistroParqueoEntidad registroParqueoEntidad = new RegistroParqueoEntidad();
		
		registroParqueoEntidad.setId(this.id);
		registroParqueoEntidad.setTipoVehiculo(this.tipoVehiculo);
		registroParqueoEntidad.setPlaca(this.placa);
		registroParqueoEntidad.setCilindraje(this.cilindraje);
		registroParqueoEntidad.setFechaHoraIngreso(this.fechaHoraIngreso);
		registroParqueoEntidad.setFechaHoraSalida(this.fechaHoraSalida); 
		registroParqueoEntidad.setValorParqueo(this.valorParqueo); 
		registroParqueoEntidad.setEstadoInOut(this.estadoInOut);
		
		return registroParqueoEntidad;
	}
	
	public ComandoRegistroParqueo buildComandoBySetters() {
		
		ComandoRegistroParqueo comandoRegistroParqueo = new ComandoRegistroParqueo();
		
		comandoRegistroParqueo.setId(this.id);
		comandoRegistroParqueo.setTipoVehiculo(this.tipoVehiculo);
		comandoRegistroParqueo.setPlaca(this.placa);
		comandoRegistroParqueo.setCilindraje(this.cilindraje);
		comandoRegistroParqueo.setFechaHoraIngreso(this.fechaHoraIngreso);
		comandoRegistroParqueo.setFechaHoraSalida(this.fechaHoraSalida); 
		comandoRegistroParqueo.setValorParqueo(this.valorParqueo); 
		comandoRegistroParqueo.setEstadoInOut(this.estadoInOut);
		
		return comandoRegistroParqueo;
	}
	
	public ComandoRegistroParqueo buildComando() {
		
		ComandoRegistroParqueo comandoRegistroParqueo = new ComandoRegistroParqueo(this.id, 
																					this.tipoVehiculo, 
																					this.placa, 
																					this.cilindraje, 
																					this.fechaHoraIngreso, 
																					this.fechaHoraSalida, 
																					this.valorParqueo, 
																					this.estadoInOut);
		
		return comandoRegistroParqueo;
	}
	
	public RegistroParqueoDto buildDto() {
		
		RegistroParqueoDto registroParqueoDto = new RegistroParqueoDto();
		
		registroParqueoDto.setId(this.id);
		registroParqueoDto.setTipoVehiculo(this.tipoVehiculo);
		registroParqueoDto.setPlaca(this.placa);
		registroParqueoDto.setCilindraje(this.cilindraje);
		registroParqueoDto.setFechaHoraIngreso(this.fechaHoraIngreso);
		registroParqueoDto.setFechaHoraSalida(this.fechaHoraSalida); 
		registroParqueoDto.setValorParqueo(this.valorParqueo); 
		registroParqueoDto.setEstadoInOut(this.estadoInOut);
		
		return registroParqueoDto;
	}
}
