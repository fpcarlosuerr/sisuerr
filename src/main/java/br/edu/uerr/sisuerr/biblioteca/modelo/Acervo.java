/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.biblioteca.modelo;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpcarlos
 */
@Dependent
@Entity
@Table(name = "acervo", schema = "scsisbibli")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acervo.findAll", query = "SELECT a FROM Acervo a"),
    @NamedQuery(name = "Acervo.findById", query = "SELECT a FROM Acervo a WHERE a.id = :id"),
    @NamedQuery(name = "Acervo.findByAnoPublicacao", query = "SELECT a FROM Acervo a WHERE a.anoPublicacao = :anoPublicacao"),
    @NamedQuery(name = "Acervo.findByEditora", query = "SELECT a FROM Acervo a WHERE a.editora = :editora"),
    @NamedQuery(name = "Acervo.findByResumo", query = "SELECT a FROM Acervo a WHERE a.resumo = :resumo"),
    @NamedQuery(name = "Acervo.findByEdicao", query = "SELECT a FROM Acervo a WHERE a.edicao = :edicao"),
    @NamedQuery(name = "Acervo.findByVolume", query = "SELECT a FROM Acervo a WHERE a.volume = :volume"),
    @NamedQuery(name = "Acervo.findBySerie", query = "SELECT a FROM Acervo a WHERE a.serie = :serie"),
    @NamedQuery(name = "Acervo.findByNumeroPaginas", query = "SELECT a FROM Acervo a WHERE a.numeroPaginas = :numeroPaginas"),
    @NamedQuery(name = "Acervo.findByNumeroDaChamada", query = "SELECT a FROM Acervo a WHERE a.numeroDaChamada = :numeroDaChamada"),
    @NamedQuery(name = "Acervo.findByQuantidadeExemplar", query = "SELECT a FROM Acervo a WHERE a.quantidadeExemplar = :quantidadeExemplar"),
    @NamedQuery(name = "Acervo.findByTitulo", query = "SELECT a FROM Acervo a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Acervo.findByLocalPublicacao", query = "SELECT a FROM Acervo a WHERE a.localPublicacao = :localPublicacao")})
public class Acervo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 4)
    @Column(name = "ano_publicacao")
    private String anoPublicacao;
    @Size(max = 2147483647)
    @Column(name = "editora")
    private String editora;
    @Size(max = 2147483647)
    @Column(name = "resumo")
    private String resumo;
    @Lob
    @Column(name = "capa")
    private byte[] capa;
    @Size(max = 2147483647)
    @Column(name = "edicao")
    private String edicao;
    @Size(max = 3)
    @Column(name = "volume")
    private String volume;
    @Size(max = 100)
    @Column(name = "serie")
    private String serie;
    @Column(name = "numero_paginas")
    private Integer numeroPaginas;
    @Size(max = 2147483647)
    @Column(name = "numero_da_chamada")
    private String numeroDaChamada;
    @Column(name = "quantidade_exemplar")
    private Integer quantidadeExemplar;
    @Size(max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 2147483647)
    @Column(name = "local_publicacao")
    private String localPublicacao;
    @JoinTable(name = "autor_acervo", joinColumns = {
        @JoinColumn(name = "id_acervo", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_autor", referencedColumnName = "id")})
    @ManyToMany
    private List<Autor> autorList;
    @JoinTable(name = "palavra_chave_acervo", joinColumns = {
        @JoinColumn(name = "id_acervo", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_palavra_chave", referencedColumnName = "id")})
    @ManyToMany
    private List<PalavraChave> palavraChaveList;
    @JoinColumn(name = "id_tipo_acervo", referencedColumnName = "id")
    @ManyToOne
    private TipoAcervo idTipoAcervo;
    @OneToMany(mappedBy = "idAcervo")
    private List<Livro> livroList;

    public Acervo() {
    }

    public Acervo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public byte[] getCapa() {
        return capa;
    }

    public void setCapa(byte[] capa) {
        this.capa = capa;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getNumeroDaChamada() {
        return numeroDaChamada;
    }

    public void setNumeroDaChamada(String numeroDaChamada) {
        this.numeroDaChamada = numeroDaChamada;
    }

    public Integer getQuantidadeExemplar() {
        return quantidadeExemplar;
    }

    public void setQuantidadeExemplar(Integer quantidadeExemplar) {
        this.quantidadeExemplar = quantidadeExemplar;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocalPublicacao() {
        return localPublicacao;
    }

    public void setLocalPublicacao(String localPublicacao) {
        this.localPublicacao = localPublicacao;
    }

    @XmlTransient
    public List<Autor> getAutorList() {
        return autorList;
    }

    public void setAutorList(List<Autor> autorList) {
        this.autorList = autorList;
    }

    @XmlTransient
    public List<PalavraChave> getPalavraChaveList() {
        return palavraChaveList;
    }

    public void setPalavraChaveList(List<PalavraChave> palavraChaveList) {
        this.palavraChaveList = palavraChaveList;
    }

    public TipoAcervo getIdTipoAcervo() {
        return idTipoAcervo;
    }

    public void setIdTipoAcervo(TipoAcervo idTipoAcervo) {
        this.idTipoAcervo = idTipoAcervo;
    }

    @XmlTransient
    public List<Livro> getLivroList() {
        return livroList;
    }

    public void setLivroList(List<Livro> livroList) {
        this.livroList = livroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acervo)) {
            return false;
        }
        Acervo other = (Acervo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sisuerr.biblioteca.modelo.Acervo[ id=" + id + " ]";
    }
    
}
