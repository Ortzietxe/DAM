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
import UML.Equipo;

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

public class vEquipos extends JFrame {

	private JPanel contentPane;
	private JTextField nomEquipo, idEquipo;
	DefaultTableModel teamsTableModel = new DefaultTableModel();
	private JTable tablaEquipos;
	private Object[][] teamsData;
	private String Equipo;
	public int row;
	private ArrayList<Equipo> listaEquipos;
	private ArrayList<Equipo> listaFiltrada;
	private JButton btnModificar;
	private botonBorrar borrar;

	//Column Names
	Object[] sportColumns = {"id", "Nombre" };
	private JTextField iniciales;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public vEquipos() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 365);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,1,8,0);
		contentPane.setBorder(brdr);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		this.setShape( new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 10, 10));
		
		JLabel lblNewLabel = new JLabel("Equipos");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setBounds(152, 12, 123, 41);
		contentPane.add(lblNewLabel);
		
		AbstractBorder componentbrdr = new TextBubbleBorder(Color.BLACK,0,3,0);
		
		tablaEquipos = new JTable(teamsTableModel);
		for(Object c : sportColumns)
			teamsTableModel.addColumn(c);
		
		tablaEquipos.getColumnModel().getColumn(0).setPreferredWidth(30);     
		tablaEquipos.getColumnModel().getColumn(1).setPreferredWidth(300);
        
		// Pedir datos y rellenar tabla
		listaEquipos = Controlador.pedirEquipos();
		setTeamsData(listaEquipos);
		
		tablaEquipos.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
            	row = tablaEquipos.rowAtPoint(evt.getPoint());
                
            	Equipo oEquipo = new Equipo();
                
                if(listaFiltrada != null) 
                {
                	oEquipo = listaFiltrada.get(tablaEquipos.convertRowIndexToModel(row));
                }
                else
                {
                	oEquipo = listaEquipos.get(tablaEquipos.convertRowIndexToModel(row));
                }
                	
                idEquipo.setText(String.valueOf(oEquipo.getIdEquipo()));
                
                btnModificar.setEnabled(true);
				btnModificar.setBackground(Color.BLACK);
            }
        });
		tablaEquipos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		tablaEquipos.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		tablaEquipos.setDefaultEditor(Object.class, null);
		       
        JScrollPane spDeportes = new JScrollPane(tablaEquipos);
        spDeportes.setBounds(12, 58, 370, 168);
        spDeportes.setBorder(componentbrdr);
        contentPane.add(spDeportes);
        
		nomEquipo = new JTextField();
		nomEquipo.setColumns(10);
		nomEquipo.setBounds(76, 297, 125, 19);
		nomEquipo.setBorder(componentbrdr);
		contentPane.add(nomEquipo);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nombre");
		lblNewLabel_1_2_1.setBounds(12, 299, 63, 15);
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
		btnNewButton.setBounds(136, 328, 111, 25);
		contentPane.add(btnNewButton);
		
		botonVolver volver = new botonVolver();
		volver.setLocation(339, 5);
		vEquipos frame = this;
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
		
		JLabel lblAltaDeporte = new JLabel("Alta Equipo");
		lblAltaDeporte.setBounds(152, 277, 95, 15);
		contentPane.add(lblAltaDeporte);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(12, 285, 114, 9);
		contentPane.add(separator);
		
		idEquipo = new JTextField();
		idEquipo.setEnabled(false);
		idEquipo.setEditable(false);
		idEquipo.setVisible(false);
		idEquipo.setBounds(173, 246, 14, 19);
		contentPane.add(idEquipo);
		idEquipo.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Iniciales");
		lblNewLabel_1_2_1_1.setBounds(212, 299, 63, 15);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		iniciales = new JTextField();
		iniciales.setColumns(10);
		iniciales.setBounds(271, 297, 111, 19);
		contentPane.add(iniciales);
		
	}
	
	
	public void setTeamsData(ArrayList<Equipo> equipos)
    {	   	
		teamsTableModel.getDataVector().removeAllElements();
    	
    	Object[]fila;
    	
    	for(Equipo e: equipos)
    	{
			fila= new Object[]{ e.getIdEquipo(), e.getNombre(), e.getIniciales()};
			teamsTableModel.addRow(fila);

    	}  	
    	teamsTableModel.fireTableDataChanged();  	
    }
}
