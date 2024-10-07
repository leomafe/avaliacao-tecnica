package br.com.avaliacao.controller;

import br.com.avaliacao.dto.EstablishmentDto;
import br.com.avaliacao.dto.GeolocationDto;
import br.com.avaliacao.exception.EstablishmentNotFoundException;
import br.com.avaliacao.service.EstablishmentService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("/establishment")
@RequiredArgsConstructor
public class EstabelecimentoController {

    private final EstablishmentService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEstablishment(EstablishmentDto dto) {

        service.insert(dto);
        return Response.status(Response.Status.CREATED).build();

    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEstablishment(@PathParam("id") String id, EstablishmentDto dto) {

        service.update(id, dto);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEstablishment(@PathParam("id") String id) {

        service.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/geolocation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findEstablishment(GeolocationDto dto) {

        try {
            var establishmentDto = service.findEstablishment(dto.getLatitude(), dto.getLongitude());
            return Response.ok(establishmentDto).build();
        } catch (EstablishmentNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
