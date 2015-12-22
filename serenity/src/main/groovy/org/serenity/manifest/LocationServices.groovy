package org.serenity.manifest

import org.serenity.persistence.service.LocationFacade

import javax.ejb.Stateless
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Stateless
@Path('locations')
class LocationServices {

    @Inject
    LocationFacade locationFacade

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response findAll() {
        return Response.ok(locationFacade.findAll()).build()
    }

}