package pe.edu.coworkers.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.coworkers.entities.Profesor;
import pe.edu.coworkers.repository.ProfesorRepository;

@Named

public class ProfesorBusiness implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject 
	private ProfesorRepository profesorRepository;
	@Transactional
	public void Registrar(Profesor profesor) throws Exception 
	{
		profesorRepository.Registrar(profesor);
	}
	@Transactional
	public void Actualizar(Profesor profesor) throws Exception 
	{
		profesorRepository.Actualizar(profesor);
	}
	public List<Profesor> ListarProfesores() throws Exception
	{
		return profesorRepository.ListarProfesores();
	}
}
