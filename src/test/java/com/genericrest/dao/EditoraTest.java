/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao;

import com.genericrest.dao.connection.AbstractDAOTest;
import com.genericrest.dao.impl.EditoraDAOImpl;
import com.genericrest.model.Editora;
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
@AdditionalClasses({EditoraDAOImpl.class, EditoraDAOImpl.class})
public class EditoraTest extends AbstractDAOTest {

    @Inject
    private EditoraDAO editoraDAO;

    @Test
    @Override
    public void cdiInjectionTest() {
        Assert.assertNotNull(editoraDAO);
 
    }
    
      @Test
    @Override
    public void saveTest() {
        Editora toSave = new Editora("tosave");
        editoraDAO.save(toSave);

        Editora saved = editoraDAO.findByNome(toSave.getNome());
        Assert.assertNotNull(saved);
        Assert.assertNotNull(saved.getId());
    }
    
       @Test
    @Override
    public void updateTest() {
        Editora toUpdate = new Editora("To Update");
        editoraDAO.save(toUpdate);

        Editora toChange = new Editora("To Change");

        toUpdate = editoraDAO.findByNome(toUpdate.getNome());
        toUpdate.updateParameters(toChange);
        editoraDAO.update(toUpdate);

        toUpdate = editoraDAO.findByNome(toUpdate.getNome());
        Assert.assertNotNull(toUpdate);
        Assert.assertNotNull(toUpdate.getId());
    }

    
      @Test
    @Override
    public void mergeTest() {
        Editora toMerge = new Editora("To Merge");
        toMerge = editoraDAO.merge(toMerge);
        Assert.assertNotNull(toMerge);
        Assert.assertNotNull(toMerge.getId());
    }

    @Test
    @Override
    public void deleteTest() {
        Editora toDelete = new Editora("delete");
        toDelete = editoraDAO.merge(toDelete);
        Assert.assertNotNull(toDelete.getId());

        editoraDAO.delete(toDelete);

        toDelete = editoraDAO.findByNome(toDelete.getNome());
        Assert.assertNull(toDelete);
    }
    
        @Test
    @Override
    public void findByIdTest() {
        Editora alice = editoraDAO.merge(new Editora("alice"));
        alice = editoraDAO.findById(alice.getId());
        Assert.assertNotNull(alice);
    }
  
    @Test
    @Override
    public void findAllTest() {
        Editora lessOne = new Editora("lessone");
        editoraDAO.save(lessOne);

        List<Editora> editoras = editoraDAO.findAll();
        Assert.assertNotNull(editoras);
        Assert.assertTrue(editoras.size() >= 1);
    }

}

