package org.sofka.resourses;

import io.smallrye.mutiny.Uni;
import org.sofka.dto.ValidadorDto;
import org.sofka.services.ValidadorServices;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/validador")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ValidadorResouces {

    @Inject
    ValidadorServices validadorServices;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response> createValidador (@NotNull ValidadorDto validadorDto){
        return validadorServices.createValidador(validadorDto).map(val -> Response.ok(val).build());
    }

    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getAllValidadores(){
        return validadorServices.getAll().map(val -> Response.ok(val).build() );
    }

    @GET
    @Path("/{tipoDoc}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getByName(@PathParam("tipoDoc") String tipoDoc){
        return validadorServices.findByName(tipoDoc).map(val -> Response.ok(val).build() );
    }

    @DELETE
    @Path("/{tipoDoc}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response> deleteValidador(@PathParam("tipoDoc") String tipoDoc){
        return validadorServices.deleteValidador(tipoDoc).map(
                val -> val==1 ? Response.ok(val).build() : Response.noContent().build());
    }

}
