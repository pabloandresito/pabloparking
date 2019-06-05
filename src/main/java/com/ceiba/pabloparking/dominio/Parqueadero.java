package com.ceiba.pabloparking.dominio;

import org.joda.time.DateTime;

public class Parqueadero {
	// TODO probles - Cambiar nombre de la clase
	
	private Integer tipoVehiculo;
	private String placa;
	private Integer cilindraje;
	private DateTime fechaHoraIngreso;
	private DateTime fechaHoraSalida;
	private Double valorParqueo;
	private Integer estadoInOut;
	private Long idVigilante;

	public Parqueadero(Integer tipoVehiculo, String placa, Integer cilindraje, DateTime fechaHoraIngreso,
			DateTime fechaHoraSalida, Double valorParqueo, Integer estadoInOut, Long idVigilante) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.fechaHoraIngreso = fechaHoraIngreso;
		this.fechaHoraSalida = fechaHoraSalida;
		this.valorParqueo = valorParqueo;
		this.estadoInOut = estadoInOut;
		this.idVigilante = idVigilante;
		// TODO probles - Se debe validar atributos por ejemplo las fechas y tener atributos consistentes
	}



	public Integer getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(Integer tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	} // TODO probles - No es necesario tener eeste set debido a que debemos representar la realidad 

	public Integer getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	public DateTime getFechaHoraIngreso() {
		return fechaHoraIngreso;
	}

	public void setFechaHoraIngreso(DateTime fechaHoraIngreso) {
		this.fechaHoraIngreso = fechaHoraIngreso;
	}

	public DateTime getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(DateTime fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public Double getValorParqueo() {
		return valorParqueo;
	}

	public void setValorParqueo(Double valorParqueo) {
		this.valorParqueo = valorParqueo;
	}

	public Integer getEstadoInOut() {
		return estadoInOut;
	}

	public void setEstadoInOut(Integer estadoInOut) {
		this.estadoInOut = estadoInOut;
	}

	public Long getIdVigilante() {
		return idVigilante;
	}

	public void setIdVigilante(Long idVigilante) {
		this.idVigilante = idVigilante;
	}
}
