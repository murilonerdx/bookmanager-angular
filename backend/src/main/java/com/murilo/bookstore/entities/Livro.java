package com.murilo.bookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Campo TITULO é requerido")
    @Length(min=5, max=20, message="O campo deve ter entre 5 e 20 caracteres")
    private String titulo;
    private String nomeAutor;
    private String texto;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    public Livro(Integer id, String titulo, String nomeAutor, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.texto = texto;
    }

    public Livro() {
    }

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

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id) && Objects.equals(titulo, livro.titulo) && Objects.equals(nomeAutor, livro.nomeAutor) && Objects.equals(texto, livro.texto) && Objects.equals(categoria, livro.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, nomeAutor, texto, categoria);
    }
}
