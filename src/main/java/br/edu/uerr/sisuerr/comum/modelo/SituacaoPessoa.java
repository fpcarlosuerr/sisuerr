/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.comum.modelo;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "situacao_pessoa", schema = "scsiscomum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacaoPessoa.findAll", query = "SELECT s FROM SituacaoPessoa s"),
    @NamedQuery(name = "SituacaoPessoa.findById", query = "SELECT s FROM SituacaoPessoa s WHERE s.id = :id"),
    @NamedQuery(name = "SituacaoPessoa.findByNome", query = "SELECT s FROM SituacaoPessoa s WHERE s.nome = :nome")})
public class SituacaoPessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idSituacaoPessoa")
    private List<PessoaTipo> pessoaTipoList;

    public SituacaoPessoa() {
    }

    public SituacaoPessoa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<PessoaTipo> getPessoaTipoList() {
        return pessoaTipoList;
    }

    public void setPessoaTipoList(List<PessoaTipo> pessoaTipoList) {
        this.pessoaTipoList = pessoaTipoList;
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
        if (!(object instanceof SituacaoPessoa)) {
            return false;
        }
        SituacaoPessoa other = (SituacaoPessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sisuerr.comum.modelo.SituacaoPessoa[ id=" + id + " ]";
    }
    
}
