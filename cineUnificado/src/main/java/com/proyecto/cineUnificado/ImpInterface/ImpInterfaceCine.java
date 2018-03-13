package com.proyecto.cineUnificado.ImpInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.cineUnificado.Interfaces.InterfaceCine;
import com.proyecto.cineUnificado.modelo.Cinema;
import com.proyecto.cineUnificado.modelo.Empresa;
import com.proyecto.cineUnificado.persistencia.CinemaDAO;
import com.proyecto.cineUnificado.persistencia.EmpresasDAO;

public class ImpInterfaceCine implements InterfaceCine{
	
	EmpresasDAO empresasDAO;
	CinemaDAO cinemaDAO;

	public ImpInterfaceCine() {
		empresasDAO = new EmpresasDAO();
		cinemaDAO = new CinemaDAO();
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
	
	
	public void ConsultarHorario(){
		
	}
	
	public void GuardarReserva(){
		
	}
}
