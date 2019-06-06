package com.ceiba.pabloparking.dominio.repositorio;

import com.ceiba.pabloparking.dominio.RegistroParqueo;

public interface RepositorioRegistroParqueo {
	
	/**
	 * Permite crear un RegistroParqueo
	 * @param registroParqueo
	 * @return el id generado
	 */
    Long crear(RegistroParqueo registroParqueo);
    
    /**
	 * Permite actualizar un registroParqueo
	 * @param registroParqueo
	 */
    void actualizar(RegistroParqueo registroParqueo);
    
    /**
     * Permite eliminar un registroParqueo
     * @param id
     */
    void eliminar(Long id);
   
    /**
     * Permite validar si existe un carro en el parqueadero con una placa especifica y que este ingresado (No Retirado)
     * @param placa
     * @return si existe o no
     */
	boolean existeIngresado(String placa);
}
