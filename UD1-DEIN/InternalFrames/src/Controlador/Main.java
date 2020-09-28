package Controlador;

import Vistas.vPrincipal;

public class Main 
{
	public static void main(String[] args) 
	{		
		try {
			vPrincipal frame = new vPrincipal();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
