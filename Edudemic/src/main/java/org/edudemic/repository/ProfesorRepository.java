package org.edudemic.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.edudemic.entities.Profesor;

@Named
public class ProfesorRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;

	public void Registrar(Profesor profesor) throws Exception {
		em.persist(profesor);
	}

	public void Actualizar(Profesor profesor) throws Exception {
		em.merge(profesor);
	}
	public List<Profesor> ListarProfesores() throws Exception 
	{
		List<Profesor> profesores = new ArrayList<>();
		TypedQuery<Profesor> query = em.createQuery("FROM Profesor p",Profesor.class);
		profesores = query.getResultList();
		return profesores;
	}

}
