package com.proyecto.cineUnificado.modelo;

import java.util.ArrayList;
import java.util.List;

public class Sala {
	
	private int id;
	private String nombre;
	private int numSillas;
	private String idioma;
	private List peliculas = new ArrayList<>();
	private List<Horario> horarios;
	private List<Silla> sillas;
	
	public List<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	public List<Silla> getSillas() {
		return sillas;
	}
	public void setSillas(List<Silla> sillas) {
		this.sillas = sillas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumSillas() {
		return numSillas;
	}
	public void setNumSillas(int numSillas) {
		this.numSillas = numSillas;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public List getPeliculas() {
		return peliculas;
	}
	public List setPeliculas(Peliculas pelicula) {
		if (!peliculas.contains(pelicula)){
			peliculas.add(pelicula);
		}
		return peliculas;
		
	}
	

}
