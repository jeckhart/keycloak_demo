package org.serenity.persistence.service

import javax.ejb.LocalBean
import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import org.serenity.persistence.pdo.Location

import javax.persistence.TypedQuery

@Stateless
@LocalBean
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

    public List<Location> findByAccess(String access) {
        TypedQuery<Location> query = em.createNamedQuery('Location.findByAccess', Location)
        query.setParameter('access', access)
        return query.getResultList()
    }
    
}
