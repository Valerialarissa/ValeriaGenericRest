/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valerialarissa
 */
@Entity
@Table(name = "categorialivros")
@NamedQueries({
    @NamedQuery(name = "CategoriaLivro.findByNome", query = "select c from CategoriaLivro c where c.nome = :nome")
})
@XmlRootElement(name = "categorialivros")
public class CategoriaLivro extends AbstractEntity {

    @Column(length = 255, nullable = true)
    private String nome;

    public CategoriaLivro() {
    }

    public CategoriaLivro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void updateParameters(Object entity) {
        final CategoriaLivro other = (CategoriaLivro) entity;
        this.nome = other.nome;

    }

    @Override
    public String toString() {
        return "CategoriaLivro{" + "nome=" + nome + '}';
    }

}
