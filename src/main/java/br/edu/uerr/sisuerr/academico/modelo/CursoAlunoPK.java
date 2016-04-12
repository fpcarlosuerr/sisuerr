package br.edu.uerr.sisuerr.academico.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the curso_aluno database table.
 * 
 */
@Embeddable
public class CursoAlunoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_curso", insertable=false, updatable=false)
	private Integer idCurso;

	@Column(name="id_aluno", insertable=false, updatable=false)
	private Integer idAluno;

	public CursoAlunoPK() {
	}
	public Integer getIdCurso() {
		return this.idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public Integer getIdAluno() {
		return this.idAluno;
	}
	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CursoAlunoPK)) {
			return false;
		}
		CursoAlunoPK castOther = (CursoAlunoPK)other;
		return 
			this.idCurso.equals(castOther.idCurso)
			&& this.idAluno.equals(castOther.idAluno);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCurso.hashCode();
		hash = hash * prime + this.idAluno.hashCode();
		
		return hash;
	}
}