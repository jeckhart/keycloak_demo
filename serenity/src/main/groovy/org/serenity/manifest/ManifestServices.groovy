package org.serenity.manifest

import org.serenity.persistence.pdo.Cargo
import org.serenity.persistence.service.CargoFacade

import javax.ejb.Stateless
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Stateless
@Path('manifest')
class ManifestServices {

    @Inject
    CargoFacade cargoFacade

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response findAllCargo() {

        return Response.ok(mapper(cargoFacade.findAll())).build()
    }

    private List<CargoDTO> mapper(List<Cargo> cargo) {
        List<CargoDTO> dtos = []
        cargo.each { Cargo c ->
            CargoDTO dto = new CargoDTO()
            dto.owner = c.owner
            dto.description = c.description
            dto.count = c.count
            dto.job = c.job?.name
            dto.location = c.location.name
            dtos.add(dto)
        }

        dtos
    }
}
