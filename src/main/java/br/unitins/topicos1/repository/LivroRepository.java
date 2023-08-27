package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Livro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LivroRepository implements PanacheRepository<Livro> {
    public List<Livro> findByIsbn(String isbn) {
        return find("UPPER(isbn) LIKE UPPER (?1) ", "%" + isbn + "%").list();
    }

    public static boolean isLivroTituloIsNotEmpty(Livro livro) {
        return false;
    }

}
