package com.proyecto.cineUnificado.modelo;

public class Silla {
	
	private int id;
	private String estado;
	private String fila;
	private String numero;
	private TipoSilla tipoSilla;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFila() {
		return fila;
	}
	public void setFila(String fila) {
		this.fila = fila;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public TipoSilla getTipoSilla() {
		return tipoSilla;
	}
	public void setTipoSilla(TipoSilla tipoSilla) {
		this.tipoSilla = tipoSilla;
	}
	
	

}
