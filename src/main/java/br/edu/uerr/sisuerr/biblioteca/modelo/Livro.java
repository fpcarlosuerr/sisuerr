package br.edu.uerr.sisuerr.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the livro database table.
 * 
 */
@Entity
@Table(name = "livro", schema = "scsisbibli")
@NamedQuery(name="Livro.findAll", query="SELECT l FROM Livro l")
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inclusao")
	private Date dataInclusao;

	@Column(name="exemplar_numero")
	private Integer exemplarNumero;

	@Column(name="id_departamento")
	private Integer idDepartamento;

	@Column(name="nomero_da_cahamda")
	private String nomeroDaCahamda;

	@Column(name="numero_tombamento")
	private Integer numeroTombamento;

	private String observacao;

	//bi-directional many-to-one association to Acervo
	@ManyToOne
	@JoinColumn(name="id_acervo")
	private Acervo acervo;

	//bi-directional many-to-one association to SituacaoLivro
	@ManyToOne
	@JoinColumn(name="id_situacao_livro")
	private SituacaoLivro situacaoLivro;

	//bi-directional many-to-one association to Movimento
	@OneToMany(mappedBy="livro")
	private List<Movimento> movimentos;

	public Livro() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInclusao() {
		return this.dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Integer getExemplarNumero() {
		return this.exemplarNumero;
	}

	public void setExemplarNumero(Integer exemplarNumero) {
		this.exemplarNumero = exemplarNumero;
	}

	public Integer getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNomeroDaCahamda() {
		return this.nomeroDaCahamda;
	}

	public void setNomeroDaCahamda(String nomeroDaCahamda) {
		this.nomeroDaCahamda = nomeroDaCahamda;
	}

	public Integer getNumeroTombamento() {
		return this.numeroTombamento;
	}

	public void setNumeroTombamento(Integer numeroTombamento) {
		this.numeroTombamento = numeroTombamento;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Acervo getAcervo() {
		return this.acervo;
	}

	public void setAcervo(Acervo acervo) {
		this.acervo = acervo;
	}

	public SituacaoLivro getSituacaoLivro() {
		return this.situacaoLivro;
	}

	public void setSituacaoLivro(SituacaoLivro situacaoLivro) {
		this.situacaoLivro = situacaoLivro;
	}

	public List<Movimento> getMovimentos() {
		return this.movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}

	public Movimento addMovimento(Movimento movimento) {
		getMovimentos().add(movimento);
		movimento.setLivro(this);

		return movimento;
	}

	public Movimento removeMovimento(Movimento movimento) {
		getMovimentos().remove(movimento);
		movimento.setLivro(null);

		return movimento;
	}

}