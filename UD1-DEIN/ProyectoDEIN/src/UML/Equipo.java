package UML;

public class Equipo {
	private int idEquipo;
	private String nombre;
	private String iniciales;
	
	public Equipo(String nombre, String iniciales) {
		super();
		this.nombre = nombre;
		this.iniciales = iniciales;
	}
	public Equipo(int idEquipo, String nombre, String iniciales) {
		super();
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.iniciales = iniciales;
	}
	public Equipo() {
		// TODO Auto-generated constructor stub
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIniciales() {
		return iniciales;
	}
	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}
}
