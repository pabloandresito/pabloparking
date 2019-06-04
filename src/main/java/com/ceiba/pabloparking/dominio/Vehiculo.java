package com.ceiba.pabloparking.dominio;

public abstract class Vehiculo {
	
	private String placa;
	
	public abstract void calcularPrecioParqueo();

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
