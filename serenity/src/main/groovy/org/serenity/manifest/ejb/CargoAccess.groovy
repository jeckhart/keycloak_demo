package org.serenity.manifest.ejb

import org.jboss.ejb3.annotation.SecurityDomain
import org.keycloak.KeycloakPrincipal
import org.serenity.persistence.pdo.Cargo
import org.serenity.persistence.pdo.Job
import org.serenity.persistence.pdo.Location
import org.serenity.persistence.service.CargoFacade
import org.serenity.persistence.service.JobFacade
import org.serenity.persistence.service.LocationFacade

import javax.annotation.Resource
import javax.annotation.security.PermitAll
import javax.annotation.security.RolesAllowed
import javax.ejb.LocalBean
import javax.ejb.SessionContext
import javax.ejb.Stateless
import javax.inject.Inject

@Stateless
@LocalBean
@SecurityDomain("keycloak")
@PermitAll
class CargoAccess {

    @Inject
    CargoFacade cargoFacade

    @Inject
    JobFacade jobFacade

    @Inject
    LocationFacade locationFacade

    @Resource
    SessionContext sessionContext


    public List<Cargo> findAccessibleCargo() {
        KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) sessionContext.getCallerPrincipal();

        List<Cargo> retVal
        if (sessionContext.isCallerInRole('captain')) {
            retVal = cargoFacade.findAll();
        } else {
            retVal = cargoFacade.findCargoByAccess('PUBLIC')
        }
        retVal
    }

    public Cargo findAccessibleCargoById(Integer id) {
        KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) sessionContext.getCallerPrincipal();

        Cargo retVal
        if (sessionContext.isCallerInRole('captain')) {
            retVal = cargoFacade.find(id);
        } else {
            retVal = cargoFacade.findCargoByAccessAndId('PUBLIC', id)
        }
        retVal
    }

    @RolesAllowed(['captain', 'crew'])
    public List<Location> findAccessibleLocations() {
        List<Location> retVal

        if (sessionContext.isCallerInRole('captain')) {
            retVal = locationFacade.findAll()
        } else {
            retVal = locationFacade.findByAccess('PUBLIC')
        }
        retVal
    }

    @RolesAllowed(['captain', 'crew'])
    public List<Job> findJobs() {
        return jobFacade.findAll()
    }

    @RolesAllowed(['captain', 'crew'])
    public void addCargo(Cargo cargo) {
        cargoFacade.create(cargo)
    }

    @RolesAllowed(['captain', 'crew'])
    public void updateCargo(Cargo cargo) {
        cargoFacade.edit(cargo)
    }
}
