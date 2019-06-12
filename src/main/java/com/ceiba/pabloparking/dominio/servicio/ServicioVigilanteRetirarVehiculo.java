package com.ceiba.pabloparking.dominio.servicio;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.pabloparking.dominio.EstadoVehiculo;
import com.ceiba.pabloparking.dominio.RegistroParqueo;
import com.ceiba.pabloparking.dominio.TipoVehiculo;
import com.ceiba.pabloparking.dominio.repositorio.RepositorioRegistroParqueo;

@Service
public class ServicioVigilanteRetirarVehiculo {
	
	private static final String MENSAJE_VEHICULO_RETIRADO_DEL_PARQUEADERO = "Vehiculo Retirado - El valor a pagar es: $";
	private static final String MENSAJE_VEHICULO_YA_RETIRADO_EN_EL_PASADO = " ya ha sido retirado con anterioridad - El valor pagado fue de: $";
	private static final String MENSAJE_VEHICULO_YA_RETIRADO_EN_EL_PASADO_SIN_INFO = "El vehículo ya ha sido retirado con anterioridad.";
	
	private static double valorHoraCarro = 1000d;
	private static double valorHoraMoto = 500d;
	private static double valorDiaCarro = 8000d;
	private static double valorDiaMoto = 4000d;
	private static int valorLimiteCilindrajeParaCobroExcedenteMoto = 500;
	private static double valorExcedenteMotoMayor500CC = 2000d;
	
	private static double horaDeInicioParaCobroDeDiaCompleto = 9d;
	
	private static double constanteConversionMinutosHoras = 3600d;
	private static double constanteHorasDelDia = 24d;
	
	@Autowired
	private RepositorioRegistroParqueo repositorioRegistroParqueo;
	
	public String ejecutar(Long id, LocalDateTime fechaHoraSalida) {
		StringBuilder mensajeRespuesta = new StringBuilder();
		// Obtenemos el objeto de domio a actualizar
		RegistroParqueo registroParqueoUpdate = repositorioRegistroParqueo.getById(id);
		
		if(registroParqueoUpdate != null && registroParqueoUpdate.getEstadoInOut() == EstadoVehiculo.INGRESADO_PARQUEADERO.getIdEstado()) {
			registroParqueoUpdate.setFechaHoraSalida(fechaHoraSalida);
			registroParqueoUpdate.setValorParqueo(calcularValorParqueo(registroParqueoUpdate));
			registroParqueoUpdate.setEstadoInOut(EstadoVehiculo.RETIRADO_PARQUEADERO.getIdEstado());
			
			mensajeRespuesta.append(MENSAJE_VEHICULO_RETIRADO_DEL_PARQUEADERO);
			mensajeRespuesta.append(registroParqueoUpdate.getValorParqueo());
		} else if(registroParqueoUpdate != null) {
			mensajeRespuesta.append(registroParqueoUpdate.getPlaca());
			mensajeRespuesta.append(MENSAJE_VEHICULO_YA_RETIRADO_EN_EL_PASADO);
			mensajeRespuesta.append(registroParqueoUpdate.getValorParqueo());
		} else {
			mensajeRespuesta.append(MENSAJE_VEHICULO_YA_RETIRADO_EN_EL_PASADO_SIN_INFO);
		}
		
		repositorioRegistroParqueo.actualizar(registroParqueoUpdate);
		
		return mensajeRespuesta.toString();
    }
	
	public List<RegistroParqueo> consultarVehiculosRetirados() {
    	return repositorioRegistroParqueo.consultarVehiculosRetirados();
	}
	
	public double calcularValorParqueo(RegistroParqueo registroParqueo) {
		double valorParqueo = 0d;
		
		double segundosParqueo = (double) Duration.between(registroParqueo.getFechaHoraIngreso(), registroParqueo.getFechaHoraSalida()).getSeconds();
		double horasParqueo = segundosParqueo / constanteConversionMinutosHoras;
		double diasPorCobrar = Math.floor(horasParqueo / constanteHorasDelDia);
		double horasRestantesPorCobrar = Math.ceil(horasParqueo % constanteHorasDelDia);
		
		if(registroParqueo.getTipoVehiculo() == TipoVehiculo.CARRO.getIdTipoVehiculo()) {
			valorParqueo = calcularValorParqueoCarro(diasPorCobrar, horasRestantesPorCobrar);
		} else if(registroParqueo.getTipoVehiculo() == TipoVehiculo.MOTO.getIdTipoVehiculo()) {
			valorParqueo = calcularValorParqueoMoto(diasPorCobrar, horasRestantesPorCobrar, registroParqueo.getCilindraje());
		}
		
		return valorParqueo;
	}
	
	private double calcularValorParqueoCarro(double diasPorCobrar, double horasRestantesPorCobrar) {
		double valorParqueoCarro = 0d;
		
		// Cobro por Días
		valorParqueoCarro += (diasPorCobrar * valorDiaCarro);
		
		// Cobro por Horas
		// Del tiempo restante --> Si el Carro permanecio más de 9 horas entonces se cobra un (1) día completo. (En caso contrario se cobra por hora)
		if(horasRestantesPorCobrar >= horaDeInicioParaCobroDeDiaCompleto) {
			valorParqueoCarro += valorDiaCarro;
		} else {
			valorParqueoCarro += (horasRestantesPorCobrar * valorHoraCarro);
		}
		
		return valorParqueoCarro;
	}
	
	private double calcularValorParqueoMoto(double diasPorCobrar, double horasRestantesPorCobrar, int cilindraje) {
		double valorParqueoMoto = 0d;
		
		// Cobro por Días
		valorParqueoMoto += (diasPorCobrar * valorDiaMoto);
		
		// Cobro por Horas
		// Del tiempo restante --> Si la Moto permanecio más de 9 horas entonces se cobra un (1) día completo. (En caso contrario se cobra por hora)
		if(horasRestantesPorCobrar >= horaDeInicioParaCobroDeDiaCompleto) {
			valorParqueoMoto += valorDiaMoto;
		} else {
			valorParqueoMoto += (horasRestantesPorCobrar * valorHoraMoto);
		}
		
		// Las motos que tengan un cilindraje mayor a 500 CC paga 2000 de mas al valor total.
		if(cilindraje > valorLimiteCilindrajeParaCobroExcedenteMoto) {
			valorParqueoMoto += valorExcedenteMotoMayor500CC;
		}
		
		return valorParqueoMoto;
	}
}