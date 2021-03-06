/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entitys.Arriendo;

/**
 *
 * @author Javier
 */
@Stateless
public class ArriendoFacade extends AbstractFacade<Arriendo> {
    @PersistenceContext(unitName = "Proyecto_Web_OOPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArriendoFacade() {
        super(Arriendo.class);
    }
    
}
