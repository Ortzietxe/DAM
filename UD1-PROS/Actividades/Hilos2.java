package Hilos;

public class Hilos2 {
	public static void main(String arg[]) {
		Thread p = new Thread(new Primero());
		Thread s = new Thread(new Segundo());
		s.setName("Hilo 2");
		System.out.println("Nombre de hilo 2 "+s.getName());
		
		s.setPriority(8);
		System.out.println("Prioridad de hilo 2 "+s.getPriority());
		
		System.out.println("Prioridad de hilo 1 "+p.getPriority());
		System.out.println("Nombre de hilo 1 "+p.getName());

		System.out.println("Numero de hilos activos: "+ Thread.currentThread().activeCount());

		p.start();
		s.start();
		System.out.println( "Fin programa ");
	}
}
