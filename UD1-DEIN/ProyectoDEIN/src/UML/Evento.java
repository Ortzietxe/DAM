package UML;

public class Evento 
{
	private int idEvento;
	private String nombre;
	private int idDeporte;
	private int idOlimpiada;
	
	public Evento(int idEvento, String nombre, int idDeporte, int idOlimpiada) {
		super();
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.idDeporte = idDeporte;
		this.idOlimpiada = idOlimpiada;
	}
	
	public Evento(String nombre, int idDeporte, int idOlimpiada) {
		super();
		this.nombre = nombre;
		this.idDeporte = idDeporte;
		this.idOlimpiada = idOlimpiada;
	}

	public Evento() {
		super();
	}

	public int getIdEvento() 
	{
		return idEvento;
	}
	public void setIdEvento(int idEvento) 
	{
		this.idEvento = idEvento;
	}
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	public int getIdDeporte() 
	{
		return idDeporte;
	}
	public void setIdDeporte(int idDeporte) 
	{
		this.idDeporte = idDeporte;
	}
	public int getIdOlimpiada() 
	{
		return idOlimpiada;
	}
	public void setIdOlimpiada(int idOlimpiada) 
	{
		this.idOlimpiada = idOlimpiada;
	}
}
