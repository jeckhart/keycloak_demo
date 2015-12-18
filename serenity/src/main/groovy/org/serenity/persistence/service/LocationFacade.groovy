package org.serenity.persistence.service

import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import org.serenity.persistence.pdo.Location

@Stateless
public class LocationFacade extends AbstractFacade<Location> {

    @PersistenceContext(unitName = 'serenityDSUnit')
    private EntityManager em

    @Override
    protected EntityManager getEntityManager() {
        return em
    }

    public LocationFacade() {
        super(Location)
    }
    
}
