package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import UML.*;

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

	public static ArrayList<EventoDeporteOlimpiada> buscarEventos() throws SQLException {
		ArrayList<EventoDeporteOlimpiada> eventos = new ArrayList();
		con = conexionBasedeDatos.conectar();
		
		Statement consulta = con.createStatement();
        ResultSet resultado = consulta.executeQuery("SELECT E.id_evento, E.nombre, D.nombre, D.id_deporte, O.nombre, O.id_olimpiada FROM OLIMPIADAS.Evento E, OLIMPIADAS.Deporte D, OLIMPIADAS.Olimpiada O WHERE E.id_olimpiada = O.id_olimpiada AND E.id_deporte = D.id_deporte ;");
        while(resultado.next())
        {
        	EventoDeporteOlimpiada oEvento= new EventoDeporteOlimpiada();
        	oEvento.setIdEvento(resultado.getInt("E.id_evento"));
        	oEvento.setNombreEvento(resultado.getString("E.nombre"));
        	oEvento.setNombreDeporte(resultado.getString("D.nombre"));
        	oEvento.setIdDeporte(resultado.getInt("D.id_deporte"));
          	oEvento.setNombreOlimpiada(resultado.getString("O.nombre"));
          	oEvento.setIdOlimpiada(resultado.getInt("O.id_olimpiada"));

	        eventos.add(oEvento);
        }
        resultado.close();
        consulta.close();
	conexionBasedeDatos.cerrar();
	
	return eventos;	
	}

}
