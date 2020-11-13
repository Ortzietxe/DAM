package UML;

public class EventoDeporteOlimpiada {
	private int idEvento, idOlimpiada, idDeporte;
	private String nombreEvento;
	private String nombreOlimpiada;
	private String nombreDeporte;
	
	public EventoDeporteOlimpiada() {
		super();
	}
	
	public EventoDeporteOlimpiada(int idEvento, int idOlimpiada, int idDeporte, String nombreEvento, String nombreOlimpiada, String nombreDeporte) {
		super();
		this.idEvento = idEvento;
		this.idOlimpiada = idOlimpiada;
		this.idDeporte = idDeporte;
		this.nombreEvento = nombreEvento;
		this.nombreOlimpiada = nombreOlimpiada;
		this.nombreDeporte = nombreDeporte;
	}

	public EventoDeporteOlimpiada(int idEvento, String nombreEvento, String nombreOlimpiada, String nombreDeporte) {
		super();
		this.idEvento = idEvento;
		this.nombreEvento = nombreEvento;
		this.nombreOlimpiada = nombreOlimpiada;
		this.nombreDeporte = nombreDeporte;
	}
	
	public int getIdOlimpiada() {
		return idOlimpiada;
	}

	public void setIdOlimpiada(int idOlimpiada) {
		this.idOlimpiada = idOlimpiada;
	}

	public int getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(int idDeporte) {
		this.idDeporte = idDeporte;
	}
	
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	public String getNombreOlimpiada() {
		return nombreOlimpiada;
	}
	public void setNombreOlimpiada(String nombreOlimpiada) {
		this.nombreOlimpiada = nombreOlimpiada;
	}
	public String getNombreDeporte() {
		return nombreDeporte;
	}
	public void setNombreDeporte(String nombreDeporte) {
		this.nombreDeporte = nombreDeporte;
	}
}
