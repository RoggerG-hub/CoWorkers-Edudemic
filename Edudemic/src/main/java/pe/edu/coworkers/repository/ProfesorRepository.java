package pe.edu.coworkers.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.coworkers.entities.Profesor;

@Named
public class ProfesorRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;

	public Long registrarProfesor(Profesor profesor) throws Exception {
		em.persist(profesor);
		return profesor.getId();
	}

	public void actualizarProfesor(Profesor profesor) throws Exception {
		em.merge(profesor);
	}
	public List<Profesor> listarProfesores() throws Exception 
	{
		List<Profesor> profesores = new ArrayList<>();
		TypedQuery<Profesor> query = em.createQuery("FROM Profesor p",Profesor.class);
		profesores = query.getResultList();
		return profesores;
	}
	

}
