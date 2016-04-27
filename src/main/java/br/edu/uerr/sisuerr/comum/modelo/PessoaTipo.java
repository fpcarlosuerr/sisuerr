/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.comum.modelo;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpcarlos
 */
@Dependent
@Entity
@Table(name = "pessoa_tipo", schema = "scsiscomum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaTipo.findAll", query = "SELECT p FROM PessoaTipo p"),
    @NamedQuery(name = "PessoaTipo.findById", query = "SELECT p FROM PessoaTipo p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaTipo.findByMatricula", query = "SELECT p FROM PessoaTipo p WHERE p.matricula = :matricula"),
    @NamedQuery(name = "PessoaTipo.findByDataInicioTipo", query = "SELECT p FROM PessoaTipo p WHERE p.dataInicioTipo = :dataInicioTipo"),
    @NamedQuery(name = "PessoaTipo.findByDataFimTipo", query = "SELECT p FROM PessoaTipo p WHERE p.dataFimTipo = :dataFimTipo")})
public class PessoaTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "matricula")
    private Integer matricula;
    @Column(name = "data_inicio_tipo")
    @Temporal(TemporalType.DATE)
    private Date dataInicioTipo;
    @Column(name = "data_fim_tipo")
    @Temporal(TemporalType.DATE)
    private Date dataFimTipo;
    @OneToMany(mappedBy = "idPessoaTipo")
    private List<Servidor> servidorList;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    @ManyToOne
    private Pessoa idPessoa;
    @JoinColumn(name = "id_situacao_pessoa", referencedColumnName = "id")
    @ManyToOne
    private SituacaoPessoa idSituacaoPessoa;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id")
    @ManyToOne
    private Tipo idTipo;

    public PessoaTipo() {
    }

    public PessoaTipo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Date getDataInicioTipo() {
        return dataInicioTipo;
    }

    public void setDataInicioTipo(Date dataInicioTipo) {
        this.dataInicioTipo = dataInicioTipo;
    }

    public Date getDataFimTipo() {
        return dataFimTipo;
    }

    public void setDataFimTipo(Date dataFimTipo) {
        this.dataFimTipo = dataFimTipo;
    }

    @XmlTransient
    public List<Servidor> getServidorList() {
        return servidorList;
    }

    public void setServidorList(List<Servidor> servidorList) {
        this.servidorList = servidorList;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    public SituacaoPessoa getIdSituacaoPessoa() {
        return idSituacaoPessoa;
    }

    public void setIdSituacaoPessoa(SituacaoPessoa idSituacaoPessoa) {
        this.idSituacaoPessoa = idSituacaoPessoa;
    }

    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        this.idTipo = idTipo;
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
        if (!(object instanceof PessoaTipo)) {
            return false;
        }
        PessoaTipo other = (PessoaTipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sisuerr.comum.modelo.PessoaTipo[ id=" + id + " ]";
    }
    
}
