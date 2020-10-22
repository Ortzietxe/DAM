package ComponentesPersonalizados;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import ComponentesPersonalizados.TextBubbleBorder;

import javax.swing.*;
import javax.swing.border.AbstractBorder;

import Vista.vPrincipal;

public class botonVolver extends JButton{

    public botonVolver() {
        this.setBackground(Color.BLACK);
        this.setFocusPainted(false);
        this.setIcon(new ImageIcon(vPrincipal.class.getResource("/Images/back.png")));
        
        AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,1,8,0);
        this.setBorder(brdr);
        
        this.setSize(new Dimension(50,50));
        this.setVisible(true);
    }
}
