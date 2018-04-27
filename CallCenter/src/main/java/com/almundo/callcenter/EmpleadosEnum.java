package com.almundo.callcenter;

public enum EmpleadosEnum {
	DIRECTOR("Director"), SUPERVISOR("Supervisor"), OPERARIO("Operario");
	private String tipo;

	EmpleadosEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
