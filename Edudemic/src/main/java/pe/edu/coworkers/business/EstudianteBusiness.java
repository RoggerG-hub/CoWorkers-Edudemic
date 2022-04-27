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
	public void Registrar(Estudiante estudiante) throws Exception 
	{
		estudianteRepository.Registrar(estudiante);
	}
	@Transactional
	public void Actualizar(Estudiante estudiante) throws Exception 
	{
		estudianteRepository.Actualizar(estudiante);
	}
}