package br.edu.uerr.sisuerr.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the acervo database table.
 * 
 */
@Entity
@Table(name = "acervo", schema = "scsisbibli")
@NamedQuery(name="Acervo.findAll", query="SELECT a FROM Acervo a")
public class Acervo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="ano_publicacao")
	private String anoPublicacao;

	private byte[] capa;

	private String edicao;

	private String editora;

	@Column(name="local_publicacao")
	private String localPublicacao;

	@Column(name="numero_da_chamada")
	private String numeroDaChamada;

	@Column(name="numero_paginas")
	private Integer numeroPaginas;

	@Column(name="quantidade_exemplar")
	private Integer quantidadeExemplar;

	private String resumo;

	private String serie;

	private String titulo;

	private String volume;

	//bi-directional many-to-one association to TipoAcervo
	@ManyToOne
	@JoinColumn(name="id_tipo_acervo")
	private TipoAcervo tipoAcervo;

	//bi-directional many-to-many association to Autor
	@ManyToMany(mappedBy="acervos")
	private List<Autor> autors;

	//bi-directional many-to-one association to Livro
	@OneToMany(mappedBy="acervo")
	private List<Livro> livros;

	//bi-directional many-to-many association to PalavraChave
	@ManyToMany(mappedBy="acervos")
	private List<PalavraChave> palavraChaves;

	public Acervo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnoPublicacao() {
		return this.anoPublicacao;
	}

	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public byte[] getCapa() {
		return this.capa;
	}

	public void setCapa(byte[] capa) {
		this.capa = capa;
	}

	public String getEdicao() {
		return this.edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getEditora() {
		return this.editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getLocalPublicacao() {
		return this.localPublicacao;
	}

	public void setLocalPublicacao(String localPublicacao) {
		this.localPublicacao = localPublicacao;
	}

	public String getNumeroDaChamada() {
		return this.numeroDaChamada;
	}

	public void setNumeroDaChamada(String numeroDaChamada) {
		this.numeroDaChamada = numeroDaChamada;
	}

	public Integer getNumeroPaginas() {
		return this.numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Integer getQuantidadeExemplar() {
		return this.quantidadeExemplar;
	}

	public void setQuantidadeExemplar(Integer quantidadeExemplar) {
		this.quantidadeExemplar = quantidadeExemplar;
	}

	public String getResumo() {
		return this.resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getVolume() {
		return this.volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public TipoAcervo getTipoAcervo() {
		return this.tipoAcervo;
	}

	public void setTipoAcervo(TipoAcervo tipoAcervo) {
		this.tipoAcervo = tipoAcervo;
	}

	public List<Autor> getAutors() {
		return this.autors;
	}

	public void setAutors(List<Autor> autors) {
		this.autors = autors;
	}

	public List<Livro> getLivros() {
		return this.livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Livro addLivro(Livro livro) {
		getLivros().add(livro);
		livro.setAcervo(this);

		return livro;
	}

	public Livro removeLivro(Livro livro) {
		getLivros().remove(livro);
		livro.setAcervo(null);

		return livro;
	}

	public List<PalavraChave> getPalavraChaves() {
		return this.palavraChaves;
	}

	public void setPalavraChaves(List<PalavraChave> palavraChaves) {
		this.palavraChaves = palavraChaves;
	}

}