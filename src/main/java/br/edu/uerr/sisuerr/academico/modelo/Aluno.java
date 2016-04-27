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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpcarlos
 */
@Dependent
@Entity
@Table(name = "aluno", schema = "scsisacademico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findById", query = "SELECT a FROM Aluno a WHERE a.id = :id"),
    @NamedQuery(name = "Aluno.findByIdPessoaTipo", query = "SELECT a FROM Aluno a WHERE a.idPessoaTipo = :idPessoaTipo"),
    @NamedQuery(name = "Aluno.findBySemestre", query = "SELECT a FROM Aluno a WHERE a.semestre = :semestre"),
    @NamedQuery(name = "Aluno.findByAno", query = "SELECT a FROM Aluno a WHERE a.ano = :ano"),
    @NamedQuery(name = "Aluno.findByMatricula", query = "SELECT a FROM Aluno a WHERE a.matricula = :matricula")})
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_pessoa_tipo")
    private Integer idPessoaTipo;
    @Size(max = 2147483647)
    @Column(name = "semestre")
    private String semestre;
    @Size(max = 4)
    @Column(name = "ano")
    private String ano;
    @Size(max = 2147483647)
    @Column(name = "matricula")
    private String matricula;
    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    @ManyToOne
    private Curso idCurso;

    public Aluno() {
    }

    public Aluno(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPessoaTipo() {
        return idPessoaTipo;
    }

    public void setIdPessoaTipo(Integer idPessoaTipo) {
        this.idPessoaTipo = idPessoaTipo;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sisuerr.academico.modelo.Aluno[ id=" + id + " ]";
    }
    
}
