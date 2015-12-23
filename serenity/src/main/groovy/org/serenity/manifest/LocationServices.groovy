package org.serenity.manifest

import org.serenity.manifest.ejb.CargoAccess

import javax.ejb.LocalBean
import javax.ejb.Stateless
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Stateless
@LocalBean
@Path('locations')
class LocationServices {

    @Inject
    CargoAccess cargoAccess

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response findAll() {
        return Response.ok(cargoAccess.findAccessibleLocations()).build()
    }

}
