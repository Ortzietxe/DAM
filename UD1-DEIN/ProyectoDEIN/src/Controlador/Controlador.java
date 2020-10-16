package Controlador;

import BD.*;
import Modelo.*;
import Vista.*;
import javax.swing.*;

public class Controlador 
{
	private static vPrincipal vp;
	private static vAltaOlimpiada vao;
	private static vAltaDeportista vad;
	private static Olimpiada oOlimpiada;
	private static Deportista oDeportista;
	
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

	public static void altaDeportista(String nombre, String genero, int peso, int altura) {
		oDeportista = new Deportista(nombre,genero,peso,altura);
		BDDeportistas.altaDeportistaBD(oDeportista);
		
	}

	public static void mostrarAltaDeportista() {
		vp.setVisible(false);
		
		vad = new vAltaDeportista();
		vad.setVisible(true);		
	}
	
}
