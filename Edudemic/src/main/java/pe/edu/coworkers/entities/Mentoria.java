package pe.edu.coworkers.entities;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="mentorias")
public class Mentoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String enlace;
	private String hInicio;
	private String hFin;
	private Date fecha;
	
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
	public String gethInicio() {
		return hInicio;
	}
	public void sethInicio(String hInicio) {
		this.hInicio = hInicio;
	}
	public String gethFin() {
		return hFin;
	}
	public void sethFin(String hFin) {
		this.hFin = hFin;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
}
