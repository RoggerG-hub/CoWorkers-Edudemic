package pe.edu.coworkers.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.coworkers.business.ProfesorBusiness;

import pe.edu.coworkers.entities.Profesor;

@Named
public class ProfesorController  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject 
	private ProfesorBusiness profesorBusiness;
	@Inject 
	
	private Profesor profesor;
	private List<Profesor> profesores;

	@PostConstruct
	public void init()
	{
		profesor = new Profesor();
		profesores=new ArrayList<>();

	}	
	public void Registrar(Profesor profe) 
	{
		try {
			profesorBusiness.Registrar(profe);
		} catch (Exception e) {
		
		}
	}
	public void Actualizar(Profesor profe) 
	{
		try {
			profesorBusiness.Actualizar(profe);
		} catch (Exception e) {
		
		}
	}

	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public List<Profesor> getProfesores() {
		return profesores;
	}
	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	
}
