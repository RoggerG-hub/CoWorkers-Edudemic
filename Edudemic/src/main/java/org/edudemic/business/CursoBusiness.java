package org.edudemic.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.edudemic.entities.Curso;
import org.edudemic.repository.CursoRepository;

@Named

public class CursoBusiness implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject 
	private CursoRepository cursoRepository;
	public void Registrar(Curso curso) throws Exception 
	{
		cursoRepository.Registrar(curso);
	}
	public List<Curso> ListarCursos() throws Exception
	{
		return cursoRepository.ListarCursos();
	}
	public List<Curso> BuscarPorNombre(String nombre) throws Exception
	{
		return cursoRepository.BuscarPorNombre(nombre);
	}
}
