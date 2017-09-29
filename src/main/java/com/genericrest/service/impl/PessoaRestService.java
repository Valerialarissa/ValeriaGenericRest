/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.service.impl;

import com.genericrest.dao.DAO;
import com.genericrest.dao.PessoaDAO;
import com.genericrest.model.Pessoa;
import com.genericrest.service.GenericCRUDRestService;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.genericrest.service.PessoaService;

/**
 *
 * @author valerialarissa
 */
@ManagedBean
@Path("/pessoa")
public class PessoaRestService extends GenericCRUDRestService<Pessoa> implements PessoaService {

    private static final Logger LOG = LoggerFactory.getLogger(PessoaRestService.class);

    @Inject
    private PessoaDAO pessoaDAO;

    public PessoaRestService() {
        super(Pessoa.class);
    }
    
   /**
     *
     * @param nome
     * @return
     */
    @GET
    @Path("/nome/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
        

    @Override
    public GenericEntity listToGenericEntity(List<Pessoa> list) {
        return new GenericEntity<List<Pessoa>>(list){};
    }
    

    @Override
    public Response getByNome(@PathParam("param") String nome) {
        getLogger().debug("Pesquise a pessoa pelo nome: {}", nome);
        Pessoa encontrado = pessoaDAO.findByNome(nome);
        if (encontrado == null){
            return Response.noContent().build();
        }
        return Response.ok().entity(encontrado).build();
    }

        @Override
    public DAO getDao() {
        return pessoaDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

}  
