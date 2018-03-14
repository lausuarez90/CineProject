package com.proyecto.cineUnificado.persistencia.entities;


public class Pelicula {

	private int id;
	private double duracion;
	private String calificacion;
	private String nombre;
	private String resena;
	private String genero;
	private String clasificacion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getReseña() {
		return resena;
	}
	public void setReseña(String reseña) {
		this.resena = reseña;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", duracion=" + duracion + ", calificacion=" + calificacion + ", nombre=" + nombre
				+ ", reseña=" + resena + ", genero=" + genero + ", clasificacion=" + clasificacion + "]";
	}
	
}
