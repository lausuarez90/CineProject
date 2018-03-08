package com.proyecto.cineUnificado.modelo;

public class Cinema extends Empresa{
	
	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private Cartelera cartelera;
	
	public Cartelera getCartelera() {
		return cartelera;
	}
	public void setCartelera(Cartelera cartelera) {
		this.cartelera = cartelera;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
