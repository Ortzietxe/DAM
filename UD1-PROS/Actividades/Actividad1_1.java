package Evaluacion1;

import Hilos.Primero;
import Hilos.Segundo;
import Hilos.Tercero;

public class Actividad1_1 {
	public static void main(String arg[]) {

		Primero p = new Primero();
		Segundo s = new Segundo();
		Tercero t = new Tercero("Hilo 3");
		
		System.out.println("Hilo actual: "+Thread.currentThread().getName());
		
		System.out.println("Nombre de hilo 1 "+p.getName());
		System.out.println("Nombre de hilo 2 "+s.getName());
		System.out.println("Nombre de hilo 3 "+t.getName());

		
		s.setName("Hilo 2");
		System.out.println("Nombre de hilo 2 "+s.getName());
		
		System.out.println("Prioridad de hilo 1 "+p.getPriority());
		System.out.println("Prioridad de hilo 2 "+s.getPriority());
		
		s.setPriority(8);
		System.out.println("Prioridad de hilo 2 "+s.getPriority());
		
		System.out.println("Hilos activos principal: "+Thread.currentThread().activeCount());


		
		p.start();
		s.start();
		System.out.print("Fin programa");
			
	}
}
