package org.edudemic.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.edudemic.business.EstudianteBusiness;

@Named
public class EstudianteController  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject 
	private EstudianteBusiness estudianteBusiness;
	

}
