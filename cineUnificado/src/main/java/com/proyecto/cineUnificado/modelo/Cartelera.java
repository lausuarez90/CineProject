package com.proyecto.cineUnificado.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cartelera {
	
	private int id;
	private List peliculas = new ArrayList<>();
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List setPeliculas(Peliculas pelicula){
		if (!peliculas.contains(pelicula)){
			peliculas.add(pelicula);
		}
		return peliculas;
	}

	public List getPeliculas() {
		return peliculas;
	}	
	
}
