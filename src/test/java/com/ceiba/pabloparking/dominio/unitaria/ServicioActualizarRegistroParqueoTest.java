package com.ceiba.pabloparking.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.buildertest.RegistroParqueoTestDataBuilder;
import com.ceiba.pabloparking.dominio.servicio.ServicioActualizarRegistroParqueo;
import com.ceiba.pabloparking.infraestructura.persistencia.dao.ConexionDBRegistroParqueo;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.RegistroParqueoEntidad;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServicioActualizarRegistroParqueoTest {
	
	private static final String PLACA = "MSH250";
	private static final double VALOR_PARQUEO = 0d;
	private static final double VALOR_PARQUEO_UPDATE = 1000D;
	
	@Autowired
	ConexionDBRegistroParqueo conexionDBRegistroParqueo;
	
	@Autowired
	ServicioActualizarRegistroParqueo servicioActualizarRegistroParqueo;
	
	@Test
	public void ejecutarActualizarRegistroParqueoTest() {
		RegistroParqueoTestDataBuilder registroParqueoTestDataBuilder = new RegistroParqueoTestDataBuilder().
				withPlaca(PLACA).
				withValorParqueo(VALOR_PARQUEO);
		
		RegistroParqueoEntidad registroParqueoEntidad = registroParqueoTestDataBuilder.buildEntity();
		Long idRegistroParqueo = conexionDBRegistroParqueo.save(registroParqueoEntidad).getId();
		
		
		// act
		registroParqueoTestDataBuilder.withId(idRegistroParqueo).
									   withValorParqueo(VALOR_PARQUEO_UPDATE);
		RegistroParqueo registroParqueoUpdate = registroParqueoTestDataBuilder.build();
		servicioActualizarRegistroParqueo.ejecutar(registroParqueoUpdate);
		
		Optional<RegistroParqueoEntidad> resultConsulta = conexionDBRegistroParqueo.findById(idRegistroParqueo);
		RegistroParqueoEntidad registroParqueoEntidadUpdated = resultConsulta.isPresent() ? resultConsulta.get() : null;
		
		assertNotNull(registroParqueoEntidadUpdated);
		if(registroParqueoEntidadUpdated != null) {
			assertEquals(VALOR_PARQUEO_UPDATE, registroParqueoEntidadUpdated.getValorParqueo().doubleValue(), 0d);
		}
	
	}
}
