package src;

public class Hilos1 {
	public static void main(String arg[]) {
		primero p=new primero();
		segundo s=new segundo();
		p.start();
		s.start();
		System.out.print("Fin programa");
	}
}