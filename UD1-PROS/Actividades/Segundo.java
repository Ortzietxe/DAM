package Hilos;

public class Segundo implements Runnable {//extends Thread{
	public void run(){
		for (int i=1;i<100;i++)
		System.out.println("Segundo " + i);
	}
}
