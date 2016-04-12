package br.edu.uerr.sisuerr.academico.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import br.edu.uerr.sisuerr.academico.modelo.Professor;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@Table(name = "curso",schema = "scsisacademico")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nome;

	//bi-directional many-to-one association to CursoAluno
	@OneToMany(mappedBy="curso")
	private List<CursoAluno> cursoAlunos;

	//bi-directional many-to-one association to Professor
	@OneToMany(mappedBy="curso")
	private List<Professor> professors;

	public Curso() {
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

	public List<CursoAluno> getCursoAlunos() {
		return this.cursoAlunos;
	}

	public void setCursoAlunos(List<CursoAluno> cursoAlunos) {
		this.cursoAlunos = cursoAlunos;
	}

	public CursoAluno addCursoAluno(CursoAluno cursoAluno) {
		getCursoAlunos().add(cursoAluno);
		cursoAluno.setCurso(this);

		return cursoAluno;
	}

	public CursoAluno removeCursoAluno(CursoAluno cursoAluno) {
		getCursoAlunos().remove(cursoAluno);
		cursoAluno.setCurso(null);

		return cursoAluno;
	}

	public List<Professor> getProfessors() {
		return this.professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public Professor addProfessor(Professor professor) {
		getProfessors().add(professor);
		professor.setCurso(this);

		return professor;
	}

	public Professor removeProfessor(Professor professor) {
		getProfessors().remove(professor);
		professor.setCurso(null);

		return professor;
	}

}