package br.edu.uerr.sisuerr.comum.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_pessoa database table.
 * 
 */
@Entity
@Table(name = "tipo_pessoa", schema = "sccomum")
@NamedQuery(name="TipoPessoa.findAll", query="SELECT t FROM TipoPessoa t")
public class TipoPessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to PessoaTipo
	@OneToMany(mappedBy="tipoPessoa")
	private List<PessoaTipo> pessoaTipos;

	public TipoPessoa() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PessoaTipo> getPessoaTipos() {
		return this.pessoaTipos;
	}

	public void setPessoaTipos(List<PessoaTipo> pessoaTipos) {
		this.pessoaTipos = pessoaTipos;
	}

	public PessoaTipo addPessoaTipo(PessoaTipo pessoaTipo) {
		getPessoaTipos().add(pessoaTipo);
		pessoaTipo.setTipoPessoa(this);

		return pessoaTipo;
	}

	public PessoaTipo removePessoaTipo(PessoaTipo pessoaTipo) {
		getPessoaTipos().remove(pessoaTipo);
		pessoaTipo.setTipoPessoa(null);

		return pessoaTipo;
	}

}