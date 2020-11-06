package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

import ComponentesPersonalizados.TextBubbleBorder;
import ComponentesPersonalizados.botonVolver;
import Controlador.Controlador;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class vAltaDeportista extends JFrame {

	private JPanel contentPane;
	private JTextField nomDeportista;
	private JTextField pesoDeportista;
	private JTextField alturaDeportista;

	/**
	 * Create the frame.
	 */
	public vAltaDeportista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,1,8,0);
		contentPane.setBorder(brdr);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		this.setShape( new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 10, 10));
		
		JLabel lblNewLabel = new JLabel("Alta Deportista");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setBounds(124, 12, 214, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(12, 64, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		AbstractBorder componentbrdr = new TextBubbleBorder(Color.BLACK,0,3,0);
		
		nomDeportista = new JTextField();
		nomDeportista.setColumns(10);
		nomDeportista.setBounds(79, 65, 114, 19);
		nomDeportista.setBorder(componentbrdr);
		contentPane.add(nomDeportista);
		
		JLabel lblNewLabel_1_1 = new JLabel("Peso");
		lblNewLabel_1_1.setBounds(211, 64, 40, 15);
		contentPane.add(lblNewLabel_1_1);
		
		pesoDeportista = new JTextField();
		pesoDeportista.setColumns(10);
		pesoDeportista.setBounds(300, 65, 105, 19);
		pesoDeportista.setBorder(componentbrdr);
		contentPane.add(pesoDeportista);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sexo");
		lblNewLabel_1_2.setBounds(211, 109, 86, 15);
		contentPane.add(lblNewLabel_1_2);
		
		alturaDeportista = new JTextField();
		alturaDeportista.setColumns(10);
		alturaDeportista.setBounds(79, 107, 114, 19);
		alturaDeportista.setBorder(componentbrdr);
		contentPane.add(alturaDeportista);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Altura");
		lblNewLabel_1_2_1.setBounds(12, 109, 70, 15);
		contentPane.add(lblNewLabel_1_2_1);
		
		JComboBox sexoDeportista = new JComboBox();
		sexoDeportista.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		sexoDeportista.setBounds(300, 107, 105, 19);
		contentPane.add(sexoDeportista);
		
		JButton btnNewButton = new JButton("Dar de alta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String genero = "";
				String sexo =  sexoDeportista.getSelectedItem().toString();
				switch(sexo) {
				case "Hombre":
					genero = "M";
					break;
				case "Mujer":
					genero = "F";
					break;	
				}
				Controlador.altaDeportista(nomDeportista.getText(),genero, Integer.parseInt(pesoDeportista.getText()),Integer.parseInt(alturaDeportista.getText()));
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(166, 158, 123, 25);
		contentPane.add(btnNewButton);
		
		botonVolver volver = new botonVolver();
		vAltaDeportista frame = this;
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Controlador.mostrarVentanaPrincipal();
			}
		});
		volver.setSize(48, 48);
		volver.setToolTipText("volver");
		volver.setLocation(395, 5);
		contentPane.add(volver);
	}
}
