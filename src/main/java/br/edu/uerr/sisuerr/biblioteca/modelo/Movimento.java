/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.biblioteca.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpcarlos
 */
@Dependent
@Entity
@Table(name = "movimento", schema = "scsisbibli")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimento.findAll", query = "SELECT m FROM Movimento m"),
    @NamedQuery(name = "Movimento.findById", query = "SELECT m FROM Movimento m WHERE m.id = :id"),
    @NamedQuery(name = "Movimento.findByDataEmprestimo", query = "SELECT m FROM Movimento m WHERE m.dataEmprestimo = :dataEmprestimo"),
    @NamedQuery(name = "Movimento.findByDataDevolucao", query = "SELECT m FROM Movimento m WHERE m.dataDevolucao = :dataDevolucao"),
    @NamedQuery(name = "Movimento.findByIdPessoaTipo", query = "SELECT m FROM Movimento m WHERE m.idPessoaTipo = :idPessoaTipo")})
public class Movimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_emprestimo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmprestimo;
    @Column(name = "data_devolucao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDevolucao;
    @Column(name = "id_pessoa_tipo")
    private Integer idPessoaTipo;
    @JoinColumn(name = "id_livro", referencedColumnName = "id")
    @ManyToOne
    private Livro idLivro;
    @JoinColumn(name = "id_tipo_movimento", referencedColumnName = "id")
    @ManyToOne
    private TipoMovimento idTipoMovimento;

    public Movimento() {
    }

    public Movimento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Integer getIdPessoaTipo() {
        return idPessoaTipo;
    }

    public void setIdPessoaTipo(Integer idPessoaTipo) {
        this.idPessoaTipo = idPessoaTipo;
    }

    public Livro getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Livro idLivro) {
        this.idLivro = idLivro;
    }

    public TipoMovimento getIdTipoMovimento() {
        return idTipoMovimento;
    }

    public void setIdTipoMovimento(TipoMovimento idTipoMovimento) {
        this.idTipoMovimento = idTipoMovimento;
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
        if (!(object instanceof Movimento)) {
            return false;
        }
        Movimento other = (Movimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sisuerr.biblioteca.modelo.Movimento[ id=" + id + " ]";
    }
    
}
