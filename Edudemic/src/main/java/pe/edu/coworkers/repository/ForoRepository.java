package pe.edu.coworkers.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.coworkers.entities.Foro;

@Named
public class ForoRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;
		
	public Long registrarForo(Foro foro) throws Exception {
		em.persist(foro);
		return foro.getId();
	}

	public void actualizarForo(Foro foro) throws Exception {
		em.merge(foro);
	}
	public List<Foro> listarForos() throws Exception 
	{
		List<Foro> foros = new ArrayList<>();
		TypedQuery<Foro> query = em.createQuery("FROM Foro f",Foro.class);
		foros = query.getResultList();
		return foros;
	}	
		
		
}
