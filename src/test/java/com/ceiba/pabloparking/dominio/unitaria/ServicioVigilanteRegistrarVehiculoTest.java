package com.ceiba.pabloparking.dominio.unitaria;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.pabloparking.dominio.EstadoVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.dominio.buildertest.RegistroParqueoTestDataBuilder;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionMaxCapacidadParqueadero;
import com.ceiba.pabloparking.dominio.repositorio.RepositorioRegistroParqueo;
import com.ceiba.pabloparking.dominio.servicio.ServicioVigilanteRegistrarVehiculo;

@RunWith(SpringRunner.class)
public class ServicioVigilanteRegistrarVehiculoTest {
	
private static final String PLACA = "TTO567";
	
	@Mock
	private RepositorioRegistroParqueo repositorioRegistroParqueoMock;
	
	@InjectMocks
	private ServicioVigilanteRegistrarVehiculo servicioVigilanteRegistrarVehiculoMock;
	
	@Test
	public void ejecutarCrearRegistroparqueoTest() {
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
																		withPlaca(PLACA).
																		withEstadoInOut(EstadoVehiculo.INGRESADO_PARQUEADERO.getIdEstado());
		
		RegistroParqueo registroParqueo = registroParqueoTestDataBuilder.build();
		Long idNuevoRegistroParqueo = servicioVigilanteRegistrarVehiculoMock.ejecutar(registroParqueo);
		
		assertNotNull(idNuevoRegistroParqueo);
	}
	
	@Test(expected = ExcepcionDuplicidad.class)
	public void validarExistenciaPreviaTest() {
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
																		withPlaca(PLACA).
																		withEstadoInOut(EstadoVehiculo.INGRESADO_PARQUEADERO.getIdEstado());
		
		RegistroParqueo registroParqueo = registroParqueoTestDataBuilder.build();

		when(repositorioRegistroParqueoMock.existeIngresado(Mockito.anyString())).thenReturn(true);
		servicioVigilanteRegistrarVehiculoMock.validarExistenciaPrevia(registroParqueo);
	}
	
	@Test(expected = ExcepcionMaxCapacidadParqueadero.class)
	public void validarCapacidadMaximaParqueaderoCarroTest() {
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
																		withPlaca(PLACA).
																		withTipoVehiculo(TipoVehiculo.CARRO.getIdTipoVehiculo());
		
		RegistroParqueo registroParqueo = registroParqueoTestDataBuilder.build();

		when(repositorioRegistroParqueoMock.countByTipoVehiculoAndEstadoInOut(Mockito.any(), Mockito.any())).thenReturn(servicioVigilanteRegistrarVehiculoMock.CAPACIDAD_MAX_DE_PARQUEADEROS_CARRO);
		servicioVigilanteRegistrarVehiculoMock.validarCapacidadMaximaParqueadero(registroParqueo);
	}
	
	@Test(expected = ExcepcionMaxCapacidadParqueadero.class)
	public void validarCapacidadMaximaParqueaderoMotoTest() {
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
																		withPlaca(PLACA).
																		withTipoVehiculo(TipoVehiculo.MOTO.getIdTipoVehiculo());
		
		RegistroParqueo registroParqueo = registroParqueoTestDataBuilder.build();

		when(repositorioRegistroParqueoMock.countByTipoVehiculoAndEstadoInOut(Mockito.any(), Mockito.any())).thenReturn(servicioVigilanteRegistrarVehiculoMock.CAPACIDAD_MAX_DE_PARQUEADEROS_MOTOS);
		servicioVigilanteRegistrarVehiculoMock.validarCapacidadMaximaParqueadero(registroParqueo);
	}
}
