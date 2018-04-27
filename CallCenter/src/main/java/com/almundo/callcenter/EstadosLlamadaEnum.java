package com.almundo.callcenter;

public enum EstadosLlamadaEnum {
	ESPERA("1"), PROGRESO("2"), ATENDIDA("3");
	private String tipo;

	EstadosLlamadaEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
