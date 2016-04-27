/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.localizacao.controle;

import br.edu.uerr.sisuerr.comum.controle.*;
import br.edu.uerr.sisuerr.localizacao.modelo.VisitantePessoaCracha;
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
public class VisitantePessoaCrachaEjb extends AbstractEjb implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(VisitantePessoaCracha entity) throws Exception {
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

    public void remove(VisitantePessoaCracha entity) throws Exception {
        try {
            VisitantePessoaCracha aux = entityManager.find(VisitantePessoaCracha.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public VisitantePessoaCracha pegaVisitantePessoaCrachaPeloId(Integer id) throws Exception{
        try {
            VisitantePessoaCracha aux = entityManager.find(VisitantePessoaCracha.class, id);
            return aux;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public List<VisitantePessoaCracha> findAll() throws Exception {
		try {
			List<VisitantePessoaCracha> lista = new ArrayList<>();
	  		String sql = "select * from scsisloc.visitante_pessoa_cracha";
			lista = executaSqlNativo(sql, VisitantePessoaCracha.class, entityManager);
			return lista;

		} catch (RuntimeException re) {
			throw new Exception(" Erro" + re.getMessage());
		} catch (Exception e) {
			throw new Exception(" Erro" + e.getMessage());
		}

	}

}
