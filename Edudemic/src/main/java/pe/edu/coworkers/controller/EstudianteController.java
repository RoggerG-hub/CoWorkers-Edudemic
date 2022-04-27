package pe.edu.coworkers.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.coworkers.business.EstudianteBusiness;

@Named
@SessionScoped
public class EstudianteController  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject 
	private EstudianteBusiness estudianteBusiness;
	

}
