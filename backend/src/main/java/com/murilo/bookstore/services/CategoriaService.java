package com.murilo.bookstore.services;

import com.murilo.bookstore.entities.Categoria;
import com.murilo.bookstore.entities.dto.CategoriaDTO;
import com.murilo.bookstore.repositories.CategoriaRepository;
import com.murilo.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    public CategoriaRepository repository;


    public Categoria findById(Integer id){
        Optional<Categoria> obj =  repository.findById(id);
        return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ",Tipo " + Categoria.class.getName()));
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria create(Categoria categoria){
        categoria.setId(null);
        return repository.save(categoria);
    }

    public Categoria update(Integer id, CategoriaDTO categoriaDTO){
        Categoria entity = findById(id);
        entity.setNome(categoriaDTO.getNome());
        entity.setDescricao(categoriaDTO.getDescricao());
        return repository.save(entity);
    }

    public void delete(Integer id){

    }
}
