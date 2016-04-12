package br.edu.uerr.sisuerr.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_movimento database table.
 * 
 */
@Entity
@Table(name = "tipo_movimento", schema = "scsisbibli")
@NamedQuery(name="TipoMovimento.findAll", query="SELECT t FROM TipoMovimento t")
public class TipoMovimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Movimento
	@OneToMany(mappedBy="tipoMovimento")
	private List<Movimento> movimentos;

	public TipoMovimento() {
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

	public List<Movimento> getMovimentos() {
		return this.movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}

	public Movimento addMovimento(Movimento movimento) {
		getMovimentos().add(movimento);
		movimento.setTipoMovimento(this);

		return movimento;
	}

	public Movimento removeMovimento(Movimento movimento) {
		getMovimentos().remove(movimento);
		movimento.setTipoMovimento(null);

		return movimento;
	}

}