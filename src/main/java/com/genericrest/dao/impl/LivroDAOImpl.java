/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao.impl;

import com.genericrest.dao.GenericDAO;
import com.genericrest.dao.LivroDAO;
import com.genericrest.model.Livro;
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
public class LivroDAOImpl extends GenericDAO<Livro, Long> implements LivroDAO {

    private static final Logger LOG = LoggerFactory.getLogger(LivroDAOImpl.class);

    public LivroDAOImpl() {
        super(Livro.class);
    }

  
    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Livro findByTitulo(String titulo) {
         Query query = getEntityManager().createNamedQuery("Livro.findByTitulo", Livro.class);
        query.setParameter("titulo", titulo);
        List<Livro> livros = query.getResultList();
        
        if (livros == null || livros.isEmpty()) {
           return null;
        } else if (livros.size() > 1) {
            throw new  NonUniqueResultException();
        } else {
            return livros.get(0);
        }
    }
}
