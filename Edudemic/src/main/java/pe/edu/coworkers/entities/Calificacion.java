package pe.edu.coworkers.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="calificaciones")
public class Calificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private int actitudProfesor;
    private int nivelEnseñanza;
    private int metodologia;
    private String opinion;
    @OneToOne
	@JoinColumn(name="estudiante_id",nullable=false)
    private Estudiante estudiante;
    @ManyToOne
	@JoinColumn(name="profesor_id",nullable=false)
    private Profesor profesor;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getActitudProfesor() {
		return actitudProfesor;
	}
	public void setActitudProfesor(int actitudProfesor) {
		this.actitudProfesor = actitudProfesor;
	}
	public int getNivelEnseñanza() {
		return nivelEnseñanza;
	}
	public void setNivelEnseñanza(int nivelEnseñanza) {
		this.nivelEnseñanza = nivelEnseñanza;
	}
	public int getMetodologia() {
		return metodologia;
	}
	public void setMetodologia(int metodologia) {
		this.metodologia = metodologia;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
    
}
