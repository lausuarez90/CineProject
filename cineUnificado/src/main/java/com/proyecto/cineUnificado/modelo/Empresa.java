package com.proyecto.cineUnificado.modelo;

public abstract class Empresa {

	private int idEmpresa;
	private String nombreEmpresa;
	private String nit;
	
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(int id) {
		this.idEmpresa = id;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombre) {
		this.nombreEmpresa = nombre;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	@Override
	public String toString() {
		return "Empresa [id=" + idEmpresa + ", nombre=" + nombreEmpresa + ", nit=" + nit + "]";
	}
	
	
}
