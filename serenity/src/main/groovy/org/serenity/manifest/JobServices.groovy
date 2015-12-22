package org.serenity.manifest

import org.serenity.persistence.service.JobFacade

import javax.ejb.Stateless
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Stateless
@Path('jobs')
class JobServices {

    @Inject
    JobFacade jobFacade

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response findAll() {
        return Response.ok(jobFacade.findAll()).build()
    }
}
