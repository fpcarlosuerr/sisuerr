package br.edu.uerr.sisuerr.localizacao.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the visitante_pessoa_cracha database table.
 * 
 */
@Entity
@Table(name="visitante_pessoa_cracha", schema = "scsisloc")
@NamedQuery(name="VisitantePessoaCracha.findAll", query="SELECT v FROM VisitantePessoaCracha v")
public class VisitantePessoaCracha implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VisitantePessoaCrachaPK id;

	@Column(name="data_hora_entrada")
	private Timestamp dataHoraEntrada;

	@Column(name="data_hora_saida")
	private Timestamp dataHoraSaida;

	@Column(name="id_departamento")
	private Integer idDepartamento;

	@Column(name="id_pessoa_tipo")
	private Integer idPessoaTipo;

	private String obsercavao;

	//bi-directional many-to-one association to Crachar
	@ManyToOne
	@JoinColumn(name="id_crachar")
	private Crachar crachar;

	public VisitantePessoaCracha() {
	}

	public VisitantePessoaCrachaPK getId() {
		return this.id;
	}

	public void setId(VisitantePessoaCrachaPK id) {
		this.id = id;
	}

	public Timestamp getDataHoraEntrada() {
		return this.dataHoraEntrada;
	}

	public void setDataHoraEntrada(Timestamp dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public Timestamp getDataHoraSaida() {
		return this.dataHoraSaida;
	}

	public void setDataHoraSaida(Timestamp dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}

	public Integer getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Integer getIdPessoaTipo() {
		return this.idPessoaTipo;
	}

	public void setIdPessoaTipo(Integer idPessoaTipo) {
		this.idPessoaTipo = idPessoaTipo;
	}

	public String getObsercavao() {
		return this.obsercavao;
	}

	public void setObsercavao(String obsercavao) {
		this.obsercavao = obsercavao;
	}

	public Crachar getCrachar() {
		return this.crachar;
	}

	public void setCrachar(Crachar crachar) {
		this.crachar = crachar;
	}

}