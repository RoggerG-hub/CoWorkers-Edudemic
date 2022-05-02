package pe.edu.coworkers.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.coworkers.entities.Mentoria;
import pe.edu.coworkers.repository.MentoriaRepository;


@Named
public class MentoriaBusiness implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MentoriaRepository mentoriaRepository;
	
	@Transactional
	public Long registrarMentoria(Mentoria mentoria) throws Exception {
		return mentoriaRepository.registrarMentoria(mentoria);
	}
	public List<Mentoria> listarMentoria() throws Exception {
		return mentoriaRepository.listarMentorias();
	}
	
}
