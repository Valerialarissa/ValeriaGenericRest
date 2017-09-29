/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao;

import com.genericrest.model.Emprestimo;
import java.util.Date;

/**
 *
 * @author valerialarissa
 */
public interface EmprestimoDAO extends DAO<Emprestimo, Long>{
 
    Emprestimo findBydataEmprestimo(Date dataEmprestimo);
}
