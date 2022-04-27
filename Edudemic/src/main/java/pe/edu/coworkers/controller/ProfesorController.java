package pe.edu.coworkers.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.coworkers.business.CursoBusiness;
import pe.edu.coworkers.business.ProfesorBusiness;
import pe.edu.coworkers.entities.Curso;
import pe.edu.coworkers.entities.Profesor;

@Named
@SessionScoped
public class ProfesorController  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject 
	private ProfesorBusiness profesorBusiness;
	@Inject 
	private CursoBusiness cursoBusiness;
	private Profesor profesor;
	private List<Profesor> profesores;
	private Curso curso;
	private List<Curso> cursos;
	@PostConstruct
	public void init()
	{
		profesor = new Profesor();
		profesores=new ArrayList<>();
		curso = new Curso();
		cursos = new ArrayList<>();
		listaCursos();
	}	
	public String registrarProfesor() 
	{
		String vista = "";
		try {
			System.out.println("registrarProfesor");
			System.out.println(profesor.getId());
			System.out.println(profesor.getNombres());
			System.out.println(profesor.getApellidos());
			System.out.println(profesor.getEdad());
			System.out.println(profesor.getContraseña());
			System.out.println(profesor.getCurso());
			System.out.println(profesor.getFecha());
			System.out.println(profesor.getTelefono());
			System.out.println(profesor.getCorreo());
			profesor.setCurso(curso);
			profesorBusiness.registrarProfesor(profesor);
			this.reiniciarForm();
		} catch (Exception e) {
		
		}
		return vista;
	}
	public void listaCursos() {
		try {
			this.cursos = cursoBusiness.listarCursos();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public List<Profesor> getProfesores() {
		return profesores;
	}
	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
	public void reiniciarForm() {
		profesor = new Profesor();
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}
