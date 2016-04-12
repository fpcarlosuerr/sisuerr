package br.edu.uerr.sisuerr.comum.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupo_usuario database table.
 * 
 */
@Entity
@Table(name = "grupo_usuario", schema = "sccomum")
@NamedQuery(name="GrupoUsuario.findAll", query="SELECT g FROM GrupoUsuario g")
public class GrupoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="grupoUsuario")
	private List<Usuario> usuarios;

	public GrupoUsuario() {
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

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setGrupoUsuario(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setGrupoUsuario(null);

		return usuario;
	}

}