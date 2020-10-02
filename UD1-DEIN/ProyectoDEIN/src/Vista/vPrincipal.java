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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;

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
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Dialog", Font.BOLD, 17));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(230, 230, 250));
		menuBar.add(Box.createRigidArea(new Dimension(5, 45)));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Olimpiadas");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mnNewMenu.add(mntmConsulta);
		
		JMenuItem mntmAltaOlimpiada = new JMenuItem("Alta olimpiada");
		mnNewMenu.add(mntmAltaOlimpiada);
		
		JMenu mnNewMenu_1 = new JMenu("Eventos");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Consulta");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmAltaEventos = new JMenuItem("Alta Eventos");
		mnNewMenu_1.add(mntmAltaEventos);
		
		JMenu mnNewMenu_2 = new JMenu("Deportista");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmConsulta_1 = new JMenuItem("Consulta");
		mnNewMenu_2.add(mntmConsulta_1);
		
		JMenuItem mntmAltaDeportista = new JMenuItem("Alta Deportista");
		mnNewMenu_2.add(mntmAltaDeportista);
		
		JMenu mnParticipacin = new JMenu("Participaciónes");
		menuBar.add(mnParticipacin);
		
		JMenuItem mntmConsultaParticipacin = new JMenuItem("Consulta");
		mnParticipacin.add(mntmConsultaParticipacin);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Alta Participación");
		mnParticipacin.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("  Equipo");
		mntmNewMenuItem_2.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem_2.setBackground(new Color(230, 230, 250));
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Deportes");
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_1.setBackground(new Color(230, 230, 250));
		menuBar.add(mntmNewMenuItem_1);
		logo = new JPanel();
		logo.setBackground(new Color(245, 245, 245));
		logo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(logo);
		logo.setLayout(null);
		
		JLabel Titulo_1_1 = new JLabel("");
		Titulo_1_1.setVerticalAlignment(SwingConstants.TOP);
		Titulo_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo_1_1.setIcon(new ImageIcon(vPrincipal.class.getResource("/Images/1200px-Olympic_rings_without_rims.svg.png")));
		Titulo_1_1.setFont(new Font("Dialog", Font.BOLD, 26));
		Titulo_1_1.setBounds(33, 22, 490, 230);
		logo.add(Titulo_1_1);
		

	}
}
