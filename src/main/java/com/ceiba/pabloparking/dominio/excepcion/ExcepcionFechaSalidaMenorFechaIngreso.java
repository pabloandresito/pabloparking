package com.ceiba.pabloparking.dominio.excepcion;

public class ExcepcionFechaSalidaMenorFechaIngreso extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public ExcepcionFechaSalidaMenorFechaIngreso(String message) {
        super(message);
    }
}
