package com.ceiba.pabloparking.infraestructura.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.pabloparking.aplicacion.fabrica.FabricaRegistroParqueo;
import com.ceiba.pabloparking.dominio.EstadoVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.dominio.repositorio.RepositorioRegistroParqueo;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.RegistroParqueoEntidad;

@Component
public class RegistroParqueoDao implements RepositorioRegistroParqueo {
	
	@Autowired
	private ConexionDBRegistroParqueo conexionDBRegistroParqueo;
	
	@Autowired
	private FabricaRegistroParqueo fabricaRegistroParqueo;
	
	@Override
	public Long crear(RegistroParqueo registroParqueo) {
		RegistroParqueoEntidad registroParqueoEntidadResultado = conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(registroParqueo));
		return registroParqueoEntidadResultado != null ? registroParqueoEntidadResultado.getId() : null;
	}

	@Override
	public void actualizar(RegistroParqueo registroParqueo) {
		conexionDBRegistroParqueo.save(fabricaRegistroParqueo.convertirDominoAEntity(registroParqueo));
	}

	@Override
	public void eliminar(Long idRegistroParqueo) {
		conexionDBRegistroParqueo.deleteById(idRegistroParqueo);
	}

	@Override
	public boolean existeIngresado(String placa) {
		RegistroParqueoEntidad registroParqueoEntidad = conexionDBRegistroParqueo.findByPlacaAndEstadoInOut(placa, EstadoVehiculo.INGRESADO_PARQUEADERO.getIdEstado());
		if(registroParqueoEntidad != null && registroParqueoEntidad.getId() != null && registroParqueoEntidad.getId() > 0l) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	public List<RegistroParqueo> consultarVehiculosIngresados() {
		List<RegistroParqueoEntidad> listRegistroParqueoEntidad = conexionDBRegistroParqueo.findByEstadoInOutOrderByIdDesc(EstadoVehiculo.INGRESADO_PARQUEADERO.getIdEstado());
		
		List<RegistroParqueo> listRegistroParqueo = new ArrayList<RegistroParqueo>();
		for (RegistroParqueoEntidad registroParqueoEntidad : listRegistroParqueoEntidad) {
			listRegistroParqueo.add(fabricaRegistroParqueo.convertirEntityADominio(registroParqueoEntidad));
		}
		return listRegistroParqueo;
	}

	@Override
	public List<RegistroParqueo> consultarCarros() {
		List<RegistroParqueoEntidad> listRegistroParqueoMotosEntidad = conexionDBRegistroParqueo.findByTipoVehiculoOrderByIdDesc(TipoVehiculo.CARRO.getIdTipoVehiculo());
		
		List<RegistroParqueo> listRegistroParqueo = new ArrayList<RegistroParqueo>();
		for (RegistroParqueoEntidad registroParqueoEntidad : listRegistroParqueoMotosEntidad) {
			listRegistroParqueo.add(fabricaRegistroParqueo.convertirEntityADominio(registroParqueoEntidad));
		}
		return listRegistroParqueo;
	}
	
	@Override
	public List<RegistroParqueo> consultarMotos() {
		List<RegistroParqueoEntidad> listRegistroParqueoMotosEntidad = conexionDBRegistroParqueo.findByTipoVehiculoOrderByIdDesc(TipoVehiculo.MOTO.getIdTipoVehiculo());
		
		List<RegistroParqueo> listRegistroParqueo = new ArrayList<RegistroParqueo>();
		for (RegistroParqueoEntidad registroParqueoEntidad : listRegistroParqueoMotosEntidad) {
			listRegistroParqueo.add(fabricaRegistroParqueo.convertirEntityADominio(registroParqueoEntidad));
		}
		return listRegistroParqueo;
	}

	@Override
	public int countByTipoVehiculoAndEstadoInOut(Integer tipoVehiculo, Integer idEstadoInOut) {
		return conexionDBRegistroParqueo.countByTipoVehiculoAndEstadoInOut(tipoVehiculo, idEstadoInOut);
	}
}
