package com.almundo.callcenter;

import java.util.Date;

public class Llamada {
	private String numeroLlamada;
	private int segundos;
	private String estado; // estado 1: en espera // estado 2: en progreso // estado 3: atendida
	private Date tiempoCreacion;
	private Date tiempoAtendido;
	private Date tiempoFinalizado;
	
	public Llamada(String numeroLlamada, int segundos){
		this.numeroLlamada = numeroLlamada;
		this.segundos = segundos;
		this.estado = EstadosLlamadaEnum.ESPERA.getTipo();
		this.tiempoCreacion = new Date();
	}
	
	public Date getTiempoCreacion() {
		return tiempoCreacion;
	}

	public void setTiempoCreacion(Date tiempoCreacion) {
		this.tiempoCreacion = tiempoCreacion;
	}

	public Date getTiempoAtendido() {
		return tiempoAtendido;
	}

	public void setTiempoAtendido(Date tiempoAtendido) {
		this.tiempoAtendido = tiempoAtendido;
	}

	public Date getTiempoFinalizado() {
		return tiempoFinalizado;
	}

	public void setTiempoFinalizado(Date tiempoFinalizado) {
		this.tiempoFinalizado = tiempoFinalizado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumeroLlamada() {
		return numeroLlamada;
	}
	public void setNumeroLlamada(String numeroLlamada) {
		this.numeroLlamada = numeroLlamada;
	}
	public int getSegundos() {
		return segundos;
	}
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	
}
