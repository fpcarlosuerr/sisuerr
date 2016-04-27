/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.biblioteca.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpcarlos
 */
@Dependent
@Entity
@Table(name = "livro", schema = "scsisbibli")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l"),
    @NamedQuery(name = "Livro.findById", query = "SELECT l FROM Livro l WHERE l.id = :id"),
    @NamedQuery(name = "Livro.findByIdDepartamento", query = "SELECT l FROM Livro l WHERE l.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "Livro.findByExemplarNumero", query = "SELECT l FROM Livro l WHERE l.exemplarNumero = :exemplarNumero"),
    @NamedQuery(name = "Livro.findByDataInclusao", query = "SELECT l FROM Livro l WHERE l.dataInclusao = :dataInclusao"),
    @NamedQuery(name = "Livro.findByNomeroDaCahamda", query = "SELECT l FROM Livro l WHERE l.nomeroDaCahamda = :nomeroDaCahamda"),
    @NamedQuery(name = "Livro.findByObservacao", query = "SELECT l FROM Livro l WHERE l.observacao = :observacao"),
    @NamedQuery(name = "Livro.findByNumeroTombamento", query = "SELECT l FROM Livro l WHERE l.numeroTombamento = :numeroTombamento")})
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_departamento")
    private Integer idDepartamento;
    @Column(name = "exemplar_numero")
    private Integer exemplarNumero;
    @Column(name = "data_inclusao")
    @Temporal(TemporalType.DATE)
    private Date dataInclusao;
    @Size(max = 2147483647)
    @Column(name = "nomero_da_cahamda")
    private String nomeroDaCahamda;
    @Size(max = 2147483647)
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "numero_tombamento")
    private Integer numeroTombamento;
    @JoinColumn(name = "id_acervo", referencedColumnName = "id")
    @ManyToOne
    private Acervo idAcervo;
    @JoinColumn(name = "id_situacao_livro", referencedColumnName = "id")
    @ManyToOne
    private SituacaoLivro idSituacaoLivro;
    @OneToMany(mappedBy = "idLivro")
    private List<Movimento> movimentoList;

    public Livro() {
    }

    public Livro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Integer getExemplarNumero() {
        return exemplarNumero;
    }

    public void setExemplarNumero(Integer exemplarNumero) {
        this.exemplarNumero = exemplarNumero;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getNomeroDaCahamda() {
        return nomeroDaCahamda;
    }

    public void setNomeroDaCahamda(String nomeroDaCahamda) {
        this.nomeroDaCahamda = nomeroDaCahamda;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getNumeroTombamento() {
        return numeroTombamento;
    }

    public void setNumeroTombamento(Integer numeroTombamento) {
        this.numeroTombamento = numeroTombamento;
    }

    public Acervo getIdAcervo() {
        return idAcervo;
    }

    public void setIdAcervo(Acervo idAcervo) {
        this.idAcervo = idAcervo;
    }

    public SituacaoLivro getIdSituacaoLivro() {
        return idSituacaoLivro;
    }

    public void setIdSituacaoLivro(SituacaoLivro idSituacaoLivro) {
        this.idSituacaoLivro = idSituacaoLivro;
    }

    @XmlTransient
    public List<Movimento> getMovimentoList() {
        return movimentoList;
    }

    public void setMovimentoList(List<Movimento> movimentoList) {
        this.movimentoList = movimentoList;
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
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sisuerr.biblioteca.modelo.Livro[ id=" + id + " ]";
    }
    
}
