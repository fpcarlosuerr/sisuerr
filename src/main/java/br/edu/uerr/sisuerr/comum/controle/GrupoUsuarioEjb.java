/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sisuerr.comum.controle;

import br.edu.uerr.sisuerr.comum.modelo.GrupoUsuario;
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
public class GrupoUsuarioEjb extends AbstractEjb {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(GrupoUsuario entity) throws Exception {
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

    public void remove(GrupoUsuario entity) throws Exception {
        try {
            GrupoUsuario aux = entityManager.find(GrupoUsuario.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public GrupoUsuario pegaGrupoUsuarioPeloId(Integer id) throws Exception{
        try {
            GrupoUsuario aux = entityManager.find(GrupoUsuario.class, id);
            return aux;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public List<GrupoUsuario> findAll() throws Exception {
		try {
			List<GrupoUsuario> lista = new ArrayList<>();
	  		String sql = "select * from scsiscomum.grupo_usuario";
			lista = executaSqlNativo(sql, GrupoUsuario.class, entityManager);
			return lista;

		} catch (RuntimeException re) {
			throw new Exception(" Erro" + re.getMessage());
		} catch (Exception e) {
			throw new Exception(" Erro" + e.getMessage());
		}

	}

}
