package pe.edu.coworkers.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.coworkers.entities.Calificacion;

@Named
public class CalificacionRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;
	public Long registrarCalificacion(Calificacion calificacion) throws Exception {
		em.persist(calificacion);
		return calificacion.getId();
	}
	public void actualizarCalificacion(Calificacion calificacion) throws Exception {
		em.merge(calificacion);
	}
	public List<Calificacion> listarCalificaciones() throws Exception 
	{
		List<Calificacion> calificaciones = new ArrayList<>();
		TypedQuery<Calificacion> query = em.createQuery("SELECT c FROM Calificacion c",Calificacion.class);
		calificaciones = query.getResultList();
		return calificaciones;
	}
}