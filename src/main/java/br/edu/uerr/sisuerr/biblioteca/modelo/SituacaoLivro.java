package br.edu.uerr.sisuerr.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the situacao_livro database table.
 * 
 */
@Entity
@Table(name = "situacao_livro", schema = "scsisbibli")
@NamedQuery(name="SituacaoLivro.findAll", query="SELECT s FROM SituacaoLivro s")
public class SituacaoLivro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Livro
	@OneToMany(mappedBy="situacaoLivro")
	private List<Livro> livros;

	public SituacaoLivro() {
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

	public List<Livro> getLivros() {
		return this.livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Livro addLivro(Livro livro) {
		getLivros().add(livro);
		livro.setSituacaoLivro(this);

		return livro;
	}

	public Livro removeLivro(Livro livro) {
		getLivros().remove(livro);
		livro.setSituacaoLivro(null);

		return livro;
	}

}