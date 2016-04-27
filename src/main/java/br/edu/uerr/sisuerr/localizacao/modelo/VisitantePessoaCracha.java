/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.localizacao.modelo;

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
@Table(name = "visitante_pessoa_cracha", schema = "scsisloc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VisitantePessoaCracha.findAll", query = "SELECT v FROM VisitantePessoaCracha v"),
    @NamedQuery(name = "VisitantePessoaCracha.findById", query = "SELECT v FROM VisitantePessoaCracha v WHERE v.id = :id"),
    @NamedQuery(name = "VisitantePessoaCracha.findByIdPessoa", query = "SELECT v FROM VisitantePessoaCracha v WHERE v.idPessoa = :idPessoa"),
    @NamedQuery(name = "VisitantePessoaCracha.findByIdDepartamento", query = "SELECT v FROM VisitantePessoaCracha v WHERE v.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "VisitantePessoaCracha.findByDataHoraEntrada", query = "SELECT v FROM VisitantePessoaCracha v WHERE v.dataHoraEntrada = :dataHoraEntrada"),
    @NamedQuery(name = "VisitantePessoaCracha.findByDataHoraSaida", query = "SELECT v FROM VisitantePessoaCracha v WHERE v.dataHoraSaida = :dataHoraSaida"),
    @NamedQuery(name = "VisitantePessoaCracha.findByObsercavao", query = "SELECT v FROM VisitantePessoaCracha v WHERE v.obsercavao = :obsercavao"),
    @NamedQuery(name = "VisitantePessoaCracha.findByIdPessoaTipo", query = "SELECT v FROM VisitantePessoaCracha v WHERE v.idPessoaTipo = :idPessoaTipo")})
public class VisitantePessoaCracha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_pessoa")
    private Integer idPessoa;
    @Column(name = "id_departamento")
    private Integer idDepartamento;
    @Column(name = "data_hora_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraEntrada;
    @Column(name = "data_hora_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraSaida;
    @Size(max = 2147483647)
    @Column(name = "obsercavao")
    private String obsercavao;
    @Column(name = "id_pessoa_tipo")
    private Integer idPessoaTipo;
    @JoinColumn(name = "id_crachar", referencedColumnName = "id")
    @ManyToOne
    private Crachar idCrachar;

    public VisitantePessoaCracha() {
    }

    public VisitantePessoaCracha(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Date getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(Date dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public Date getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(Date dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public String getObsercavao() {
        return obsercavao;
    }

    public void setObsercavao(String obsercavao) {
        this.obsercavao = obsercavao;
    }

    public Integer getIdPessoaTipo() {
        return idPessoaTipo;
    }

    public void setIdPessoaTipo(Integer idPessoaTipo) {
        this.idPessoaTipo = idPessoaTipo;
    }

    public Crachar getIdCrachar() {
        return idCrachar;
    }

    public void setIdCrachar(Crachar idCrachar) {
        this.idCrachar = idCrachar;
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
        if (!(object instanceof VisitantePessoaCracha)) {
            return false;
        }
        VisitantePessoaCracha other = (VisitantePessoaCracha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sisuerr.localizacao.modelo.VisitantePessoaCracha[ id=" + id + " ]";
    }
    
}
