package com.almundo.callcenter;

public class Operario extends Empleado {
	public Operario(String nombre){
		prioridad = 1;
		super.setNombre(nombre);
	}
}
