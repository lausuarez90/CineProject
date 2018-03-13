package com.proyecto.cineUnificado.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.cineUnificado.persistencia.entities.Cinema;

public class CinemaDAO {
	
	Connection connection = null;
	ConexionBD conexionBD;
	
	public CinemaDAO() {
		
		conexionBD = new ConexionBD();
	}
	
	public List<Cinema> consultarCinemaPorEmpresa(int idTipoCinema) throws SQLException{
		
		connection = conexionBD.getConnection();
		
		List<Cinema> cinemas = new ArrayList<Cinema>();
		
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement("SELECT * FROM cinema WHERE id_tipo_cinema = ?");
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
	

}
