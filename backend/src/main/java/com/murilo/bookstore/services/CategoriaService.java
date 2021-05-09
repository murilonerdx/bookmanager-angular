package com.murilo.bookstore.services;

import com.murilo.bookstore.entities.Categoria;
import com.murilo.bookstore.repositories.CategoriaRepository;
import com.murilo.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    public CategoriaRepository repository;


    public Categoria findById(Integer id){
        Optional<Categoria> obj =  repository.findById(id);
        return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ",Tipo " + Categoria.class.getName()));
    }
}
