/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao.impl;

import com.genericrest.dao.GenericDAO;
import com.genericrest.model.Editora;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.genericrest.dao.EditoraDAO;

/**
 *
 * @author valerialarissa
 */

@ApplicationScoped
public class EditoraDAOImpl extends GenericDAO<Editora, Long> implements EditoraDAO {

    private static final Logger LOG = LoggerFactory.getLogger(EditoraDAOImpl.class);

    public EditoraDAOImpl() {
        super(Editora.class);
    }
    
    @Override
    public Editora findByNome(String nome) {
        Query query = getEntityManager().createNamedQuery("Editora.findByNome", Editora.class);
        query.setParameter("nome", nome);
        List<Editora> editoras = query.getResultList();

        if (editoras == null || editoras.isEmpty()) {
            return null;
        } else if (editoras.size() > 1) {
            throw new NonUniqueResultException();
        } else {
            return editoras.get(0);
        }
    }
    
    @Override
    public Logger getLogger() {
        return LOG;
    }


}