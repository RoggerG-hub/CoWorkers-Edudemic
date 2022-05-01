package pe.edu.coworkers.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.coworkers.business.CalificacionBusiness;
import pe.edu.coworkers.business.EstudianteBusiness;
import pe.edu.coworkers.business.ProfesorBusiness;
import pe.edu.coworkers.entities.Calificacion;

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

}
