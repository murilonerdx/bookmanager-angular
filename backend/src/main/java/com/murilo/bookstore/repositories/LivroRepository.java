package com.murilo.bookstore.repositories;

import com.murilo.bookstore.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
