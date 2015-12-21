package org.serenity.manifest

import org.serenity.persistence.pdo.Cargo
import org.serenity.persistence.service.CargoFacade

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
@Path('cargo')
class CargoServices {

    @Inject
    CargoFacade cargoFacade

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response findAllCargo() {

        return Response.ok(cargoFacade.findAll()).build()
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path('/{id}')
    Response findCargoById(@PathParam('id') Integer id) {
        Response response
        try {
            Cargo cargo = cargoFacade.find(id)
            response = Response.ok(cargo).build()
        } catch (PersistenceException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build()
        }
        return response
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response addCargo(Cargo cargo) {
        null
    }

}
