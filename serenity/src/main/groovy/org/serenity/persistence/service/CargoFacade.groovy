package org.serenity.persistence.service

import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import org.serenity.persistence.pdo.Cargo

@Stateless
public class CargoFacade extends AbstractFacade<Cargo> {

    @PersistenceContext(unitName = 'serenityDSUnit')
    private EntityManager em

    @Override
    protected EntityManager getEntityManager() {
        return em
    }

    public CargoFacade() {
        super(Cargo)
    }
    
}
