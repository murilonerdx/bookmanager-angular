package com.murilo.bookstore.services;

import com.murilo.bookstore.entities.Livro;
import com.murilo.bookstore.repositories.LivroRepository;
import com.murilo.bookstore.services.exceptions.DataIntegrityException;
import com.murilo.bookstore.services.exceptions.EmptyResultDataException;
import com.murilo.bookstore.services.exceptions.HttpRequestMethodSupportedException;
import com.murilo.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    public LivroRepository repository;

    @Autowired
    public CategoriaService categoriaService;


    public Livro findById(Integer id) {
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ",Tipo " + Livro.class.getName()));
    }

    public List<Livro> findAll(Integer id_cat) {
        try {
            categoriaService.findById(id_cat);
            return repository.findByCategoria(id_cat);
        } catch (HttpRequestMethodSupportedException e) {
            throw new HttpRequestMethodSupportedException("Esse metodo não é suportado");
        }
    }

    public Livro create(Livro livro) {
        livro.setId(null);
        return repository.save(livro);


    }

    public Livro update(Integer id, Livro livro) {

        Livro entity = findById(id);
        entity.setCategoria(livro.getCategoria());
        entity.setNomeAutor(livro.getNomeAutor());
        entity.setTexto(livro.getNomeAutor());
        entity.setTitulo(livro.getTitulo());
        return repository.save(entity);


    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataException("Objeto não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Muitos items associados a entidade");
        }
    }
}
