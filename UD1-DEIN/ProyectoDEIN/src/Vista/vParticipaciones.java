package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;

public class vParticipaciones extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vParticipaciones frame = new vParticipaciones();
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
	public vParticipaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Olimpiada");
		lblNewLabel_1.setBounds(12, 223, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(12, 241, 146, 22);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(168, 241, 116, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Evento");
		lblNewLabel.setBounds(168, 223, 84, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombreDeportista = new JLabel("Nombre deportista");
		lblNombreDeportista.setBounds(299, 223, 139, 14);
		contentPane.add(lblNombreDeportista);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(299, 242, 141, 20);
		contentPane.add(textField);
	}
}
