package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import UML.Deportista;
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

	public static ArrayList<Evento> buscarEventos() throws SQLException {
		ArrayList<Evento> eventos = new ArrayList();
		con = conexionBasedeDatos.conectar();
		
		Statement consulta = con.createStatement();
        ResultSet resultado = consulta.executeQuery("SELECT * FROM `OLIMPIADAS`.`Evento`; ");
        while(resultado.next())
        {
        	Evento oEvento= new Evento();
        	oEvento.setIdEvento(resultado.getInt("id_evento"));
        	oEvento.setNombre(resultado.getString("nombre"));
        	oEvento.setIdOlimpiada(resultado.getInt("id_olimpiada"));
        	oEvento.setIdDeporte(resultado.getInt("id_deporte"));

	        eventos.add(oEvento);
        }
        resultado.close();
        consulta.close();
	conexionBasedeDatos.cerrar();
	
	return eventos;	
	}

}
