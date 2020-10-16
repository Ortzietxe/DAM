package ComponentesPersonalizados;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import ComponentesPersonalizados.TextBubbleBorder;

import javax.swing.*;
import javax.swing.border.AbstractBorder;

import Vista.vPrincipal;

public class botonVolver extends JButton{

    public botonVolver() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        JButton b = new JButton("");
        b.setBackground(Color.BLACK);
        b.setFocusPainted(false);
        b.setFocusPainted(false);
        b.setIcon(new ImageIcon(vPrincipal.class.getResource("/Images/back.png")));
        
        AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,1,8,0);
        b.setBorder(brdr);
        
        frame.add(b);
        frame.pack();
        frame.setVisible(true);
    }
}
