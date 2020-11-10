package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import UML.Deporte;
import UML.Deportista;

public class BDDeportes {
	private static Connection con;
	
	public static ArrayList<Deporte> buscarDeportes() throws SQLException {
		ArrayList<Deporte> deportes = new ArrayList();
		con = conexionBasedeDatos.conectar();
		
		Statement consulta = con.createStatement();
        ResultSet resultado = consulta.executeQuery("SELECT * FROM `OLIMPIADAS`.`Deporte`; ");
        while(resultado.next())
        {
			Deporte oDeporte= new Deporte();
			oDeporte.setIdDeporte(resultado.getInt("id_deporte"));
			oDeporte.setNombre(resultado.getString("nombre"));
			
			deportes.add(oDeporte);
        }
        resultado.close();
        consulta.close();
	conexionBasedeDatos.cerrar();
	
	return deportes;
	}

}
