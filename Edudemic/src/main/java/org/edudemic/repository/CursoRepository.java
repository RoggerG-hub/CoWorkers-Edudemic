package org.edudemic.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.edudemic.entities.Curso;

@Named
public class CursoRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;

	public void Registrar(Curso curso) throws Exception {
		em.persist(curso);
	}
	public List<Curso> ListarCursos() throws Exception 
	{
		List<Curso> cursos = new ArrayList<>();
		TypedQuery<Curso> query = em.createQuery("FROM Curso c",Curso.class);
		cursos = query.getResultList();
		return cursos;
	}
	public List<Curso> BuscarPorNombre(String nombre) throws Exception 
	{
		List<Curso> cursos = new ArrayList<>();
		TypedQuery<Curso> query = em.createQuery("FROM Curso c WHERE c.nombre LIKE ?1",Curso.class);
		query.setParameter(1, "%"+nombre+"%");
		cursos = query.getResultList();
		return cursos;
	}

}
