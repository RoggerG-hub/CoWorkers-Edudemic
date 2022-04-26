package org.edudemic.business;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.edudemic.entities.Estudiante;
import org.edudemic.repository.EstudianteRepository;

@Named
public class EstudianteBusiness  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject 
	private EstudianteRepository estudianteRepository;
	public void Registrar(Estudiante estudiante) throws Exception 
	{
		estudianteRepository.Registrar(estudiante);
	}
	public void Actualizar(Estudiante estudiante) throws Exception 
	{
		estudianteRepository.Actualizar(estudiante);
	}
}