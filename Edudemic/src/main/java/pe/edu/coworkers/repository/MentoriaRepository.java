package pe.edu.coworkers.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.coworkers.entities.Mentoria;

@Named
public class MentoriaRepository implements Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;

	public Long registrarMentoria(Mentoria mentoria) throws Exception {
		em.persist(mentoria);
		return mentoria.getId();
	}
	public List<Mentoria> listarMentorias () throws Exception 
	{
		List<Mentoria> mentorias = new ArrayList<>();
		TypedQuery<Mentoria> query = em.createQuery("FROM Mentoria m",Mentoria.class);
		mentorias = query.getResultList();
		return mentorias;
	}

}
