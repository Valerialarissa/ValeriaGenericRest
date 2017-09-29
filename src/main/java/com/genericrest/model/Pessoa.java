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
@Table(name = "pessoas")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findByNome", query = "select p from Pessoa p where p.nome = :nome")
})
@XmlRootElement(name = "pessoas")
public class Pessoa extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(length = 200, nullable = false)
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void updateParameters(Object entity) {
        final Pessoa other = (Pessoa) entity;
        this.nome = other.nome;
        this.cpf = other.cpf;

    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", cpf=" + cpf + '}';
    }

}
