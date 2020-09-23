package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel Titulo;
	private JButton btnNewButton;
	private JLabel lblNombre;
	private JList listaDeportes;
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
		
		Titulo = new JLabel("Alta Deporte");
		Titulo.setBounds(119, 5, 205, 32);
		Titulo.setFont(new Font("Dialog", Font.BOLD, 26));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(Titulo);
		
		btnNewButton = new JButton("Añadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				anadirDeporte(arg0);
			}
		});
		btnNewButton.setBounds(253, 71, 163, 19);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(103, 71, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(31, 73, 70, 15);
		contentPane.add(lblNombre);
		
		listaDeportes = new JList();
		listaDeportes.setBounds(61, 129, 326, 101);
		contentPane.add(listaDeportes);
	}
	private void anadirDeporte(ActionEvent arg0) {
		listaDeportes.add()
	}
}
