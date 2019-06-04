package com.ceiba.pabloparking.dominio;

public class Moto extends Vehiculo {
	
	private Integer cilindraje;

	public Moto(String placa, Integer cilindraje) {
		this.setPlaca(placa);
		this.cilindraje = cilindraje;
	}

	public Integer getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}

	@Override
	public void calcularPrecioParqueo() {
		
	}

}
