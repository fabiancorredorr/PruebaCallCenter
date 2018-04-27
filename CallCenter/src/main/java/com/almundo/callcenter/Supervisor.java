package com.almundo.callcenter;

public class Supervisor extends Empleado {
	public Supervisor(String nombre){
		prioridad = 2;
		super.setNombre(nombre);
	}
}
