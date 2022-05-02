package pe.edu.coworkers.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.coworkers.entities.Comentario;

@Named
public class ComentarioRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;
	
	public Long registrarComentario(Comentario comentario) throws Exception {
		em.persist(comentario);
		return comentario.getId();
	}

	public void actualizarComentario(Comentario comentario) throws Exception {
		em.merge(comentario);
	}
	public List<Comentario> listarComentarios() throws Exception 
	{
		List<Comentario> comentarios = new ArrayList<>();
		TypedQuery<Comentario> query = em.createQuery("FROM Comentario f",Comentario.class);
		comentarios = query.getResultList();
		return comentarios;
	}	
	
	
}
