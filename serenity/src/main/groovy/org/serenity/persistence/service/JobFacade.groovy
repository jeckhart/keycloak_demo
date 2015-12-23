package org.serenity.persistence.service

import javax.ejb.LocalBean
import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import org.serenity.persistence.pdo.Job

@Stateless
@LocalBean
public class JobFacade extends AbstractFacade<Job> {

    @PersistenceContext(unitName = 'serenityDSUnit')
    private EntityManager em

    @Override
    protected EntityManager getEntityManager() {
        return em
    }

    JobFacade() {
        super(Job)
    }
    
}
