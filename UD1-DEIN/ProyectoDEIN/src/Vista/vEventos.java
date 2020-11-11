package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class vEventos extends JFrame {

	private JPanel contentPane;
	public int row;
	private JTextField idEvento;
	private static ArrayList<Evento> listaEventos;
	private ArrayList<Evento> listaFiltrada;
	private Object[][] data;
	private JButton btnModificar;
	private JTable tabla;
	DefaultTableModel tableModel = new DefaultTableModel();
	private String olimpiada, deporte;
	
	
	 // Column Names 
    Object[] columnNames = { "id","Nombre", "Olimpiada", "Deporte" }; 

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public vEventos() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 420);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,1,8,0);
		contentPane.setBorder(brdr);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		this.setShape( new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 10, 10));
				
		AbstractBorder componentbrdr = new TextBubbleBorder(Color.BLACK,0,3,0);		
  
        // Initializing the JTable 
		tabla = new JTable(tableModel);
		for(Object c : columnNames)
			tableModel.addColumn(c);
		
		// Pedir datos y rellenar tabla
		listaEventos = Controlador.pedirEventos();
		setAllData(listaEventos);		
      
        tabla.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
                row = tabla.rowAtPoint(evt.getPoint());
                
                Evento oEvento = new Evento();
                
                if(listaFiltrada != null) 
                {
                	oEvento = listaFiltrada.get(tabla.convertRowIndexToModel(row));
                }
                else
                {
                	oEvento = listaEventos.get(tabla.convertRowIndexToModel(row));
                }
                	
                /*idEvento.setText(String.valueOf(oEvento.getIdEvento()));
                nombre.setText(oEvento.getNombre());
                idOlimpiada.setText(String.valueOf(oEvento.getIdOlimpiada()));
                idDeporte.setText(String.valueOf(oEvento.getIdDeporte()));*/
            }
        });
        
        tabla.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tabla.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        tabla.setDefaultEditor(Object.class, null);
        tabla.setBounds(30, 40, 200, 300); 
        
  
        // adding it to JScrollPane 
        JScrollPane sp = new JScrollPane(tabla); 
        sp.setBounds(12, 58, 546, 135); 
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
		volver.setLocation(510, 5);
		contentPane.add(volver);
		
		botonBorrar borrar = new botonBorrar();
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador.borrarDeportista(Integer.parseInt(idEvento.getText()));
			}
		});
		borrar.setSize(38, 41);
		borrar.setLocation(322, 367);
		volver.setSize(48, 48);
		volver.setToolTipText("volver");
		volver.setLocation(510, 5);
		contentPane.add(borrar);
		
		JLabel lblConsultaOlimpiada = new JLabel("Consulta eventos");
		lblConsultaOlimpiada.setFont(new Font("Dialog", Font.BOLD, 24));
		lblConsultaOlimpiada.setBounds(160, 5, 285, 41);
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
		btnModificar.setBounds(215, 376, 83, 26);
		btnModificar.setBorder(componentbrdr);
		contentPane.add(btnModificar);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(41, 272, 175, 9);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Modificar");
		lblNewLabel.setBounds(255, 264, 70, 15);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(347, 272, 175, 9);
		contentPane.add(separator_1);
		
		idEvento = new JTextField();
		idEvento.setEnabled(false);
		idEvento.setEditable(false);
		idEvento.setVisible(false);
		idEvento.setBounds(308, 380, 14, 19);
		contentPane.add(idEvento);
		idEvento.setColumns(10);
	}
	
    public void setAllData(ArrayList<Evento> eventos) throws SQLException
    {	   	
    	tableModel.getDataVector().removeAllElements();
    	
    	Object[]fila;
    	
    	for(Evento e: eventos)
    	{
    		olimpiada = Controlador.buscarOlimpiadaPorId(e.getIdOlimpiada());
    		deporte = Controlador.buscarDeportesPorId(e.getIdDeporte());
    		fila= new Object[]{e.getIdEvento(), e.getNombre(), olimpiada, e.getIdDeporte() };
			tableModel.addRow(fila);

    	}  	
    	tableModel.fireTableDataChanged();  	
    }
}
