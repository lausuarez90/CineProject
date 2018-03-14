package com.proyecto.cineUnificado.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.cineUnificado.Interfaces.InterfaceCine;
import com.proyecto.cineUnificado.persistencia.entities.Empresa;

public class EmpresasDAO {
	
	Connection connection = null;
	ConexionBD conexionBD;
	
	
	public EmpresasDAO() {
		
		conexionBD = new ConexionBD();
	}
	
	public List<Empresa> consultarEmpresas(){
		
		connection = conexionBD.getConnection();
		
		List<Empresa> empresas = new ArrayList<Empresa>();
		
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("SELECT * FROM empresa");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
	            Empresa empresa = new Empresa();
	            empresa.setIdEmpresa(rs.getInt(1));
	            empresa.setNombreEmpresa(rs.getString(2));
	            empresa.setNit(rs.getString(3));
                System.out.print(empresa.toString());
                empresas.add(empresa);
            }
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return empresas;
	}
 
	public Empresa consultarEmpresaPorId(int id) {

		connection = conexionBD.getConnection();
		
		Empresa empresa = null;
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("SELECT * FROM empresa where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				empresa = new Empresa();
				empresa.setIdEmpresa(rs.getInt(1));
				empresa.setNombreEmpresa(rs.getString(2));
				empresa.setNit(rs.getString(3));
				System.out.print(empresa.toString());
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empresa;
	}
}
