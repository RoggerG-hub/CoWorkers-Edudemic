package pe.edu.coworkers.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.coworkers.business.CursoBusiness;
import pe.edu.coworkers.business.ProfesorBusiness;
import pe.edu.coworkers.entities.Curso;
import pe.edu.coworkers.entities.Profesor;
import pe.edu.coworkers.util.Message;

@Named
@SessionScoped
public class ProfesorController  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject 
	private ProfesorBusiness profesorBusiness;
	@Inject 
	private CursoBusiness cursoBusiness;
	private Profesor profesor;
	private Profesor profesorSelected;
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
		profesorSelected = new Profesor();
		listaCursos();
		profesoresTodos();
	}	
	public String registrarProfesor() 
	{
		String vista = "";
		try {
			if (profesor.getId() != null) {// update
				profesor.setCurso(curso);
				profesorBusiness.actualizarProfesor(profesor);
				Message.messageInfo("Registro actualizado exitosamente");

			} else {// save
				
				profesor.setCurso(curso);
				profesorBusiness.registrarProfesor(profesor);
				Message.messageInfo("Registro guardado exitosamente");
			}	
			this.profesoresTodos();
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
	public void profesoresTodos() {
		try {
			this.profesores=profesorBusiness.listarProfesores();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String editProfesor() {
		String view = "";
		try {
			if (this.profesorSelected != null) {
				this.profesor = profesorSelected;
				this.cursos = cursoBusiness.listarCursos();
				view = "/profesor/edit";
			} else {
				Message.messageInfo("Debe seleccionar un curso");
			}

		} catch (Exception e) {
			Message.messageError("Error:" + e.getMessage());
		}

		return view;
	}
	public String listProfesor() {
		return "list.xhtml";
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
	public void selectProduct(SelectEvent e) {
		this.profesorSelected = (Profesor) e.getObject();
	}
	public Profesor getProfesorSelected() {
		return profesorSelected;
	}
	public void setProfesorSelected(Profesor profesorSelected) {
		this.profesorSelected = profesorSelected;
	}
	
}
