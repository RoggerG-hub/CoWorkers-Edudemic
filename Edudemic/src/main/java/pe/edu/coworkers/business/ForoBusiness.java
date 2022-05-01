package pe.edu.coworkers.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.coworkers.entities.Foro;
import pe.edu.coworkers.repository.ForoRepository;

@Named
public class ForoBusiness implements Serializable{
	private static final long serialVersionUID = 1L;
	@Inject 
	private ForoRepository foroRepository;
	@Transactional
	public Long registrarForo(Foro foro) throws Exception 
	{
		return foroRepository.registrarForo(foro);	
	}
	@Transactional
	public void actualizarForo(Foro foro) throws Exception 
	{
		foroRepository.actualizarForo(foro);
	}
	public List<Foro> listarForos() throws Exception
	{
		return foroRepository.listarForos();
	}
}
