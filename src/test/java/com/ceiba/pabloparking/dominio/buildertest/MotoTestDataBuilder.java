package com.ceiba.pabloparking.dominio.buildertest;

import com.ceiba.pabloparking.dominio.Moto;

public class MotoTestDataBuilder {

	private static final String PLACA= "MSO814";
	private static final Integer CILINDRAJE = 250;
	
	private String placa;
	private Integer cilindraje;
	
	public MotoTestDataBuilder() {
		this.placa = PLACA;
		this.cilindraje = CILINDRAJE;
		
	}

	public MotoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public MotoTestDataBuilder conCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}

	public Moto build() {
		return new Moto(this.placa, this.cilindraje);
	}
}
