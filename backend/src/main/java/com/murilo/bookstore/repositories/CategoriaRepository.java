package com.murilo.bookstore.repositories;

import com.murilo.bookstore.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
