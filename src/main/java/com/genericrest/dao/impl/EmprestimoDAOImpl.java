/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao.impl;

import com.genericrest.dao.EmprestimoDAO;
import com.genericrest.dao.GenericDAO;
import com.genericrest.model.Emprestimo;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author valerialarissa
 */
@ApplicationScoped
public class EmprestimoDAOImpl extends GenericDAO<Emprestimo, Long> implements EmprestimoDAO {

    private static final Logger LOG = LoggerFactory.getLogger(EmprestimoDAOImpl.class);

    public EmprestimoDAOImpl() {
        super(Emprestimo.class);
    }

  
    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Emprestimo findBydataEmprestimo(Date dataEmprestimo) {
         Query query = getEntityManager().createNamedQuery("Emprestimo.findBydataEmprestimo", Emprestimo.class);
        query.setParameter("dataEmprestimo", dataEmprestimo);
        List<Emprestimo> emprestimos = query.getResultList();
        
        if (emprestimos == null || emprestimos.isEmpty()) {
           return null;
        } else if (emprestimos.size() > 1) {
            throw new  NonUniqueResultException();
        } else {
            return emprestimos.get(0);
        }
    }
}