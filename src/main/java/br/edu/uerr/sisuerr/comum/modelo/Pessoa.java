package br.edu.uerr.sisuerr.comum.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@Table(name = "pessoa", schema = "sccomum")
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String celular;

	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	private Date dataNascimento;

	private String email;

	private String nome;

	private String rg;

	private String sexo;

	private String telefone;

	//bi-directional many-to-one association to PessoaTipo
	@OneToMany(mappedBy="pessoa")
	private List<PessoaTipo> pessoaTipos;

	public Pessoa() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<PessoaTipo> getPessoaTipos() {
		return this.pessoaTipos;
	}

	public void setPessoaTipos(List<PessoaTipo> pessoaTipos) {
		this.pessoaTipos = pessoaTipos;
	}

	public PessoaTipo addPessoaTipo(PessoaTipo pessoaTipo) {
		getPessoaTipos().add(pessoaTipo);
		pessoaTipo.setPessoa(this);

		return pessoaTipo;
	}

	public PessoaTipo removePessoaTipo(PessoaTipo pessoaTipo) {
		getPessoaTipos().remove(pessoaTipo);
		pessoaTipo.setPessoa(null);

		return pessoaTipo;
	}

}