/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.biblioteca.controle;

import br.edu.uerr.sisuerr.biblioteca.modelo.SituacaoLivro;
import br.edu.uerr.sisuerr.comum.controle.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fpcarlos
 */
@Stateless
public class SituacaoLivroEjb extends AbstractEjb implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(SituacaoLivro entity) throws Exception {
        try {
            if (entity.getId() != null && entity.getId() > 0) {
                entityManager.merge(entity);
            } else {
                entityManager.persist(entity);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void remove(SituacaoLivro entity) throws Exception {
        try {
            SituacaoLivro aux = entityManager.find(SituacaoLivro.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public SituacaoLivro pegaSituacaoLivroPeloId(Integer id) throws Exception{
        try {
            SituacaoLivro aux = entityManager.find(SituacaoLivro.class, id);
            return aux;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public List<SituacaoLivro> findAll() throws Exception {
		try {
			List<SituacaoLivro> lista = new ArrayList<>();
	  		String sql = "select * from scsisbibli.situacao_livro";
			lista = executaSqlNativo(sql, SituacaoLivro.class, entityManager);
			return lista;

		} catch (RuntimeException re) {
			throw new Exception(" Erro" + re.getMessage());
		} catch (Exception e) {
			throw new Exception(" Erro" + e.getMessage());
		}

	}

}
