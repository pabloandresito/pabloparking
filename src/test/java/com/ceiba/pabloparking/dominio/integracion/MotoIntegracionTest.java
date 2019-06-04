package com.ceiba.pabloparking.dominio.integracion;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.pabloparking.dominio.Moto;
import com.ceiba.pabloparking.dominio.buildertest.MotoTestDataBuilder;
import com.ceiba.pabloparking.infraestructura.persistencia.SistemaDePersistencia;
import com.ceiba.pabloparking.infraestructura.persistencia.dao.MotoDao;
import com.ceiba.pabloparking.infraestructura.persistencia.dao.MotoDaoImpl;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.MotoEntidad;

public class MotoIntegracionTest {

	private static final String PLACA = "MSO252";
	private static final Integer CILINDRAJE = 200;

	private SistemaDePersistencia sistemaPersistencia;
	
	@Autowired
	private MotoDao motoDao;
	
	@Before
	public void setUp() {
		sistemaPersistencia = new SistemaDePersistencia();
		motoDao = sistemaPersistencia.iniciarMotoDao();
		sistemaPersistencia.iniciar();
	}
	
	@After
	public void tearDown() {
		sistemaPersistencia.terminar();
	}
	
	@Test
	public void guardarMoto() {
		MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().
				conPlaca(PLACA).
				conCilindraje(CILINDRAJE);
		
		Moto moto = motoTestDataBuilder.build();
		
		motoDao.agregar(moto);
		
		Moto motoConsulta = motoDao.obtenerPorPlaca(moto.getPlaca());
		
		assertNotNull(motoConsulta);
		
	}
	
}
