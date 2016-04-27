/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.academico.controle;

import br.edu.uerr.sisuerr.util.AbstractEjb;
import br.edu.uerr.sisuerr.academico.modelo.Professor;
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
public class ProfessorEjb extends AbstractEjb implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Professor entity) throws Exception {
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

    public void remove(Professor entity) throws Exception {
        try {
            Professor aux = entityManager.find(Professor.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public Professor pegaProfessorPeloId(Integer id) throws Exception{
        try {
            Professor aux = entityManager.find(Professor.class, id);
            return aux;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public List<Professor> findAll() throws Exception {
		try {
			List<Professor> lista = new ArrayList<>();
	  		String sql = "select * from scsisacademico.professor";
			lista = executaSqlNativo(sql, Professor.class, entityManager);
			return lista;

		} catch (RuntimeException re) {
			throw new Exception(" Erro" + re.getMessage());
		} catch (Exception e) {
			throw new Exception(" Erro" + e.getMessage());
		}

	}

}
