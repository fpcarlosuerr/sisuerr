package br.edu.uerr.sisuerr.patrimonio.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sub_grupo database table.
 * 
 */
@Entity
@Table(name="sub_grupo", schema = "scsispat")
@NamedQuery(name="SubGrupo.findAll", query="SELECT s FROM SubGrupo s")
public class SubGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Material
	@OneToMany(mappedBy="subGrupo")
	private List<Material> materials;

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="id_grupo")
	private Grupo grupo;

	public SubGrupo() {
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

	public List<Material> getMaterials() {
		return this.materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public Material addMaterial(Material material) {
		getMaterials().add(material);
		material.setSubGrupo(this);

		return material;
	}

	public Material removeMaterial(Material material) {
		getMaterials().remove(material);
		material.setSubGrupo(null);

		return material;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}