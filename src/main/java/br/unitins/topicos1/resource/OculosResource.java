package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.model.Oculos;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/oculos")
public class OculosResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Oculos> todosOculos(){
         return Oculos.listAll();
    }
       
}
