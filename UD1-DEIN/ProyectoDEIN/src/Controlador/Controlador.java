package Controlador;

import BD.BDOlimpiadas;
import Modelo.Olimpiada;
import Vista.*;

public class Controlador 
{
	private static vPrincipal vp;
	private static vAltaOlimpiada vao;
	private static Olimpiada oOlimpiada;
	
	public static void mostrarVentanaPrincipal()
	{
		vp = new vPrincipal();
		vp.setVisible(true);
	}
	
	public static void mostrarConsultaOlimpiada()
	{

	}
	public static void mostrarAltaOlimpiada()
	{
		vp.setVisible(false);
		
		vao = new vAltaOlimpiada();
		vao.setVisible(true);
	}
	
	public static void altaOlimpiada(String nombre, int anio, String ciudad, String temporada) 
	{
		oOlimpiada = new Olimpiada(nombre, anio, temporada, ciudad);
		BDOlimpiadas.altaOlimpiadaBD(oOlimpiada);
	}
	
}
