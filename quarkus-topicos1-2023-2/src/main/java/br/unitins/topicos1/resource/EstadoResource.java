package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.dto.EstadoDTO;
import br.unitins.topicos1.dto.EstadoResponseDTO;
import br.unitins.topicos1.service.EstadoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {

    @Inject
    EstadoService service;

    @POST
    public EstadoResponseDTO insert(EstadoDTO dto) {
        return service.insert(dto);
    }

    @PUT
    @Path("/{id}")
    public EstadoResponseDTO uptadate(EstadoDTO dto, @PathParam("id") Long id) {
        return service.update(dto, id);
    }

    @GET
    public List<EstadoResponseDTO> findAll() {
        return service.findByAll();

        // return repository.listAll();
    }

    @GET
    @Path("/{id}")
    public EstadoResponseDTO findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<EstadoResponseDTO> findByNome(@PathParam("nome") String nome) {
        return service.findByNome(nome);
        // return repository.findByNome(nome);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }
}
