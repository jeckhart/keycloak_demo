package org.serenity.persistence.service

import javax.ejb.LocalBean
import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import org.serenity.persistence.pdo.Cargo

import javax.persistence.TypedQuery

@Stateless
@LocalBean
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

    public List<Cargo> findCargoByOwner(String owner) {
        TypedQuery<Cargo> query = em.createNamedQuery('Cargo.findByOwner', Cargo)
        query.setParameter('owner', owner)
        return query.getResultList()
    }


    public List<Cargo> findCargoByAccess(String access) {
        TypedQuery<Cargo> query = em.createNamedQuery('Cargo.findByAccess', Cargo)
        query.setParameter('access', access)
        return query.getResultList()
    }

    public Cargo findCargoByAccessAndId(String access, Integer id) {
        TypedQuery<Cargo> query = em.createNamedQuery('Cargo.findByAccessAndId', Cargo)
        query.setParameter('access', access)
        query.setParameter('id', id)
        return query.getSingleResult()
    }

}
