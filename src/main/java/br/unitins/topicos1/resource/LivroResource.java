package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.model.Livro;
import br.unitins.topicos1.repository.LivroRepository;
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
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/livros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LivroResource {

     @Inject
     LivroRepository repository;

     @POST
     @Transactional
     public Livro insert(Livro livro) {
          Livro novoLivro = new Livro();
          novoLivro.setIsbn(livro.getIsbn());
          novoLivro.setTitulo(livro.getTitulo());

          repository.persist(novoLivro);

          return novoLivro;
     }

     @GET
     public List<Livro> findAll() {
          return repository.listAll();
     }

     @GET
     @Path("/{id}")
     public Livro findById(@PathParam("id") Long id) {
          return repository.findById(id);
     }

     @GET
     @Path("/search/titulo/{isbn}")
     public List<Livro> findByIsbn(@PathParam("isbn") String isbn) {
          return repository.findByIsbn(isbn);
     }

     @PUT
     @Path("/update/{id}")
     @Transactional
     public Livro update(@PathParam("id") Long id, Livro livro){
         Livro entityLivro = repository.findById(id);
         if(entityLivro == null){
             throw new WebApplicationException("Livro com o id " + id + " não existe.", 404);
         }
 
         if(livro.getIsbn() != null) {
             entityLivro.setIsbn(livro.getIsbn());
         }
         if(livro.getTitulo() != null) {
             entityLivro.setTitulo(livro.getTitulo());
         }
         if(livro.getAutor() != null) {
             entityLivro.setAutor(livro.getAutor());
         }
         if(livro.getNumeroPaginas() != null) {
             entityLivro.setNumeroPaginas(livro.getNumeroPaginas());
         }
         if(livro.getGenero() != null) {
             entityLivro.setGenero(livro.getGenero());
         }
         if(livro.getEditora() != null) {
             entityLivro.setEditora(livro.getEditora());
         }
         repository.persist(entityLivro);
 
         return entityLivro;
     }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Livro livroToDelete = repository.findById(id);
        if (livroToDelete == null) {
            throw new WebApplicationException("Livro com o id " + id + " não existe.", 404);
        }
        repository.delete(livroToDelete);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

