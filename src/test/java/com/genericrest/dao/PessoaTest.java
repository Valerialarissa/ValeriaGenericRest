/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao;

/**
 *
 * @author valerialarissa
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.genericrest.dao.connection.AbstractDAOTest;
import com.genericrest.dao.impl.PessoaDAOImpl;
import com.genericrest.model.Pessoa;
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
@AdditionalClasses({PessoaDAOImpl.class, PessoaDAOImpl.class})
public class PessoaTest extends AbstractDAOTest {

    @Inject
    private PessoaDAO pessoaDAO;

    @Test
    @Override
    public void cdiInjectionTest() {
        Assert.assertNotNull(pessoaDAO);
 
    }
    
      @Test
    @Override
    public void saveTest() {
        Pessoa toSave = new Pessoa("tosave", "tosave");
        pessoaDAO.save(toSave);

        Pessoa saved = pessoaDAO.findByNome(toSave.getNome());
        Assert.assertNotNull(saved);
        Assert.assertNotNull(saved.getId());
    }
    
       @Test
    @Override
    public void updateTest() {
        Pessoa toUpdate = new Pessoa("To Update", "To Update");
        pessoaDAO.save(toUpdate);

        Pessoa toChange = new Pessoa("To Change", "To Update");

        toUpdate = pessoaDAO.findByNome(toUpdate.getNome());
        toUpdate.updateParameters(toChange);
        pessoaDAO.update(toUpdate);

        toUpdate = pessoaDAO.findByNome(toUpdate.getNome());
        Assert.assertNotNull(toUpdate);
        Assert.assertNotNull(toUpdate.getId());
      //  Assert.assertEquals(toUpdate, toChange);
    }

    
      @Test
    @Override
    public void mergeTest() {
        Pessoa toMerge = new Pessoa("To Merge", "To Update");
        toMerge = pessoaDAO.merge(toMerge);
        Assert.assertNotNull(toMerge);
        Assert.assertNotNull(toMerge.getId());
    }

    @Test
    @Override
    public void deleteTest() {
        Pessoa toDelete = new Pessoa("delete", "todelete");
        toDelete = pessoaDAO.merge(toDelete);
        Assert.assertNotNull(toDelete.getId());

        pessoaDAO.delete(toDelete);

        toDelete = pessoaDAO.findByNome(toDelete.getNome());
        Assert.assertNull(toDelete);
    }
    
        @Test
    @Override
    public void findByIdTest() {
        Pessoa alice = pessoaDAO.merge(new Pessoa("alice", "alice"));
        alice = pessoaDAO.findById(alice.getId());
        Assert.assertNotNull(alice);
    }
  
    @Test
    @Override
    public void findAllTest() {
        Pessoa lessOne = new Pessoa("lessone", "lessone");
        pessoaDAO.save(lessOne);

        List<Pessoa> pessoas = pessoaDAO.findAll();
        Assert.assertNotNull(pessoas);
        Assert.assertTrue(pessoas.size() >= 1);
    }

}
