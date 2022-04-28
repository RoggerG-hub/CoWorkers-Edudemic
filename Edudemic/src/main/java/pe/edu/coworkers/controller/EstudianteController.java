package pe.edu.coworkers.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.coworkers.business.EstudianteBusiness;
import pe.edu.coworkers.entities.Estudiante;

@Named
@SessionScoped
public class EstudianteController implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private EstudianteBusiness estudianteBusiness;
	private Estudiante estudiante;
	private List<Estudiante> estudiantes;

	@PostConstruct
	public void init() {
		estudiante = new Estudiante();
		estudiantes = new ArrayList<>();
	}

	public String registrarEstudiante() {
		String vista = "";
		try {
			System.out.println("registrarProfesor");
			System.out.println(estudiante.getId());
			System.out.println(estudiante.getNombres());
			System.out.println(estudiante.getApellidos());
			System.out.println(estudiante.getEdad());
			System.out.println(estudiante.getContraseña());
			System.out.println(estudiante.getFecha());
			System.out.println(estudiante.getTelefono());
			System.out.println(estudiante.getCorreo());
			estudianteBusiness.registrarEstudiante(estudiante);
			this.reiniciarForm();
		} catch (Exception e) {

		}
		return vista;
	}
	public void reiniciarForm() {
		estudiante = new Estudiante();
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
	
}
