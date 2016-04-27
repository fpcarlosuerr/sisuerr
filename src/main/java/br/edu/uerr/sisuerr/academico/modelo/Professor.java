/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.academico.modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpcarlos
 */
@Dependent
@Entity
@Table(name = "professor", schema = "scsisacademico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
    @NamedQuery(name = "Professor.findByIdPessoaTipo", query = "SELECT p FROM Professor p WHERE p.idPessoaTipo = :idPessoaTipo"),
    @NamedQuery(name = "Professor.findById", query = "SELECT p FROM Professor p WHERE p.id = :id")})
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "id_pessoa_tipo")
    private Integer idPessoaTipo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    @ManyToOne
    private Curso idCurso;

    public Professor() {
    }

    public Professor(Integer id) {
        this.id = id;
    }

    public Integer getIdPessoaTipo() {
        return idPessoaTipo;
    }

    public void setIdPessoaTipo(Integer idPessoaTipo) {
        this.idPessoaTipo = idPessoaTipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
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
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sisuerr.academico.modelo.Professor[ id=" + id + " ]";
    }
    
}
