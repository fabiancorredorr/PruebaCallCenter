package com.almundo.callcenter;


public class Empleado implements Comparable<Empleado> {
	private Llamada llamada;
	private boolean disponible = true;
	private String nombre;
	private String cargo;
	protected Integer prioridad;


	public void procesarLlamada() {	
		try {
			Thread.sleep(llamada.getSegundos() * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}	
	}

	public void asignarLlamada(Llamada llamada) {
		this.llamada = llamada;
	}
	
	public boolean isDisponible() {
		return disponible;
	}

	public Llamada getLlamada() {
		return llamada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public void setLlamada(Llamada llamada) {
		this.llamada = llamada;
	}
//	@Override
	public int compareTo(Empleado o) {
		if (prioridad < o.prioridad) {
          return -1;
      }
      if (prioridad > o.prioridad) {
          return 1;
      }
      return 0;
	}
}
