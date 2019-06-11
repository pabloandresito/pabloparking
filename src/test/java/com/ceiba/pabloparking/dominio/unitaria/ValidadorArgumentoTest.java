package com.ceiba.pabloparking.dominio.unitaria;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

import com.ceiba.pabloparking.dominio.excepcion.ExcepcionFechaSalidaMenorFechaIngreso;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pabloparking.dominio.validacion.ValidadorArgumento;

public class ValidadorArgumentoTest {
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void validarObligatorioConNullTest() {
		ValidadorArgumento.validarObligatorio(null, "");
    }
	
	@Test(expected = ExcepcionLongitudValor.class)
	public void validarLongitudConStringTest() {
		ValidadorArgumento.validarLongitud("1", 2, "");
    }
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void validarNoVacioStringTest() {
		ValidadorArgumento.validarNoVacioString("", "");
    }
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void validarNoVacioStringConEspacioTest() {
		ValidadorArgumento.validarNoVacioString(" ", "");
    }
	
	@Test(expected = ExcepcionValorInvalido.class)
	public void validarPositivoTest() {
		ValidadorArgumento.validarPositivo(-1d, "");
    }
	
	@Test(expected = ExcepcionValorInvalido.class)
	public void validarNoLunesNiDomingoPlacaIniciaConATest() {
		
		String PlacaIniciaConA = "AMF852";
		LocalDateTime fechaIngresoMartes = LocalDateTime.of(2019, Month.JUNE, 11, 14, 12, 41);
		
		// arrange
		ValidadorArgumento.validarNoLunesNiDomingoPlacaIniciaConA(PlacaIniciaConA, fechaIngresoMartes, "");

		// See assert on annotation
	}
	
	@Test
	public void validarPlacaIniciaConATest() {
		
		String placaIniciaConA = "AMF852";
		String placaNOIniciaConA = "BMF852";
		
		// arrange
		boolean booleanPlacaIniciaConA = ValidadorArgumento.validarPlacaIniciaConA(placaIniciaConA);
		boolean booleanPlacaNoIniciaConA = ValidadorArgumento.validarPlacaIniciaConA(placaNOIniciaConA);

		// assert
		assertTrue(booleanPlacaIniciaConA);
		assertFalse(booleanPlacaNoIniciaConA);
	}
	
	@Test(expected = ExcepcionFechaSalidaMenorFechaIngreso.class)
	public void crearFechaSalidaMenorQueFechaIngresoTest() {
		
		LocalDateTime fechaIngreso = LocalDateTime.of(2019, Month.JUNE, 11, 14, 12, 41);
		LocalDateTime fechaSalidaMenorQueIngreso = LocalDateTime.of(2019, Month.JUNE, 10, 14, 12, 41);
		
		// arrange
		ValidadorArgumento.validarFechaIngresoYFechaSalida(fechaIngreso, fechaSalidaMenorQueIngreso, "");

		// See assert on annotation
	}
}
