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
	private static vEventos vce;
	private static Olimpiada oOlimpiada;
	private static Deportista oDeportista;
	private static Evento oEvento;
	private static ArrayList<Deportista> listaDeportistas;
	private static ArrayList<Deporte> listaDeportes;
	private static ArrayList<Olimpiada> listaOlimpiadas;
	private static ArrayList<Evento> listaEventos;
	private static String olimpiada,deporte;
	
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

	public static void mostrarAltaEvento() throws SQLException {
		vp.setVisible(false);
		
		vae = new vAltaEvento();
		vae.setVisible(true);		
	}
	
	public static void altaEvento(String nomEvento, int idOlimpiada, int idDeporte) {
		oEvento = new Evento(nomEvento, idOlimpiada, idDeporte);
		BDEventos.altaEventoBD(oEvento);
	}

	public static void mostrarConsultaDeportista() throws SQLException {
		vp.setVisible(false);
		vcd = new vDeportistas();

		vcd.setVisible(true);		
	}

	public static ArrayList<Deportista> pedirDeportistas() throws SQLException {
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

	public static ArrayList<Deporte> pedirDeportes() throws SQLException {
		listaDeportes = BDDeportes.buscarDeportes();		
		return listaDeportes;
	}

	public static ArrayList<Olimpiada> pedirOlimpiadas() throws SQLException {
		listaOlimpiadas = BDOlimpiadas.buscarOlimpiadas();		
		return listaOlimpiadas;
	}
	
	public static ArrayList<Evento> pedirEventos() throws SQLException {
		listaEventos = BDEventos.buscarEventos();		
		return listaEventos;
	}

	public static void mostrarConsultaEvento() throws SQLException {
		vp.setVisible(false);
		
		vce = new vEventos();
		vce.setVisible(true);
		
	}

	public static String buscarOlimpiadaPorId(int idOlimpiada) throws SQLException {
		olimpiada = BDOlimpiadas.buscarOlimpiadaPorId(idOlimpiada);
		return olimpiada;
	}

	public static String buscarDeportesPorId(int idDeporte) throws SQLException {
		deporte = BDDeportes.buscarDeportesPorId(idDeporte);
		return deporte;
	}
}
