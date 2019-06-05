package com.ceiba.pabloparking.dominio;

public class Moto {
	
	private String placa;
	private Integer cilindraje;

	public Moto(String placa, Integer cilindraje) {
		this.placa = placa;
		this.cilindraje = cilindraje;
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

	public void calcularPrecioParqueo() {
		
	}

}
