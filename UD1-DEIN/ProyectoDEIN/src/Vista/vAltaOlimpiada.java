package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 450, 220);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alta Olimpiada");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setBounds(124, 12, 214, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(12, 64, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		nomOlimpiada = new JTextField();
		nomOlimpiada.setColumns(10);
		nomOlimpiada.setBounds(79, 65, 114, 19);
		contentPane.add(nomOlimpiada);
		
		JLabel lblNewLabel_1_1 = new JLabel("Año");
		lblNewLabel_1_1.setBounds(211, 64, 40, 15);
		contentPane.add(lblNewLabel_1_1);
		
		anioOlimpiada = new JTextField();
		anioOlimpiada.setColumns(10);
		anioOlimpiada.setBounds(300, 65, 105, 19);
		contentPane.add(anioOlimpiada);
		
		JLabel lblNewLabel_1_2 = new JLabel("Temporada");
		lblNewLabel_1_2.setBounds(211, 109, 86, 15);
		contentPane.add(lblNewLabel_1_2);
		
		ciudadOlimpiada = new JTextField();
		ciudadOlimpiada.setColumns(10);
		ciudadOlimpiada.setBounds(79, 107, 114, 19);
		contentPane.add(ciudadOlimpiada);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ciudad");
		lblNewLabel_1_2_1.setBounds(12, 109, 70, 15);
		contentPane.add(lblNewLabel_1_2_1);
		
		JComboBox temporadaOlimpiada = new JComboBox();
		temporadaOlimpiada.setModel(new DefaultComboBoxModel(new String[] {"Summer", "Winter"}));
		temporadaOlimpiada.setBounds(300, 107, 105, 19);
		contentPane.add(temporadaOlimpiada);
		
		JButton btnNewButton = new JButton("Dar de alta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador.altaOlimpiada(nomOlimpiada.getText(), Integer.parseInt(anioOlimpiada.getText()), ciudadOlimpiada.getText(), temporadaOlimpiada.getSelectedItem().toString());
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(166, 158, 123, 25);
		contentPane.add(btnNewButton);
	}
}
