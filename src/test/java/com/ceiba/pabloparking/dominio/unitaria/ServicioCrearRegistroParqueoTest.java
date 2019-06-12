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
import com.ceiba.pabloparking.dominio.buildertest.RegistroParqueoTestDataBuilder;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pabloparking.dominio.repositorio.RepositorioRegistroParqueo;
import com.ceiba.pabloparking.dominio.servicio.ServicioCrearRegistroParqueo;

@RunWith(SpringRunner.class)
public class ServicioCrearRegistroParqueoTest {
	
	private static final String PLACA = "MSO267";
	
	@Mock
	private RepositorioRegistroParqueo repositorioRegistroParqueoMock;
	
	@InjectMocks
	private ServicioCrearRegistroParqueo servicioCrearRegistroParqueoMock;
	
	@Test
	public void ejecutarCrearRegistroparqueoTest() {
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
																		withPlaca(PLACA).
																		withEstadoInOut(EstadoVehiculo.INGRESADO_PARQUEADERO.getIdEstado());
		
		RegistroParqueo registroParqueo = registroParqueoTestDataBuilder.build();
		Long idNuevoRegistroParqueo = servicioCrearRegistroParqueoMock.ejecutar(registroParqueo);
		
		assertNotNull(idNuevoRegistroParqueo);
	}
	
	@Test(expected = ExcepcionDuplicidad.class)
	public void validarExistenciaPreviaTest() {
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
																		withPlaca(PLACA).
																		withEstadoInOut(EstadoVehiculo.INGRESADO_PARQUEADERO.getIdEstado());
		
		RegistroParqueo registroParqueo = registroParqueoTestDataBuilder.build();

		when(repositorioRegistroParqueoMock.existeIngresado(Mockito.anyString())).thenReturn(true);
		servicioCrearRegistroParqueoMock.validarExistenciaPrevia(registroParqueo);
	}
}
