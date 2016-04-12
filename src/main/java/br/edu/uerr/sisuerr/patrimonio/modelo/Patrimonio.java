package br.edu.uerr.sisuerr.patrimonio.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the patrimonio database table.
 * 
 */
@Entity
@Table(name = "patrimonio", schema = "scsispat")
@NamedQuery(name="Patrimonio.findAll", query="SELECT p FROM Patrimonio p")
public class Patrimonio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_baixa")
	private Date dataBaixa;

	@Temporal(TemporalType.DATE)
	@Column(name="data_incorporacao")
	private Date dataIncorporacao;

	@Column(name="id_departamento")
	private Integer idDepartamento;

	@Column(name="numero_tombamento")
	private Integer numeroTombamento;

	private String observacao;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="id_material")
	private Material material;

	//bi-directional many-to-one association to Situacao
	@ManyToOne
	@JoinColumn(name="id_situacao")
	private Situacao situacao;

	public Patrimonio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataBaixa() {
		return this.dataBaixa;
	}

	public void setDataBaixa(Date dataBaixa) {
		this.dataBaixa = dataBaixa;
	}

	public Date getDataIncorporacao() {
		return this.dataIncorporacao;
	}

	public void setDataIncorporacao(Date dataIncorporacao) {
		this.dataIncorporacao = dataIncorporacao;
	}

	public Integer getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
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

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Situacao getSituacao() {
		return this.situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

}