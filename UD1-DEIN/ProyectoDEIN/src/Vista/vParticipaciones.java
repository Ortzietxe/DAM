package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import UML.*;
import ComponentesPersonalizados.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;

public class vParticipaciones extends JFrame {

	private JPanel contentPane;
	public int row;
	private JTextField idEvento, idDeportista, idEquipo;
	private static ArrayList<ParticipacionDeportistaEventoEquipo> listaParticipaciones;
	private ArrayList<ParticipacionDeportistaEventoEquipo> listaFiltrada;
	private ArrayList<Equipo> listaEquipos;
	private ArrayList<EventoDeporteOlimpiada> listaEventos;
	private Object[][] data;
	private JButton btnModificar;
	private JTable tabla;
	DefaultTableModel tableModel = new DefaultTableModel();
	private String equipo, deportista, evento;
	DefaultTableModel eventsTableModel = new DefaultTableModel();
	private JTable tablaEventos;
	private Object[][] eventsData;
	DefaultTableModel teamsTableModel = new DefaultTableModel();
	private JTable tablaEquipos;
	private Object[][] teamsData;
	DefaultTableModel athleteTableModel = new DefaultTableModel();
	private JTable tablaDeportistas;
	private Object[][] athleteData;
	DefaultTableModel modAthleteTableModel = new DefaultTableModel();
	private JTable tablaDeportistasMod;
	private Object[][] modAthleteData;
	
