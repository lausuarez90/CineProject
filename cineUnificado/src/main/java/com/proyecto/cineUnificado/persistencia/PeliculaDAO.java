package com.proyecto.cineUnificado.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.cineUnificado.persistencia.entities.Empresa;
import com.proyecto.cineUnificado.persistencia.entities.Pelicula;

public class PeliculaDAO {
	
	Connection connection = null;
	ConexionBD conexionBD;
	
	public PeliculaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Pelicula consultarPeliculaPorId(int id) {

//		connection = conexionBD.getConnection();
		
		Pelicula pelicula = null;
		PreparedStatement pst;
		try {
			pst = this.connection.prepareStatement("SELECT * FROM pelicula where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				pelicula = new Pelicula();
				pelicula.setId(rs.getInt(1));
				pelicula.setDuracion(rs.getInt(2));
				pelicula.setCalificacion(rs.getString(3));
				pelicula.setNombre(rs.getString(4));
				pelicula.setResena(rs.getString(5));
				pelicula.setGenero(rs.getString(6));
				pelicula.setClasificacion(rs.getString(7));
				pelicula.setImagen(rs.getString(8));
				System.out.print(pelicula.toString());
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pelicula;
	}

}
