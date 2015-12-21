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

        return Response.ok(mapList(cargoFacade.findAll())).build()
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path('/{id}')
    Response findCargoById(@PathParam('id') Integer id) {
        Response response
        try {
            Cargo cargo = cargoFacade.find(id)
            response = Response.ok(map(cargo)).build()
        } catch (PersistenceException ex) {
            response = Response.status(Response.Status.NOT_FOUND).build()
        }
        return response
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response addCargo(CargoDTO cargoDTO) {
        null
    }

    private Cargo map(CargoDTO cargoDTO) {
        Cargo cargo = new Cargo()
        cargo.count = cargoDTO.count
        cargo.description = cargoDTO.description
        cargo.owner = cargoDTO.owner
        cargo
    }

    private List<CargoDTO> mapList(List<Cargo> cargo) {
        List<CargoDTO> dtos = []
        cargo.each { Cargo c ->
            dtos.add(map(c))
        }

        dtos
    }

    private CargoDTO map(Cargo cargo) {
        CargoDTO dto = new CargoDTO()
        dto.owner = cargo.owner
        dto.description = cargo.description
        dto.count = cargo.count
        dto.job = cargo.job?.name
        dto.location = cargo.location.name
        dto
    }
}
