package br.edu.uerr.sisuerr.comum.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the servidor database table.
 * 
 */
@Entity
@Table(name = "servidor", schema = "sccomum")
@NamedQuery(name="Servidor.findAll", query="SELECT s FROM Servidor s")
public class Servidor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ServidorPK id;

	@Temporal(TemporalType.DATE)
	private Date datainfo;

	private Boolean status;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="id_cargo")
	private Cargo cargo;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="id_departamento")
	private Departamento departamento;

	//bi-directional many-to-one association to PessoaTipo
	@ManyToOne
	@JoinColumn(name="id_pessoa_tipo")
	private PessoaTipo pessoaTipo;

	public Servidor() {
	}

	public ServidorPK getId() {
		return this.id;
	}

	public void setId(ServidorPK id) {
		this.id = id;
	}

	public Date getDatainfo() {
		return this.datainfo;
	}

	public void setDatainfo(Date datainfo) {
		this.datainfo = datainfo;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public PessoaTipo getPessoaTipo() {
		return this.pessoaTipo;
	}

	public void setPessoaTipo(PessoaTipo pessoaTipo) {
		this.pessoaTipo = pessoaTipo;
	}

}