/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao.impl;

import com.genericrest.dao.GenericDAO;
import com.genericrest.dao.PessoaDAO;
import com.genericrest.model.Pessoa;
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
public class PessoaDAOImpl extends GenericDAO<Pessoa, Long> implements PessoaDAO {

    private static final Logger LOG = LoggerFactory.getLogger(PessoaDAOImpl.class);

    public PessoaDAOImpl() {
        super(Pessoa.class);
    }

  
    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Pessoa findByNome(String nome) {
        Query query = getEntityManager().createNamedQuery("Pessoa.findByNome", Pessoa.class);
        query.setParameter("nome", nome);
        List<Pessoa> pessoas = query.getResultList();
        
        if (pessoas == null || pessoas.isEmpty()) {
           return null;
        } else if (pessoas.size() > 1) {
            throw new  NonUniqueResultException();
        } else {
            return pessoas.get(0);
        }
    }
 

}