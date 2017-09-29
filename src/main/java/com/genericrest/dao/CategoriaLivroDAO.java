/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.dao;

import com.genericrest.model.CategoriaLivro;

/**
 *
 * @author valerialarissa
 */
public interface CategoriaLivroDAO extends DAO<CategoriaLivro, Long>{

    CategoriaLivro findByNome (String nome);
}
