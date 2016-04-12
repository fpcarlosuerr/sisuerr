package br.edu.uerr.sisuerr.localizacao.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the crachar database table.
 * 
 */
@Entity
@Table(name = "cracha", schema = "scsisloc")
@NamedQuery(name="Crachar.findAll", query="SELECT c FROM Crachar c")
public class Crachar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to VisitantePessoaCracha
	@OneToMany(mappedBy="crachar")
	private List<VisitantePessoaCracha> visitantePessoaCrachas;

	public Crachar() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<VisitantePessoaCracha> getVisitantePessoaCrachas() {
		return this.visitantePessoaCrachas;
	}

	public void setVisitantePessoaCrachas(List<VisitantePessoaCracha> visitantePessoaCrachas) {
		this.visitantePessoaCrachas = visitantePessoaCrachas;
	}

	public VisitantePessoaCracha addVisitantePessoaCracha(VisitantePessoaCracha visitantePessoaCracha) {
		getVisitantePessoaCrachas().add(visitantePessoaCracha);
		visitantePessoaCracha.setCrachar(this);

		return visitantePessoaCracha;
	}

	public VisitantePessoaCracha removeVisitantePessoaCracha(VisitantePessoaCracha visitantePessoaCracha) {
		getVisitantePessoaCrachas().remove(visitantePessoaCracha);
		visitantePessoaCracha.setCrachar(null);

		return visitantePessoaCracha;
	}

}