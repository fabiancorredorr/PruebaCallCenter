# PruebaCallCenter
Simulación de atención de un Call Center con concurrencia de llamadas.

Se realizan dos test unitarios con 10 llamadas.
  testLlamadasSinAtender:
    Revisa si al final de la ejecución en el arreglo de llamadas queda al menos una llamada sin atender.
  testLlamadasTiempo
    Revisa si al final de la ejecución de todas las llamadas los tiempos final - inicial son iguales al tiempo en segundos 
    configurado para cada llamada.
    
Si hay más de las 10 llamadas esperara a que quede un empleado libre para iniciar la llamada que está en espera.

Se diseña una clase CallCenter que es la que se encarga de administrar los empleados y las llamadas, 
se implementa el patrón creacional Singleton para aasegurar que durante la ejecución solo exista una instancia de esa clase.

Se utiliza el pool de hilos FixedThreadPool con un máximo de 10 hilos en el pool, 
esto para controlar el número máximo de hilos y evitar saturación de memoria.

