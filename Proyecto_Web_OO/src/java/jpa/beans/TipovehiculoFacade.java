/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entitys.Tipovehiculo;

/**
 *
 * @author Javier
 */
@Stateless
public class TipovehiculoFacade extends AbstractFacade<Tipovehiculo> {
    @PersistenceContext(unitName = "Proyecto_Web_OOPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipovehiculoFacade() {
        super(Tipovehiculo.class);
    }
    
}
