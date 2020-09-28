package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Main;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vPrincipal extends JFrame {

//	private JPanel contentPane;
	private JDesktopPane contenedor;
	private JMenuBar menuBar;
	private JMenu mnAlta;
	private JMenu mnBaja;
	private JMenu mnConsultar;
	private JMenuItem mntmAltaDeporte;
	private JMenuItem mntmAltaEquipo;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public vPrincipal() 
	{
		
		contenedor = new JDesktopPane();
		this.setContentPane(contenedor);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
//		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(new BorderLayout(0, 0));
		
		
//		contentPane.add(contenedor);
		contenedor.setLayout(new BorderLayout());
		
//		JLabel lblNewLabel = new JLabel("MENU");
//		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 40));
//		contenedor.add(lblNewLabel);
		
		
		this.setContentPane(contenedor);
		this.setJMenuBar(this.CrearMenu());
	}
	
	private JMenuBar CrearMenu()
	{
		menuBar = new JMenuBar();
		contenedor.add(menuBar, BorderLayout.NORTH);
		
		mnAlta = new JMenu("Dar de alta");
		menuBar.add(mnAlta);
		
		mntmAltaDeporte = new JMenuItem("Alta Deporte");
		mnAlta.add(mntmAltaDeporte);
		
		mntmAltaEquipo = new JMenuItem("Alta Equipo");
		mntmAltaEquipo.addActionListener(new ActionListener() 
										{
											public void actionPerformed(ActionEvent arg0) 
											{
													mostrarAltaEquipo();
											}
										});
		mnAlta.add(mntmAltaEquipo);
		
		mnBaja = new JMenu("Dar de baja");
		menuBar.add(mnBaja);
		
		mnConsultar = new JMenu("Consultar");
		menuBar.add(mnConsultar);
		
		return menuBar;
		
		
	}
	
	
	public void mostrarAltaEquipo()
	{
		AltaEquipo frame = new AltaEquipo();
		frame.setVisible(true);
		contenedor.add(frame);
	}
	
	
}
