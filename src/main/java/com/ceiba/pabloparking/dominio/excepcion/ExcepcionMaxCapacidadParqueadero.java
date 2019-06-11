package com.ceiba.pabloparking.dominio.excepcion;

public class ExcepcionMaxCapacidadParqueadero extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionMaxCapacidadParqueadero(String mensaje) {
        super(mensaje);
    }
}
