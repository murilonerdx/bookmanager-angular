package com.murilo.bookstore.entities.dto;

import com.murilo.bookstore.entities.Livro;

public class LivroDTO {

    private Integer id;
    private String titulo;

    public LivroDTO(Integer id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public LivroDTO(Livro obj){
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    public LivroDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
