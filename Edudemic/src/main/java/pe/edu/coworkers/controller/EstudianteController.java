package pe.edu.coworkers.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.coworkers.business.EstudianteBusiness;
import pe.edu.coworkers.entities.Estudiante;
import pe.edu.coworkers.util.Message;

@Named
@SessionScoped
public class EstudianteController implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private EstudianteBusiness estudianteBusiness;
	private Estudiante estudiante;
	private List<Estudiante> estudiantes;
	private Estudiante estudianteSelected;
	@PostConstruct
	public void init() {
		estudiante = new Estudiante();
		estudiantes = new ArrayList<>();
		estudianteSelected = new Estudiante();
		estudiantesTodos();
	}
	public void selectEstudiante(SelectEvent e) {
		this.estudianteSelected = (Estudiante) e.getObject();
	}
	public String editEstudiante() {
		String view = "";
		try {
			if (this.estudianteSelected != null) {
				this.estudiante = estudianteSelected;
				view = "/estudiante/edit";
			} else {
				Message.messageInfo("Debe seleccionar un estudiante");
			}

		} catch (Exception e) {
			Message.messageError("Error ProductController:" + e.getMessage());
		}

		return view;
	}
	public void estudiantesTodos() {
		try {
			this.estudiantes=estudianteBusiness.listarEstudiantes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public void buscarEstudiante(String usuario, String password) 
	{
		 try {
			 estudianteBusiness.buscarEstudiante(usuario, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Estudiante getEstudianteSelected() {
		return estudianteSelected;
	}

	public void setEstudianteSelected(Estudiante estudianteSelected) {
		this.estudianteSelected = estudianteSelected;
	}
	
}
