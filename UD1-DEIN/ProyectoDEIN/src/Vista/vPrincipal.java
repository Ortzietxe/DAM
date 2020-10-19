package Vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;

import Controlador.Controlador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class vPrincipal extends JFrame {

	private JPanel logo;
	private JButton btnAceptar;
	private ArrayList<String> listaDeportes;
	/**
	 * Create the frame.
	 */
	public vPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 354);
		setUndecorated(true);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Dialog", Font.BOLD, 17));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 0, 51));
		menuBar.add(Box.createRigidArea(new Dimension(5, 45)));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Olimpiadas");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mntmConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "vamonos wey");
			}
		});
		mntmConsulta.setBackground(Color.BLACK);
		mntmConsulta.setForeground(Color.WHITE);
		mnNewMenu.add(mntmConsulta);
		
		JMenuItem mntmAltaOlimpiada = new JMenuItem("Alta olimpiada");
		mntmAltaOlimpiada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador.mostrarAltaOlimpiada();
			}
		});
		mntmAltaOlimpiada.setForeground(Color.WHITE);
		mntmAltaOlimpiada.setBackground(Color.BLACK);
		mnNewMenu.add(mntmAltaOlimpiada);
		
		JMenu mnNewMenu_1 = new JMenu("Eventos");
		mnNewMenu_1.setBackground(Color.BLACK);
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Consulta");
		mntmNewMenuItem.setForeground(Color.WHITE);
		mntmNewMenuItem.setBackground(Color.BLACK);
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmAltaEventos = new JMenuItem("Alta Eventos");
		mntmAltaEventos.setForeground(Color.WHITE);
		mntmAltaEventos.setBackground(Color.BLACK);
		mnNewMenu_1.add(mntmAltaEventos);
		
		JMenu mnNewMenu_2 = new JMenu("Deportista");
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmConsulta_1 = new JMenuItem("Consulta");
		mntmConsulta_1.setBackground(Color.BLACK);
		mntmConsulta_1.setForeground(Color.WHITE);
		mnNewMenu_2.add(mntmConsulta_1);
		
		JMenuItem mntmAltaDeportista = new JMenuItem("Alta Deportista");
		mntmAltaDeportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador.mostrarAltaDeportista();
			}
		});
		mntmAltaDeportista.setForeground(Color.WHITE);
		mntmAltaDeportista.setBackground(Color.BLACK);
		mnNewMenu_2.add(mntmAltaDeportista);
		
		JMenu mnParticipacin = new JMenu("Participaciónes");
		mnParticipacin.setForeground(new Color(255, 255, 255));
		menuBar.add(mnParticipacin);
		
		JMenuItem mntmConsultaParticipacin = new JMenuItem("Consulta");
		mntmConsultaParticipacin.setBackground(Color.BLACK);
		mntmConsultaParticipacin.setForeground(Color.WHITE);
		mnParticipacin.add(mntmConsultaParticipacin);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Alta Participacion");
		mntmNewMenuItem_3.setForeground(Color.WHITE);
		mntmNewMenuItem_3.setBackground(Color.BLACK);
		mnParticipacin.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("  Equipo");
		mntmNewMenuItem_2.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_2.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem_2.setBackground(new Color(0, 0, 51));
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Deportes");
		mntmNewMenuItem_1.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_1.setBackground(new Color(0, 0, 51));
		menuBar.add(mntmNewMenuItem_1);
		logo = new JPanel();
		logo.setBackground(Color.WHITE);
		logo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(logo);
		logo.setLayout(null);
		
		JLabel Titulo_1_1 = new JLabel("");
		Titulo_1_1.setVerticalAlignment(SwingConstants.TOP);
		Titulo_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo_1_1.setIcon(new ImageIcon(vPrincipal.class.getResource("/Images/1200px-Olympic_rings_without_rims.svg.png")));
		Titulo_1_1.setFont(new Font("Dialog", Font.BOLD, 26));
		Titulo_1_1.setBounds(32, 31, 490, 230);
		logo.add(Titulo_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
			}
		});
		lblNewLabel.setIcon(new ImageIcon(vPrincipal.class.getResource("/Images/logout.png")));
		lblNewLabel.setBounds(505, 249, 38, 58);
		logo.add(lblNewLabel);
		

	}
}
