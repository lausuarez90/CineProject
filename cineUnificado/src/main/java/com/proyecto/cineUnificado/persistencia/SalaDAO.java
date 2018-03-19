package com.proyecto.cineUnificado.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.cineUnificado.persistencia.entities.CinemaPelicula;
import com.proyecto.cineUnificado.persistencia.entities.Sala;

public class SalaDAO {

	Connection connection = null;
	
	public SalaDAO(Connection connection) {
		
		this.connection = connection;
	}

	public List<Sala> consultarSalaporPeliculasCinema(int idCinemaPelicula) throws SQLException {


		List<Sala> salas = new ArrayList<Sala>();

		PreparedStatement pst = null;
		try {
			pst = this.connection.prepareStatement("SELECT * FROM sala WHERE id_cinema_pelicula = ?");
			pst.setInt(1, idCinemaPelicula);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Sala sala = new Sala();
				sala.setId(rs.getInt(1));
				sala.setNumSillas(rs.getInt(2));
				sala.setTipoSala(rs.getString(3));
				sala.setId_cinema_pelicula(rs.getInt(4));
				sala.setIdioma(rs.getString(5));
				salas.add(sala);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pst.close();
		}

		return salas;
	}
}
