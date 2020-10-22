
public class proceso extends Thread {
	public void run(){
		for (int i=1;i<21;i++)
		System.out.println("Primero " + i);
		
		for (int i=1;i<21;i++)
		System.out.println("Segundo " + i);
	}
}