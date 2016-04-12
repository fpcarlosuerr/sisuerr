package br.edu.uerr.sisuerr.academico.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the professor database table.
 * 
 */
@Entity
@Table(name = "professor",schema = "scsisacademico")
@NamedQuery(name="Professor.findAll", query="SELECT p FROM Professor p")
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProfessorPK id;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="id_curso")
	private Curso curso;

	public Professor() {
	}

	public ProfessorPK getId() {
		return this.id;
	}

	public void setId(ProfessorPK id) {
		this.id = id;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}