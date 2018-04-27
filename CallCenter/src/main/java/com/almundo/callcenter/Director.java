package com.almundo.callcenter;

public class Director extends Empleado  {
	public Director(String nombre){
		prioridad = 3;
		super.setNombre(nombre);
	}
}
