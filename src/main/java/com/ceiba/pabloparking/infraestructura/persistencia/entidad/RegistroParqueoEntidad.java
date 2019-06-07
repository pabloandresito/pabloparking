package com.ceiba.pabloparking.infraestructura.persistencia.entidad;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Parqueadero")
public class ParqueaderoEntidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Integer tipoVehiculo;
	
	@Column(nullable = false)
	private String placa;
	
	@Column
	private Integer cilindraje;
	
	@Column(nullable = false)
	private LocalDateTime fechaHoraIngreso;
	
	@Column
	private LocalDateTime fechaHoraSalida;
	
	@Column
	private Double valorParqueo;
	
	@Column(nullable = false)
	private Integer estadoInOut;
	
	public ParqueaderoEntidad() {
		super();
	}

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
