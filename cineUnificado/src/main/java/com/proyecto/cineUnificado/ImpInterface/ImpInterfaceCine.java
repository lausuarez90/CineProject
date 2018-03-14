package com.proyecto.cineUnificado.ImpInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.cineUnificado.Interfaces.InterfaceCine;
import com.proyecto.cineUnificado.modelo.Cartelera;
import com.proyecto.cineUnificado.modelo.Cinema;
import com.proyecto.cineUnificado.modelo.Empresa;
import com.proyecto.cineUnificado.modelo.Peliculas;
import com.proyecto.cineUnificado.persistencia.CinemaDAO;
import com.proyecto.cineUnificado.persistencia.EmpresasDAO;
import com.proyecto.cineUnificado.persistencia.PeliculaDAO;
import com.proyecto.cineUnificado.persistencia.entities.CinemaPelicula;
import com.proyecto.cineUnificado.persistencia.entities.Pelicula;

public class ImpInterfaceCine implements InterfaceCine{
	
	EmpresasDAO empresasDAO;
	CinemaDAO cinemaDAO;
	PeliculaDAO peliculaDAO;

	public ImpInterfaceCine() {
		empresasDAO = new EmpresasDAO();
		cinemaDAO = new CinemaDAO();
		peliculaDAO = new PeliculaDAO();
	}
	
	public List<Empresa> consultarEmpresas(){
		
		List<Empresa> empresas = new ArrayList<Empresa>();
		
		for( com.proyecto.cineUnificado.persistencia.entities.Empresa empresa :empresasDAO.consultarEmpresas()){
				Empresa empresaModelo = new Empresa() {};
				empresaModelo.setIdEmpresa(empresa.getIdEmpresa());
				empresaModelo.setNit(empresa.getNit());
				empresaModelo.setNombreEmpresa(empresa.getNombreEmpresa());
				empresas.add(empresaModelo);
		}
		return empresas;		
	}
	
	public Empresa consultarEmpresaPorId(int id) {

		com.proyecto.cineUnificado.persistencia.entities.Empresa empresa = empresasDAO.consultarEmpresaPorId(id);

		Empresa empresaModelo = new Empresa() {
		};
		empresaModelo.setIdEmpresa(empresa.getIdEmpresa());
		empresaModelo.setNit(empresa.getNit());
		empresaModelo.setNombreEmpresa(empresa.getNombreEmpresa());
		

		return empresaModelo;
	}
	
	
	public List<Cinema> consultarCinemasPorEmpresa(int idEmpresa){
		
		List<Cinema> cinemaEmpresa = new ArrayList<Cinema>();
		
		try {
			for ( com.proyecto.cineUnificado.persistencia.entities.Cinema cinemas : cinemaDAO.consultarCinemaPorEmpresa(idEmpresa)){
				Cinema cinema = new Cinema();
				cinema.setId(cinemas.getId());
				cinema.setNombre(cinemas.getNombre());
				cinema.setTelefono(cinemas.getTelefono());
				cinema.setDireccion(cinemas.getDireccion());
				cinemaEmpresa.add(cinema);			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cinemaEmpresa;
	}
	
	public Cinema consultaCinemaporId(int idCinema){
		
		Cinema cine = new Cinema();
		
		try {
			com.proyecto.cineUnificado.persistencia.entities.Cinema cinema = cinemaDAO.consultaCinemaporId(idCinema);
		
			if (cinema != null){
				cine.setId(cinema.getId());
				cine.setNombre(cinema.getNombre());
				cine.setTelefono(cinema.getTelefono());
				cine.setDireccion(cinema.getDireccion());
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cine;
	}
	
	public Cinema consultarPeliculasporCinema(Cinema cinema){		
		
		try {
			List<CinemaPelicula> peliculasCinema = cinemaDAO.consultarPeliculasporCinema(cinema.getId());
			Cartelera cartelera = new Cartelera();
			for (CinemaPelicula cinemaPelicula : peliculasCinema) {				
				Peliculas pelicula = consultarPeliculaporId(cinemaPelicula.getIdPelicula());
				cartelera.setPeliculas(pelicula);
				cinema.setCartelera(cartelera);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cinema;
	}
	
	public Peliculas consultarPeliculaporId(int id){
		
		Pelicula pelicula = peliculaDAO.consultarPeliculaPorId(id);
		Peliculas peliculas = null;
		
		if (pelicula != null){
			peliculas = new Peliculas();
			peliculas.setId(pelicula.getId());
			peliculas.setCalificacion(pelicula.getCalificacion());
			peliculas.setClasificacion(pelicula.getClasificacion());
			peliculas.setDuracion(pelicula.getDuracion());
			peliculas.setGenero(pelicula.getGenero());
			peliculas.setNombre(pelicula.getNombre());
			peliculas.setReseña(pelicula.getReseña());
		}
		
		return peliculas;
	}
	
	public void ConsultarHorario(){
		
	}
	
	
}
