package Modelo;

public class Deportista {
	private int idDeportista;
	private String nombre;
	private String genero;
	private int peso;
	private int altura;
	
	public Deportista(int idDeportista, String nombre, String genero, int peso, int altura) {
		super();
		this.idDeportista = idDeportista;
		this.nombre = nombre;
		this.genero = genero;
		this.peso = peso;
		this.altura = altura;
	}
	
	public Deportista(String nombre, String genero, int peso, int altura) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.peso = peso;
		this.altura = altura;
	}
	
	public int getIdDeportista() {
		return idDeportista;
	}
	
	public void setIdDeportista(int idDeportista) {
		this.idDeportista = idDeportista;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
}
