package es.jacaranda.proyectoJSP;

public class MatriculaBean {
	
	private String nombre = "";
	private int matematicas = 0;
	private int ingles = 0;
	private int ciencias = 0;
	
	public MatriculaBean() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getMatematicas() {
		return matematicas;
	}
	public void setMatematicas(int matematicas) {
		this.matematicas = matematicas;
	}
	public int getIngles() {
		return ingles;
	}
	public void setIngles(int ingles) {
		this.ingles = ingles;
	}
	public int getCiencias() {
		return ciencias;
	}
	public void setCiencias(int ciencias) {
		this.ciencias = ciencias;
	}

}
