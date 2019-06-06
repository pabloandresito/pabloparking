package com.ceiba.pabloparking.dominio.unitaria;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.Test;

import com.ceiba.pabloparking.dominio.EstadoVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.dominio.buildertest.ParqueaderoTestDataBuilder;

public class ParqueaderoTest {
	
	private static final Integer TIPOVEHICULO = TipoVehiculo.MOTO.getIdTipoVehiculo();
	private static final String PLACA = "MSQ253";
	private static final Integer CILINDRAJE = 200;
	
	// Especificar indicando año, mes, día, horas, minutos, segundos y milisegundos
	private static final DateTime FECHAHORAINGRESO = new DateTime(2019, 6, 4, 13, 30, 0, 0);
	
	// Especificar indicando año, mes, día, horas, minutos, segundos y milisegundos
	private static final DateTime FECHAHORASALIDA = new DateTime(2019, 6, 4, 14, 12, 0, 0);
	private static final Double VALORPARQUEO = 5000d;
	private static final Integer ESTADOINOUT = EstadoVehiculo.RETIRADO_PARQUEADERO.getIdEstado();
	
	@Test
	public void crearParqueaderoTest() {
		
		// arrange
		ParqueaderoTestDataBuilder parqueaderoTestDataBuilder = new ParqueaderoTestDataBuilder().
				withTipoVehiculo(TIPOVEHICULO).
				withPlaca(PLACA).
				withCilindraje(CILINDRAJE).
				withFechaHoraIngreso(FECHAHORAINGRESO).
				withFechaHoraSalida(FECHAHORASALIDA).
				withValorParqueo(VALORPARQUEO).
				withEstadoInOut(ESTADOINOUT);

		// act
		RegistroParqueo parqueadero = parqueaderoTestDataBuilder.build();

		// assert
		assertEquals(TIPOVEHICULO, parqueadero.getTipoVehiculo());
		assertEquals(PLACA, parqueadero.getPlaca());
		assertEquals(CILINDRAJE, parqueadero.getCilindraje());
		assertEquals(FECHAHORAINGRESO, parqueadero.getFechaHoraIngreso());
		assertEquals(FECHAHORASALIDA, parqueadero.getFechaHoraSalida());
		assertEquals(VALORPARQUEO, parqueadero.getValorParqueo());
		assertEquals(ESTADOINOUT, parqueadero.getEstadoInOut());
	}
}
