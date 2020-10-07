package Controlador;

import Modelo.Olimpiada;
import Vista.*;

public class Controlador 
{
	private static vPrincipal vp;
	private static vAltaOlimpiada vao;
	//private static Olimpiada o;
	
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
	
	public void altaOlimpiada(Olimpiada o) 
	{
		//oOlimpiadaBD = BDOlimpiadas.BDalta(o);
	}
	
}
