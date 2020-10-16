package BD;
import java.sql.Connection;
import java.sql.PreparedStatement;

import BD.*;
import Modelo.Olimpiada;

public class BDOlimpiadas {

	private static Connection con;
	
	public static void altaOlimpiadaBD(Olimpiada oOlimpiada)
	{
		try{  
			con = conexionBasedeDatos.conectar();
			
	        //String plantilla="INSERT INTO olimpiadas.OLIMPIADA ('nombre','anio, 'temporada', 'ciudad') VALUES (?,?,?,?);";
	       
			
			String plantilla = "INSERT INTO `olimpiadas`.`Olimpiada`(`nombre`,`anio`,`temporada`,`ciudad`)VALUES(?,?,?,?);";
	        
	        
	        PreparedStatement ps=con.prepareStatement(plantilla);
	        
	        ps.setString(1,oOlimpiada.getNombre());
	        ps.setInt(2,oOlimpiada.getAnio());
	        ps.setString(3,oOlimpiada.getTemporada());
	        ps.setString(4,oOlimpiada.getCiudad());
	        
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
