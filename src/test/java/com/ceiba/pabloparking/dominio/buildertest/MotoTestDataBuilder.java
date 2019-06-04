package com.ceiba.pabloparking.dominio.buildertest;

import com.ceiba.pabloparking.dominio.Moto;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.MotoEntidad;

public class MotoTestDataBuilder {

	private static final String PLACA= "MSO814";
	private static final Integer CILINDRAJE = 250;
	
	private String placa;
	private Integer cilindraje;
	
	public MotoTestDataBuilder() {
		this.placa = PLACA;
		this.cilindraje = CILINDRAJE;
		
	}

	public MotoTestDataBuilder withPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public MotoTestDataBuilder withCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}

	public Moto build() {
		return new Moto(this.placa, this.cilindraje);
	}
	
	public MotoEntidad buildEntity() {
		
		MotoEntidad motoEntidad = new MotoEntidad();
		
		motoEntidad.setPlaca(this.placa);
		motoEntidad.setCilindraje(this.cilindraje);
		
		return motoEntidad;
	}
}
