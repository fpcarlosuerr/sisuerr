package br.edu.uerr.sisuerr.comum.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
@Table(name = "cargo", schema = "sccomum")
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Integer nome;

	//bi-directional many-to-one association to Servidor
	@OneToMany(mappedBy="cargo")
	private List<Servidor> servidors;

	public Cargo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNome() {
		return this.nome;
	}

	public void setNome(Integer nome) {
		this.nome = nome;
	}

	public List<Servidor> getServidors() {
		return this.servidors;
	}

	public void setServidors(List<Servidor> servidors) {
		this.servidors = servidors;
	}

	public Servidor addServidor(Servidor servidor) {
		getServidors().add(servidor);
		servidor.setCargo(this);

		return servidor;
	}

	public Servidor removeServidor(Servidor servidor) {
		getServidors().remove(servidor);
		servidor.setCargo(null);

		return servidor;
	}

}