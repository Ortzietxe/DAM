package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Modelo.Deportista;

public class BDDeportistas {
	private static Connection con;
	
	public static void altaDeportistaBD(Deportista oDeportista)
	{
		try{  
			con = conexionBasedeDatos.conectar();

			String plantilla = "INSERT INTO `olimpiadas`.`Deportista`(`nombre`,`genero`,`peso`,`altura`)VALUES(?,?,?,?);";
	        
	        
	        PreparedStatement ps=con.prepareStatement(plantilla);
	        
	        ps.setString(1,oDeportista.getNombre());
	        ps.setString(2,oDeportista.getGenero());
	        ps.setInt(3,oDeportista.getPeso());
	        ps.setInt(4,oDeportista.getAltura());
	        
	        int n = ps.executeUpdate();
	        
	        if (n == 0) 
	            System.out.println("Cero filas insertadas");	        
	        }
	        catch(Exception e){  
	        	System.out.println(e.getMessage());
	        }
		conexionBasedeDatos.cerrar();
	}
}
