package com.proyecto.cineUnificado.Interfaces;

import java.util.List;

import com.proyecto.cineUnificado.modelo.Cinema;
import com.proyecto.cineUnificado.modelo.Empresa;

public interface InterfaceCine  {
	
	public List<Empresa> consultarEmpresas();
	
	public List<Cinema> consultarCinemasPorEmpresa(int idEmpresa);

}
