package pe.edu.coworkers.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.coworkers.entities.Calificacion;
import pe.edu.coworkers.repository.CalificacionRepository;

@Named
public class CalificacionBusiness implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private CalificacionRepository calificacionRepository;
	@Transactional
	public Long registrarCalificacion(Calificacion calificacion) throws Exception 
	{
		return calificacionRepository.registrarCalificacion(calificacion);	
	}
	@Transactional
	public void actualizarCalificacion(Calificacion calificacion) throws Exception 
	{
		calificacionRepository.actualizarCalificacion(calificacion);
	}
	public List<Calificacion> listarCalificaciones() throws Exception
	{
		return calificacionRepository.listarCalificaciones();
	}
}