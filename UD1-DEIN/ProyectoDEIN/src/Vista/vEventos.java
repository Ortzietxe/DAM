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

public class vEventos extends JFrame {

	private JPanel contentPane;
	public int row;
	private JTextField idDeporte, idOlimpiada;
	private static ArrayList<EventoDeporteOlimpiada> listaEventos;
	private ArrayList<EventoDeporteOlimpiada> listaFiltrada;
	private ArrayList<Deporte> listaDeportes;
	private ArrayList<Olimpiada> listaOlimpiadas;
	private Object[][] data;
	private JButton btnModificar;
	private JTable tabla;
	DefaultTableModel tableModel = new DefaultTableModel();
	private String olimpiada, deporte;
	DefaultTableModel sportsTableModel = new DefaultTableModel();
	private JTable tablaDeportes;
	private Object[][] sportsData;
	DefaultTableModel modSportsTableModel = new DefaultTableModel();
	private JTable tablaDeportesMod;
	private Object[][] modSportsData;
	DefaultTableModel olimpsTableModel = new DefaultTableModel();
	private JTable tablaOlimpiadas;
	private Object[][] olimpsData;
	
	 // Column Names 
    Object[] columnNames = { "id","Nombre", "Olimpiada", "Deporte" }; 
    Object[] sportColumns = {"Deporte"};
    Object[] olimpsColumns = {"Nombre"};
    private JTextField modNombre;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings("unchecked")
	public vEventos() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 400);
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
		
	    tablaDeportesMod = new JTable(modSportsTableModel);
		for(Object c : sportColumns)
			modSportsTableModel.addColumn(c);
		
	    tablaDeportes = new JTable(sportsTableModel);
		for(Object c : sportColumns)
			sportsTableModel.addColumn(c);
		
	    tablaOlimpiadas = new JTable(olimpsTableModel);
		for(Object c : olimpsColumns)
			olimpsTableModel.addColumn(c);
		
		// Pedir datos y rellenar tabla
		listaEventos = Controlador.pedirEventos();
		setAllData(listaEventos);		
		
		tabla.getColumnModel().getColumn(0).setPreferredWidth(20);     
        tabla.getColumnModel().getColumn(1).setPreferredWidth(370);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(170);
        
        tabla.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
                row = tabla.rowAtPoint(evt.getPoint());
                
                EventoDeporteOlimpiada oEvento = new EventoDeporteOlimpiada();
                
                if(listaFiltrada != null) 
                {
                	oEvento = listaFiltrada.get(tabla.convertRowIndexToModel(row));
                }
                else
                {
                	oEvento = listaEventos.get(tabla.convertRowIndexToModel(row));
                }
                	
                idOlimpiada.setText(String.valueOf(oEvento.getIdOlimpiada()));
                idDeporte.setText(String.valueOf(oEvento.getIdDeporte()));
            }
        });
        
        tabla.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tabla.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        tabla.setDefaultEditor(Object.class, null);
        tabla.setBounds(30, 40, 200, 300); 
        
		// Pedir datos y rellenar tabla
		listaDeportes = Controlador.pedirDeportes();
		setSportsData(listaDeportes);
		
        tablaDeportes.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
            	row = tablaDeportes.rowAtPoint(evt.getPoint());
            	listaFiltrada = new ArrayList<EventoDeporteOlimpiada>();
				for(int x = 0; x < listaEventos.size(); x++) {
					if(listaEventos.get(x).getNombreDeporte().contains(listaDeportes.get(tablaDeportes.convertRowIndexToModel(row)).toString())) {
						listaFiltrada.add(listaEventos.get(x));						
					}
				}
				try {
					setAllData(listaEventos);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        tablaDeportes.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tablaDeportes.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        tablaDeportes.setDefaultEditor(Object.class, null);
        
        tablaDeportesMod.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
            	
            }
        });
        tablaDeportesMod.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tablaDeportesMod.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        tablaDeportesMod.setDefaultEditor(Object.class, null);
        
		// Pedir datos y rellenar tabla
		listaOlimpiadas = Controlador.pedirOlimpiadas();
		setOlimpsData(listaOlimpiadas);
		
        tablaOlimpiadas.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
            	
            }
        });
        tablaOlimpiadas.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tablaOlimpiadas.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        tablaOlimpiadas.setDefaultEditor(Object.class, null);
        
		//Añadir scrollbar para las tablas
        JScrollPane spOlimpiadas= new JScrollPane(tablaOlimpiadas);
        spOlimpiadas.setBounds(518, 297, 220, 40);
        spOlimpiadas.setBorder(componentbrdr);
        contentPane.add(spOlimpiadas);
        
        JScrollPane spDeportesMod = new JScrollPane(tablaDeportesMod);
        spDeportesMod.setBounds(281, 297, 220, 40);
        spDeportesMod.setBorder(componentbrdr);
        contentPane.add(spDeportesMod);
        
        JScrollPane spDeportes = new JScrollPane(tablaDeportes);
        spDeportes.setBounds(369, 203, 249, 40);
        spDeportes.setBorder(componentbrdr);
        contentPane.add(spDeportes);
        
        JScrollPane sp = new JScrollPane(tabla); 
        sp.setBounds(12, 58, 726, 135); 
		sp.setBorder(componentbrdr);
        contentPane.add(sp);
		
		
		botonVolver volver = new botonVolver();
		vEventos frame = this;
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
				Controlador.borrarDeportista(Integer.parseInt(idDeporte.getText()));
			}
		});
		borrar.setSize(38, 41);
		borrar.setLocation(443, 349);
		volver.setSize(48, 48);
		volver.setToolTipText("volver");
		volver.setLocation(695, 5);
		contentPane.add(borrar);
		
		JLabel lblConsultaOlimpiada = new JLabel("Consulta eventos");
		lblConsultaOlimpiada.setFont(new Font("Dialog", Font.BOLD, 24));
		lblConsultaOlimpiada.setBounds(267, 5, 285, 41);
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
		separator.setBounds(84, 274, 220, 9);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Modificar");
		lblNewLabel.setBounds(343, 266, 70, 15);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(443, 274, 220, 9);
		contentPane.add(separator_1);
		
		idDeporte = new JTextField();
		idDeporte.setEnabled(false);
		idDeporte.setEditable(false);
		idDeporte.setVisible(false);
		idDeporte.setBounds(429, 362, 14, 19);
		contentPane.add(idDeporte);
		idDeporte.setColumns(10);
		
		idOlimpiada = new JTextField();
		idOlimpiada.setEnabled(false);
		idOlimpiada.setEditable(false);
		idOlimpiada.setVisible(false);
		idOlimpiada.setBounds(310, 362, 14, 19);
		contentPane.add(idOlimpiada);
		idOlimpiada.setColumns(10);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nombre evento");
		lblNewLabel_1_2_1.setBounds(12, 201, 129, 15);
		contentPane.add(lblNewLabel_1_2_1);
		
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Temporada");
		lblNewLabel_1_2_2.setBounds(636, 201, 83, 15);
		contentPane.add(lblNewLabel_1_2_2);
		
		comboBoxPersonalizado temporada = new comboBoxPersonalizado();
		temporada.setBounds(633, 221, 105, 22);
		temporada.setModel(new DefaultComboBoxModel(new String[] {"Winter", "Summer"}));
		contentPane.add(temporada);
		
		JTextField nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBorder(componentbrdr);
		nombre.setBounds(12, 221, 345, 22);
		contentPane.add(nombre);
		
		modNombre = new JTextField();
		modNombre.setColumns(10);
		modNombre.setBorder(componentbrdr);
		modNombre.setBounds(12, 315, 249, 22);
		contentPane.add(modNombre);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Nombre evento");
		lblNewLabel_1_2_1_1.setBounds(12, 295, 129, 15);
		contentPane.add(lblNewLabel_1_2_1_1);
	}
	
	private void setOlimpsData(ArrayList<Olimpiada> olimpiadas) {
		olimpsTableModel.getDataVector().removeAllElements();
    	
    	Object[]fila;
    	
    	for(Olimpiada o: olimpiadas)
    	{
			fila= new Object[]{ o.getNombre()};
			olimpsTableModel.addRow(fila);

    	}  	
    	olimpsTableModel.fireTableDataChanged();  	
		
	}

	public void setSportsData(ArrayList<Deporte> deportes)
    {	   	
    	sportsTableModel.getDataVector().removeAllElements();
    	
    	Object[]fila;
    	
    	for(Deporte d: deportes)
    	{
			fila= new Object[]{ d.getNombre()};
			sportsTableModel.addRow(fila);

    	}  	
    	sportsTableModel.fireTableDataChanged();  	
    }
	
    public void setAllData(ArrayList<EventoDeporteOlimpiada> eventos) throws SQLException
    {	   	
    	tableModel.getDataVector().removeAllElements();
    	
    	Object[]fila;
    	
    	for(EventoDeporteOlimpiada e: eventos)
    	{
    		fila= new Object[]{e.getIdEvento(), e.getNombreEvento(), e.getNombreOlimpiada(), e.getNombreDeporte() };
			tableModel.addRow(fila);

    	}  	
    	tableModel.fireTableDataChanged();  	
    }
}
