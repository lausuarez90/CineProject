package com.proyecto.cineUnificado.modelo;

import java.util.List;

public class Sala {
	
	private int id;
	private String nombre;
	private int numSillas;
	private String idioma;
	private List<Horario> horarios;
	
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
	

}
