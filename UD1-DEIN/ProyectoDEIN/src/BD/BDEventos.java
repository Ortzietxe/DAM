package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import UML.Evento;

public class BDEventos {
	private static Connection con;

	public static void altaEventoBD(Evento oEvento) {
		try{  
			con = conexionBasedeDatos.conectar();

			String plantilla = "INSERT INTO `OLIMPIADAS`.`Evento`(`nombre`,`id_olimpiada`,`id_deporte`)VALUES(?,?,?);";
	        
	        
	        PreparedStatement ps=con.prepareStatement(plantilla);
	        
	        ps.setString(1,oEvento.getNombre());
	        ps.setInt(2,oEvento.getIdOlimpiada());
	        ps.setInt(3,oEvento.getIdDeporte());
	        
	        //int n = ps.executeUpdate();
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
