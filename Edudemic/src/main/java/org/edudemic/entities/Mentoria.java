package org.edudemic.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="mentorias")
public class Mentoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String enlace;
	private int hInicio;
	private int hFin;
	private Date fecha;
	@OneToOne
	@JoinColumn(name="estudiante_id")
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
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	public int gethInicio() {
		return hInicio;
	}
	public void sethInicio(int hInicio) {
		this.hInicio = hInicio;
	}
	public int gethFin() {
		return hFin;
	}
	public void sethFin(int hFin) {
		this.hFin = hFin;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
