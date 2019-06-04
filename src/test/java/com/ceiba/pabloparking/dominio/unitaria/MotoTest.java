package com.ceiba.pabloparking.dominio.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ceiba.pabloparking.dominio.Moto;
import com.ceiba.pabloparking.dominio.buildertest.MotoTestDataBuilder;

public class MotoTest {

	private static final String PLACA = "MSO252";
	private static final Integer CILINDRAJE = 200;

	@Test
	public void crearMotoTest() {
		
		// arrange
		MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().
				conPlaca(PLACA).
				conCilindraje(CILINDRAJE);

		// act
		Moto moto = motoTestDataBuilder.build();

		// assert
		assertEquals(PLACA, moto.getPlaca());
		assertEquals(CILINDRAJE, moto.getCilindraje());
	}

}
