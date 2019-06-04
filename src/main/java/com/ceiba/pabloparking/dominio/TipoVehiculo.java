package com.ceiba.pabloparking.dominio;

public enum TipoVehiculo {
	CARRO(1, "Carro"), MOTO(2, "Moto");

    private final int idTipoVehiculo;
    private final String valor;

    TipoVehiculo(int idTipoVehiculo, String valor) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.valor = valor;
    }

	public int getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public String getValor() {
		return valor;
	}
}
