/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.service;

import com.genericrest.model.Pessoa;
import javax.ws.rs.core.Response;

/**
 *
 * @author valerialarissa
 */
public interface PessoaService extends CRUDRestService<Pessoa> {

    
    Response getByNome(String nome);
    
}
