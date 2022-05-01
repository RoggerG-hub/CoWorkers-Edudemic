package pe.edu.coworkers.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
		listaProfesores();
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
			this.reiniciarForm();
		} catch (Exception e) {
		
		}
		return vista;
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
	
}
