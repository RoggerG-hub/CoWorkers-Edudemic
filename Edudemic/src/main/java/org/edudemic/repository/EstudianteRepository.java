package org.edudemic.repository;

import java.io.Serializable;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.edudemic.entities.Estudiante;

@Named
public class EstudianteRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;

	public void Registrar(Estudiante estudiante) throws Exception {
		em.persist(estudiante);
	}

	public void Actualizar(Estudiante estudiante) throws Exception {
		em.merge(estudiante);
	}
}