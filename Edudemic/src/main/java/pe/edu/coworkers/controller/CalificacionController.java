package pe.edu.coworkers.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.coworkers.business.CalificacionBusiness;
import pe.edu.coworkers.business.EstudianteBusiness;
import pe.edu.coworkers.business.ProfesorBusiness;
import pe.edu.coworkers.entities.Calificacion;
import pe.edu.coworkers.entities.Estudiante;
import pe.edu.coworkers.entities.Profesor;
import pe.edu.coworkers.util.Message;

@Named
@SessionScoped
public class CalificacionController  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject 
	private CalificacionBusiness calificacionBusiness;
	@Inject 
	private ProfesorBusiness profesorBusiness;
	@Inject 
	private EstudianteBusiness estudianteBusiness;
	private Calificacion calificacion;
	private List<Calificacion> calificaciones;
	private Calificacion selectCalficacion;
	private Profesor profesor;
	private List<Profesor> profesores;
	private Estudiante estudiante;
	private List<Estudiante> estudiantes;
	
	@PostConstruct
	public void init() {
		calificacion = new Calificacion();
		calificaciones = new ArrayList<>();
		selectCalficacion = new Calificacion();
		
		profesor = new Profesor();
		profesores = new ArrayList<>();
		
		estudiante = new Estudiante();
		estudiantes = new ArrayList<>();
		
		listaCalificaciones();
		profesoresTodos();
		estudiantesTodos();
	}
	public String registrarCalificacion() 
	{
		String vista = "";
		try {
			if (calificacion.getId() != null) {// update
				calificacion.setEstudiante(estudiante);
				calificacion.setProfesor(profesor);
				calificacionBusiness.actualizarCalificacion(calificacion);
				Message.messageInfo("Registro actualizado exitosamente");

			} else {// save
				
				calificacion.setEstudiante(estudiante);
				calificacion.setProfesor(profesor);
				calificacionBusiness.registrarCalificacion(calificacion);
				Message.messageInfo("Registro guardado exitosamente");
			}	
			this.listaCalificaciones();
			this.reiniciarForm();
		} catch (Exception e) {
		
		}
		return vista;
	}
	public void listaCalificaciones() {
		try{
			this.calificaciones = calificacionBusiness.listarCalificaciones();
		} catch (Exception e) {
			// TODO Auto-generated method stub
		}
	}
	public void estudiantesTodos() {
		try{
			this.estudiantes = estudianteBusiness.listarEstudiantes();	
		} catch (Exception e) {
			// TODO Auto-generated method stub
		}	
	}

	public void profesoresTodos() {
		try{
			this.profesores = profesorBusiness.listarProfesores();
		} catch (Exception e) {
			// TODO Auto-generated method stub
		}
	}
	public String modificarCalificacion() {
		String view = "";
		try {
			if (this.selectCalficacion != null) {
				this.calificacion = selectCalficacion;
				this.estudiantes = estudianteBusiness.listarEstudiantes();
				this.profesores = profesorBusiness.listarProfesores();
				view = "/calificacion/modificar";
			} else {
				Message.messageInfo("Debe seleccionar una calificacion");
			}

		} catch (Exception e) {
			Message.messageError("Error:" + e.getMessage());
		}

		return view;
	}
	public String verCalificacion() {
		return "lista.xhtml";
	}
	public void reiniciarForm() {
		calificacion = new Calificacion();
		
	}
	public Calificacion getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}
	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
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
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	public void selectProduct(SelectEvent e) {
		this.selectCalficacion= (Calificacion) e.getObject();
	}
	public Calificacion getProfesorSelected() {
		return selectCalficacion;
	}
	public void setProfesorSelected(Calificacion selectCalficacion) {
		this.selectCalficacion = selectCalficacion;
	}
}