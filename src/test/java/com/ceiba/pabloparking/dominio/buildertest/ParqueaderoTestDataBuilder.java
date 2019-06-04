package com.ceiba.pabloparking.dominio.buildertest;

import org.joda.time.DateTime;

import com.ceiba.pabloparking.dominio.EstadoVehiculo;
import com.ceiba.pabloparking.dominio.Parqueadero;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.ParqueaderoEntidad;

public class ParqueaderoTestDataBuilder {
	
	private static final Integer TIPOVEHICULO = TipoVehiculo.MOTO.getIdTipoVehiculo();
	private static final String PLACA = "RRR888";
	private static final Integer CILINDRAJE = 300;
	
	// Especificar indicando año, mes, día, horas, minutos, segundos y milisegundos
	private static final DateTime FECHAHORAINGRESO = new DateTime(2019, 5, 4, 11, 30, 0, 0);
	
	// Especificar indicando año, mes, día, horas, minutos, segundos y milisegundos
	private static final DateTime FECHAHORASALIDA = new DateTime(2019, 5, 5, 13, 10, 0, 0);
	private static final Double VALORPARQUEO = 6000d;
	private static final Integer ESTADOINOUT = EstadoVehiculo.RETIRADO_PARQUEADERO.getIdEstado();
	private static final Long IDVIGILANTE = 1l;
	
	private Integer tipoVehiculo;
	private String placa;
	private Integer cilindraje;
	private DateTime fechaHoraIngreso;
	private DateTime fechaHoraSalida;
	private Double valorParqueo;
	private Integer estadoInOut;
	private Long idVigilante;
	
	public ParqueaderoTestDataBuilder() {
		this.tipoVehiculo = TIPOVEHICULO;
		this.placa = PLACA;
		this.cilindraje = CILINDRAJE;
		this.fechaHoraIngreso = FECHAHORAINGRESO;
		this.fechaHoraSalida = FECHAHORASALIDA;
		this.valorParqueo = VALORPARQUEO;
		this.estadoInOut = ESTADOINOUT;
		this.idVigilante = IDVIGILANTE;	
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

	public ParqueaderoTestDataBuilder withFechaHoraIngreso(DateTime fechaHoraIngreso) {
		this.fechaHoraIngreso = fechaHoraIngreso;
		return this;
	}

	public ParqueaderoTestDataBuilder withFechaHoraSalida(DateTime fechaHoraSalida) {
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

	public ParqueaderoTestDataBuilder withIdVigilante(Long idVigilante) {
		this.idVigilante = idVigilante;
		return this;
	}

	public Parqueadero build() {
		return new Parqueadero(this.tipoVehiculo, this.placa, this.cilindraje, this.fechaHoraIngreso, this.fechaHoraSalida, 
																			this.valorParqueo, this.estadoInOut, this.idVigilante);
	}
	
	public ParqueaderoEntidad buildEntity() {
		
		ParqueaderoEntidad parqueaderoEntidad = new ParqueaderoEntidad();
		
		parqueaderoEntidad.setTipoVehiculo(this.tipoVehiculo);
		parqueaderoEntidad.setPlaca(this.placa);
		parqueaderoEntidad.setCilindraje(this.cilindraje);
		parqueaderoEntidad.setFechaHoraIngreso(this.fechaHoraIngreso);
		parqueaderoEntidad.setFechaHoraSalida(this.fechaHoraSalida); 
		parqueaderoEntidad.setValorParqueo(this.valorParqueo); 
		parqueaderoEntidad.setEstadoInOut(this.estadoInOut);
		parqueaderoEntidad.setIdVigilante(this.idVigilante);
		
		return parqueaderoEntidad;
	}
}
