package com.ceiba.pabloparking.infraestructura.persistencia.entidad.builder;

import com.ceiba.pabloparking.dominio.Moto;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.MotoEntidad;

public class MotoBuilder {

	private MotoBuilder() {}
	
	public static Moto convertirADominio(MotoEntidad motoEntidad) {
		
		Moto moto = null;
		
		if(motoEntidad != null) {
			moto = new Moto(motoEntidad.getPlaca(), motoEntidad.getCilindraje());
		}
		
		return moto;
	}
	
	public static MotoEntidad convertirAEntity(Moto moto) {
		
		MotoEntidad motoEntidad = new MotoEntidad();
		
		motoEntidad.setPlaca(moto.getPlaca());
		motoEntidad.setCilindraje(moto.getCilindraje());
		
		return motoEntidad;
	}
}
