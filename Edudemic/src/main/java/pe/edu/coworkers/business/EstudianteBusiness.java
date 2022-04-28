package pe.edu.coworkers.business;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.coworkers.entities.Estudiante;
import pe.edu.coworkers.repository.EstudianteRepository;

@Named
public class EstudianteBusiness  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject 
	private EstudianteRepository estudianteRepository;
	@Transactional
	public Long registrarEstudiante(Estudiante estudiante) throws Exception 
	{
		return estudianteRepository.registrarEstudiante(estudiante);
	}
	@Transactional
	public Long actualizarEstudiante(Estudiante estudiante) throws Exception 
	{
		return estudianteRepository.actualizarEstudiante(estudiante);
	}
}