package BD;

import static BD.clsConstantesDB.DRIVER;
import static BD.clsConstantesDB.PASS;
import static BD.clsConstantesDB.SCHEMA;
import static BD.clsConstantesDB.URL;
import static BD.clsConstantesDB.USER;
import static BD.clsConstantesDB.PARAMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static BD.clsConstantesDB.SQL_SELECT_ALUMNO_BY_NOMBRE;
import static BD.clsConstantesDB.SQL_SELECT_ALUMNO;


/**
 * Esta clase es la encargada de acceder a la base de datos y de realizar consultas. Fundamentalmente realiza las operaciones de
 * INSERT, SELECT, UPDATE y DELETE de cualquier tipo de datos.
 */
public class clsgestorLD 
{
	
	
	/**
	 * Objeto para crear la conexión a base de datos.
	 */
	Connection conn = null;
	
	/**
	 * Objeto para crear la consulta a base de datos.
	 */
	PreparedStatement ps=null;
	
	/**
	 * Objeto para devolver el resultado de la consulta.
	 */
	ResultSet rs=null;
	
	
	/**
	 * Constructor sin parámetros de la clase.
	 */
	public clsgestorLD()
	{
		
	}
	
	
	/**
	 * Método para la conexión a la base de datos.
	 * 
	 */
	 public void Connect()
	 {
		 
		 
		 try 
		 {
			//Se carga el driver de acceso a datos
		   Class.forName(DRIVER);
		   conn = DriverManager.getConnection(URL+SCHEMA+PARAMS,USER,PASS);
		   System.out.println("Connected to the database");
		   
		   
		 }
		 catch (Exception e) 
		 {
		     System.out.println("NO CONNECTION ");
		 }
	 }
	 
	 
	 public void Disconnect()
	 {
		 
		 try 
		 {
			conn.close();
			ps.close(); // cerrar el statement tb cierra el resultset.
		 } 
		 catch (SQLException e) 
		 {
			
		 }
		 finally 
		 {
			 try {conn.close();} catch(Exception e){/*no hago nada*/}
			 try {ps.close();} catch(Exception e){/*no hago nada*/}
		 }
		 
		 
	 }
	 
	 
	 private ResultSet sendSelect(String sql)
	 {
			
			
			try 
			{
				ps = conn.prepareStatement(sql);
				rs=ps.executeQuery(sql);
			} 
			catch (SQLException e) 
			{
				System.out.println("Error en la recuperación de datos para SQL= " + sql + " " + e);
			}
			
			
			return rs; 
			
	 }
}
