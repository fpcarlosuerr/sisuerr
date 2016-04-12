package br.edu.uerr.sisuerr.comum.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the servidor database table.
 * 
 */
@Embeddable
public class ServidorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_pessoa")
	private Integer idPessoa;

	@Column(name="id_departamento", insertable=false, updatable=false)
	private Integer idDepartamento;

	public ServidorPK() {
	}
	public Integer getIdPessoa() {
		return this.idPessoa;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	public Integer getIdDepartamento() {
		return this.idDepartamento;
	}
	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ServidorPK)) {
			return false;
		}
		ServidorPK castOther = (ServidorPK)other;
		return 
			this.idPessoa.equals(castOther.idPessoa)
			&& this.idDepartamento.equals(castOther.idDepartamento);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPessoa.hashCode();
		hash = hash * prime + this.idDepartamento.hashCode();
		
		return hash;
	}
}