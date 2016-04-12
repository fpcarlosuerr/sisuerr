package br.edu.uerr.sisuerr.patrimonio.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the material database table.
 * 
 */
@Entity
@Table(name = "material", schema = "scsispat")
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_compra")
	private Date dataCompra;

	@Column(name="id_instituicao")
	private Integer idInstituicao;

	private String nome;

	@Column(name="nota_fiscal")
	private String notaFiscal;

	private String observacao;

	private Integer quantidade;

	private String unidade;

	@Column(name="valor_total_nota_fiscal")
	private double valorTotalNotaFiscal;

	@Column(name="valor_unidade_compra")
	private double valorUnidadeCompra;

	//bi-directional many-to-one association to SubGrupo
	@ManyToOne
	@JoinColumn(name="id_sub_grupo")
	private SubGrupo subGrupo;

	//bi-directional many-to-one association to Patrimonio
	@OneToMany(mappedBy="material")
	private List<Patrimonio> patrimonios;

	public Material() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCompra() {
		return this.dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Integer getIdInstituicao() {
		return this.idInstituicao;
	}

	public void setIdInstituicao(Integer idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNotaFiscal() {
		return this.notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return this.unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public double getValorTotalNotaFiscal() {
		return this.valorTotalNotaFiscal;
	}

	public void setValorTotalNotaFiscal(double valorTotalNotaFiscal) {
		this.valorTotalNotaFiscal = valorTotalNotaFiscal;
	}

	public double getValorUnidadeCompra() {
		return this.valorUnidadeCompra;
	}

	public void setValorUnidadeCompra(double valorUnidadeCompra) {
		this.valorUnidadeCompra = valorUnidadeCompra;
	}

	public SubGrupo getSubGrupo() {
		return this.subGrupo;
	}

	public void setSubGrupo(SubGrupo subGrupo) {
		this.subGrupo = subGrupo;
	}

	public List<Patrimonio> getPatrimonios() {
		return this.patrimonios;
	}

	public void setPatrimonios(List<Patrimonio> patrimonios) {
		this.patrimonios = patrimonios;
	}

	public Patrimonio addPatrimonio(Patrimonio patrimonio) {
		getPatrimonios().add(patrimonio);
		patrimonio.setMaterial(this);

		return patrimonio;
	}

	public Patrimonio removePatrimonio(Patrimonio patrimonio) {
		getPatrimonios().remove(patrimonio);
		patrimonio.setMaterial(null);

		return patrimonio;
	}

}