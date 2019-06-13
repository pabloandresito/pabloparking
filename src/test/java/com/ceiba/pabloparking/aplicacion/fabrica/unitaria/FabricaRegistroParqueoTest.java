package com.ceiba.pabloparking.aplicacion.fabrica.unitaria;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.pabloparking.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.pabloparking.aplicacion.fabrica.FabricaRegistroParqueo;
import com.ceiba.pabloparking.dominio.EstadoVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.dominio.buildertest.RegistroParqueoTestDataBuilder;
import com.ceiba.pabloparking.infraestructura.controller.dto.RegistroParqueoDto;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.RegistroParqueoEntidad;

@RunWith(SpringRunner.class)
public class FabricaRegistroParqueoTest {
	
	private static final Integer TIPOVEHICULO = TipoVehiculo.MOTO.getIdTipoVehiculo();
	private static final String PLACA = "MSQ253";
	private static final Integer CILINDRAJE = 200;
	
	// Especificar indicando año, mes, día, horas, minutos, segundos y milisegundos
	private static final LocalDateTime FECHAHORAINGRESO = LocalDateTime.of(2019, Month.JUNE, 4, 13, 30, 0);
	
	// Especificar indicando año, mes, día, horas, minutos, segundos y milisegundos
	private static final LocalDateTime FECHAHORASALIDA = LocalDateTime.of(2019, Month.JUNE, 4, 14, 12, 41);
	private static final Double VALORPARQUEO = 5000d;
	private static final Integer ESTADOINOUT = EstadoVehiculo.RETIRADO_PARQUEADERO.getIdEstado();
	
	@InjectMocks
	FabricaRegistroParqueo fabricaRegistroParqueo;
	
	@Test
	public void convertirComandoADominioTest() {
		
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
		
		 RegistroParqueo registroParqueo = fabricaRegistroParqueo.convertirComandoADominio(comandoRegistroParqueo);

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
	public void convertirComandoADominioBySettersTest() {
		
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
		ComandoRegistroParqueo comandoRegistroParqueo = registroParqueoTestDataBuilder.buildComandoBySetters();
		
		 RegistroParqueo registroParqueo = fabricaRegistroParqueo.convertirComandoADominio(comandoRegistroParqueo);

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
	public void convertirEntityADominioTest() {
		
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
		
		 RegistroParqueo registroParqueo = fabricaRegistroParqueo.convertirEntityADominio(registroParqueoEntidad);

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
	public void convertirDominoAEntityTest() {
		
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
		
		RegistroParqueoEntidad registroParqueoEntidad = fabricaRegistroParqueo.convertirDominoAEntity(registroParqueo);

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
	public void convertirDtoADominioTest() {
		
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
		
		RegistroParqueo registroParqueo = fabricaRegistroParqueo.convertirDtoADominio(registroParqueoDto);

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
