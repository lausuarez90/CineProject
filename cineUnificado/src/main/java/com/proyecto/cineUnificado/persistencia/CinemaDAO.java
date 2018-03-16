package com.proyecto.cineUnificado.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.cineUnificado.persistencia.entities.Cinema;
import com.proyecto.cineUnificado.persistencia.entities.CinemaPelicula;

public class CinemaDAO {
	
	Connection connection = null;
	ConexionBD conexionBD;
	
	public CinemaDAO(Connection connection) {
		
		this.connection = connection;
	}
	
	public List<Cinema> consultarCinemaPorEmpresa(int idTipoCinema) throws SQLException{
		
//		connection = conexionBD.getConnection();
		
		List<Cinema> cinemas = new ArrayList<Cinema>();
		
		PreparedStatement pst = null;
		try {
			pst = this.connection.prepareStatement("SELECT * FROM cinema WHERE id_tipo_cinema = ?");
			pst.setInt(1, idTipoCinema);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
	            Cinema cinema = new Cinema();
	            cinema.setId(rs.getInt(1));
	            cinema.setNombre(rs.getString(2));
	            cinema.setDireccion(rs.getString(3));
	            cinema.setTelefono(rs.getString(4));
	            cinema.setIdTipoCinema(rs.getInt(5));
                System.out.print(cinema.toString());
                cinemas.add(cinema);
            }
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pst.close();
		}
       
		return cinemas;
			
	}
	
	public Cinema consultaCinemaporId(int idCinema) throws SQLException{
		
//		connection = conexionBD.getConnection();
		
		Cinema cinema = null;
		
		PreparedStatement pst = null;
		try {
			pst = this.connection.prepareStatement("SELECT * FROM cinema WHERE id = ?");
			pst.setInt(1, idCinema);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
	            cinema = new Cinema();
	            cinema.setId(rs.getInt(1));
	            cinema.setNombre(rs.getString(2));
	            cinema.setDireccion(rs.getString(3));
	            cinema.setTelefono(rs.getString(4));
	            cinema.setIdTipoCinema(rs.getInt(5));
                System.out.print(cinema.toString());
               
            }
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pst.close();
		}
       
		return cinema;
		
	}
	
	public List<CinemaPelicula> consultarPeliculasporCinema(int idCinema) throws SQLException{
		
//		connection = conexionBD.getConnection();
		
		List<CinemaPelicula> peliculas = new ArrayList<CinemaPelicula>();
		
		PreparedStatement pst = null;
		try {
			pst = this.connection.prepareStatement("SELECT * FROM cinema_pelicula cp WHERE cp.id_cinema = ?");
			pst.setInt(1, idCinema);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				CinemaPelicula cinemaPelicula = new CinemaPelicula();
				cinemaPelicula.setId(rs.getInt(1));
				cinemaPelicula.setIdCinema(rs.getInt(2));
				cinemaPelicula.setIdPelicula(rs.getInt(3));
				peliculas.add(cinemaPelicula);
            }
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pst.close();
		}
       
		return peliculas;
	}
	

}
