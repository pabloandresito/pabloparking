package com.ceiba.pabloparking.dominio;

public enum EstadoVehiculo {
	INGRESADO_PARQUEADERO(1, "Ingresado"), RETIRADO_PARQUEADERO(2, "Retirado");

    private final int idEstado;
    private final String estado;

    EstadoVehiculo(int idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }

	public int getIdEstado() {
		return idEstado;
	}

	public String getEstado() {
		return estado;
	}
}
