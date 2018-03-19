package com.proyecto.cineUnificado.Interfaces;

import java.util.Date;
import java.util.List;

import com.proyecto.cineUnificado.modelo.Cinema;
import com.proyecto.cineUnificado.modelo.Empresa;
import com.proyecto.cineUnificado.modelo.Horario;
import com.proyecto.cineUnificado.modelo.Sala;

public interface InterfaceCine  {
	
	public List<Empresa> consultarEmpresas();
	
	public Empresa consultarEmpresaPorId(int id);
	
	public List<Cinema> consultarCinemasPorEmpresa(int idEmpresa);
	
	public Cinema consultarPeliculasporCinema(Cinema idCinema);

	public List<Sala> consultarSalaporPeliculasCinema(int idCinema, int idPelicula);
	
	public List<Horario> consultarFechas();
	
	public List<Horario> consultarFechasPorSala(int idSala);
	
	public List<Horario> consultarHorariosPorSala(Date date, int idSala);
}
