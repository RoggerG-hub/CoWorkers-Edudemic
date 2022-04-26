package org.edudemic.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.edudemic.business.CursoBusiness;

@Named
public class CursoController  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private CursoBusiness cursoBusiness;
	
}
