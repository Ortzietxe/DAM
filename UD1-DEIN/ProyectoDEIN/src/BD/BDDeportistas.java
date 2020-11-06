package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import UML.Deportista;

public class BDDeportistas {
	private static Connection con;
	
	public static void altaDeportistaBD(Deportista oDeportista)
	{
		try{  
			con = conexionBasedeDatos.conectar();

			String plantilla = "INSERT INTO `OLIMPIADAS`.`Deportista`(`nombre`,`sexo`,`peso`,`altura`)VALUES(?,?,?,?);";
	        
	        
	        PreparedStatement ps=con.prepareStatement(plantilla);
	        
	        ps.setString(1,oDeportista.getNombre());
	        ps.setString(2,oDeportista.getGenero());
	        ps.setInt(3,oDeportista.getPeso());
	        ps.setInt(4,oDeportista.getAltura());
	        
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

	public static ArrayList<Deportista> buscarDeportistas() throws SQLException 
	{
			ArrayList<Deportista> deportistas = new ArrayList();
			con = conexionBasedeDatos.conectar();
			
			Statement consulta = con.createStatement();
	        ResultSet resultado = consulta.executeQuery("SELECT * FROM `OLIMPIADAS`.`Deportista`; ");
	        while(resultado.next())
	        {
	          Deportista oDeportista= new Deportista();
	          oDeportista.setIdDeportista(resultado.getInt("id_deportista"));
	          oDeportista.setNombre(resultado.getString("nombre"));
	          oDeportista.setGenero(resultado.getString("sexo"));
	          oDeportista.setPeso(resultado.getInt("peso"));
	          oDeportista.setAltura(resultado.getInt("altura"));

	          deportistas.add(oDeportista);
	        }
	        resultado.close();
	        consulta.close();
		conexionBasedeDatos.cerrar();
		
		return deportistas;
	
	}

	public static void modificacionDeportistaBD(Deportista oDeportista) {
		try{  
			con = conexionBasedeDatos.conectar();

			String plantilla = "UPDATE `OLIMPIADAS`.`Deportista` SET `nombre` = ?, `peso` = ?, `altura` = ? WHERE `id_deportista` = ?;";
	        
	        
	        PreparedStatement ps=con.prepareStatement(plantilla);
	        
	        ps.setString(1,oDeportista.getNombre());
	        ps.setInt(2,oDeportista.getPeso());
	        ps.setInt(3,oDeportista.getAltura());
	        ps.setInt(4,oDeportista.getIdDeportista());
	        
	        int n = ps.executeUpdate();
	        
	        JOptionPane.showMessageDialog(null, "El deportista seleccionado se ha modificado correctamente");
	        if (n == 0) 
	            System.out.println("Cero filas actualizadas");	        
	        }
	        catch(Exception e){  
	        	System.out.println(e.getMessage());
	        }
		conexionBasedeDatos.cerrar();		
	}

	public static void borrarDeportista(int idDeportista) 
	{
		try{  
			con = conexionBasedeDatos.conectar();

			String plantilla = "DELETE * FROM `OLIMPIADAS`.`Deportista` WHERE `id_deportista` = " + idDeportista+ ";";
	        	        
	        PreparedStatement ps=con.prepareStatement(plantilla);
	        	        
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
