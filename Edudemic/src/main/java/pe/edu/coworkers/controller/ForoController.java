package pe.edu.coworkers.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.coworkers.business.EstudianteBusiness;
import pe.edu.coworkers.business.ForoBusiness;
import pe.edu.coworkers.entities.Estudiante;
import pe.edu.coworkers.entities.Foro;

@Named
@SessionScoped
public class ForoController implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject 
	private ForoBusiness foroBusiness;
	
	@Inject
	private EstudianteBusiness estudianteBusiness;
	private Foro foro;
	private List<Foro> foros;
	private Estudiante estudiante;
	private List<Estudiante>estudiantes;
	@PostConstruct
	public void init()
	{
		foro = new Foro();
		foros=new ArrayList<>();
		estudiante = new Estudiante();
		estudiantes= new ArrayList<>();
		listaEstudiantes();
	}
	public String registrarForo() 
	{
		String vista = "";
		try {
			System.out.println("registrarForo");
			System.out.println(foro.getId());
			System.out.println(foro.getTitulo());
			System.out.println(foro.getDescripcion());
			System.out.println(foro.getFechaPublicacion());
			System.out.println(foro.getEstudiante());
			foro.setEstudiante(estudiante);
			foroBusiness.registrarForo(foro);
			this.reiniciarForm();
		} catch (Exception e) {
		
		}
		return vista;
	}
	
	public void listaEstudiantes() {
		try {
			this.estudiantes = estudianteBusiness.listarEstudiantes();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ForoBusiness getForoBusiness() {
		return foroBusiness;
	}
	public void setForoBusiness(ForoBusiness foroBusiness) {
		this.foroBusiness = foroBusiness;
	}
	public Foro getForo() {
		return foro;
	}
	public void setForo(Foro foro) {
		this.foro = foro;
	}
	public List<Foro> getForos() {
		return foros;
	}
	public void setForos(List<Foro> foros) {
		this.foros = foros;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void reiniciarForm() {
		foro = new Foro();
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public EstudianteBusiness getEstudianteBusiness() {
		return estudianteBusiness;
	}
	public void setEstudianteBusiness(EstudianteBusiness estudianteBusiness) {
		this.estudianteBusiness = estudianteBusiness;
	}
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
}
