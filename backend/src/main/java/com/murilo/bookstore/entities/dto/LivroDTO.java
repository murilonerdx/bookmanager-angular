package com.murilo.bookstore.entities.dto;

import com.murilo.bookstore.entities.Livro;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class LivroDTO {

    private Integer id;
    @NotEmpty(message = "Campo TITULO é requerido")
    @Length(min=5, max=20, message="O campo deve ter entre 5 e 20 caracteres")
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
