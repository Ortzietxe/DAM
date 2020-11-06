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
import UML.Deportista;
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

public class vDeportistas extends JFrame {

	private JPanel contentPane;
	private JTextField nomDeportista;
	public int row;
	public Deportista oDeportista;
	private JTextField peso;
	private JTextField nombre;
	private JTextField altura;
	private JTextField idDeportista;
	private static ArrayList<Deportista> listaDeportistas;
	private ArrayList<Deportista> listaFiltrada;
	private Object[][] data;
	private JButton btnModificar;
	private JTable tabla;
	DefaultTableModel tableModel = new DefaultTableModel();
	
	
	 // Column Names 
    Object[] columnNames = { "id","Nombre", "Sexo", "Peso", "Altura" }; 

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public vDeportistas() throws SQLException {
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
		listaDeportistas = Controlador.pedirDatos();
		setAllData(listaDeportistas);		
		
        tabla.getColumnModel().getColumn(0).setPreferredWidth(40);     
        tabla.getColumnModel().getColumn(1).setPreferredWidth(290);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(30);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(30);
      
        tabla.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
                row = tabla.rowAtPoint(evt.getPoint());
                
                Deportista odeportista = new Deportista();
                
                if(listaFiltrada != null) 
                {
                	odeportista = listaFiltrada.get(tabla.convertRowIndexToModel(row));
                }
                else
                {
                	odeportista = listaDeportistas.get(tabla.convertRowIndexToModel(row));
                }
                	
                idDeportista.setText(String.valueOf(odeportista.getIdDeportista()));
                nombre.setText(odeportista.getNombre());
                peso.setText(String.valueOf(odeportista.getPeso()));
                altura.setText(String.valueOf(odeportista.getAltura()));
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
		vDeportistas frame = this;
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
				Controlador.borrarDeportista(Integer.parseInt(idDeportista.getText()));
			}
		});
		borrar.setSize(38, 41);
		borrar.setLocation(520, 311);
		volver.setSize(48, 48);
		volver.setToolTipText("volver");
		volver.setLocation(510, 5);
		contentPane.add(borrar);
		
		JLabel lblConsultaOlimpiada = new JLabel("Consulta deportistas");
		lblConsultaOlimpiada.setFont(new Font("Dialog", Font.BOLD, 24));
		lblConsultaOlimpiada.setBounds(140, 5, 285, 41);
		contentPane.add(lblConsultaOlimpiada);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nombre");
		lblNewLabel_1_2_1.setBounds(41, 213, 70, 15);
		contentPane.add(lblNewLabel_1_2_1);
		
		nomDeportista = new JTextField();
		nomDeportista.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{	
				listaFiltrada = new ArrayList<Deportista>();
				for(int x = 0; x < listaDeportistas.size(); x++) {
					if(listaDeportistas.get(x).getNombre().contains(nomDeportista.getText())) {
						listaFiltrada.add(listaDeportistas.get(x));						
					}
				}
				setAllData(listaFiltrada);
			}
		});
		nomDeportista.setColumns(10);
		nomDeportista.setBounds(41, 227, 345, 22);
		nomDeportista.setBorder(componentbrdr);
		contentPane.add(nomDeportista);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sexo");
		lblNewLabel_1_2.setBounds(428, 213, 83, 15);
		contentPane.add(lblNewLabel_1_2);
		
		comboBoxPersonalizado sexoDeportista = new comboBoxPersonalizado();
		sexoDeportista.setBounds(425, 229, 105, 19);
		sexoDeportista.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		contentPane.add(sexoDeportista);
				
		JLabel lblpeso = new JLabel("Peso");
		lblpeso.setBounds(12, 296, 73, 15);
		contentPane.add(lblpeso);
		
		peso = new JTextField();
		peso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				btnModificar.setEnabled(true);
				btnModificar.setBackground(Color.BLACK);
			}
		});
		peso.setColumns(10);
		peso.setBounds(69, 294, 133, 19);
		peso.setBorder(componentbrdr);
		contentPane.add(peso);
		
		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setBounds(12, 326, 73, 15);
		contentPane.add(lblnombre);
		
		nombre = new JTextField();
		nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				btnModificar.setEnabled(true);
				btnModificar.setBackground(Color.BLACK);
			}
		});
		nombre.setColumns(10);
		nombre.setBounds(69, 322, 345, 22);
		nombre.setBorder(componentbrdr);
		contentPane.add(nombre);
		
		JLabel lblaltura = new JLabel("Altura");
		lblaltura.setBounds(367, 293, 73, 15);
		contentPane.add(lblaltura);
		
		altura = new JTextField();
		altura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				btnModificar.setEnabled(true);
				btnModificar.setBackground(Color.BLACK);
			}
		});
		altura.setColumns(10);
		altura.setBounds(430, 291, 127, 19);
		altura.setBorder(componentbrdr);
		contentPane.add(altura);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Controlador.modificarDeportista(Integer.parseInt(idDeportista.getText()), nombre.getText(), Integer.parseInt(peso.getText()), Integer.parseInt(altura.getText()));
				setAllData(listaDeportistas);
			}
		});
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setEnabled(false);
		btnModificar.setBackground(Color.GRAY);
		btnModificar.setBounds(430, 320, 83, 26);
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
		
		idDeportista = new JTextField();
		idDeportista.setEnabled(false);
		idDeportista.setEditable(false);
		idDeportista.setVisible(false);
		idDeportista.setBounds(289, 293, 14, 19);
		contentPane.add(idDeportista);
		idDeportista.setColumns(10);
	}
	
    public void setAllData(ArrayList<Deportista> deportistas)
    {	
    	//int cont=0;
    	
    	//data = new Object[deportistas.size()][];
    	
    	tableModel.getDataVector().removeAllElements();
    	
    	Object[]fila;
    	
    	for(Deportista d: deportistas)
    	{
    		String genero = "";
			String sexo =  d.getGenero();
			switch(sexo) {
			case "M":
				genero = "Hombre";
				break;
			case "F":
				genero = "Mujer";
				break;	
			}

			fila= new Object[]{d.getIdDeportista(), d.getNombre(), genero, d.getPeso(), d.getAltura()};
			tableModel.addRow(fila);

    	}
    	
    	
    	tableModel.fireTableDataChanged();  	
    
    }
}
