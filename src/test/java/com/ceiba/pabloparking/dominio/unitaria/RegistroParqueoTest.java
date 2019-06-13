package com.ceiba.pabloparking.dominio.unitaria;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

import com.ceiba.pabloparking.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.pabloparking.dominio.EstadoVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.dominio.buildertest.RegistroParqueoTestDataBuilder;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionFechaSalidaMenorFechaIngreso;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pabloparking.infraestructura.controller.dto.RegistroParqueoDto;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.RegistroParqueoEntidad;

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
	
	@Test
	public void crearRegistroParqueoEntidadTest() {
		
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
		RegistroParqueoEntidad registroParqueoEntidad = registroParqueoTestDataBuilder.buildEntity();

		// assert
		assertEquals(TIPOVEHICULO, registroParqueoEntidad.getTipoVehiculo());
		assertEquals(PLACA, registroParqueoEntidad.getPlaca());
		assertEquals(CILINDRAJE, registroParqueoEntidad.getCilindraje());
		assertEquals(FECHAHORAINGRESO, registroParqueoEntidad.getFechaHoraIngreso());
		assertEquals(FECHAHORASALIDA, registroParqueoEntidad.getFechaHoraSalida());
		assertEquals(VALORPARQUEO, registroParqueoEntidad.getValorParqueo());
		assertEquals(ESTADOINOUT, registroParqueoEntidad.getEstadoInOut());
	}
	
	@Test
	public void crearRegistroParqueoComandoTest() {
		
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
		ComandoRegistroParqueo comandoRegistroParqueo = registroParqueoTestDataBuilder.buildComando();

		// assert
		assertEquals(TIPOVEHICULO, comandoRegistroParqueo.getTipoVehiculo());
		assertEquals(PLACA, comandoRegistroParqueo.getPlaca());
		assertEquals(CILINDRAJE, comandoRegistroParqueo.getCilindraje());
		assertEquals(FECHAHORAINGRESO, comandoRegistroParqueo.getFechaHoraIngreso());
		assertEquals(FECHAHORASALIDA, comandoRegistroParqueo.getFechaHoraSalida());
		assertEquals(VALORPARQUEO, comandoRegistroParqueo.getValorParqueo());
		assertEquals(ESTADOINOUT, comandoRegistroParqueo.getEstadoInOut());
	}
	
	@Test
	public void crearRegistroParqueoDtoTest() {
		
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
		RegistroParqueoDto registroParqueoDto = registroParqueoTestDataBuilder.buildDto();

		// assert
		assertEquals(TIPOVEHICULO, registroParqueoDto.getTipoVehiculo());
		assertEquals(PLACA, registroParqueoDto.getPlaca());
		assertEquals(CILINDRAJE, registroParqueoDto.getCilindraje());
		assertEquals(FECHAHORAINGRESO, registroParqueoDto.getFechaHoraIngreso());
		assertEquals(FECHAHORASALIDA, registroParqueoDto.getFechaHoraSalida());
		assertEquals(VALORPARQUEO, registroParqueoDto.getValorParqueo());
		assertEquals(ESTADOINOUT, registroParqueoDto.getEstadoInOut());
	}
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void crearConFechaHoraIngresoNullTest() {
		
		// arrange
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
				withFechaHoraIngreso(null);

		// act
		registroParqueoTestDataBuilder.build();

		// See assert on annotation
	}
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void crearConTipoVehiculoNullTest() {
		
		// arrange
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
				withTipoVehiculo(null);

		// act
		registroParqueoTestDataBuilder.build();

		// See assert on annotation
	}
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void crearConPlacaNullTest() {
		
		// arrange
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
				withPlaca(null);

		// act
		registroParqueoTestDataBuilder.build();

		// See assert on annotation
	}
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void crearConPlacaStringVacioTest() {
		
		// arrange
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
				withPlaca("");

		// act
		registroParqueoTestDataBuilder.build();

		// See assert on annotation
	}
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void crearConPlacaStringVacioYEspacioTest() {
		
		// arrange
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
				withPlaca(" ");

		// act
		registroParqueoTestDataBuilder.build();

		// See assert on annotation
	}
	
	@Test(expected = ExcepcionValorInvalido.class)
	public void crearConPlacaIniciaConAyEsMartesTest() {
		
		String placaIniciaConA = "AMF852";
		LocalDateTime fechaIngresoMartes = LocalDateTime.of(2019, Month.JUNE, 11, 14, 12, 41);
		
		// arrange
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
				withPlaca(placaIniciaConA).
				withFechaHoraIngreso(fechaIngresoMartes);

		// act
		registroParqueoTestDataBuilder.build();

		// See assert on annotation
	}
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void crearCilindrajeNoVacioParaMotoTest() {
		
		// arrange
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
				withTipoVehiculo(TipoVehiculo.MOTO.getIdTipoVehiculo()).
				withCilindraje(null);

		// act
		registroParqueoTestDataBuilder.build();
		
		// See assert on annotation
	}
	
	@Test(expected = ExcepcionFechaSalidaMenorFechaIngreso.class)
	public void crearFechaSalidaMenorQueFechaIngresoTest() {
		
		LocalDateTime fechaIngreso = LocalDateTime.of(2019, Month.JUNE, 11, 14, 12, 41);
		LocalDateTime fechaSalidaMenorQueIngreso = LocalDateTime.of(2019, Month.JUNE, 10, 14, 12, 41);
		
		// arrange
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
				withFechaHoraIngreso(fechaIngreso).
				withFechaHoraSalida(fechaSalidaMenorQueIngreso);

		// act
		registroParqueoTestDataBuilder.build();
		
		// See assert on annotation
	}
}
