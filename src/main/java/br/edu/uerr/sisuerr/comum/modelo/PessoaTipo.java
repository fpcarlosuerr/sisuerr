package br.edu.uerr.sisuerr.comum.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pessoa_tipo database table.
 * 
 */
@Entity
@Table(name = "pessoa_tipo", schema = "sccomum")
@NamedQuery(name="PessoaTipo.findAll", query="SELECT p FROM PessoaTipo p")
public class PessoaTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_fim_tipo")
	private Date dataFimTipo;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inicio_tipo")
	private Date dataInicioTipo;

	private Integer matricula;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	//bi-directional many-to-one association to SituacaoPessoa
	@ManyToOne
	@JoinColumn(name="id_situacao_pessoa")
	private SituacaoPessoa situacaoPessoa;

	//bi-directional many-to-one association to TipoPessoa
	@ManyToOne
	@JoinColumn(name="id_tipo_pessoa")
	private TipoPessoa tipoPessoa;

	//bi-directional many-to-one association to Servidor
	@OneToMany(mappedBy="pessoaTipo")
	private List<Servidor> servidors;

	public PessoaTipo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataFimTipo() {
		return this.dataFimTipo;
	}

	public void setDataFimTipo(Date dataFimTipo) {
		this.dataFimTipo = dataFimTipo;
	}

	public Date getDataInicioTipo() {
		return this.dataInicioTipo;
	}

	public void setDataInicioTipo(Date dataInicioTipo) {
		this.dataInicioTipo = dataInicioTipo;
	}

	public Integer getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public SituacaoPessoa getSituacaoPessoa() {
		return this.situacaoPessoa;
	}

	public void setSituacaoPessoa(SituacaoPessoa situacaoPessoa) {
		this.situacaoPessoa = situacaoPessoa;
	}

	public TipoPessoa getTipoPessoa() {
		return this.tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public List<Servidor> getServidors() {
		return this.servidors;
	}

	public void setServidors(List<Servidor> servidors) {
		this.servidors = servidors;
	}

	public Servidor addServidor(Servidor servidor) {
		getServidors().add(servidor);
		servidor.setPessoaTipo(this);

		return servidor;
	}

	public Servidor removeServidor(Servidor servidor) {
		getServidors().remove(servidor);
		servidor.setPessoaTipo(null);

		return servidor;
	}

}