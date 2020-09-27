package BD;

public class clsConstantesDB 
{
	
	
	public static final String URL="jdbc:mysql://localhost:3306/";
	public static final String SCHEMA = "ERROLIMPIADAS";
	public static final String PARAMS="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASS = "pass";
	
	
	
	public final void buscar() {
	final String SQL_SELECT_ALUMNO ="SELECT `*` FROM `deporte`;";
	}					
										
	public static final String SQL_SELECT_ALUMNO_BY_NOMBRE ="SELECT `*` FROM `deporte` WHERE deporte.NOMBRE=?;";
	
		
	

	
	

}
