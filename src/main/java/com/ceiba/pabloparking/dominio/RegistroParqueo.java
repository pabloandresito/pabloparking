package com.ceiba.pabloparking.dominio;

import java.time.LocalDateTime;

import com.ceiba.pabloparking.dominio.validacion.ValidadorArgumento;

public class RegistroParqueo {
	
	private static final String OBLIGATORIO_TIPO_VEHICULO = "Se debe ingresar el tipo de vehiculo.";
	private static final String NO_VACIO_PLACA = "Se debe ingresar la placa del vehiculo.";
	private static final String PLACA_INICIA_CON_A_NO_LUNES_NI_DOMINGO = "La placa inicia por la letra A, por lo tanto no puede ingresar porque no está en un dia hábil.";
	private static final String OBLIGATORIO_CILINDRAJE_MOTO = "Se debe ingresar el cilindraje de la moto.";
	private static final String POSITIVO_CILINDRAJE_MOTO = "Se debe ingresar un cilindraje mayor que cero.";
	private static final String OBLIGATORIO_FECHA_INGRESO = "Se debe llenar la fecha de ingreso.";
	private static final String FECHA_DE_SALIDA_MENOR_A_FECHA_DE_INGRESO = "La fecha de salida no puede ser menor a la fecha de ingreso.";
	
	private Long id;
	private Integer tipoVehiculo;
	private String placa;
	private Integer cilindraje;
	private LocalDateTime fechaHoraIngreso;
	private LocalDateTime fechaHoraSalida;
	private Double valorParqueo;
	private Integer estadoInOut;
	
	public RegistroParqueo(Long id, Integer tipoVehiculo, String placa, Integer cilindraje, LocalDateTime fechaHoraIngreso) {
		
		// Validar fechaHoraIngreso
		ValidadorArgumento.validarObligatorio(fechaHoraIngreso, OBLIGATORIO_FECHA_INGRESO);
		
		// Validar tipoVehiculo
		ValidadorArgumento.validarObligatorio(tipoVehiculo, OBLIGATORIO_TIPO_VEHICULO);
		
		// Validar placa
		ValidadorArgumento.validarNoVacioString(placa, NO_VACIO_PLACA);
		ValidadorArgumento.validarNoLunesNiDomingoPlacaIniciaConA(placa, fechaHoraIngreso, PLACA_INICIA_CON_A_NO_LUNES_NI_DOMINGO);
		
		// Validar cilindraje
		if(tipoVehiculo == TipoVehiculo.MOTO.getIdTipoVehiculo()) {
			ValidadorArgumento.validarObligatorio(cilindraje, OBLIGATORIO_CILINDRAJE_MOTO);
			ValidadorArgumento.validarPositivo(Double.valueOf(cilindraje), POSITIVO_CILINDRAJE_MOTO);
			
		} else { // Si el Vehiculo no es una moto entonces nos aseguramos que el cilindraje este null
			cilindraje = null;
		}

		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.fechaHoraIngreso = fechaHoraIngreso;
		this.fechaHoraSalida = null;
		this.valorParqueo = null;
		this.estadoInOut = EstadoVehiculo.INGRESADO_PARQUEADERO.getIdEstado();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTipoVehiculo() {
		return tipoVehiculo;
	}// A nivel de negocio no se debe poder modificar el tipo de vehiculo y por esta razon se quita el metodo SET

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
		if(fechaHoraSalida != null) {
			ValidadorArgumento.validarFechaIngresoYFechaSalida(this.fechaHoraIngreso, fechaHoraSalida, FECHA_DE_SALIDA_MENOR_A_FECHA_DE_INGRESO);
		}
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
