/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.patrimonio.modelo;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpcarlos
 */
@Dependent
@Entity
@Table(name = "material", schema = "scsispat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findById", query = "SELECT m FROM Material m WHERE m.id = :id"),
    @NamedQuery(name = "Material.findByNome", query = "SELECT m FROM Material m WHERE m.nome = :nome"),
    @NamedQuery(name = "Material.findByQuantidade", query = "SELECT m FROM Material m WHERE m.quantidade = :quantidade"),
    @NamedQuery(name = "Material.findByValorUnidadeCompra", query = "SELECT m FROM Material m WHERE m.valorUnidadeCompra = :valorUnidadeCompra"),
    @NamedQuery(name = "Material.findByDataCompra", query = "SELECT m FROM Material m WHERE m.dataCompra = :dataCompra"),
    @NamedQuery(name = "Material.findByNotaFiscal", query = "SELECT m FROM Material m WHERE m.notaFiscal = :notaFiscal"),
    @NamedQuery(name = "Material.findByValorTotalNotaFiscal", query = "SELECT m FROM Material m WHERE m.valorTotalNotaFiscal = :valorTotalNotaFiscal"),
    @NamedQuery(name = "Material.findByUnidade", query = "SELECT m FROM Material m WHERE m.unidade = :unidade"),
    @NamedQuery(name = "Material.findByObservacao", query = "SELECT m FROM Material m WHERE m.observacao = :observacao"),
    @NamedQuery(name = "Material.findByIdInstituicao", query = "SELECT m FROM Material m WHERE m.idInstituicao = :idInstituicao")})
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_unidade_compra")
    private Double valorUnidadeCompra;
    @Column(name = "data_compra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @Size(max = 2147483647)
    @Column(name = "nota_fiscal")
    private String notaFiscal;
    @Column(name = "valor_total_nota_fiscal")
    private Double valorTotalNotaFiscal;
    @Size(max = 10)
    @Column(name = "unidade")
    private String unidade;
    @Size(max = 2147483647)
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "id_instituicao")
    private Integer idInstituicao;
    @JoinColumn(name = "id_sub_grupo", referencedColumnName = "id")
    @ManyToOne
    private SubGrupo idSubGrupo;
    @OneToMany(mappedBy = "idMaterial")
    private List<Patrimonio> patrimonioList;

    public Material() {
    }

    public Material(Integer id) {
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnidadeCompra() {
        return valorUnidadeCompra;
    }

    public void setValorUnidadeCompra(Double valorUnidadeCompra) {
        this.valorUnidadeCompra = valorUnidadeCompra;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Double getValorTotalNotaFiscal() {
        return valorTotalNotaFiscal;
    }

    public void setValorTotalNotaFiscal(Double valorTotalNotaFiscal) {
        this.valorTotalNotaFiscal = valorTotalNotaFiscal;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(Integer idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public SubGrupo getIdSubGrupo() {
        return idSubGrupo;
    }

    public void setIdSubGrupo(SubGrupo idSubGrupo) {
        this.idSubGrupo = idSubGrupo;
    }

    @XmlTransient
    public List<Patrimonio> getPatrimonioList() {
        return patrimonioList;
    }

    public void setPatrimonioList(List<Patrimonio> patrimonioList) {
        this.patrimonioList = patrimonioList;
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
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sisuerr.patrimonio.modelo.Material[ id=" + id + " ]";
    }
    
}
