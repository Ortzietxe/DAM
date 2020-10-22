package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import Controlador.Controlador;

public class vAltaEvento extends JFrame {

	private JPanel contentPane;
	private JTextField nomEvento;
	private JTextField nomOlimpiada;
	private JTextField nomDeporte;

	/**
	 * Create the frame.
	 */
	public vAltaEvento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblAltaEvento = new JLabel("Alta Evento");
		lblAltaEvento.setFont(new Font("Dialog", Font.BOLD, 24));
		lblAltaEvento.setBounds(152, 12, 160, 41);
		contentPane.add(lblAltaEvento);
		
		JButton btnNewButton = new JButton("Dar de alta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador.altaEvento(nomEvento.getText(), nomOlimpiada.getText(), nomDeporte.getText());
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(165, 158, 123, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNombreEvento = new JLabel("Nombre evento");
		lblNombreEvento.setBounds(25, 68, 123, 15);
		contentPane.add(lblNombreEvento);
		
		JLabel lblNombreOlimpiada = new JLabel("Nombre olimpiada");
		lblNombreOlimpiada.setBounds(25, 95, 137, 15);
		contentPane.add(lblNombreOlimpiada);
		
		JLabel lblNombreEvento_1_1 = new JLabel("Nombre deporte");
		lblNombreEvento_1_1.setBounds(25, 122, 123, 15);
		contentPane.add(lblNombreEvento_1_1);
		
		nomEvento = new JTextField();
		nomEvento.setBounds(180, 65, 238, 19);
		contentPane.add(nomEvento);
		nomEvento.setColumns(10);
		
		nomOlimpiada = new JTextField();
		nomOlimpiada.setColumns(10);
		nomOlimpiada.setBounds(180, 93, 238, 19);
		contentPane.add(nomOlimpiada);
		
		nomDeporte = new JTextField();
		nomDeporte.setColumns(10);
		nomDeporte.setBounds(180, 120, 238, 19);
		contentPane.add(nomDeporte);
	}
}
