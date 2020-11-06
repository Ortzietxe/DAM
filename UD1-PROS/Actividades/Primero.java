package Hilos;

public class Primero implements Runnable {//extends Thread {
	public void run(){
		for (int i=1;i<100;i++)
		System.out.println("Primero " + i );
		//System.out.println(getName() + " " + i);
		
		System.out.println("Numero de hilos activos: "+ Thread.currentThread().activeCount());

	}
}
