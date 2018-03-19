package com.proyecto.cineUnificado.ImpInterface;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.proyecto.cineUnificado.Interfaces.InterfaceCine;
import com.proyecto.cineUnificado.modelo.Cartelera;
import com.proyecto.cineUnificado.modelo.Cinema;
import com.proyecto.cineUnificado.modelo.Empresa;
import com.proyecto.cineUnificado.modelo.Horario;
import com.proyecto.cineUnificado.modelo.Peliculas;
import com.proyecto.cineUnificado.modelo.Sala;
import com.proyecto.cineUnificado.persistencia.CinemaDAO;
import com.proyecto.cineUnificado.persistencia.ConexionBD;
import com.proyecto.cineUnificado.persistencia.EmpresasDAO;
import com.proyecto.cineUnificado.persistencia.HorarioDAO;
import com.proyecto.cineUnificado.persistencia.PeliculaDAO;
import com.proyecto.cineUnificado.persistencia.SalaDAO;
import com.proyecto.cineUnificado.persistencia.entities.CinemaPelicula;
import com.proyecto.cineUnificado.persistencia.entities.Pelicula;

public class ImpInterfaceCine implements InterfaceCine{
	
	EmpresasDAO empresasDAO;
	CinemaDAO cinemaDAO;
	PeliculaDAO peliculaDAO;
	SalaDAO salaDAO;
	HorarioDAO horarioDAO;

	
	public ImpInterfaceCine() {
		ConexionBD conection = new ConexionBD();
		empresasDAO = new EmpresasDAO(conection.getConnection());
		cinemaDAO = new CinemaDAO(conection.getConnection());
		peliculaDAO = new PeliculaDAO(conection.getConnection());
		salaDAO = new SalaDAO(conection.getConnection());
		horarioDAO = new HorarioDAO(conection.getConnection());
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
				cartelera.setId(cinemaPelicula.getId());
				cartelera.setPeliculas(pelicula);
				cinema.setCartelera(cartelera);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cinema;
	}
	
	public Cartelera consultarCinemaPelulaPorCinemayPelicula(int idCinema, int idPelicula){		
		
		Cartelera cartelera = new Cartelera();
		
		try {
			CinemaPelicula cinemaPelicula = cinemaDAO.consultarCinemaPelulaPorCinemayPelicula(idCinema, idPelicula);
			
			if (cinemaPelicula != null){
				cartelera.setId(cinemaPelicula.getId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cartelera;
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
			peliculas.setReseña(pelicula.getResena());
			peliculas.setImagen(pelicula.getImagen());
		}
		
		return peliculas;
	}
	
	public List<Sala> consultarSalaporPeliculasCinema(int idCinema, int idPelicula){
		
		int idCinemaPelicula = consultarCinemaPelulaPorCinemayPelicula(idCinema, idPelicula).getId();
		
		List<Sala> salasPelicula = new ArrayList<>();
		
		try {
			List<com.proyecto.cineUnificado.persistencia.entities.Sala> salas = salaDAO.consultarSalaporPeliculasCinema(idCinemaPelicula);
			
			if (salas != null){
				for (com.proyecto.cineUnificado.persistencia.entities.Sala sala : salas) {
					Sala salaPeli = new Sala();
					salaPeli.setId(sala.getId());
					salaPeli.setIdioma(sala.getIdioma());
					salaPeli.setNombre(sala.getTipoSala());
					salaPeli.setNumSillas(sala.getNumSillas());
					salasPelicula.add(salaPeli);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salasPelicula;
	}
	
	public List<Horario> consultarFechas(){
		
		List<Horario> fechas = new ArrayList<Horario>();
		
		List<com.proyecto.cineUnificado.persistencia.entities.Horario> fechasSalas;
		
		try {
			fechasSalas = horarioDAO.consultarFechas();
			if (fechasSalas != null) {
				for (com.proyecto.cineUnificado.persistencia.entities.Horario horario : fechasSalas) {
					Horario fecSala = new Horario();
					fecSala.setFecha(horario.getFecha());
					fecSala.setHora(horario.getHora());
					fecSala.setId(horario.getIdHorario());
					fechas.add(fecSala);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fechas;
	}
	
	public List<Horario> consultarFechasPorSala(int idSala) {

		List<Horario> fechas = new ArrayList<Horario>();

		List<com.proyecto.cineUnificado.persistencia.entities.Horario> fechasSalas;
		try {
			fechasSalas = horarioDAO.consultarFechasPorSala(idSala);
			if (fechasSalas != null) {
				for (com.proyecto.cineUnificado.persistencia.entities.Horario horario : fechasSalas) {
					Horario fecSala = new Horario();
					fecSala.setFecha(horario.getFecha());
					fecSala.setHora(horario.getHora());
					fecSala.setId(horario.getIdHorario());
					fechas.add(fecSala);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fechas;
	}
	
	
	
	
	public List<Horario> consultarHorariosPorSala(Date fecha, int idSala){
		
		List<Horario> fechas = new ArrayList<Horario>();
		
		List<com.proyecto.cineUnificado.persistencia.entities.Horario> fechasSalas;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		final String stringDate= dateFormat.format(fecha);
		final java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
		try {
			fechasSalas = horarioDAO.consultarHorariosPorSala(sqlDate, idSala);
			if (fechasSalas != null){
				for (com.proyecto.cineUnificado.persistencia.entities.Horario horario : fechasSalas) {
					Horario fecSala = new Horario();
					fecSala.setFecha(horario.getFecha());
					fecSala.setHora(horario.getHora());
					fecSala.setId(horario.getIdHorario());
					fechas.add(fecSala);
				}
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return fechas;		
	}
	
	
}
