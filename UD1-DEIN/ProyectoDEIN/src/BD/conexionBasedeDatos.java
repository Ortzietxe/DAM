package BD;


import java.sql.*;
public class conexionBasedeDatos {
	
    private static Connection con;
	public static final String URL="jdbc:mysql://localhost:3306/";
	public static final String SCHEMA = "OLIMPIADAS";
	public static final String PARAMS="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASS = "pass";	
	
    public static Connection conectar()
    {
        try{
        // tipo de base de datos
 		   Class.forName(DRIVER);
 		   Connection con = DriverManager.getConnection(URL+SCHEMA+PARAMS,USER,PASS);
 		   
           return con;
        }
        catch( Exception e){
        	return null;
        }
    }  
    public static void cerrar()
    {
        try{
        	con.close();
        }
        
        catch(Exception e){}
    }
}