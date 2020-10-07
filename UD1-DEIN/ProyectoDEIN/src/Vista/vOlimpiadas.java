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
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class vOlimpiadas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vOlimpiadas frame = new vOlimpiadas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vOlimpiadas() {
		setBackground(new Color(0, 100, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Temporada");
		lblNewLabel.setBounds(389, 210, 84, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(12, 210, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNombreDeportista = new JLabel("Ciudad");
		lblNombreDeportista.setBounds(265, 210, 84, 14);
		contentPane.add(lblNombreDeportista);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Verano", "Invierno"}));
		comboBox.setBounds(389, 228, 116, 22);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(12, 230, 141, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBackground(Color.BLACK);
		table.setBounds(356, 157, -328, -140);
		contentPane.add(table);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(265, 230, 112, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Olimpiadas");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel_2.setBounds(180, 12, 156, 29);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(165, 230, 88, 20);
		contentPane.add(textField_2);
		
		JLabel lblNombreDeportista_1 = new JLabel("Año");
		lblNombreDeportista_1.setBounds(165, 210, 88, 14);
		contentPane.add(lblNombreDeportista_1);
	}
}
