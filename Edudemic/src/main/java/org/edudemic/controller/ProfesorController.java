package org.edudemic.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.edudemic.business.ProfesorBusiness;

@Named
public class ProfesorController  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject 
	private ProfesorBusiness profesorBusiness;
	
}
