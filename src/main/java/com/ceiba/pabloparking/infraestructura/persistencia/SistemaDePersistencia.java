package com.ceiba.pabloparking.infraestructura.persistencia;

import javax.persistence.EntityManager;

import com.ceiba.pabloparking.infraestructura.persistencia.dao.MotoDaoImpl;

public class SistemaDePersistencia {

	private EntityManager entityManager;

	public SistemaDePersistencia() {
		this.entityManager = new ConexionJPA().createEntityManager();
	}

	public void iniciar() {
		entityManager.getTransaction().begin();
	}

	public void terminar() {
		entityManager.getTransaction().commit();
	}
	
	public MotoDaoImpl iniciarMotoDao() {
		return new MotoDaoImpl(entityManager);
	}
}
