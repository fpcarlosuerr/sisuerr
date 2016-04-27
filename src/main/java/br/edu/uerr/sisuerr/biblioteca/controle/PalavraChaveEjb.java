/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.biblioteca.controle;

import br.edu.uerr.sisuerr.biblioteca.modelo.PalavraChave;
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
public class PalavraChaveEjb extends AbstractEjb implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(PalavraChave entity) throws Exception {
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

    public void remove(PalavraChave entity) throws Exception {
        try {
            PalavraChave aux = entityManager.find(PalavraChave.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public PalavraChave pegaPalavraChavePeloId(Integer id) throws Exception{
        try {
            PalavraChave aux = entityManager.find(PalavraChave.class, id);
            return aux;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public List<PalavraChave> findAll() throws Exception {
		try {
			List<PalavraChave> lista = new ArrayList<>();
	  		String sql = "select * from scsisbibli.palavra_chave";
			lista = executaSqlNativo(sql, PalavraChave.class, entityManager);
			return lista;

		} catch (RuntimeException re) {
			throw new Exception(" Erro" + re.getMessage());
		} catch (Exception e) {
			throw new Exception(" Erro" + e.getMessage());
		}

	}

}
