package pe.edu.coworkers.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.coworkers.entities.Comentario;
import pe.edu.coworkers.repository.ComentarioRepository;

@Named
public class ComentarioBusiness implements Serializable{
	private static final long serialVersionUID = 1L;
	@Inject 
	private ComentarioRepository comentarioRepository;
	@Transactional
	public Long registrarComentario(Comentario comentario) throws Exception 
	{
		return comentarioRepository.registrarComentario(comentario);	
	}
	@Transactional
	public void actualizarComentario(Comentario comentario) throws Exception 
	{
		comentarioRepository.actualizarComentario(comentario);
	}
	public List<Comentario> listarComentarios() throws Exception
	{
		return comentarioRepository.listarComentarios();
	}
}
