/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao;

import com.genericrest.dao.connection.AbstractDAOTest;
import com.genericrest.dao.impl.CategoriaLivroDAOImpl;
import com.genericrest.model.CategoriaLivro;
import java.util.List;
import javax.inject.Inject;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author valerialarissa
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({CategoriaLivroDAOImpl.class, CategoriaLivroDAOImpl.class})
public class CategoriaLivroTest extends AbstractDAOTest {

    @Inject
    private CategoriaLivroDAO categoriaLivroDAO;

    @Test
    @Override
    public void cdiInjectionTest() {
        Assert.assertNotNull(categoriaLivroDAO);
 
    }
    
      @Test
    @Override
    public void saveTest() {
        CategoriaLivro toSave = new CategoriaLivro("tosave");
        categoriaLivroDAO.save(toSave);

        CategoriaLivro saved = categoriaLivroDAO.findByNome(toSave.getNome());
        Assert.assertNotNull(saved);
        Assert.assertNotNull(saved.getId());
    }
    
       @Test
    @Override
    public void updateTest() {
        CategoriaLivro toUpdate = new CategoriaLivro("To Update");
        categoriaLivroDAO.save(toUpdate);

        CategoriaLivro toChange = new CategoriaLivro("To Change");

        toUpdate = categoriaLivroDAO.findByNome(toUpdate.getNome());
        toUpdate.updateParameters(toChange);
        categoriaLivroDAO.update(toUpdate);

        toUpdate = categoriaLivroDAO.findByNome(toUpdate.getNome());
        Assert.assertNotNull(toUpdate);
        Assert.assertNotNull(toUpdate.getId());
    }

      @Test
    @Override
    public void mergeTest() {
        CategoriaLivro toMerge = new CategoriaLivro("To Merge");
        toMerge = categoriaLivroDAO.merge(toMerge);
        Assert.assertNotNull(toMerge);
        Assert.assertNotNull(toMerge.getId());
    }

    @Test
    @Override
    public void deleteTest() {
        CategoriaLivro toDelete = new CategoriaLivro("delete");
        toDelete = categoriaLivroDAO.merge(toDelete);
        Assert.assertNotNull(toDelete.getId());

        categoriaLivroDAO.delete(toDelete);

        toDelete = categoriaLivroDAO.findByNome(toDelete.getNome());
        Assert.assertNull(toDelete);
    }
    
        @Test
    @Override
    public void findByIdTest() {
        CategoriaLivro alice = categoriaLivroDAO.merge(new CategoriaLivro("alice"));
        alice = categoriaLivroDAO.findById(alice.getId());
        Assert.assertNotNull(alice);
    }
  
    @Test
    @Override
    public void findAllTest() {
        CategoriaLivro lessOne = new CategoriaLivro("lessone");
        categoriaLivroDAO.save(lessOne);

        List<CategoriaLivro> categoriaLivros = categoriaLivroDAO.findAll();
        Assert.assertNotNull(categoriaLivros);
        Assert.assertTrue(categoriaLivros.size() >= 1);
    }

}
