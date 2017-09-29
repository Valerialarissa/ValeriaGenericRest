/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valerialarissa
 */
@Entity
@Table(name = "livros")
@NamedQueries({
    @NamedQuery(name = "Livro.findByTitulo", query = "select j from Livro j where j.titulo = :titulo")
})
@XmlRootElement(name = "livros")
public class Livro extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String titulo;

    @Column(length = 200, nullable = false)
    private String autorPrincipal;

    @ManyToOne
    private CategoriaLivro categoriaLivro;

    @ManyToOne
    private Editora editora;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private LivroSituacao livroSituacao;

    public Livro() {
    }

    public Livro(String titulo, String autorPrincipal, CategoriaLivro categoriaLivro, Editora editora, LivroSituacao livroSituacao) {
        this.titulo = titulo;
        this.autorPrincipal = autorPrincipal;
        this.categoriaLivro = categoriaLivro;
        this.editora = editora;
        this.livroSituacao = livroSituacao;
    }

    public Livro(String titulo, String autorPrincipal, CategoriaLivro categoriaLivro, Editora editora) {
        this.titulo = titulo;
        this.autorPrincipal = autorPrincipal;
        this.categoriaLivro = categoriaLivro;
        this.editora = editora;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutorPrincipal() {
        return autorPrincipal;
    }

    public void setAutorPrincipal(String autorPrincipal) {
        this.autorPrincipal = autorPrincipal;
    }

    public CategoriaLivro getCategoriaLivro() {
        return categoriaLivro;
    }

    public void setCategoriaLivro(CategoriaLivro categoriaLivro) {
        this.categoriaLivro = categoriaLivro;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public LivroSituacao getLivroSituacao() {
        return livroSituacao;
    }

    public void setLivroSituacao(LivroSituacao livroSituacao) {
        this.livroSituacao = livroSituacao;
    }

   
    @Override
    public void updateParameters(Object entity) {
        final Livro other = (Livro) entity;
        this.titulo = other.titulo;
        this.autorPrincipal = other.autorPrincipal;
        this.categoriaLivro = other.categoriaLivro;
        this.editora = other.editora;
        this.livroSituacao = other.livroSituacao;

    }

    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", autor principal=" + autorPrincipal + ", Categoria do livro="
                + categoriaLivro + ", Editora=" + editora + ", Situação do livro=" + livroSituacao + '}';
    }

    public enum LivroSituacao {
        DISPONIVEL, INDISPONIVEL;
    }

}
