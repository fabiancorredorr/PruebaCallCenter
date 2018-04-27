package com.almundo.callcenter;

import java.util.Date;

public class Dispatcher implements Runnable/* extends Thread */ {
	private Llamada llamada;
	CallCenter callCenter = CallCenter.getSingletonInstance();
	public Dispatcher(Llamada llamada) {
		this.llamada = llamada;
	}

	public void run() {
		this.dispatchCall();
	}

	synchronized public void dispatchCall() {
		try{ 
			if (callCenter.hayLlamadasEspera()) {
				callCenter.pushLlamadaEspera(llamada);
				llamada = callCenter.getLlamadaEspera();
			}
			if (callCenter.hayEmpleadosDisponibles()) {
				llamada.setEstado(EstadosLlamadaEnum.PROGRESO.getTipo());
				Date tiempoInicial = new Date();
				Date tiempoFinal;
				llamada.setTiempoAtendido(tiempoInicial);
				System.out.println(llamada.getNumeroLlamada() + "::Estado::" + llamada.getEstado() + " :: tiempoInicial -> "
						+ tiempoInicial);
	
				callCenter.procesarLlamada(llamada);
	
				llamada.setEstado(EstadosLlamadaEnum.ATENDIDA.getTipo());
				tiempoFinal = new Date();
				llamada.setTiempoFinalizado(tiempoFinal);
				System.out.println(llamada.getNumeroLlamada() + "::Estado::" + llamada.getEstado() + " :: tiempoFinal -> "
						+ tiempoFinal);
	
			} else {
				callCenter.pushLlamadaEspera(llamada);
				llamada.setEstado(EstadosLlamadaEnum.ESPERA.getTipo());
				System.out.println(llamada.getNumeroLlamada() + ":: En espera");
			}
		}catch(NullPointerException e){
			System.out.println("Se ha generado el error: " + e.getMessage());
		}catch(Exception e){
			System.out.println("Se ha generado el error: " + e.getMessage());			
		}

	}

	public Llamada getLlamada() {
		return llamada;
	}

	public void setLlamada(Llamada llamada) {
		this.llamada = llamada;
	}

}
