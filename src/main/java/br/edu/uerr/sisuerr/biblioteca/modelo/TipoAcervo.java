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
@Table(name = "tipo_acervo", schema = "scsisbibli")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAcervo.findAll", query = "SELECT t FROM TipoAcervo t"),
    @NamedQuery(name = "TipoAcervo.findById", query = "SELECT t FROM TipoAcervo t WHERE t.id = :id"),
    @NamedQuery(name = "TipoAcervo.findByNome", query = "SELECT t FROM TipoAcervo t WHERE t.nome = :nome")})
public class TipoAcervo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idTipoAcervo")
    private List<Acervo> acervoList;

    public TipoAcervo() {
    }

    public TipoAcervo(Integer id) {
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
    public List<Acervo> getAcervoList() {
        return acervoList;
    }

    public void setAcervoList(List<Acervo> acervoList) {
        this.acervoList = acervoList;
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
        if (!(object instanceof TipoAcervo)) {
            return false;
        }
        TipoAcervo other = (TipoAcervo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sisuerr.biblioteca.modelo.TipoAcervo[ id=" + id + " ]";
    }
    
}
