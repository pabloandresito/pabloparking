package com.ceiba.pabloparking.infraestructura.persistencia.dao;

import com.ceiba.pabloparking.dominio.Moto;

public interface MotoDao {
		
	/**
	 * Permite obtener una moto dado un placa
	 * @param placa
	 * @return
	 */
	public Moto obtenerPorPlaca(String placa);

	/**
	 * Permite agregar una moto
	 * @param moto
	 */
	public void agregar(Moto moto);

}
