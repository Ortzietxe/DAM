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

public class vOlimpiadas extends JFrame {

	private JPanel contentPane;
	public int row;
	public Deportista oDeportista;
	private JTextField idOlimpiada;
	private static ArrayList<Olimpiada> listaOlimpiadas;
	private ArrayList<Olimpiada> listaFiltrada;
	private Object[][] data;
	private JButton btnModificar;
	private JTable tabla;
	DefaultTableModel tableModel = new DefaultTableModel();
	
	
	 // Column Names 
    Object[] columnNames = { "id","Nombre", "Año", "Temporada", "Ciudad" }; 
    private JTextField nomOlimpiada;
    private JTextField olimpiadaMod;
    private JTextField anio;
    private JTextField ciudad;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public vOlimpiadas() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 360);
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
		listaOlimpiadas = Controlador.pedirOlimpiadas();
		setAllData(listaOlimpiadas);		
		
        tabla.getColumnModel().getColumn(0).setPreferredWidth(20);     
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(40);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(230);
      
        tabla.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
                row = tabla.rowAtPoint(evt.getPoint());
                
                Olimpiada oOlimpiada = new Olimpiada();
                
                if(listaFiltrada != null) 
                {
                	oOlimpiada = listaFiltrada.get(tabla.convertRowIndexToModel(row));
                }
                else
                {
                	oOlimpiada = listaOlimpiadas.get(tabla.convertRowIndexToModel(row));
                }
                	
                /*idOlimpiada.setText(String.valueOf(odeportista.getIdDeportista()));
                nombre.setText(odeportista.getNombre());
                peso.setText(String.valueOf(odeportista.getPeso()));
                altura.setText(String.valueOf(odeportista.getAltura()));*/
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
		vOlimpiadas frame = this;
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
				Controlador.borrarDeportista(Integer.parseInt(idOlimpiada.getText()));
			}
		});
		borrar.setSize(38, 41);
		borrar.setLocation(520, 313);
		volver.setSize(48, 48);
		volver.setToolTipText("volver");
		volver.setLocation(510, 5);
		contentPane.add(borrar);
		
		JLabel lblConsultaOlimpiada = new JLabel("Consulta deportistas");
		lblConsultaOlimpiada.setFont(new Font("Dialog", Font.BOLD, 24));
		lblConsultaOlimpiada.setBounds(140, 5, 285, 41);
		contentPane.add(lblConsultaOlimpiada);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//Controlador.modificarDeportista(Integer.parseInt(idOlimpiada.getText()), nombre.getText(), Integer.parseInt(peso.getText()), Integer.parseInt(altura.getText()));
				setAllData(listaOlimpiadas);
			}
		});
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setEnabled(false);
		btnModificar.setBackground(Color.GRAY);
		btnModificar.setBounds(436, 322, 83, 26);
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
		
		idOlimpiada = new JTextField();
		idOlimpiada.setEnabled(false);
		idOlimpiada.setEditable(false);
		idOlimpiada.setVisible(false);
		idOlimpiada.setBounds(423, 327, 14, 19);
		contentPane.add(idOlimpiada);
		idOlimpiada.setColumns(10);
		
		nomOlimpiada = new JTextField();
		nomOlimpiada.setColumns(10);
		nomOlimpiada.setBorder(componentbrdr);
		nomOlimpiada.setBounds(54, 230, 325, 22);
		contentPane.add(nomOlimpiada);
		
		JLabel lblolimpiada = new JLabel("Nombre olimpiada");
		lblolimpiada.setBounds(54, 205, 129, 15);
		contentPane.add(lblolimpiada);
		
		comboBoxPersonalizado temporada = new comboBoxPersonalizado();
		temporada.setBounds(403, 229, 105, 22);
		contentPane.add(temporada);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Temporada");
		lblNewLabel_1_2_2.setBounds(403, 205, 83, 15);
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 289, 61, 15);
		contentPane.add(lblNombre);
		
		olimpiadaMod = new JTextField();
		olimpiadaMod.setColumns(10);
		olimpiadaMod.setBorder(componentbrdr);
		olimpiadaMod.setBounds(75, 286, 285, 22);
		contentPane.add(olimpiadaMod);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Temporada");
		lblNewLabel_1_2_2_1.setBounds(367, 289, 83, 15);
		contentPane.add(lblNewLabel_1_2_2_1);
		
		comboBoxPersonalizado temporada_1 = new comboBoxPersonalizado();
		temporada_1.setBounds(453, 285, 105, 22);
		contentPane.add(temporada_1);
		
		JLabel lblAo = new JLabel("Año");
		lblAo.setBounds(12, 327, 61, 15);
		contentPane.add(lblAo);
		
		anio = new JTextField();
		anio.setColumns(10);
		anio.setBorder(componentbrdr);
		anio.setBounds(75, 324, 83, 22);
		contentPane.add(anio);
		
		JLabel lblNombre_2 = new JLabel("Ciudad");
		lblNombre_2.setBounds(170, 327, 61, 15);
		contentPane.add(lblNombre_2);
		
		ciudad = new JTextField();
		ciudad.setColumns(10);
		ciudad.setBorder(componentbrdr);
		ciudad.setBounds(233, 324, 179, 22);
		contentPane.add(ciudad);
	}
	
    public void setAllData(ArrayList<Olimpiada> olimpiadas)
    {	   	
    	tableModel.getDataVector().removeAllElements();
    	
    	Object[]fila;
    	
    	for(Olimpiada o: olimpiadas)
    	{
			fila= new Object[]{ o.getIdOlimpiada(), o.getNombre(), o.getAnio(), o.getTemporada(), o.getCiudad()};
			tableModel.addRow(fila);	
    	}  	
    	tableModel.fireTableDataChanged();  	
    }
}
