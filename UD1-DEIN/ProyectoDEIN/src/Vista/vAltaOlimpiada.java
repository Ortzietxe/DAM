package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;




import ComponentesPersonalizados.*;

public class vAltaOlimpiada extends JFrame {

	private JPanel contentPane;
	private JTextField nomOlimpiada;
	private JTextField anioOlimpiada;
	private JTextField ciudadOlimpiada;

	/**
	 * Create the frame.
	 */
	public vAltaOlimpiada() {
		
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
		
		JLabel lblNewLabel = new JLabel("Alta Olimpiada");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setBounds(124, 12, 214, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(12, 64, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		AbstractBorder componentbrdr = new TextBubbleBorder(Color.BLACK,0,3,0);
		
		nomOlimpiada = new JTextField();
		nomOlimpiada.setColumns(10);
		nomOlimpiada.setBounds(79, 65, 114, 19);
		nomOlimpiada.setBorder(componentbrdr);
		contentPane.add(nomOlimpiada);
		
		JLabel lblNewLabel_1_1 = new JLabel("Año");
		lblNewLabel_1_1.setBounds(211, 64, 40, 15);
		contentPane.add(lblNewLabel_1_1);
		
		anioOlimpiada = new JTextField();
		anioOlimpiada.setColumns(10);
		anioOlimpiada.setBounds(300, 65, 105, 19);
		anioOlimpiada.setBorder(componentbrdr);
		contentPane.add(anioOlimpiada);
		
		JLabel lblNewLabel_1_2 = new JLabel("Temporada");
		lblNewLabel_1_2.setBounds(211, 109, 86, 15);
		contentPane.add(lblNewLabel_1_2);
		
		ciudadOlimpiada = new JTextField();
		ciudadOlimpiada.setColumns(10);
		ciudadOlimpiada.setBounds(79, 107, 114, 19);
		ciudadOlimpiada.setBorder(componentbrdr);
		contentPane.add(ciudadOlimpiada);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ciudad");
		lblNewLabel_1_2_1.setBounds(12, 109, 70, 15);
		contentPane.add(lblNewLabel_1_2_1);


		comboBoxPersonalizado temporadaOlimpiada = new comboBoxPersonalizado();
		temporadaOlimpiada.setSize(105, 19);
		temporadaOlimpiada.setModel(new DefaultComboBoxModel(new String[] {"Verano", "Invierno"}));
		temporadaOlimpiada.setLocation(300, 107);
		temporadaOlimpiada.setFocusable(false);
		contentPane.add(temporadaOlimpiada);
		
		JButton btnNewButton = new JButton("Dar de alta");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String temporada = "";
					String campoTemporada =  temporadaOlimpiada.getSelectedItem().toString();
					switch(campoTemporada) {
					case "Verano":
						temporada = "Summer";
						break;
					case "Invierno":
						temporada = "Winter";
						break;	
					}
					Controlador.altaOlimpiada(nomOlimpiada.getText(), Integer.parseInt(anioOlimpiada.getText()), ciudadOlimpiada.getText(), temporada);
				}
			});
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(Color.BLACK);
			btnNewButton.setBounds(166, 158, 123, 25);
			btnNewButton.setBorder(componentbrdr);
		contentPane.add(btnNewButton);
		
		botonVolver volver = new botonVolver();
		vAltaOlimpiada frame = this;
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

