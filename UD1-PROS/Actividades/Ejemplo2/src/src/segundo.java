package src;

public class segundo extends Thread {
	public void run(){
		for (int i=1;i<100;i++)
		System.out.println("Segundo " + i);
	}
}