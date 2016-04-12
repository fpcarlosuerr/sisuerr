package br.edu.uerr.sisuerr.patrimonio.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the situacao database table.
 * 
 */
@Entity
@Table(name = "situacao", schema = "scsispat")
@NamedQuery(name="Situacao.findAll", query="SELECT s FROM Situacao s")
public class Situacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Patrimonio
	@OneToMany(mappedBy="situacao")
	private List<Patrimonio> patrimonios;

	public Situacao() {
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

	public List<Patrimonio> getPatrimonios() {
		return this.patrimonios;
	}

	public void setPatrimonios(List<Patrimonio> patrimonios) {
		this.patrimonios = patrimonios;
	}

	public Patrimonio addPatrimonio(Patrimonio patrimonio) {
		getPatrimonios().add(patrimonio);
		patrimonio.setSituacao(this);

		return patrimonio;
	}

	public Patrimonio removePatrimonio(Patrimonio patrimonio) {
		getPatrimonios().remove(patrimonio);
		patrimonio.setSituacao(null);

		return patrimonio;
	}

}