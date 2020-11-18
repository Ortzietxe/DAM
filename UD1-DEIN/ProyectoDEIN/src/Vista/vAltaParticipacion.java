package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import ComponentesPersonalizados.TextBubbleBorder;
import ComponentesPersonalizados.botonVolver;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import Controlador.Controlador;
import UML.*;

import javax.swing.JSeparator;
import ComponentesPersonalizados.comboBoxPersonalizado;

public class vAltaParticipacion extends JFrame {

	private JPanel contentPane;
	public int row;
	private static ArrayList<Deportista> listaDeportistas;
	private static ArrayList<Equipo> listaEquipos;
	private static ArrayList<EventoDeporteOlimpiada> listaEventos;
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
	private JTextField idEquipo, idEvento, idDeportista;
	private JTextField edad;
	public comboBoxPersonalizado medalla;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public vAltaParticipacion() throws SQLException {    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 288);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,1,8,0);
		contentPane.setBorder(brdr);
		setContentPane(contentPane);
		this.setUndecorated(true);
		this.setShape( new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 10, 10));
        contentPane.setLayout(null);
		
		AbstractBorder componentbrdr = new TextBubbleBorder(Color.BLACK,0,3,0);
		
		// Columnas de olimpiadas y deportes
	    Object[] teamsColumns = {"Nombre"};
	    Object[] eventsColumns = {"Nombre"};
	    Object[] athleteColumns = {"Nombre"};
	    
	    //Creacion de las tablas
	    tablaEquipos = new JTable(teamsTableModel);
		for(Object c : teamsColumns)
			teamsTableModel.addColumn(c);
		
		tablaEventos = new JTable(eventsTableModel);
		for(Object c : eventsColumns)
			eventsTableModel.addColumn(c);
		
		tablaDeportistas = new JTable(athleteTableModel);
		for(Object c : athleteColumns)
			athleteTableModel.addColumn(c);
		
		// Pedir datos y rellenar tabla
		listaDeportistas = Controlador.pedirDeportistas();
		setAthleteData(listaDeportistas);
		
		tablaDeportistas.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
            	row = tablaDeportistas.rowAtPoint(evt.getPoint());
            	int deportista = listaDeportistas.get(tablaDeportistas.convertRowIndexToModel(row)).getIdDeportista();
            	idDeportista.setText(String.valueOf(deportista));
            }
        });
		tablaDeportistas.setFont(new Font("SansSerif", Font.PLAIN, 12));
		tablaDeportistas.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		tablaDeportistas.setDefaultEditor(Object.class, null);
        	        
		        
		// Pedir datos y rellenar tabla
		listaEventos = Controlador.pedirEventos();
		setEventsData(listaEventos);	
		
        tablaEventos.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
            	row = tablaEventos.rowAtPoint(evt.getPoint());
            	int evento = listaEventos.get(tablaEventos.convertRowIndexToModel(row)).getIdEvento();
            	idEvento.setText(String.valueOf(evento));	
            	
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
             	row = tablaEquipos.rowAtPoint(evt.getPoint());
             	int equipo = listaEquipos.get(tablaEquipos.convertRowIndexToModel(row)).getIdEquipo();
             	idEquipo.setText(String.valueOf(equipo));
             }
         });
         tablaEquipos.setFont(new Font("SansSerif", Font.PLAIN, 12));
         tablaEquipos.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
         tablaEquipos.setDefaultEditor(Object.class, null);
		
 		//Añadir scrollbar para las tablas
		JScrollPane spEventos= new JScrollPane(tablaEventos);
		spEventos.setBounds(24, 149, 283, 40);
		spEventos.setBorder(componentbrdr);
		contentPane.add(spEventos);
		
		JScrollPane spEquipos= new JScrollPane(tablaEquipos);
		spEquipos.setBounds(273, 57, 220, 40);
		spEquipos.setBorder(componentbrdr);
		contentPane.add(spEquipos);
		
		JScrollPane spDeportistas= new JScrollPane(tablaDeportistas);
		spDeportistas.setBounds(24, 57, 220, 40);
		spDeportistas.setBorder(componentbrdr);
		contentPane.add(spDeportistas);
        
		JLabel lblAltaEvento = new JLabel("Alta Participación");
		lblAltaEvento.setBounds(125, 12, 237, 41);
		lblAltaEvento.setFont(new Font("Dialog", Font.BOLD, 24));
		contentPane.add(lblAltaEvento);
		
		JButton btnNewButton = new JButton("Dar de alta");
		btnNewButton.setBounds(198, 240, 123, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador.altaParticipacion(Integer.parseInt(idDeportista.getText()), Integer.parseInt(idEvento.getText()), Integer.parseInt(idEquipo.getText()), Integer.parseInt(edad.getText()), medalla.getSelectedItem().toString());
			}
		});
		btnNewButton.setBorder(componentbrdr);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		contentPane.add(btnNewButton);
		btnNewButton.setBorder(componentbrdr);
		
		botonVolver volver = new botonVolver();
		volver.setBounds(465, 5, 48, 48);
		vAltaParticipacion frame = this;
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Controlador.mostrarVentanaPrincipal();
			}
		});
		volver.setToolTipText("volver");
		contentPane.add(volver);
		
		idEquipo = new JTextField();
		idEquipo.setEnabled(false);
		idEquipo.setEditable(false);
		idEquipo.setVisible(false);
		idEquipo.setBounds(321, 243, 14, 19);
		contentPane.add(idEquipo);
		idEquipo.setColumns(10);

		
		idEvento = new JTextField();
		idEvento.setEnabled(false);
		idEvento.setEditable(false);
		idEvento.setVisible(false);
		idEvento.setBounds(250, 264, 14, 19);
		contentPane.add(idEvento);
		idEvento.setColumns(10);

		idDeportista = new JTextField();
		idDeportista.setEnabled(false);
		idDeportista.setEditable(false);
		idDeportista.setVisible(false);
		idDeportista.setBounds(184, 243, 14, 19);
		contentPane.add(idDeportista);
		idDeportista.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Edad");
		lblNewLabel_1_2_1_1.setBounds(321, 150, 48, 15);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		edad = new JTextField();
		edad.setColumns(10);
		edad.setBorder(componentbrdr);
		edad.setBounds(387, 147, 105, 22);
		contentPane.add(edad);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Medalla");
		lblNewLabel_1_2_2_1.setBounds(321, 175, 83, 15);
		contentPane.add(lblNewLabel_1_2_2_1);
		
		medalla = new comboBoxPersonalizado();
		medalla.setBounds(387, 170, 105, 22);
		medalla.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Silver", "Bronze", "NA"}));
		contentPane.add(medalla);
	}
	
    public void setAthleteData(ArrayList<Deportista> deportista)
    {	   	
    	athleteTableModel.getDataVector().removeAllElements();
    	
    	Object[]fila;
    	
    	for(Deportista d: deportista)
    	{
			fila= new Object[]{d.getNombre()};
			athleteTableModel.addRow(fila);

    	}  	
    	athleteTableModel.fireTableDataChanged();  	
    }
    
    public void setTeamsData(ArrayList<Equipo> equipos) {
		
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
}
