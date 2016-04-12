package br.edu.uerr.sisuerr.comum.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@Table(name = "departamento", schema = "sccomum")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String bloco;

	private String email;

	private String nome;

	private String observacao;

	private String responsavel;

	private String telefone;

	//bi-directional many-to-one association to Instituicao
	@ManyToOne
	@JoinColumn(name="id_instituicao")
	private Instituicao instituicao;

	//bi-directional many-to-one association to TipoAmbiente
	@ManyToOne
	@JoinColumn(name="id_tipo_ambiente")
	private TipoAmbiente tipoAmbiente;

	//bi-directional many-to-one association to Servidor
	@OneToMany(mappedBy="departamento")
	private List<Servidor> servidors;

	public Departamento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBloco() {
		return this.bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Instituicao getInstituicao() {
		return this.instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public TipoAmbiente getTipoAmbiente() {
		return this.tipoAmbiente;
	}

	public void setTipoAmbiente(TipoAmbiente tipoAmbiente) {
		this.tipoAmbiente = tipoAmbiente;
	}

	public List<Servidor> getServidors() {
		return this.servidors;
	}

	public void setServidors(List<Servidor> servidors) {
		this.servidors = servidors;
	}

	public Servidor addServidor(Servidor servidor) {
		getServidors().add(servidor);
		servidor.setDepartamento(this);

		return servidor;
	}

	public Servidor removeServidor(Servidor servidor) {
		getServidors().remove(servidor);
		servidor.setDepartamento(null);

		return servidor;
	}

}