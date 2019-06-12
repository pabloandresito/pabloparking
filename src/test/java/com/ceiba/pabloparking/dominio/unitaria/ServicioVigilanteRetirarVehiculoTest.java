package com.ceiba.pabloparking.dominio.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.pabloparking.dominio.servicio.ServicioVigilanteRetirarVehiculo;

@RunWith(SpringRunner.class)
public class ServicioVigilanteRetirarVehiculoTest {
	
	@InjectMocks
	private ServicioVigilanteRetirarVehiculo vigilanteRetirarVehiculoMock;
	
	@Test
	public void calcularValorParqueoCarroConHorasRestantesCeroTest() {
		double diasPorCobrar = 5d;
		double horasRestantesPorCobrarEnCero = 0d; // Este siempre debe tener valor cero para esta prueba especifica
		
		double valorParqueoCarro = vigilanteRetirarVehiculoMock.calcularValorParqueoCarro(diasPorCobrar, horasRestantesPorCobrarEnCero);
		
		assertEquals((diasPorCobrar * vigilanteRetirarVehiculoMock.valorDiaCarro), valorParqueoCarro, 0d);
	}
	
	@Test
	public void calcularValorParqueoCarroConHorasRestantesMayorAlLimiteDia() {
		double diasPorCobrar = 5d;
		double horasRestantesPorCobrar = vigilanteRetirarVehiculoMock.horaDeInicioParaCobroDeDiaCompleto + 1d;
		
		double valorParqueoCarro = vigilanteRetirarVehiculoMock.calcularValorParqueoCarro(diasPorCobrar, horasRestantesPorCobrar);
		
		assertEquals( (diasPorCobrar * vigilanteRetirarVehiculoMock.valorDiaCarro) + (vigilanteRetirarVehiculoMock.valorDiaCarro), valorParqueoCarro, 0d);
	}
	
	@Test
	public void calcularValorParqueoMotoConHorasRestantesCeroTest() {
		double diasPorCobrar = 5d;
		double horasRestantesPorCobrarEnCero = 0d; // Este siempre debe tener valor cero para esta prueba especifica
		int cilindraje = 1;
		
		double valorParqueoCarro = vigilanteRetirarVehiculoMock.calcularValorParqueoMoto(diasPorCobrar, horasRestantesPorCobrarEnCero, cilindraje);
		
		assertEquals((diasPorCobrar * vigilanteRetirarVehiculoMock.valorDiaMoto), valorParqueoCarro, 0d);
	}
	
	@Test
	public void calcularValorParqueoMotoConHorasRestantesMayorAlLimiteDia() {
		double diasPorCobrar = 5d;
		double horasRestantesPorCobrar = vigilanteRetirarVehiculoMock.horaDeInicioParaCobroDeDiaCompleto + 1d;
		int cilindraje = 1;
		
		double valorParqueoCarro = vigilanteRetirarVehiculoMock.calcularValorParqueoMoto(diasPorCobrar, horasRestantesPorCobrar, cilindraje);
		
		assertEquals( (diasPorCobrar * vigilanteRetirarVehiculoMock.valorDiaMoto) + (vigilanteRetirarVehiculoMock.valorDiaMoto), valorParqueoCarro, 0d);
	}
	
	@Test
	public void calcularValorParqueoMotoConHorasRestantesMayorAlLimiteDiaYMaxCilingraje() {
		double diasPorCobrar = 5d;
		double horasRestantesPorCobrar = vigilanteRetirarVehiculoMock.horaDeInicioParaCobroDeDiaCompleto + 1d;
		int cilindrajeSuperiorAlMaximo = vigilanteRetirarVehiculoMock.valorLimiteCilindrajeParaCobroExcedenteMoto + 1;
		
		double valorParqueoCarro = vigilanteRetirarVehiculoMock.calcularValorParqueoMoto(diasPorCobrar, horasRestantesPorCobrar, cilindrajeSuperiorAlMaximo);
		
		assertEquals( (diasPorCobrar * vigilanteRetirarVehiculoMock.valorDiaMoto) + (vigilanteRetirarVehiculoMock.valorDiaMoto) + (vigilanteRetirarVehiculoMock.valorExcedenteMotoMayor500CC), valorParqueoCarro, 0d);
	}
}