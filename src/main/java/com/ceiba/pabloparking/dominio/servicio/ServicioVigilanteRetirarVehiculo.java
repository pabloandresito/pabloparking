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
	
	public static final double VALOR_HORA_CARRO = 1000d;
	public static final double VALOR_HORA_MOTO = 500d;
	public static final double VALOR_DIA_CARRO = 8000d;
	public static final double VALOR_DIA_MOTO = 4000d;
	public static final int VALOR_LIMITE_CILINDRAJE_PARA_COBRO_EXCEDENTE_MOTO = 500;
	public static final double VALOR_EXCEDENTE_MOTO_MAYOR_500CC = 2000d;
	
	public static final double HORA_DE_INICIO_PARA_COBRO_DE_DIA_COMPLETO = 9d;
	
	private static final double CONSTANTE_CONVERSION_MINUTOS_HORAS = 3600d;
	private static final double CONSTANTE_HORAS_DEL_DIA = 24d;
	
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
		double horasParqueo = segundosParqueo / CONSTANTE_CONVERSION_MINUTOS_HORAS;
		double diasPorCobrar = Math.floor(horasParqueo / CONSTANTE_HORAS_DEL_DIA);
		double horasRestantesPorCobrar = Math.ceil(horasParqueo % CONSTANTE_HORAS_DEL_DIA);
		
		if(registroParqueo.getTipoVehiculo() == TipoVehiculo.CARRO.getIdTipoVehiculo()) {
			valorParqueo = calcularValorParqueoCarro(diasPorCobrar, horasRestantesPorCobrar);
		} else if(registroParqueo.getTipoVehiculo() == TipoVehiculo.MOTO.getIdTipoVehiculo()) {
			valorParqueo = calcularValorParqueoMoto(diasPorCobrar, horasRestantesPorCobrar, registroParqueo.getCilindraje());
		}
		
		return valorParqueo;
	}
	
	public double calcularValorParqueoCarro(double diasPorCobrar, double horasRestantesPorCobrar) {
		double valorParqueoCarro = 0d;
		
		// Cobro por Días
		valorParqueoCarro += (diasPorCobrar * VALOR_DIA_CARRO);
		
		// Cobro por Horas
		// Del tiempo restante --> Si el Carro permanecio más de 9 horas entonces se cobra un (1) día completo. (En caso contrario se cobra por hora)
		if(horasRestantesPorCobrar >= HORA_DE_INICIO_PARA_COBRO_DE_DIA_COMPLETO) {
			valorParqueoCarro += VALOR_DIA_CARRO;
		} else {
			valorParqueoCarro += (horasRestantesPorCobrar * VALOR_HORA_CARRO);
		}
		
		return valorParqueoCarro;
	}
	
	public double calcularValorParqueoMoto(double diasPorCobrar, double horasRestantesPorCobrar, int cilindraje) {
		double valorParqueoMoto = 0d;
		
		// Cobro por Días
		valorParqueoMoto += (diasPorCobrar * VALOR_DIA_MOTO);
		
		// Cobro por Horas
		// Del tiempo restante --> Si la Moto permanecio más de 9 horas entonces se cobra un (1) día completo. (En caso contrario se cobra por hora)
		if(horasRestantesPorCobrar >= HORA_DE_INICIO_PARA_COBRO_DE_DIA_COMPLETO) {
			valorParqueoMoto += VALOR_DIA_MOTO;
		} else {
			valorParqueoMoto += (horasRestantesPorCobrar * VALOR_HORA_MOTO);
		}
		
		// Las motos que tengan un cilindraje mayor a 500 CC paga 2000 de mas al valor total.
		if(cilindraje > VALOR_LIMITE_CILINDRAJE_PARA_COBRO_EXCEDENTE_MOTO) {
			valorParqueoMoto += VALOR_EXCEDENTE_MOTO_MAYOR_500CC;
		}
		
		return valorParqueoMoto;
	}
}