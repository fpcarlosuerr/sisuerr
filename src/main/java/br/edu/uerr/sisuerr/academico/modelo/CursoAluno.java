package br.edu.uerr.sisuerr.academico.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the curso_aluno database table.
 * 
 */
@Entity
@Table(name="curso_aluno", schema = "scsisacademico")
@NamedQuery(name="CursoAluno.findAll", query="SELECT c FROM CursoAluno c")
public class CursoAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CursoAlunoPK id;

	private String ano;

	@Temporal(TemporalType.DATE)
	@Column(name="data_desligamento_curso")
	private Date dataDesligamentoCurso;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inicio_curso")
	private Date dataInicioCurso;

	private String matricula;

	private String semestre;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="id_aluno")
	private Aluno aluno;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="id_curso")
	private Curso curso;

	public CursoAluno() {
	}

	public CursoAlunoPK getId() {
		return this.id;
	}

	public void setId(CursoAlunoPK id) {
		this.id = id;
	}

	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Date getDataDesligamentoCurso() {
		return this.dataDesligamentoCurso;
	}

	public void setDataDesligamentoCurso(Date dataDesligamentoCurso) {
		this.dataDesligamentoCurso = dataDesligamentoCurso;
	}

	public Date getDataInicioCurso() {
		return this.dataInicioCurso;
	}

	public void setDataInicioCurso(Date dataInicioCurso) {
		this.dataInicioCurso = dataInicioCurso;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}