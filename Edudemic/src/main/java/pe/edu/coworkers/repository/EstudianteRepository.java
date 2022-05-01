package pe.edu.coworkers.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.coworkers.entities.Estudiante;

@Named
public class EstudianteRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "demoWeb")
	private EntityManager em;

	public Long registrarEstudiante(Estudiante estudiante) throws Exception {
		em.persist(estudiante);
		return estudiante.getId();
	}

	public Long actualizarEstudiante(Estudiante estudiante) throws Exception {
		em.merge(estudiante);
		return estudiante.getId();
	}
	public List<Estudiante> listarEstudiantes() throws Exception 
	{
		List<Estudiante> estudiantes = new ArrayList<>();
		TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e",Estudiante.class);
		estudiantes = query.getResultList();
		return estudiantes;
	}
	public Estudiante buscarEstudiante(String dni, String password) throws Exception 
	{
		
		Estudiante estudiante = new Estudiante();
		TypedQuery<Estudiante> query = em.createQuery("FROM Estudiante e WHERE e.dni LIKE dni and e.contraseña LIKE password",Estudiante.class);
		estudiante = query.getSingleResult();
		return estudiante;
	}	
}