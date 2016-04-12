package br.edu.uerr.sisuerr.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the movimento database table.
 * 
 */
@Entity
@Table(name = "movimento", schema = "scsisbibli")
@NamedQuery(name="Movimento.findAll", query="SELECT m FROM Movimento m")
public class Movimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="data_devolucao")
	private Timestamp dataDevolucao;

	@Column(name="data_emprestimo")
	private Timestamp dataEmprestimo;

	//bi-directional many-to-one association to Livro
	@ManyToOne
	@JoinColumn(name="id_livro")
	private Livro livro;

	//bi-directional many-to-one association to TipoMovimento
	@ManyToOne
	@JoinColumn(name="id_tipo_movimento")
	private TipoMovimento tipoMovimento;

	public Movimento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDataDevolucao() {
		return this.dataDevolucao;
	}

	public void setDataDevolucao(Timestamp dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Timestamp getDataEmprestimo() {
		return this.dataEmprestimo;
	}

	public void setDataEmprestimo(Timestamp dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Livro getLivro() {
		return this.livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public TipoMovimento getTipoMovimento() {
		return this.tipoMovimento;
	}

	public void setTipoMovimento(TipoMovimento tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

}