package pe.edu.coworkers.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.coworkers.business.MentoriaBusiness;
import pe.edu.coworkers.business.ProfesorBusiness;
import pe.edu.coworkers.entities.Mentoria;
import pe.edu.coworkers.entities.Profesor;
import pe.edu.coworkers.util.Message;

@Named
@SessionScoped 
public class MentoriaController implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private MentoriaBusiness mentoriaBusiness;
	@Inject
	private ProfesorBusiness profesorBusiness;
	private Mentoria mentoriaSelected;
	private Profesor profesor;
	private Mentoria mentoria;
	private List<Profesor> profesores;
	private List<Mentoria> mentorias;
	@PostConstruct
	public void init()
	{
		profesor = new Profesor();
		profesores=new ArrayList<>();
		mentoria = new Mentoria();
		mentorias =new ArrayList<>();
		mentoriaSelected= new Mentoria();
		
		mentoriasTodos();
		listaProfesores();
	}	
	
	

	public Mentoria getMentoriaSelected() {
		return mentoriaSelected;
	}
	public void setMentoriaSelected(Mentoria mentoriaSelected) {
		this.mentoriaSelected = mentoriaSelected;
	}
	public void listaProfesores() 
	{
		try {
			profesores = profesorBusiness.listarProfesores();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String registrarMentoria() 
	{
		String vista = "";
		try {	
				mentoria.setProfesor(profesor);
				mentoriaBusiness.registrarMentoria(mentoria);
				Message.messageInfo("Registro guardado exitosamente");
			
			this.mentoriasTodos();
			this.reiniciarForm();
			
		} catch (Exception e) {
		
		}
		return vista;
	}
	
	public void mentoriasTodos() {
		try {
			mentorias=mentoriaBusiness.listarMentorias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String editMentoria() {
		String view = "";
		try {
			if (this.mentoria != null) {
				//this.mentoria = mentoriaSelected;
				this.profesores = profesorBusiness.listarProfesores();
				view = "/mentoria/edit";
			} else {
				Message.messageInfo("Debe seleccionar");
			}

		} catch (Exception e) {
			Message.messageError("Error:" + e.getMessage());
		}

		return view;
	}
	
	public void reiniciarForm() {
		mentoria = new Mentoria();
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Mentoria getMentoria() {
		return mentoria;
	}
	public void setMentoria(Mentoria mentoria) {
		this.mentoria = mentoria;
	}
	public List<Profesor> getProfesores() {
		return profesores;
	}
	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
	public List<Mentoria> getMentorias() {
		return mentorias;
	}
	public void setMentorias(List<Mentoria> mentorias) {
		this.mentorias = mentorias;
	}
	public String listMentorias() {
		return "lista.xhtml";
	}
	
	public void selectProduct(SelectEvent e) {
		this.mentoriaSelected = (Mentoria) e.getObject();
	}
}
