package org.serenity.manifest

import org.serenity.manifest.ejb.CargoAccess
import org.serenity.persistence.pdo.Cargo
import org.serenity.persistence.service.CargoFacade

import javax.ejb.LocalBean
import javax.ejb.Stateless
import javax.inject.Inject
import javax.persistence.PersistenceException
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Stateless
@LocalBean
@Path('cargo')
class CargoServices {

    @Inject
    CargoAccess cargoAccess

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response findAllCargo() {

        return Response.ok(cargoAccess.findAccessibleCargo()).build()
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path('/{id}')
    Response findCargoById(@PathParam('id') Integer id) {
        Response response
        try {
            Cargo cargo = cargoAccess.findAccessibleCargoById(id)
            response = Response.ok(cargo).build()
        } catch (PersistenceException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build()
        }
        return response
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response addCargo(Cargo cargo) {
        Response response
        try {
            cargoAccess.addCargo(cargo)
            response = Response.created().build()
        } catch (Exception ex) {
            response = Response.serverError().build()
        }
        response
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path('/{id}')
    Response updateCargo(@PathParam('id') Integer id,  Cargo cargo) {
        Response response
        try {
            cargoAccess.updateCargo(cargo)
            response = Response.ok().build()
        } catch (Exception ex) {
            response = Response.serverError().build()
        }
        response
    }

}
