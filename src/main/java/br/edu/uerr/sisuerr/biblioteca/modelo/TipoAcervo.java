package br.edu.uerr.sisuerr.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_acervo database table.
 * 
 */
@Entity
@Table(name = "tipo_acervo", schema = "scsisbibli")
@NamedQuery(name="TipoAcervo.findAll", query="SELECT t FROM TipoAcervo t")
public class TipoAcervo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Acervo
	@OneToMany(mappedBy="tipoAcervo")
	private List<Acervo> acervos;

	public TipoAcervo() {
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

	public List<Acervo> getAcervos() {
		return this.acervos;
	}

	public void setAcervos(List<Acervo> acervos) {
		this.acervos = acervos;
	}

	public Acervo addAcervo(Acervo acervo) {
		getAcervos().add(acervo);
		acervo.setTipoAcervo(this);

		return acervo;
	}

	public Acervo removeAcervo(Acervo acervo) {
		getAcervos().remove(acervo);
		acervo.setTipoAcervo(null);

		return acervo;
	}

}