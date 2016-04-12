package br.edu.uerr.sisuerr.academico.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the professor database table.
 * 
 */
@Embeddable
public class ProfessorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_pessoa_tipo", insertable=false, updatable=false)
	private Integer idPessoaTipo;

	@Column(name="id_curso", insertable=false, updatable=false)
	private Integer idCurso;

	public ProfessorPK() {
	}
	public Integer getIdPessoaTipo() {
		return this.idPessoaTipo;
	}
	public void setIdPessoaTipo(Integer idPessoaTipo) {
		this.idPessoaTipo = idPessoaTipo;
	}
	public Integer getIdCurso() {
		return this.idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProfessorPK)) {
			return false;
		}
		ProfessorPK castOther = (ProfessorPK)other;
		return 
			this.idPessoaTipo.equals(castOther.idPessoaTipo)
			&& this.idCurso.equals(castOther.idCurso);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPessoaTipo.hashCode();
		hash = hash * prime + this.idCurso.hashCode();
		
		return hash;
	}
}