package com.ceiba.pabloparking.dominio.validacion;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;

import com.ceiba.pabloparking.dominio.excepcion.ExcepcionFechaSalidaMenorFechaIngreso;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pabloparking.dominio.excepcion.ExcepcionValorObligatorio;

public class ValidadorArgumento {
	
	private ValidadorArgumento() {}

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }
    
    public static void validarLongitud(String valor,int longitud,String mensaje){
        if(valor.length() < longitud){
            throw new ExcepcionLongitudValor(mensaje);
        }
    }
    
    public static void validarNoVacioString(Object valor, String mensaje) {
        if (StringUtils.isBlank((CharSequence) valor)) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }

    public static void validarPositivo(Double valor, String mensaje) {
        if (valor <= 0d) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }
    
    public static void validarNoLunesNiDomingoPlacaIniciaConA(String placa, LocalDateTime fechaHoraIngreso, String mensaje) {
		if(validarPlacaIniciaConA(placa)) {
			if( !(fechaHoraIngreso.getDayOfWeek() == DayOfWeek.MONDAY || fechaHoraIngreso.getDayOfWeek() == DayOfWeek.SUNDAY) ) {
				throw new ExcepcionValorInvalido(mensaje);
			}
		}
	}

	public static boolean validarPlacaIniciaConA(String placa) {
		boolean placaIniciaConA = false;
		if(StringUtils.isNoneBlank(placa) && StringUtils.startsWithAny(placa, "a", "A")) {
			placaIniciaConA = true;
		}
		return placaIniciaConA;
	}

	public static void validarFechaIngresoYFechaSalida(LocalDateTime fechaHoraIngreso, LocalDateTime fechaHoraSalida, String mensaje) {
		if(fechaHoraSalida.isBefore(fechaHoraIngreso)) {
			throw new ExcepcionFechaSalidaMenorFechaIngreso(mensaje);
		}
	}
}