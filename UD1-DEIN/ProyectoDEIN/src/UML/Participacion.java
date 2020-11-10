package UML;

public class Participacion {
	private int idDeportista;
	private int idEvento;
	private int idEquipo;
	
	
	public Participacion(int idDeportista, int idEvento, int idEquipo) {
		super();
		this.idDeportista = idDeportista;
		this.idEvento = idEvento;
		this.idEquipo = idEquipo;
	}
	public int getIdDeportista() {
		return idDeportista;
	}
	public void setIdDeportista(int idDeportista) {
		this.idDeportista = idDeportista;
	}
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	
}
