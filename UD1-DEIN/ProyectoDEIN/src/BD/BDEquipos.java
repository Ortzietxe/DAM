package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import UML.Deporte;
import UML.Equipo;

public class BDEquipos {
	private static Connection con;
	
	public static ArrayList<Equipo> buscarEquipos() throws SQLException {
		ArrayList<Equipo> equipos = new ArrayList();
		con = conexionBasedeDatos.conectar();
		
		Statement consulta = con.createStatement();
        ResultSet resultado = consulta.executeQuery("SELECT * FROM `OLIMPIADAS`.`Equipo`; ");
        while(resultado.next())
        {
        	Equipo oEquipo = new Equipo();
        	oEquipo.setIdEquipo(resultado.getInt("id_equipo"));
        	oEquipo.setNombre(resultado.getString("nombre"));
        	oEquipo.setIniciales(resultado.getString("iniciales"));
			
			equipos.add(oEquipo);
        }
        resultado.close();
        consulta.close();
	conexionBasedeDatos.cerrar();
	
	return equipos;
	}
}
