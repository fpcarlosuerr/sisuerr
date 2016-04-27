/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.patrimonio.controle;

import br.edu.uerr.sisuerr.util.AbstractEjb;
import br.edu.uerr.sisuerr.patrimonio.modelo.Situacao;
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
public class SituacaoEjb extends AbstractEjb implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Situacao entity) throws Exception {
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

    public void remove(Situacao entity) throws Exception {
        try {
            Situacao aux = entityManager.find(Situacao.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public Situacao pegaSituacaoPeloId(Integer id) throws Exception{
        try {
            Situacao aux = entityManager.find(Situacao.class, id);
            return aux;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public List<Situacao> findAll() throws Exception {
		try {
			List<Situacao> lista = new ArrayList<>();
	  		String sql = "select * from scsispat.situacao";
			lista = executaSqlNativo(sql, Situacao.class, entityManager);
			return lista;

		} catch (RuntimeException re) {
			throw new Exception(" Erro" + re.getMessage());
		} catch (Exception e) {
			throw new Exception(" Erro" + e.getMessage());
		}

	}

}
