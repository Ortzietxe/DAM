package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import ComponentesPersonalizados.TextBubbleBorder;
import ComponentesPersonalizados.botonBorrar;
import ComponentesPersonalizados.botonVolver;
import ComponentesPersonalizados.comboBoxPersonalizado;
import Controlador.Controlador;
import UML.Deporte;
import UML.Deportista;
import UML.EventoDeporteOlimpiada;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class vDeportes extends JFrame {

	private JPanel contentPane;
	private JTextField nomDeporte, idDeporte;
	DefaultTableModel sportsTableModel = new DefaultTableModel();
	private JTable tablaDeportes;
	private Object[][] sportsData;
	private String deporte;
	public int row;
	private ArrayList<Deporte> listaDeportes;
	private ArrayList<Deporte> listaFiltrada;
	private JButton btnModificar;
	private botonBorrar borrar;

	//Column Names
	Object[] sportColumns = {"id", "Nombre" };
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public vDeportes() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 340);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,1,8,0);
		contentPane.setBorder(brdr);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		this.setShape( new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 10, 10));
		
		JLabel lblNewLabel = new JLabel("Deportes");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setBounds(137, 12, 123, 41);
		contentPane.add(lblNewLabel);
		
		AbstractBorder componentbrdr = new TextBubbleBorder(Color.BLACK,0,3,0);
		
		tablaDeportes = new JTable(sportsTableModel);
		for(Object c : sportColumns)
			sportsTableModel.addColumn(c);
		
		tablaDeportes.getColumnModel().getColumn(0).setPreferredWidth(30);     
		tablaDeportes.getColumnModel().getColumn(1).setPreferredWidth(300);
        
		// Pedir datos y rellenar tabla
		listaDeportes = Controlador.pedirDeportes();
		setSportsData(listaDeportes);
		
        tablaDeportes.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
            	row = tablaDeportes.rowAtPoint(evt.getPoint());
                
                Deporte odeporte = new Deporte();
                
                if(listaFiltrada != null) 
                {
                	odeporte = listaFiltrada.get(tablaDeportes.convertRowIndexToModel(row));
                }
                else
                {
                	odeporte = listaDeportes.get(tablaDeportes.convertRowIndexToModel(row));
                }
                	
                idDeporte.setText(String.valueOf(odeporte.getIdDeporte()));
                
                btnModificar.setEnabled(true);
				btnModificar.setBackground(Color.BLACK);
            }
        });
        tablaDeportes.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tablaDeportes.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        tablaDeportes.setDefaultEditor(Object.class, null);
		       
        JScrollPane spDeportes = new JScrollPane(tablaDeportes);
        spDeportes.setBounds(12, 58, 370, 168);
        spDeportes.setBorder(componentbrdr);
        contentPane.add(spDeportes);
        
		nomDeporte = new JTextField();
		nomDeporte.setColumns(10);
		nomDeporte.setBounds(133, 306, 125, 19);
		nomDeporte.setBorder(componentbrdr);
		contentPane.add(nomDeporte);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nombre deporte");
		lblNewLabel_1_2_1.setBounds(12, 308, 121, 15);
		contentPane.add(lblNewLabel_1_2_1);
		
		JButton btnNewButton = new JButton("Dar de alta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*String genero = "";
				String sexo =  sexoDeportista.getSelectedItem().toString();
				switch(sexo) {
				case "Hombre":
					genero = "M";
					break;
				case "Mujer":
					genero = "F";
					break;	
				}
				Controlador.altaDeportista(nomDeportista.getText(),genero, Integer.parseInt(pesoDeportista.getText()),Integer.parseInt(alturaDeportista.getText()));*/
			}
		});
		btnNewButton.setBorder(componentbrdr);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(271, 303, 111, 25);
		contentPane.add(btnNewButton);
		
		botonVolver volver = new botonVolver();
		volver.setLocation(339, 5);
		vDeportes frame = this;
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Controlador.mostrarVentanaPrincipal();
			}
		});
		volver.setSize(48, 48);
		volver.setToolTipText("volver");
		contentPane.add(volver);
		
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
		btnModificar.setBounds(195, 242, 83, 26);
		btnModificar.setBorder(componentbrdr);
		contentPane.add(btnModificar);
		
		borrar = new botonBorrar();
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Controlador.borrarDeportista(Integer.parseInt(idDeporte.getText()));
			}
		});
		borrar.setSize(38, 41);
		borrar.setLocation(131, 233);
		contentPane.add(borrar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(261, 285, 121, 9);
		contentPane.add(separator_1);
		
		JLabel lblAltaDeporte = new JLabel("Alta deporte");
		lblAltaDeporte.setBounds(152, 277, 95, 15);
		contentPane.add(lblAltaDeporte);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(12, 285, 114, 9);
		contentPane.add(separator);
		
		idDeporte = new JTextField();
		idDeporte.setEnabled(false);
		idDeporte.setEditable(false);
		idDeporte.setVisible(false);
		idDeporte.setBounds(173, 246, 14, 19);
		contentPane.add(idDeporte);
		idDeporte.setColumns(10);
		
	}
	
	
	public void setSportsData(ArrayList<Deporte> deportes)
    {	   	
    	sportsTableModel.getDataVector().removeAllElements();
    	
    	Object[]fila;
    	
    	for(Deporte d: deportes)
    	{
			fila= new Object[]{ d.getIdDeporte(), d.getNombre()};
			sportsTableModel.addRow(fila);

    	}  	
    	sportsTableModel.fireTableDataChanged();  	
    }
}
