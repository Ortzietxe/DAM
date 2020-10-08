package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class vEventos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public vEventos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Olimpiada");
		lblNewLabel_1.setBounds(23, 210, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(23, 228, 146, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Evento");
		lblNewLabel.setBounds(179, 210, 46, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(179, 228, 116, 22);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(310, 229, 99, 20);
		contentPane.add(textField);
		
		JLabel lblNombreDeporte = new JLabel("Nombre deporte");
		lblNombreDeporte.setBounds(310, 210, 99, 14);
		contentPane.add(lblNombreDeporte);
	}

}
