package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;

public class vParticipaciones extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	public vParticipaciones() {
		setBackground(new Color(0, 100, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Evento");
		lblNewLabel.setBounds(176, 210, 84, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Olimpiada");
		lblNewLabel_1.setBounds(20, 210, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNombreDeportista = new JLabel("Nombre deportista");
		lblNombreDeportista.setBounds(307, 210, 162, 14);
		contentPane.add(lblNombreDeportista);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(176, 228, 116, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(20, 228, 146, 22);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(307, 229, 141, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBackground(Color.BLACK);
		table.setBounds(356, 157, -328, -140);
		contentPane.add(table);
	}
}
