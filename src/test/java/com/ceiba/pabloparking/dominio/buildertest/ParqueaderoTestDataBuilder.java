package com.ceiba.pabloparking.dominio.buildertest;

import java.time.LocalDateTime;
import java.time.Month;

import com.ceiba.pabloparking.dominio.EstadoVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.RegistroParqueoEntidad;

public class ParqueaderoTestDataBuilder {
	
	private static final Integer TIPOVEHICULO = TipoVehiculo.MOTO.getIdTipoVehiculo();
	private static final String PLACA = "RRR888";
	private static final Integer CILINDRAJE = 300;
	
	// Especificar indicando año, mes, día, horas, minutos, segundos y milisegundos
	private static final LocalDateTime FECHAHORAINGRESO = LocalDateTime.of(2019, Month.JUNE, 4, 11, 23, 1);
	
	// Especificar indicando año, mes, día, horas, minutos, segundos y milisegundos
	private static final LocalDateTime FECHAHORASALIDA = LocalDateTime.of(2019, Month.JUNE, 5, 13, 30, 40);
	
	private static final Double VALORPARQUEO = 6000d;
	private static final Integer ESTADOINOUT = EstadoVehiculo.RETIRADO_PARQUEADERO.getIdEstado();
	
	private Integer tipoVehiculo;
	private String placa;
	private Integer cilindraje;
	private LocalDateTime fechaHoraIngreso;
	private LocalDateTime fechaHoraSalida;
	private Double valorParqueo;
	private Integer estadoInOut;
	
	public ParqueaderoTestDataBuilder() {
		this.tipoVehiculo = TIPOVEHICULO;
		this.placa = PLACA;
		this.cilindraje = CILINDRAJE;
		this.fechaHoraIngreso = FECHAHORAINGRESO;
		this.fechaHoraSalida = FECHAHORASALIDA;
		this.valorParqueo = VALORPARQUEO;
		this.estadoInOut = ESTADOINOUT;
	}
	
	public ParqueaderoTestDataBuilder withTipoVehiculo(Integer tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}

	public ParqueaderoTestDataBuilder withPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public ParqueaderoTestDataBuilder withCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}

	public ParqueaderoTestDataBuilder withFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
		this.fechaHoraIngreso = fechaHoraIngreso;
		return this;
	}

	public ParqueaderoTestDataBuilder withFechaHoraSalida(LocalDateTime fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
		return this;
	}

	public ParqueaderoTestDataBuilder withValorParqueo(Double valorParqueo) {
		this.valorParqueo = valorParqueo;
		return this;
	}

	public ParqueaderoTestDataBuilder withEstadoInOut(Integer estadoInOut) {
		this.estadoInOut = estadoInOut;
		return this;
	}

	public RegistroParqueo build() {
		return new RegistroParqueo(null, this.tipoVehiculo, this.placa, this.cilindraje, this.fechaHoraIngreso);
	}
	
	public RegistroParqueoEntidad buildEntity() {
		
		RegistroParqueoEntidad registroParqueoEntidad = new RegistroParqueoEntidad();
		
		registroParqueoEntidad.setTipoVehiculo(this.tipoVehiculo);
		registroParqueoEntidad.setPlaca(this.placa);
		registroParqueoEntidad.setCilindraje(this.cilindraje);
		registroParqueoEntidad.setFechaHoraIngreso(this.fechaHoraIngreso);
		registroParqueoEntidad.setFechaHoraSalida(this.fechaHoraSalida); 
		registroParqueoEntidad.setValorParqueo(this.valorParqueo); 
		registroParqueoEntidad.setEstadoInOut(this.estadoInOut);
		
		return registroParqueoEntidad;
	}
}
