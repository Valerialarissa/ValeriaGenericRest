/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao.connection;

/**
 *
 * @author valerialarissa
 */
public abstract class AbstractDAOTest {
     public abstract void cdiInjectionTest();
    
    public abstract void saveTest();

    public abstract void updateTest();

    public abstract void mergeTest();

    public abstract void deleteTest();

    public abstract void findByIdTest();

    public abstract void findAllTest();
}
