package com.almundo.callcenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.List;

public class CallCenter{
	private List<Empleado> listaEmpleados;
	private List<Llamada> llamadasEspera;
	private static CallCenter callCenter;

	private CallCenter() {
		llamadasEspera = new ArrayList<Llamada>();
	}

	public static CallCenter getSingletonInstance() {
		if (callCenter == null)
			callCenter = new CallCenter();
		return callCenter;
	}

	public void inicializarEmpleados(Map<EmpleadosEnum, Integer> stockEmpleados) {
		listaEmpleados = new ArrayList<Empleado>();

		crearEmpleado(EmpleadosEnum.DIRECTOR, stockEmpleados.get(EmpleadosEnum.DIRECTOR));
		crearEmpleado(EmpleadosEnum.SUPERVISOR, stockEmpleados.get(EmpleadosEnum.SUPERVISOR));
		crearEmpleado(EmpleadosEnum.OPERARIO, stockEmpleados.get(EmpleadosEnum.OPERARIO));
	}

	private void crearEmpleado(EmpleadosEnum tipoEmpleado, int numeroEmpleados) {
		Empleado empleado = null;
		for (int i = 1; i <= numeroEmpleados; i++) {
			if (tipoEmpleado.equals(EmpleadosEnum.DIRECTOR)) {
				empleado = new Director("D" + i);
			} else if (tipoEmpleado.equals(EmpleadosEnum.SUPERVISOR)) {
				empleado = new Supervisor("S" + i);
			} else if (tipoEmpleado.equals(EmpleadosEnum.OPERARIO)) {
				empleado = new Operario("O" + i);
			}
			if (empleado != null)
				listaEmpleados.add(empleado);
		}
	}

	synchronized public boolean hayEmpleadosDisponibles() {
		if (listaEmpleados.size()>0) return true;
		return false;
	}

	public boolean hayLlamadasEspera() {
		if(llamadasEspera.size() > 0) return true;
		else return false;
	}

	public Llamada getLlamadaEspera() {
		Llamada llamadaEspera;
		if (hayLlamadasEspera()){
			llamadaEspera = llamadasEspera.get(0);
			llamadasEspera.remove(0);
			return llamadaEspera;
		}
		return null;
	}

	public void pushLlamadaEspera(Llamada llamada) {
		llamadasEspera.add(llamada);
	}

	public void procesarLlamada(Llamada llamada) {
		Empleado empleado;
		if (hayEmpleadosDisponibles()){
			empleado = obtenerEmpleado();
			if(empleado != null){
				System.out.println("Se obtiene empleado para la llamada: " + llamada.getNumeroLlamada());
				empleado.asignarLlamada(llamada);
				empleado.procesarLlamada();
				listaEmpleados.add(empleado);
			}else 
				System.out.println("No se pudo obtener empleado para la llamada: " + llamada);
		}
		
	}
	synchronized  private Empleado obtenerEmpleado(){
		Collections.sort(listaEmpleados);
		Empleado empleadoAux;
		if (listaEmpleados.size() > 0){
			empleadoAux = listaEmpleados.get(0);
			listaEmpleados.remove(0);
			return empleadoAux;
		}
		return null;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public List<Llamada> getLlamadasEspera() {
		return llamadasEspera;
	}

	public void setLlamadasEspera(List<Llamada> llamadasEspera) {
		this.llamadasEspera = llamadasEspera;
	}

}
