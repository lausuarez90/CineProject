package com.proyecto.cineUnificado.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.cineUnificado.persistencia.entities.Horario;

public class HorarioDAO {
	
	Connection connection = null;
	
	public HorarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Horario> consultarFechas() throws SQLException {

		List<Horario> fechas = new ArrayList<>();

		PreparedStatement pst = null;
		try {
			pst = this.connection.prepareStatement("SELECT * FROM horario");
			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Horario horario = new Horario();
				horario.setIdHorario(rs.getInt(1));
				horario.setFecha(rs.getDate(2));
				horario.setHora(rs.getString(3));
				horario.setIdSala(rs.getInt(4));
				fechas.add(horario);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pst.close();
		}
		return fechas;

	}
	
	public List<Horario> consultarFechasPorSala(int idSala) throws SQLException {

		List<Horario> fechas = new ArrayList<>();

		PreparedStatement pst = null;
		try {
			pst = this.connection.prepareStatement("SELECT * FROM horario WHERE id_cinema_sala = ?");
			pst.setInt(1, idSala);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Horario horario = new Horario();
				horario.setIdHorario(rs.getInt(1));
				horario.setFecha(rs.getDate(2));
				horario.setHora(rs.getString(3));
				horario.setIdSala(rs.getInt(4));
				fechas.add(horario);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pst.close();
		}
		return fechas;

	}
	
	public List<Horario> consultarHorariosPorSala(Date fecha, int idSala) throws SQLException{
		
		List<Horario> fechas = new ArrayList<>();
		
		PreparedStatement pst = null;
		try {
			pst = this.connection.prepareStatement("SELECT * FROM horario WHERE fehca  = ? and id_cinema_sala = ?");
			pst.setDate(1, fecha);
			pst.setInt(2, idSala);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Horario horario = new Horario();
				horario.setIdHorario(rs.getInt(1));
				horario.setFecha(rs.getDate(2));
				horario.setHora(rs.getString(3));
				horario.setIdSala(rs.getInt(4));
				fechas.add(horario);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pst.close();
		}
		return fechas;	
		
	}

	
}
