package ComponentesPersonalizados;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import ComponentesPersonalizados.TextBubbleBorder;

import javax.swing.*;
import javax.swing.border.AbstractBorder;

import Vista.vPrincipal;

public class botonBorrar extends JButton{

    public botonBorrar() {
        this.setBackground(Color.WHITE);
        this.setFocusPainted(false);
        this.setIcon(new ImageIcon(vPrincipal.class.getResource("/Images/trash.png")));
        
        AbstractBorder brdr = new TextBubbleBorder(Color.WHITE,1,8,0);
        this.setBorder(brdr);
        
        this.setSize(new Dimension(50,50));
        this.setVisible(true);
    }
}
