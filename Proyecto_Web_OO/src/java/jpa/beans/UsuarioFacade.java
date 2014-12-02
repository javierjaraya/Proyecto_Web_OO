/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import jpa.entitys.Usuario;

/**
 *
 * @author Javier
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "Proyecto_Web_OOPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario validar(String rut, String password){
        System.out.println("En el usuario facade ....");
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByRutUsuario",Usuario.class);
        List<Usuario> usuarios = query.getResultList();
        System.out.println("Tamaño lista: "+usuarios.size());
        for (Usuario usuario : usuarios) {
            if(usuario.getPassword().equals(password)){
                return usuario;
            }
        }
        return null;
    }
}
