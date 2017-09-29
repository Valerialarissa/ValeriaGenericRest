/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao.impl;

import com.genericrest.dao.CategoriaLivroDAO;
import com.genericrest.dao.GenericDAO;
import com.genericrest.model.CategoriaLivro;
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
public class CategoriaLivroDAOImpl extends GenericDAO<CategoriaLivro, Long> implements CategoriaLivroDAO {

    private static final Logger LOG = LoggerFactory.getLogger(CategoriaLivroDAOImpl.class);

    public CategoriaLivroDAOImpl() {
        super(CategoriaLivro.class);
    }
    
    @Override
    public CategoriaLivro findByNome(String nome) {
        Query query = getEntityManager().createNamedQuery("CategoriaLivro.findByNome", CategoriaLivro.class);
        query.setParameter("nome", nome);
        List<CategoriaLivro> categorialivros = query.getResultList();

        if (categorialivros == null || categorialivros.isEmpty()) {
            return null;
        } else if (categorialivros.size() > 1) {
            throw new NonUniqueResultException();
        } else {
            return categorialivros.get(0);
        }
    }
    
    @Override
    public Logger getLogger() {
        return LOG;
    }
}

