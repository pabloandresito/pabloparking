package com.ceiba.pabloparking.infraestructura.persistencia.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.pabloparking.aplicacion.fabrica.FabricaRegistroParqueo;
import com.ceiba.pabloparking.dominio.EstadoVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.repositorio.RepositorioRegistroParqueo;
import com.ceiba.pabloparking.infraestructura.persistencia.entidad.RegistroParqueoEntidad;

@Component
public class RegistroParqueoDao implements RepositorioRegistroParqueo {
	
	@Autowired
	private ConexionDBRegistroParqueo conexionDBRegistroParqueo;
	
	@Autowired
	private FabricaRegistroParqueo fabricaRegistroParqueo;
	
	@Override
	public RegistroParqueo getById(Long id) {
		Optional<RegistroParqueoEntidad> registroParqueoEntidadResultado = conexionDBRegistroParqueo.findById(id);
		return registroParqueoEntidadResultado.isPresent() ? (fabricaRegistroParqueo.convertirEntityADominio(registroParqueoEntidadResultado.get())) : null;
	}
	
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
	public List<RegistroParqueo> consultarVehiculosRetirados() {
		List<RegistroParqueoEntidad> listRegistroParqueoEntidad = conexionDBRegistroParqueo.findByEstadoInOutOrderByIdDesc(EstadoVehiculo.RETIRADO_PARQUEADERO.getIdEstado());
		
		List<RegistroParqueo> listRegistroParqueo = new ArrayList<RegistroParqueo>();
		for (RegistroParqueoEntidad registroParqueoEntidad : listRegistroParqueoEntidad) {
			listRegistroParqueo.add(fabricaRegistroParqueo.convertirEntityADominio(registroParqueoEntidad));
		}
		return listRegistroParqueo;
	}

	@Override
	public int countByTipoVehiculoAndEstadoInOut(Integer tipoVehiculo, Integer idEstadoInOut) {
		return conexionDBRegistroParqueo.countByTipoVehiculoAndEstadoInOut(tipoVehiculo, idEstadoInOut);
	}
}
