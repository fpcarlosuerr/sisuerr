package br.edu.uerr.sisuerr.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the palavra_chave database table.
 * 
 */
@Entity
@Table(name = "palavra_chave", schema = "scsisbibli")
@NamedQuery(name="PalavraChave.findAll", query="SELECT p FROM PalavraChave p")
public class PalavraChave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nome;

	//bi-directional many-to-many association to Acervo
	@ManyToMany
	@JoinTable(
		name="palavra_chave_acervo"
		, joinColumns={
			@JoinColumn(name="id_palavra_chave")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_acervo")
			}
		)
	private List<Acervo> acervos;

	public PalavraChave() {
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

	public List<Acervo> getAcervos() {
		return this.acervos;
	}

	public void setAcervos(List<Acervo> acervos) {
		this.acervos = acervos;
	}

}