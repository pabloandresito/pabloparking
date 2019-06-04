package com.ceiba.pabloparking.infraestructura.persistencia.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ceiba.pabloparking.dominio.Moto;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.MotoEntidad;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.builder.MotoBuilder;

public class MotoDaoImpl implements MotoDao {
	
	private static final String PLACA = "placa";
	private static final String MOTO_FIND_BY_PLACA = "Moto.findByPlaca";

	private EntityManager entityManager;
	
	public MotoDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Moto obtenerPorPlaca(String placa) {
		MotoEntidad motoEntidad = obtenerMotoEntidadPorPlaca(placa);
		return MotoBuilder.convertirADominio(motoEntidad);
	}
	
	public MotoEntidad obtenerMotoEntidadPorPlaca(String placa) {
		Query query = entityManager.createNamedQuery(MOTO_FIND_BY_PLACA);
		query.setParameter(PLACA, placa);

		return (MotoEntidad) query.getSingleResult();
	}

	@Override
	public void agregar(Moto moto) {
		entityManager.persist(MotoBuilder.convertirAEntity(moto));
	}
}
