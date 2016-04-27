/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.comum.modelo;

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
@Table(name = "servidor", schema = "scsiscomum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servidor.findAll", query = "SELECT s FROM Servidor s"),
    @NamedQuery(name = "Servidor.findById", query = "SELECT s FROM Servidor s WHERE s.id = :id"),
    @NamedQuery(name = "Servidor.findByDatainfo", query = "SELECT s FROM Servidor s WHERE s.datainfo = :datainfo"),
    @NamedQuery(name = "Servidor.findByStatus", query = "SELECT s FROM Servidor s WHERE s.status = :status")})
public class Servidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datainfo")
    @Temporal(TemporalType.DATE)
    private Date datainfo;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id")
    @ManyToOne
    private Cargo idCargo;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    @ManyToOne
    private Categoria idCategoria;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id")
    @ManyToOne
    private Departamento idDepartamento;
    @JoinColumn(name = "id_pessoa_tipo", referencedColumnName = "id")
    @ManyToOne
    private PessoaTipo idPessoaTipo;

    public Servidor() {
    }

    public Servidor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatainfo() {
        return datainfo;
    }

    public void setDatainfo(Date datainfo) {
        this.datainfo = datainfo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public PessoaTipo getIdPessoaTipo() {
        return idPessoaTipo;
    }

    public void setIdPessoaTipo(PessoaTipo idPessoaTipo) {
        this.idPessoaTipo = idPessoaTipo;
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
        if (!(object instanceof Servidor)) {
            return false;
        }
        Servidor other = (Servidor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sisuerr.comum.modelo.Servidor[ id=" + id + " ]";
    }
    
}
