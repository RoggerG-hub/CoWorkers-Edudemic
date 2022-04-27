package pe.edu.coworkers.business;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import pe.edu.coworkers.entities.Curso;
import pe.edu.coworkers.repository.CursoRepository;

@Named
public class CursoBusiness implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private CursoRepository cursoRepository;

	@Transactional
	public Long registrarCurso(Curso curso) throws Exception {
		return cursoRepository.registrarCurso(curso);
	}

	public List<Curso> listarCursos() throws Exception {
		return cursoRepository.listarCursos();
	}

	public List<Curso> buscarNombre(String nombre) throws Exception {
		return cursoRepository.buscarNombre(nombre);
	}
}
