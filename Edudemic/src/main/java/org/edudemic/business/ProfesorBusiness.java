package org.edudemic.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.edudemic.entities.Profesor;
import org.edudemic.repository.ProfesorRepository;

@Named

public class ProfesorBusiness implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject 
	private ProfesorRepository profesorRepository;
	public void Registrar(Profesor profesor) throws Exception 
	{
		profesorRepository.Registrar(profesor);
	}
	public void Actualizar(Profesor profesor) throws Exception 
	{
		profesorRepository.Actualizar(profesor);
	}
	public List<Profesor> ListarProfesores() throws Exception
	{
		return profesorRepository.ListarProfesores();
	}
}
