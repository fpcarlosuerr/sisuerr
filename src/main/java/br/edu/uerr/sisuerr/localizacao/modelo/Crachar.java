/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.localizacao.modelo;

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
@Table(name = "crachar", schema = "scsisloc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Crachar.findAll", query = "SELECT c FROM Crachar c"),
    @NamedQuery(name = "Crachar.findById", query = "SELECT c FROM Crachar c WHERE c.id = :id"),
    @NamedQuery(name = "Crachar.findByNome", query = "SELECT c FROM Crachar c WHERE c.nome = :nome")})
public class Crachar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idCrachar")
    private List<VisitantePessoaCracha> visitantePessoaCrachaList;

    public Crachar() {
    }

    public Crachar(Integer id) {
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
    public List<VisitantePessoaCracha> getVisitantePessoaCrachaList() {
        return visitantePessoaCrachaList;
    }

    public void setVisitantePessoaCrachaList(List<VisitantePessoaCracha> visitantePessoaCrachaList) {
        this.visitantePessoaCrachaList = visitantePessoaCrachaList;
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
        if (!(object instanceof Crachar)) {
            return false;
        }
        Crachar other = (Crachar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sisuerr.localizacao.modelo.Crachar[ id=" + id + " ]";
    }
    
}
