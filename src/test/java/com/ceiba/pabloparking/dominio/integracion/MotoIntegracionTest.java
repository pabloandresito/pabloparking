package com.ceiba.pabloparking.dominio.integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.pabloparking.dominio.buildertest.MotoTestDataBuilder;
import com.ceiba.pabloparking.infraestructura.persistencia.dao.MotoDao;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.MotoEntidad;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MotoIntegracionTest {

	private static final String PLACA = "MSO252";
	private static final Integer CILINDRAJE = 200;

	@Autowired
	private MotoDao motoDao;
	
	@Before
	public void setUp() {

	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void guardarMoto() {
		MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().
				withPlaca(PLACA).
				withCilindraje(CILINDRAJE);
		
		MotoEntidad motoEntidad = motoTestDataBuilder.buildEntity();
		
		motoDao.save(motoEntidad);
		
		MotoEntidad motoEntidadConsulta = motoDao.findByPlaca(motoEntidad.getPlaca());
		
		//motoEntidad.setPlaca("SRT888");
		
		assertNotNull(motoEntidadConsulta);
		assertEquals("No guardó o no consultó correctamente la moto.", motoEntidad.getPlaca(), motoEntidadConsulta.getPlaca());
	}
	
}
