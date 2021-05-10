package com.murilo.bookstore.entities.dto;

import com.murilo.bookstore.entities.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CategoriaDTO {

    private Integer id;
    @NotEmpty(message = "Campo NOME é requerido")
    @Length(min = 3, max= 100, message="O campo deve ter entre 3 e 100 caracteres")
    private String nome;
    @NotEmpty(message = "Campo descrição é requerido")
    @Length(min = 3, max= 200, message="O campo deve ter entre 3 e 200 caracteres")
    private String descricao;

    public CategoriaDTO(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public CategoriaDTO(Categoria obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public CategoriaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
