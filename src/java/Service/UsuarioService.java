/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usuarioService")
@Transactional
public class UsuarioService {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this. entityManager = entityManager;
    }
    
    public Usuario getByName(String usuario){
        Query query = entityManager.createQuery("FROM usuario r WHERE r.usuario ='"+usuario+"'");
        return (Usuario) query.getSingleResult();
    }
    
    public void add(Usuario usuario){
        entityManager.persist(usuario);
    }
}
