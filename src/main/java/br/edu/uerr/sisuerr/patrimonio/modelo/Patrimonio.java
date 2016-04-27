/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.patrimonio.modelo;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpcarlos
 */
@Dependent
@Entity
@Table(name = "patrimonio", schema = "scsispat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patrimonio.findAll", query = "SELECT p FROM Patrimonio p"),
    @NamedQuery(name = "Patrimonio.findById", query = "SELECT p FROM Patrimonio p WHERE p.id = :id"),
    @NamedQuery(name = "Patrimonio.findByNumeroTombamento", query = "SELECT p FROM Patrimonio p WHERE p.numeroTombamento = :numeroTombamento"),
    @NamedQuery(name = "Patrimonio.findByDataIncorporacao", query = "SELECT p FROM Patrimonio p WHERE p.dataIncorporacao = :dataIncorporacao"),
    @NamedQuery(name = "Patrimonio.findByDataBaixa", query = "SELECT p FROM Patrimonio p WHERE p.dataBaixa = :dataBaixa"),
    @NamedQuery(name = "Patrimonio.findByIdDepartamento", query = "SELECT p FROM Patrimonio p WHERE p.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "Patrimonio.findByObservacao", query = "SELECT p FROM Patrimonio p WHERE p.observacao = :observacao")})
public class Patrimonio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero_tombamento")
    private Integer numeroTombamento;
    @Column(name = "data_incorporacao")
    @Temporal(TemporalType.DATE)
    private Date dataIncorporacao;
    @Column(name = "data_baixa")
    @Temporal(TemporalType.DATE)
    private Date dataBaixa;
    @Column(name = "id_departamento")
    private Integer idDepartamento;
    @Size(max = 2147483647)
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "id_material", referencedColumnName = "id")
    @ManyToOne
    private Material idMaterial;
    @JoinColumn(name = "id_situacao", referencedColumnName = "id")
    @ManyToOne
    private Situacao idSituacao;

    public Patrimonio() {
    }

    public Patrimonio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroTombamento() {
        return numeroTombamento;
    }

    public void setNumeroTombamento(Integer numeroTombamento) {
        this.numeroTombamento = numeroTombamento;
    }

    public Date getDataIncorporacao() {
        return dataIncorporacao;
    }

    public void setDataIncorporacao(Date dataIncorporacao) {
        this.dataIncorporacao = dataIncorporacao;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Material getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Material idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Situacao getIdSituacao() {
        return idSituacao;
    }

    public void setIdSituacao(Situacao idSituacao) {
        this.idSituacao = idSituacao;
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
        if (!(object instanceof Patrimonio)) {
            return false;
        }
        Patrimonio other = (Patrimonio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sisuerr.patrimonio.modelo.Patrimonio[ id=" + id + " ]";
    }
    
}
