package br.edu.uerr.sisuerr.academico.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
@Table(name = "aluno" ,schema = "scsisacademico")
@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String ano;

	@Column(name="id_pessoa_tipo")
	private Integer idPessoaTipo;

	private String semestre;

	//bi-directional many-to-one association to CursoAluno
	@OneToMany(mappedBy="aluno")
	private List<CursoAluno> cursoAlunos;

	public Aluno() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Integer getIdPessoaTipo() {
		return this.idPessoaTipo;
	}

	public void setIdPessoaTipo(Integer idPessoaTipo) {
		this.idPessoaTipo = idPessoaTipo;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public List<CursoAluno> getCursoAlunos() {
		return this.cursoAlunos;
	}

	public void setCursoAlunos(List<CursoAluno> cursoAlunos) {
		this.cursoAlunos = cursoAlunos;
	}

	public CursoAluno addCursoAluno(CursoAluno cursoAluno) {
		getCursoAlunos().add(cursoAluno);
		cursoAluno.setAluno(this);

		return cursoAluno;
	}

	public CursoAluno removeCursoAluno(CursoAluno cursoAluno) {
		getCursoAlunos().remove(cursoAluno);
		cursoAluno.setAluno(null);

		return cursoAluno;
	}

}