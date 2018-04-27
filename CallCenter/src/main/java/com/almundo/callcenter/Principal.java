package com.almundo.callcenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal {
	private static CallCenter callCenter = CallCenter.getSingletonInstance();
	private static List<Llamada> llamadas = new ArrayList<Llamada>();

	public static void main(String[] args) {
		inicializarEmpleados();
		inicializarLlamadas();
		ejecutarLlamadas();
	}

	private static void ejecutarLlamadas() {
		final Integer MAX_HILOS = 10;
		ExecutorService executor = Executors.newFixedThreadPool(MAX_HILOS);
		for (Llamada llamada : llamadas) {
			Runnable worker = new Dispatcher(llamada);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
	}

	private static void inicializarLlamadas() {
		Llamada llamada1 = new Llamada("00001", (int) (Math.random() * 10) + 5);
		llamadas.add(llamada1);
		Llamada llamada2 = new Llamada("00002", (int) (Math.random() * 10) + 5);
		llamadas.add(llamada2);
		Llamada llamada3 = new Llamada("00003", (int) (Math.random() * 10) + 5);
		llamadas.add(llamada3);
		Llamada llamada4 = new Llamada("00004", (int) (Math.random() * 10) + 5);
		llamadas.add(llamada4);
		Llamada llamada5 = new Llamada("00005", (int) (Math.random() * 10) + 5);
		llamadas.add(llamada5);

		Llamada llamada6 = new Llamada("00006", (int) (Math.random() * 10) + 5);
		llamadas.add(llamada6);
		Llamada llamada7 = new Llamada("00007", (int) (Math.random() * 10) + 5);
		llamadas.add(llamada7);
		Llamada llamada8 = new Llamada("00008", (int) (Math.random() * 10) + 5);
		llamadas.add(llamada8);
		Llamada llamada9 = new Llamada("00009", (int) (Math.random() * 10) + 5);
		llamadas.add(llamada9);
		Llamada llamada10 = new Llamada("00010", (int) (Math.random() * 10) + 5);
		llamadas.add(llamada10);
	}

	private static void inicializarEmpleados() {
		// inicio creacion de empleados

		Map<EmpleadosEnum, Integer> stockEmpleados = new HashMap<EmpleadosEnum, Integer>();

		stockEmpleados.put(EmpleadosEnum.DIRECTOR, 2);
		stockEmpleados.put(EmpleadosEnum.SUPERVISOR, 4);
		stockEmpleados.put(EmpleadosEnum.OPERARIO, 4);

		callCenter.inicializarEmpleados(stockEmpleados);

		// fin creacion de empleados

	}
}