	 // Column Names 
    Object[] columnNames = { "NombreDeportista", "NombreEvento", "NombreEquipo", "Edad", "Medalla" }; 
    Object[] teamsColumns = {"Nombre equipo"};
    Object[] eventsColumns = {"Nombre evento"};
    Object[] athleteColumns = {"Nombre deportista"};
    private JTextField edad;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings("unchecked")
	public vParticipaciones() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,1,8,0);
		contentPane.setBorder(brdr);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		this.setShape( new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 10, 10));
				
		AbstractBorder componentbrdr = new TextBubbleBorder(Color.BLACK,0,3,0);		
  
        // Initializing the JTable of events
		tabla = new JTable(tableModel);
		for(Object c : columnNames)
			tableModel.addColumn(c);
		
		tablaEquipos = new JTable(teamsTableModel);
		for(Object c : teamsColumns)
			teamsTableModel.addColumn(c);
		
		tablaEventos = new JTable(eventsTableModel);
		for(Object c : eventsColumns)
			eventsTableModel.addColumn(c);
		
		tablaDeportistas = new JTable(athleteTableModel);
		for(Object c : athleteColumns)
			athleteTableModel.addColumn(c);
		
		tablaDeportistasMod = new JTable(modAthleteTableModel);
		for(Object c : athleteColumns)
			modAthleteTableModel.addColumn(c);
		
		// Pedir datos y rellenar tabla
		listaParticipaciones = Controlador.pedirParticipaciones();
		setAllData(listaParticipaciones);		
		
		tabla.getColumnModel().getColumn(0).setPreferredWidth(300);     
        tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(20);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(50);
        
        tabla.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
                row = tabla.rowAtPoint(evt.getPoint());
                
                ParticipacionDeportistaEventoEquipo oParticipacion= new ParticipacionDeportistaEventoEquipo();
                
                if(listaFiltrada != null) 
                {
                	oParticipacion = listaFiltrada.get(tabla.convertRowIndexToModel(row));
                }
                else
                {
                	oParticipacion = listaParticipaciones.get(tabla.convertRowIndexToModel(row));
                }
                	
                /*idOlimpiada.setText(String.valueOf(oEvento.getIdOlimpiada()));
                idDeporte.setText(String.valueOf(oEvento.getIdDeporte()));*/
            }
        });
        
        tabla.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tabla.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        tabla.setDefaultEditor(Object.class, null);
        tabla.setBounds(30, 40, 200, 300); 
        
		// Pedir datos y rellenar tabla
		listaEventos = Controlador.pedirEventos();
		setEventsData(listaEventos);	
		
        tablaEventos.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
            	row = tablaEventos.rowAtPoint(evt.getPoint());
            	String evento = listaEventos.get(tablaEventos.convertRowIndexToModel(row)).getNombreEvento();
            	JOptionPane.showMessageDialog(null, evento);	
            	
            }
        });
        tablaEventos.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tablaEventos.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        tablaEventos.setDefaultEditor(Object.class, null);
        
        
		// Pedir datos y rellenar tabla
		listaEquipos = Controlador.pedirEquipos();
		setTeamsData(listaEquipos);
		
        tablaEquipos.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
            	
            }
        });
        tablaEquipos.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tablaEquipos.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        tablaEquipos.setDefaultEditor(Object.class, null);
        
		//Añadir scrollbar para las tablas
        JScrollPane spEventos= new JScrollPane(tablaEventos);
        spEventos.setBounds(336, 298, 220, 40);
        spEventos.setBorder(componentbrdr);
        contentPane.add(spEventos);
        
        JScrollPane spEquipos= new JScrollPane(tablaEquipos);
        spEquipos.setBounds(42, 298, 220, 40);
        spEquipos.setBorder(componentbrdr);
        contentPane.add(spEquipos);
        
        JScrollPane sp = new JScrollPane(tabla); 
        sp.setBounds(12, 58, 801, 135); 
		sp.setBorder(componentbrdr);
        contentPane.add(sp);
		
		
		botonVolver volver = new botonVolver();
		vParticipaciones frame = this;
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Controlador.mostrarVentanaPrincipal();
			}
		});
		volver.setSize(48, 48);
		volver.setToolTipText("volver");
		contentPane.add(volver);
		
		botonBorrar borrar = new botonBorrar();
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Controlador.borrarDeportista(Integer.parseInt(idDeporte.getText()));
			}
		});
		borrar.setSize(38, 41);
		borrar.setLocation(443, 349);
		volver.setSize(48, 48);
		volver.setToolTipText("volver");
		volver.setLocation(770, 5);
		contentPane.add(borrar);
		
		JLabel lblConsultaOlimpiada = new JLabel("Consulta participaciones");
		lblConsultaOlimpiada.setFont(new Font("Dialog", Font.BOLD, 24));
		lblConsultaOlimpiada.setBounds(223, 5, 345, 41);
		contentPane.add(lblConsultaOlimpiada);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				/*Controlador.modificarDeportista(Integer.parseInt(idEvento.getText()), nombre.getText(), Integer.parseInt(peso.getText()), Integer.parseInt(altura.getText()));
				setAllData(listaEventos);*/
			}
		});
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setEnabled(false);
		btnModificar.setBackground(Color.GRAY);
		btnModificar.setBounds(336, 358, 83, 26);
		btnModificar.setBorder(componentbrdr);
		contentPane.add(btnModificar);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(134, 277, 220, 9);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Modificar");
		lblNewLabel.setBounds(393, 269, 70, 15);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(493, 277, 220, 9);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nombre deportista");
		lblNewLabel_1_2_1.setBounds(32, 225, 149, 15);
		contentPane.add(lblNewLabel_1_2_1);
		
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Medalla");
		lblNewLabel_1_2_2.setBounds(607, 225, 83, 15);
		contentPane.add(lblNewLabel_1_2_2);
		
		comboBoxPersonalizado medalla = new comboBoxPersonalizado();
		medalla.setBounds(672, 221, 105, 22);
		medalla.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Silver", "Bronze", "NA"}));
		contentPane.add(medalla);
		
		JTextField nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBorder(componentbrdr);
		nombre.setBounds(170, 222, 419, 22);
		contentPane.add(nombre);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Edad");
		lblNewLabel_1_2_1_1.setBounds(606, 298, 48, 15);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		edad = new JTextField();
		edad.setColumns(10);
		edad.setBorder(componentbrdr);
		edad.setBounds(672, 295, 105, 22);
		contentPane.add(edad);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Medalla");
		lblNewLabel_1_2_2_1.setBounds(606, 323, 83, 15);
		contentPane.add(lblNewLabel_1_2_2_1);
		
		comboBoxPersonalizado medalla_1 = new comboBoxPersonalizado();
		medalla_1.setBounds(672, 319, 105, 22);
		medalla_1.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Silver", "Bronze", "NA"}));
		contentPane.add(medalla_1);
	}
	
	private void setTeamsData(ArrayList<Equipo> equipos) {
		
		teamsTableModel.getDataVector().removeAllElements();
    	
    	Object[]fila;
    	
    	for(Equipo e: equipos)
    	{
			fila= new Object[]{ e.getNombre()};
			teamsTableModel.addRow(fila);

    	}  	
    	teamsTableModel.fireTableDataChanged();  	
		
	}

	public void setEventsData(ArrayList<EventoDeporteOlimpiada> eventos) throws SQLException
    {	   	
		eventsTableModel.getDataVector().removeAllElements();
    	
    	Object[]fila;
    	
    	for(EventoDeporteOlimpiada e: eventos)
    	{
    		fila= new Object[]{ e.getNombreEvento()};
			eventsTableModel.addRow(fila);

    	}  	
    	eventsTableModel.fireTableDataChanged();  	
    }
	
    public void setAllData(ArrayList<ParticipacionDeportistaEventoEquipo> participaciones) throws SQLException
    {	   	
    	tableModel.getDataVector().removeAllElements();
    	
    	Object[]fila;
    	
    	for(ParticipacionDeportistaEventoEquipo p: participaciones)
    	{
    		fila= new Object[]{p.getNomDeportista(), p.getNomEvento(), p.getNomEquipo(), p.getEdad(), p.getMedalla()};
			tableModel.addRow(fila);

    	}  	
    	tableModel.fireTableDataChanged();  	
    }
}
