package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService service;

    @POST
    public Response insert(UsuarioDTO dto) {
        UsuarioResponseDTO responseDTO = service.insert(dto);
        return Response.status(Response.Status.CREATED)
                .entity(responseDTO)
                .build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(UsuarioDTO dto, @PathParam("id") Long id) {
        UsuarioResponseDTO responseDTO = service.update(dto, id);
        if (responseDTO != null) {
            return Response.status(Response.Status.OK)
                    .entity(responseDTO)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    

    @GET
    public Response findAll() {
        List<UsuarioResponseDTO> usuarios = service.findByAll();
        return Response.status(Response.Status.OK)
                .entity(usuarios)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        UsuarioResponseDTO usuario = service.findById(id);
        if (usuario != null) {
            return Response.status(Response.Status.OK)
                    .entity(usuario)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        List<UsuarioResponseDTO> usuarios = service.findByNome(nome);
        return Response.status(Response.Status.OK)
                .entity(usuarios)
                .build();
    }

}