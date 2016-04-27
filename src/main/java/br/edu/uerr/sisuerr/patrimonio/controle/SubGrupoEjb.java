/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.patrimonio.controle;

import br.edu.uerr.sisuerr.comum.controle.*;
import br.edu.uerr.sisuerr.patrimonio.modelo.SubGrupo;
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
public class SubGrupoEjb extends AbstractEjb implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(SubGrupo entity) throws Exception {
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

    public void remove(SubGrupo entity) throws Exception {
        try {
            SubGrupo aux = entityManager.find(SubGrupo.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public SubGrupo pegaSubGrupoPeloId(Integer id) throws Exception{
        try {
            SubGrupo aux = entityManager.find(SubGrupo.class, id);
            return aux;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public List<SubGrupo> findAll() throws Exception {
		try {
			List<SubGrupo> lista = new ArrayList<>();
	  		String sql = "select * from scsispat.sub_grupo";
			lista = executaSqlNativo(sql, SubGrupo.class, entityManager);
			return lista;

		} catch (RuntimeException re) {
			throw new Exception(" Erro" + re.getMessage());
		} catch (Exception e) {
			throw new Exception(" Erro" + e.getMessage());
		}

	}

}
