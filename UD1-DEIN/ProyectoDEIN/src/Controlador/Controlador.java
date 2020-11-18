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
	private static vOlimpiadas vco;
	public static vDeportes vd;
	public static vEquipos ve;
	public static vParticipaciones vpa;
	public static vAltaParticipacion vapa;
	private static Olimpiada oOlimpiada;
	private static Deportista oDeportista;
	private static Evento oEvento;
	private static Deporte oDeporte;
	private static Equipo oEquipo;
	private static Participacion oParticipacion;
	private static ArrayList<Deportista> listaDeportistas;
	private static ArrayList<Deporte> listaDeportes;
	private static ArrayList<Olimpiada> listaOlimpiadas;
	private static ArrayList<Equipo> listaEquipos;
	private static ArrayList<EventoDeporteOlimpiada> listaEventos;
	private static ArrayList<ParticipacionDeportistaEventoEquipo> listaParticipaciones;
	private static String olimpiada,deporte,equipo;
	
	public static void mostrarVentanaPrincipal()
	{
		vp = new vPrincipal();
		vp.setVisible(true);
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
	
	public static ArrayList<EventoDeporteOlimpiada> pedirEventos() throws SQLException {
		listaEventos = BDEventos.buscarEventos();		
		return listaEventos;
	}

	public static void mostrarConsultaEvento() throws SQLException {
		vp.setVisible(false);
		
		vce = new vEventos();
		vce.setVisible(true);	
	}

	public static void mostrarConsultaOlimpiada() throws SQLException {
		vp.setVisible(false);
		
		vco = new vOlimpiadas();
		vco.setVisible(true);		
	}


	public static void mostrarDeportes() throws SQLException {
		vp.setVisible(false);
		
		vd = new vDeportes();
		vd.setVisible(true);	
	}


	public static void mostrarParticipaciones() throws SQLException{
		vp.setVisible(false);
		
		vpa = new vParticipaciones();
		vpa.setVisible(true);	
	}


	public static void mostrarAltaParticipacion() throws SQLException{
		vp.setVisible(false);
		
		vapa = new vAltaParticipacion();
		vapa.setVisible(true);
	}


	public static void mostrarEquipos() throws SQLException {
		vp.setVisible(false);
		
		ve = new vEquipos();
		ve.setVisible(true);	
	}


	public static ArrayList<Equipo> pedirEquipos() throws SQLException {
		listaEquipos = BDEquipos.buscarEquipos();		
		return listaEquipos;
	}


	public static ArrayList<ParticipacionDeportistaEventoEquipo> pedirParticipaciones() throws SQLException {
		listaParticipaciones = BDParticipaciones.buscarParticipaciones();		
		return listaParticipaciones;
	}


	public static void altaParticipacion(int idDeportista, int idEvento, int idEquipo, int edad, String medalla) {
		oParticipacion = new Participacion(idDeportista, idEvento, idEquipo, edad, medalla);
		BDParticipaciones.altaParticipacionBD(oParticipacion);	
		
	}

}
