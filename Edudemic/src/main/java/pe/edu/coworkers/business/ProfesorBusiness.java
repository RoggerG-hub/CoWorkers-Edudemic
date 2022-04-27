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
	public Long registrarProfesor(Profesor profesor) throws Exception 
	{
		return profesorRepository.registrarProfesor(profesor);	
	}
	@Transactional
	public void actualizarProfesor(Profesor profesor) throws Exception 
	{
		profesorRepository.actualizarProfesor(profesor);
	}
	public List<Profesor> listarProfesores() throws Exception
	{
		return profesorRepository.listarProfesores();
	}
}
