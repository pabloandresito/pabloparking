package com.ceiba.pabloparking.dominio.unitaria;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

import com.ceiba.pabloparking.dominio.EstadoVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.dominio.buildertest.RegistroParqueoTestDataBuilder;

public class RegistroParqueoTest {
	
	private static final Integer TIPOVEHICULO = TipoVehiculo.MOTO.getIdTipoVehiculo();
	private static final String PLACA = "MSQ253";
	private static final Integer CILINDRAJE = 200;
	
	// Especificar indicando año, mes, día, horas, minutos, segundos y milisegundos
	private static final LocalDateTime FECHAHORAINGRESO = LocalDateTime.of(2019, Month.JUNE, 4, 13, 30, 0);
	
	// Especificar indicando año, mes, día, horas, minutos, segundos y milisegundos
	private static final LocalDateTime FECHAHORASALIDA = LocalDateTime.of(2019, Month.JUNE, 4, 14, 12, 41);
	private static final Double VALORPARQUEO = 5000d;
	private static final Integer ESTADOINOUT = EstadoVehiculo.RETIRADO_PARQUEADERO.getIdEstado();
	
	@Test
	public void crearRegistroParqueoTest() {
		
		// arrange
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
				withTipoVehiculo(TIPOVEHICULO).
				withPlaca(PLACA).
				withCilindraje(CILINDRAJE).
				withFechaHoraIngreso(FECHAHORAINGRESO).
				withFechaHoraSalida(FECHAHORASALIDA).
				withValorParqueo(VALORPARQUEO).
				withEstadoInOut(ESTADOINOUT);

		// act
		RegistroParqueo registroParqueo = registroParqueoTestDataBuilder.build();

		// assert
		assertEquals(TIPOVEHICULO, registroParqueo.getTipoVehiculo());
		assertEquals(PLACA, registroParqueo.getPlaca());
		assertEquals(CILINDRAJE, registroParqueo.getCilindraje());
		assertEquals(FECHAHORAINGRESO, registroParqueo.getFechaHoraIngreso());
		assertEquals(FECHAHORASALIDA, registroParqueo.getFechaHoraSalida());
		assertEquals(VALORPARQUEO, registroParqueo.getValorParqueo());
		assertEquals(ESTADOINOUT, registroParqueo.getEstadoInOut());
	}
}
