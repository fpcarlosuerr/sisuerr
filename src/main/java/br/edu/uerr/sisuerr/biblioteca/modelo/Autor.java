package br.edu.uerr.sisuerr.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the autor database table.
 * 
 */
@Entity
@Table(name = "autor", schema = "scsisbibli")
@NamedQuery(name="Autor.findAll", query="SELECT a FROM Autor a")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nome;

	//bi-directional many-to-many association to Acervo
	@ManyToMany
	@JoinTable(
		name="autor_acervo"
		, joinColumns={
			@JoinColumn(name="id_autor")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_acervo")
			}
		)
	private List<Acervo> acervos;

	public Autor() {
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