package UML;

public class ParticipacionDeportistaEventoEquipo {
	private int idDeportista, idEvento, idEquipo, edad;
	private String medalla, nomDeportista, nomEvento, nomEquipo;
	
	public ParticipacionDeportistaEventoEquipo() {
		super();
	}
	public ParticipacionDeportistaEventoEquipo(int idDeportista, int idEvento, int edad, String medalla,
			String nomDeportista, String nomEvento, String nomEquipo) {
		super();
		this.idDeportista = idDeportista;
		this.idEvento = idEvento;
		this.edad = edad;
		this.medalla = medalla;
		this.nomDeportista = nomDeportista;
		this.nomEvento = nomEvento;
		this.nomEquipo = nomEquipo;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getMedalla() {
		return medalla;
	}
	public void setMedalla(String medalla) {
		this.medalla = medalla;
	}
	public String getNomDeportista() {
		return nomDeportista;
	}
	public void setNomDeportista(String nomDeportista) {
		this.nomDeportista = nomDeportista;
	}
	public String getNomEvento() {
		return nomEvento;
	}
	public void setNomEvento(String nomEvento) {
		this.nomEvento = nomEvento;
	}
	public String getNomEquipo() {
		return nomEquipo;
	}
	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}
	
}
