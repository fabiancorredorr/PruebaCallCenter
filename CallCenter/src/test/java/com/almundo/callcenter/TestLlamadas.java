package com.almundo.callcenter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class TestLlamadas {
	private CallCenter callCenter = CallCenter.getSingletonInstance();
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private static Integer MAX_HILOS = 10;
	@Test
	public void testLlamadasSinAtender() {
		System.out.println("##################### INICIO TEST testLlamadasSinAtender ####################");
		inicializarEmpleados();
		inicializarLlamadas();
		ejecutarLlamadas();
		String llamadaNoAtendida = null;
		for(Llamada llamada : llamadas){
			if(!llamada.getEstado().equals(EstadosLlamadaEnum.ATENDIDA.getTipo())){
				llamadaNoAtendida = "Hay por lo menos una llamada no atendida";
				break;
			}
		}
		System.out.println("##################### FIN TEST testLlamadasSinAtender ####################");
		assertNull("una Llamada no fue atendida", llamadaNoAtendida);
	}
	
	@Test
	public void testLlamadasTiempo() {
		System.out.println("##################### INICIO TEST testLlamadasTiempo ####################");
		inicializarEmpleados();
		inicializarLlamadas();
		ejecutarLlamadas();
		String llamadaTiempoErrado = null;
		   Calendar cinicio = Calendar.getInstance();
           Calendar cfinal = Calendar.getInstance();
           Long tSInicial;
           Long tSFinal;
           Long resultadoSegundos;
		for(Llamada llamada : llamadas){
		    cinicio.setTime(llamada.getTiempoAtendido());
            cfinal.setTime(llamada.getTiempoFinalizado());
            tSInicial = cinicio.getTimeInMillis()/1000;
            tSFinal = cfinal.getTimeInMillis()/1000;
            resultadoSegundos = tSFinal - tSInicial;
            if(llamada.getSegundos() != resultadoSegundos.intValue()){
				llamadaTiempoErrado = "Hay por lo menos una llamada donde los tiempos no son validos";
				break;
			}
		}
		System.out.println("##################### FIN TEST testLlamadasTiempo ####################");
		assertNull("una Llamada tiempo errado", llamadaTiempoErrado);
	}
	
	private void ejecutarLlamadas() {
		ExecutorService executor = Executors.newFixedThreadPool(MAX_HILOS);
		for (Llamada llamada : llamadas) {
			Runnable worker = new Dispatcher(llamada);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
	}
	private void inicializarLlamadas() {
		Llamada llamada1 = new Llamada("00001", (int)(Math.random()*10)+5);
		llamadas.add(llamada1);
		Llamada llamada2 = new Llamada("00002", (int)(Math.random()*10)+5);
		llamadas.add(llamada2);
		Llamada llamada3 = new Llamada("00003", (int)(Math.random()*10)+5);
		llamadas.add(llamada3);
		Llamada llamada4 = new Llamada("00004", (int)(Math.random()*10)+5);
		llamadas.add(llamada4);
		Llamada llamada5 = new Llamada("00005", (int)(Math.random()*10)+5);
		llamadas.add(llamada5);

		Llamada llamada6 = new Llamada("00006", (int)(Math.random()*10)+5);
		llamadas.add(llamada6);
		Llamada llamada7 = new Llamada("00007", (int)(Math.random()*10)+5);
		llamadas.add(llamada7);
		Llamada llamada8 = new Llamada("00008", (int)(Math.random()*10)+5);
		llamadas.add(llamada8);
		Llamada llamada9 = new Llamada("00009", (int)(Math.random()*10)+5);
		llamadas.add(llamada9);
		Llamada llamada10 = new Llamada("00010", (int)(Math.random()*10)+5);
		llamadas.add(llamada10);
		Llamada llamada11 = new Llamada("00011", (int)(Math.random()*10)+5);
		llamadas.add(llamada11);
	}

	private void inicializarEmpleados() {
		// inicio creacion de empleados

		Map<EmpleadosEnum, Integer> stockEmpleados = new HashMap<EmpleadosEnum, Integer>();

		stockEmpleados.put(EmpleadosEnum.DIRECTOR, 2);
		stockEmpleados.put(EmpleadosEnum.SUPERVISOR, 4);
		stockEmpleados.put(EmpleadosEnum.OPERARIO, 4);

		callCenter.inicializarEmpleados(stockEmpleados);

		// fin creacion de empleados

	}
}
