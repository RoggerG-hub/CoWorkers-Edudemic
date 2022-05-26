package pe.edu.coworkers.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.coworkers.business.ComentarioBusiness;
import pe.edu.coworkers.business.ForoBusiness;
import pe.edu.coworkers.entities.Comentario;
import pe.edu.coworkers.entities.Foro;

@Named
@SessionScoped
public class ComentarioController implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject 
	private ComentarioBusiness comentarioBusiness;
	
	@Inject
	private ForoBusiness foroBusiness;
	private Comentario comentario;
	
	private List<Comentario> comentarios;
	private Foro foro;
	private List<Foro>foros;
	@PostConstruct
	public void init()
	{
		comentario = new Comentario();
		comentarios=new ArrayList<>();
		foro = new Foro();
		foros= new ArrayList<>();
		listaForos();
	}
	public String registrarComentario() 
	{
		String vista = "";
		try {
			System.out.println("registrarComentario");
			System.out.println(comentario.getId());
			System.out.println(comentario.getDescripcion());
			System.out.println(comentario.getHora());
			System.out.println(comentario.getForo());
			comentario.setForo(foro);
			comentarioBusiness.registrarComentario(comentario);
			this.reiniciarForm();
		} catch (Exception e) {
		
		}
		return vista;
	}
	
	public void listaForos() {
		try {
			this.foros = foroBusiness.listarForos();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String newComentario() {
		try {
			this.foros = foroBusiness.getAllForos();
			this.resetForm();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "comentario.xhtml";
	}
	public void resetForm() {
		comentario = new Comentario();
	}
	public void reiniciarForm() {
		comentario = new Comentario();
	}
	public ComentarioBusiness getComentarioBusiness() {
		return comentarioBusiness;
	}
	public void setComentarioBusiness(ComentarioBusiness comentarioBusiness) {
		this.comentarioBusiness = comentarioBusiness;
	}
	public ForoBusiness getForoBusiness() {
		return foroBusiness;
	}
	public void setForoBusiness(ForoBusiness foroBusiness) {
		this.foroBusiness = foroBusiness;
	}
	public Comentario getComentario() {
		return comentario;
	}
	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
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
}
