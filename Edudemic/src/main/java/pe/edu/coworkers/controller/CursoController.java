package pe.edu.coworkers.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.coworkers.business.CursoBusiness;
import pe.edu.coworkers.entities.Curso;

@Named
@SessionScoped //Esto de aquí!!!
public class CursoController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private CursoBusiness cursoBusiness;
	private Curso curso;
	private List<Curso> cursos;

	@PostConstruct
	public void init() {
		curso = new Curso();
		cursos = new ArrayList<>();
	}

	public void listarCursos() {
		try {
			cursos = cursoBusiness.listarCursos();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public String registrarCurso() {
		String view = "";
		try {
			System.out.println("registrarCurso");
			System.out.println(curso.getId());
			System.out.println(curso.getNombre());
			System.out.println(curso.getDescripcion());
			cursoBusiness.registrarCurso(curso);
			this.reiniciarForm();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return view;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public void reiniciarForm() {
		curso = new Curso();
	}
}
