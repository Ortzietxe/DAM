package Vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import BD.clsgestorLD;

public class vPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JLabel Titulo;
	private JButton btnAceptar;
	private JLabel lblNombre;
	private ArrayList<String> listaDeportes;
	/**
	 * Create the frame.
	 */
	public vPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Titulo = new JLabel("Busqueda Deporte");
		Titulo.setBounds(94, 11, 241, 32);
		Titulo.setFont(new Font("Dialog", Font.BOLD, 26));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(Titulo);
		
		/*
		 * btnAceptar = new JButton("Buscar"); btnAceptar.addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent arg0) {
		 * buscarCoincidencias(arg0); } });
		btnAceptar.setBounds(253, 71, 163, 19);
		contentPane.add(btnAceptar);*/
		
		txtNombre = new JTextField();
		txtNombre.setBounds(103, 71, 114, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(31, 73, 70, 15);
		contentPane.add(lblNombre);
		

	}
}
