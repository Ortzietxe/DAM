package BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BD.*;
import UML.Deportista;
import UML.Olimpiada;

public class BDOlimpiadas {

	private static Connection con;
	
	public static void altaOlimpiadaBD(Olimpiada oOlimpiada)
	{
		try{  
			con = conexionBasedeDatos.conectar();     
			
			String plantilla = "INSERT INTO `OLIMPIADAS`.`Olimpiada`(`nombre`,`anio`,`temporada`,`ciudad`)VALUES(?,?,?,?);";
	                
	        PreparedStatement ps = con.prepareStatement(plantilla);
	        
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

	public static ArrayList<Olimpiada> buscarOlimpiadas() throws SQLException {
		ArrayList<Olimpiada> olimpiadas = new ArrayList();
		con = conexionBasedeDatos.conectar();
		
		Statement consulta = con.createStatement();
        ResultSet resultado = consulta.executeQuery("SELECT * FROM `OLIMPIADAS`.`Olimpiada`; ");
        while(resultado.next())
        {
			Olimpiada oOlimpiada= new Olimpiada();
			oOlimpiada.setIdOlimpiada(resultado.getInt("id_olimpiada"));
			oOlimpiada.setNombre(resultado.getString("nombre"));
			oOlimpiada.setAnio(resultado.getInt("anio"));
			oOlimpiada.setTemporada(resultado.getString("temporada"));
			oOlimpiada.setCiudad(resultado.getString("ciudad"));

			olimpiadas.add(oOlimpiada);
        }
        resultado.close();
        consulta.close();
	conexionBasedeDatos.cerrar();
	
	return olimpiadas;
	}
}
