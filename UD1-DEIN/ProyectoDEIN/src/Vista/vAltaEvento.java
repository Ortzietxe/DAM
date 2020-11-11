package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ComponentesPersonalizados.TextBubbleBorder;
import ComponentesPersonalizados.botonVolver;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
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

public class vAltaEvento extends JFrame {

	private JPanel contentPane;
	private JTextField nomEvento;
	public int row;
	private static ArrayList<Deporte> listaDeportes;
	private static ArrayList<Olimpiada> listaOlimpiadas;
	private static ArrayList<Deporte> listaDeportesFiltrada;
	private static ArrayList<Olimpiada> listaOlimpiadasFiltrada;
	private Object[][] sportsData;
	private Object[][] olimpsData;
	private JTable tablaDeportes;
	private JTable tablaOlimpiadas;
	DefaultTableModel sportsTableModel = new DefaultTableModel();
	DefaultTableModel olimpsTableModel = new DefaultTableModel();
	private JTextField idDeporte;
	private JTextField idOlimpiada;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public vAltaEvento() throws SQLException {    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,1,8,0);
		contentPane.setBorder(brdr);
		setContentPane(contentPane);
		this.setUndecorated(true);
		this.setShape( new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 10, 10));
		
		AbstractBorder componentbrdr = new TextBubbleBorder(Color.BLACK,0,3,0);
		
		// Columnas de olimpiadas y deportes
	    Object[] olimpColumns = { "id","Año", "Temporada", "Ciudad" }; 
	    Object[] sportColumns = { "id","Nombre"};
	    
	    //Creacion de las tablas
	    tablaDeportes = new JTable(sportsTableModel);
		for(Object c : sportColumns)
			sportsTableModel.addColumn(c);
			
		
		tablaOlimpiadas = new JTable(olimpsTableModel);
		for(Object c : olimpColumns)
			olimpsTableModel.addColumn(c);
		
		
		// Pedir datos y rellenar tabla
		listaDeportes = Controlador.pedirDeportes();
		setSportsData(listaDeportes);	
				
		// Pedir datos y rellenar tabla
		listaOlimpiadas = Controlador.pedirOlimpiadas();
		setOlimpsData(listaOlimpiadas);	
		
		//tamaño de las columnas para la tabla de deportes
		tablaDeportes.getColumnModel().getColumn(0).setPreferredWidth(10);
		tablaDeportes.getColumnModel().getColumn(1).setPreferredWidth(200);
		
		//metodo de cuando se clicka encima de un deporte
		tablaDeportes.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
                row = tablaDeportes.rowAtPoint(evt.getPoint());
                
                Deporte odeporte = new Deporte();
                
                if(listaDeportesFiltrada != null) 
                {
                	odeporte = listaDeportesFiltrada.get(tablaDeportes.convertRowIndexToModel(row));
                }
                else
                {
                	odeporte = listaDeportes.get(tablaDeportes.convertRowIndexToModel(row));
                }
                	
                idDeporte.setText(String.valueOf(odeporte.getIdDeporte()));
            }
        });
		//tamaño de las columnas para la tabla de olimpiadas
		tablaOlimpiadas.getColumnModel().getColumn(0).setPreferredWidth(10);
		tablaOlimpiadas.getColumnModel().getColumn(1).setPreferredWidth(20);
		tablaOlimpiadas.getColumnModel().getColumn(2).setPreferredWidth(40);
		tablaOlimpiadas.getColumnModel().getColumn(3).setPreferredWidth(150);
		
		//metodo de cuando se clicka encima de una olimpiada
		tablaOlimpiadas.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
                row = tablaOlimpiadas.rowAtPoint(evt.getPoint());
                
                Olimpiada oOlimpiada = new Olimpiada();
                
                if(listaOlimpiadasFiltrada != null) 
                {
                	oOlimpiada = listaOlimpiadasFiltrada.get(tablaOlimpiadas.convertRowIndexToModel(row));
                }
                else
                {
                	oOlimpiada = listaOlimpiadas.get(tablaOlimpiadas.convertRowIndexToModel(row));
                }
                	
                idOlimpiada.setText(String.valueOf(oOlimpiada.getIdOlimpiada()));
                
            }
        });
        contentPane.setLayout(null);
		
		//Añadir scrollbar para las tablas
        JScrollPane spDeportes = new JScrollPane(tablaDeportes);
        spDeportes.setBounds(25, 233, 400, 72);
        spDeportes.setBorder(componentbrdr);
        contentPane.add(spDeportes);
        
        JScrollPane spOlimpiadas = new JScrollPane(tablaOlimpiadas);
        spOlimpiadas.setBounds(25, 121, 400, 72);
        spOlimpiadas.setBorder(componentbrdr);
        contentPane.add(spOlimpiadas);
		
		
		JLabel lblAltaEvento = new JLabel("Alta Evento");
		lblAltaEvento.setBounds(152, 15, 160, 41);
		lblAltaEvento.setFont(new Font("Dialog", Font.BOLD, 24));
		contentPane.add(lblAltaEvento);
		
		JButton btnNewButton = new JButton("Dar de alta");
		btnNewButton.setBounds(166, 317, 123, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador.altaEvento(nomEvento.getText(), Integer.parseInt(idOlimpiada.getText()), Integer.parseInt(idDeporte.getText()));
			}
		});
		btnNewButton.setBorder(componentbrdr);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		contentPane.add(btnNewButton);
		
		JLabel lblNombreEvento = new JLabel("Nombre evento");
		lblNombreEvento.setBounds(25, 68, 123, 15);
		contentPane.add(lblNombreEvento);
		
		nomEvento = new JTextField();
		nomEvento.setBounds(180, 65, 238, 19);
		nomEvento.setColumns(10);
		btnNewButton.setBorder(componentbrdr);
		nomEvento.setBorder(componentbrdr);
		contentPane.add(nomEvento);
		
		botonVolver volver = new botonVolver();
		volver.setBounds(395, 5, 48, 48);
		vAltaEvento frame = this;
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Controlador.mostrarVentanaPrincipal();
			}
		});
		volver.setToolTipText("volver");
		contentPane.add(volver);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 104, 150, 9);
		separator.setForeground(Color.LIGHT_GRAY);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Olimpiada");
		lblNewLabel.setBounds(190, 95, 77, 15);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(277, 104, 150, 9);
		separator_1.setForeground(Color.LIGHT_GRAY);
		contentPane.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(277, 214, 150, 9);
		separator_1_1.setForeground(Color.LIGHT_GRAY);
		contentPane.add(separator_1_1);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(196, 205, 77, 15);
		contentPane.add(lblDeporte);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(25, 214, 150, 9);
		separator_2.setForeground(Color.LIGHT_GRAY);
		contentPane.add(separator_2);
		
		idDeporte = new JTextField();
		idDeporte.setEnabled(false);
		idDeporte.setEditable(false);
		idDeporte.setVisible(false);
		idDeporte.setBounds(289, 320, 14, 19);
		contentPane.add(idDeporte);
		idDeporte.setColumns(10);

		
		idOlimpiada = new JTextField();
		idOlimpiada.setEnabled(false);
		idOlimpiada.setEditable(false);
		idOlimpiada.setVisible(false);
		idOlimpiada.setBounds(152, 320, 14, 19);
		contentPane.add(idOlimpiada);
		idOlimpiada.setColumns(10);

	}
	
    public void setSportsData(ArrayList<Deporte> deportes)
    {	   	
    	sportsTableModel.getDataVector().removeAllElements();
    	
    	Object[]fila;
    	
    	for(Deporte d: deportes)
    	{
			fila= new Object[]{d.getIdDeporte(), d.getNombre()};
			sportsTableModel.addRow(fila);

    	}  	
    	sportsTableModel.fireTableDataChanged();  	
    }
    
    public void setOlimpsData(ArrayList<Olimpiada> olimpiadas)
    {	   	
    	olimpsTableModel.getDataVector().removeAllElements();
    	
    	Object[]fila;
    	
    	for(Olimpiada o: olimpiadas)
    	{
			fila= new Object[]{o.getIdOlimpiada(), o.getAnio(), o.getTemporada(), o.getCiudad()};
			olimpsTableModel.addRow(fila);

    	}  	
    	olimpsTableModel.fireTableDataChanged();  	
    }
}
