package br.edu.uerr.sisuerr.patrimonio.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@Table(name = "grupo", schema = "scsispat")
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to SubGrupo
	@OneToMany(mappedBy="grupo")
	private List<SubGrupo> subGrupos;

	public Grupo() {
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

	public List<SubGrupo> getSubGrupos() {
		return this.subGrupos;
	}

	public void setSubGrupos(List<SubGrupo> subGrupos) {
		this.subGrupos = subGrupos;
	}

	public SubGrupo addSubGrupo(SubGrupo subGrupo) {
		getSubGrupos().add(subGrupo);
		subGrupo.setGrupo(this);

		return subGrupo;
	}

	public SubGrupo removeSubGrupo(SubGrupo subGrupo) {
		getSubGrupos().remove(subGrupo);
		subGrupo.setGrupo(null);

		return subGrupo;
	}

}