package com.ceiba.pabloparking.infraestructura.controller.dto;

import java.time.LocalDateTime;

public class RegistroParqueoDto {
	
	private Long id;
	
	// TODO probles - Probar obligatoriedad del atributo en la petición usando @notnull
	private Integer tipoVehiculo;
	private String placa;
	private Integer cilindraje;
	private LocalDateTime fechaHoraIngreso;
	private LocalDateTime fechaHoraSalida;
	private Double valorParqueo;
	private Integer estadoInOut;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	}
	
	public Integer getCilindraje() {
		return cilindraje;
	}
	
	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	public LocalDateTime getFechaHoraIngreso() {
		return fechaHoraIngreso;
	}
	
	public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
		this.fechaHoraIngreso = fechaHoraIngreso;
	}
	
	public LocalDateTime getFechaHoraSalida() {
		return fechaHoraSalida;
	}
	
	public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
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

}
