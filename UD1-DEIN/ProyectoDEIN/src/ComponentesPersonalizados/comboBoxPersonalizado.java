package ComponentesPersonalizados;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import ComponentesPersonalizados.TextBubbleBorder;

import javax.swing.*;
import javax.swing.border.AbstractBorder;

import Vista.vPrincipal;

public class comboBoxPersonalizado extends JComboBox<Object>{

    public comboBoxPersonalizado() {
    	
    	AbstractBorder borde = new TextBubbleBorder(Color.BLACK,0,3,0);
    	
		this.setBorder(borde);
		this.setOpaque(true);
		this.setEditable(true);
		this.setFocusable(false);
		JTextField boxField = (JTextField) this.getEditor().getEditorComponent();
		boxField.setBorder(BorderFactory.createEmptyBorder());
		boxField.setBackground(Color.WHITE);
		boxField.setFocusable(false);
        this.setVisible(true);
    }
}
