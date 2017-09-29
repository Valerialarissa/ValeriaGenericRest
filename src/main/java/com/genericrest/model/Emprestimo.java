/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valerialarissa
 */
@Entity
@Table(name = "emprestimos")
@NamedQueries({
    @NamedQuery(name = "Emprestimo.findBydataEmprestimo", query = "select i from Emprestimo i where i.dataEmprestimo = :dataEmprestimo")
})
@XmlRootElement(name = "emprestimos")
public class Emprestimo extends AbstractEntity {

    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    private Livro livro;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmprestimo;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDevolucao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EmprestimoSituacao emprestimoSituacao;

    public Emprestimo() {
    }

    public Emprestimo(Pessoa pessoa, Livro livro, Date dataEmprestimo, Date dataDevolucao, EmprestimoSituacao emprestimoSituacao) {
        this.pessoa = pessoa;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.emprestimoSituacao = emprestimoSituacao;
    }

    public Emprestimo(Pessoa pessoa, Livro livro, Date dataEmprestimo) {
        this.pessoa = pessoa;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public EmprestimoSituacao getEmprestimoSituacao() {
        return emprestimoSituacao;
    }

    public void setEmprestimoSituacao(EmprestimoSituacao emprestimoSituacao) {
        this.emprestimoSituacao = emprestimoSituacao;
    }

    @Override
    public void updateParameters(Object entity) {
        final Emprestimo other = (Emprestimo) entity;
        this.pessoa = other.pessoa;
        this.livro = other.livro;
        this.dataEmprestimo = other.dataEmprestimo;
        this.dataDevolucao = other.dataDevolucao;
        this.emprestimoSituacao = other.emprestimoSituacao;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "pessoa=" + pessoa + ", livro=" + livro
                + "Data Emprestimo=" + dataEmprestimo + ", Data Devolução=" + dataDevolucao
                + "Situação do Emprestimo=" + emprestimoSituacao + '}';
    }

    public enum EmprestimoSituacao {
        FECHADO, ABERTO;
    }

}
