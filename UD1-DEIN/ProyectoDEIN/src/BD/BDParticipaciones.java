package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import UML.Participacion;
import UML.ParticipacionDeportistaEventoEquipo;

public class BDParticipaciones {
	private static Connection con;
	
	public static void altaParticipacionBD(Participacion oparticipacion)
	{
		try{  
			con = conexionBasedeDatos.conectar();     
			
			String plantilla = "INSERT INTO `OLIMPIADAS`.`Participacion`(`id_deportista`,`id_evento`,`id_equipo`,`edad`,`medalla`)VALUES(?,?,?,?,?);";
	                
	        PreparedStatement ps = con.prepareStatement(plantilla);
	        
	        ps.setInt(1,oparticipacion.getIdDeportista());
	        ps.setInt(2,oparticipacion.getIdEvento());
	        ps.setInt(3,oparticipacion.getIdEquipo());
	        ps.setInt(4,oparticipacion.getEdad());
	        ps.setString(5,oparticipacion.getMedalla());
	        
	        int n = ps.executeUpdate();
	        
	        if (n == 0) 
	            System.out.println("Cero filas insertadas");	        
	        }
	        catch(Exception e){  
	        	System.out.println(e.getMessage());
	        }
		
		conexionBasedeDatos.cerrar();
	}
	
	public static ArrayList<ParticipacionDeportistaEventoEquipo> buscarParticipaciones() throws SQLException {
		ArrayList<ParticipacionDeportistaEventoEquipo> participaciones = new ArrayList();
		con = conexionBasedeDatos.conectar();
		
		Statement consulta = con.createStatement();
        ResultSet resultado = consulta.executeQuery("SELECT p.id_deportista, d.nombre, p.id_evento, ev.nombre, e.nombre, p.edad, p.medalla FROM Participacion p, Deportista d, Evento ev, Equipo e WHERE p.id_deportista = d.id_deportista AND p.id_evento = ev.id_evento AND p.id_equipo = e.id_equipo; ");
        while(resultado.next())
        {
        	ParticipacionDeportistaEventoEquipo oParticipacion= new ParticipacionDeportistaEventoEquipo();
        	oParticipacion.setIdDeportista(resultado.getInt("p.id_deportista"));
        	oParticipacion.setNomDeportista(resultado.getString("d.nombre"));
        	oParticipacion.setIdEvento(resultado.getInt("p.id_evento"));
        	oParticipacion.setNomEvento(resultado.getString("ev.nombre"));
        	oParticipacion.setNomEquipo(resultado.getString("e.nombre"));
        	oParticipacion.setEdad(resultado.getInt("p.edad"));
        	oParticipacion.setMedalla(resultado.getString("p.medalla"));
        	
			participaciones.add(oParticipacion);
        }
        resultado.close();
        consulta.close();
	conexionBasedeDatos.cerrar();
	
	return participaciones;
	}

}
