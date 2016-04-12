package br.edu.uerr.sisuerr.localizacao.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the visitante_pessoa_cracha database table.
 * 
 */
@Embeddable
public class VisitantePessoaCrachaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_pessoa")
	private Integer idPessoa;

	@Column(name="id_crachar", insertable=false, updatable=false)
	private Integer idCrachar;

	public VisitantePessoaCrachaPK() {
	}
	public Integer getIdPessoa() {
		return this.idPessoa;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	public Integer getIdCrachar() {
		return this.idCrachar;
	}
	public void setIdCrachar(Integer idCrachar) {
		this.idCrachar = idCrachar;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VisitantePessoaCrachaPK)) {
			return false;
		}
		VisitantePessoaCrachaPK castOther = (VisitantePessoaCrachaPK)other;
		return 
			this.idPessoa.equals(castOther.idPessoa)
			&& this.idCrachar.equals(castOther.idCrachar);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPessoa.hashCode();
		hash = hash * prime + this.idCrachar.hashCode();
		
		return hash;
	}
}