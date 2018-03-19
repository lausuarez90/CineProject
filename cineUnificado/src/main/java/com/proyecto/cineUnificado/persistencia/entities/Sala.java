package com.proyecto.cineUnificado.persistencia.entities;

public class Sala {
	
	private int id;
	private int numSillas;
	private String tipoSala;
	private String idioma;
	private int id_cinema_pelicula;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumSillas() {
		return numSillas;
	}
	public void setNumSillas(int numSillas) {
		this.numSillas = numSillas;
	}
	public String getTipoSala() {
		return tipoSala;
	}
	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public int getId_cinema_pelicula() {
		return id_cinema_pelicula;
	}
	public void setId_cinema_pelicula(int id_cinema_pelicula) {
		this.id_cinema_pelicula = id_cinema_pelicula;
	}
	@Override
	public String toString() {
		return "Sala [id=" + id + ", numSillas=" + numSillas + ", tipoSala=" + tipoSala + ", idioma=" + idioma
				+ ", id_cinema_pelicula=" + id_cinema_pelicula + "]";
	}

}
