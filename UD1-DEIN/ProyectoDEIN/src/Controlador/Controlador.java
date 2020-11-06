package Controlador;

import BD.*;
import UML.*;
import Vista.*;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class Controlador 
{
	private static vPrincipal vp;
	private static vAltaOlimpiada vao;
	private static vAltaDeportista vad;
	private static vDeportistas vcd;
	private static vAltaEvento vae;
	private static Olimpiada oOlimpiada;
	private static Deportista oDeportista;
	private static ArrayList listaDeportistas;
	
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

	public static void mostrarAltaDeportista() {
		vp.setVisible(false);
		
		vad = new vAltaDeportista();
		vad.setVisible(true);		
	}
	
	public static void altaDeportista(String nombre, String genero, int peso, int altura) {
		oDeportista = new Deportista(nombre,genero,peso,altura);
		BDDeportistas.altaDeportistaBD(oDeportista);
		
	}

	public static void mostrarAltaEvento() {
		vp.setVisible(false);
		
		vae = new vAltaEvento();
		vae.setVisible(true);		
	}
	
	public static void altaEvento(String nomEvento, String nomOlimpiada, String nomDeporte) {
	
		
	}

	public static void mostrarConsultaDeportista() throws SQLException {
		vp.setVisible(false);
		vcd = new vDeportistas();

		vcd.setVisible(true);		
	}

	public static ArrayList pedirDatos() throws SQLException {
		listaDeportistas = BDDeportistas.buscarDeportistas();		
		return listaDeportistas;
	}

	public static void modificarDeportista(int id, String nombre, int peso, int altura) {
		oDeportista = new Deportista(id,nombre,peso,altura);
		BDDeportistas.modificacionDeportistaBD(oDeportista);	
	}

	public static void borrarDeportista(int idDeportista) {
		BDDeportistas.borrarDeportista(idDeportista);
		
	}
	
}
