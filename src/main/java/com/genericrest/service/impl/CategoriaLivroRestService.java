/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.service.impl;

import com.genericrest.dao.CategoriaLivroDAO;
import com.genericrest.dao.DAO;
import com.genericrest.model.CategoriaLivro;
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
import com.genericrest.service.CategoriaLivroService;

/**
 *
 * @author valerialarissa
 */
@ManagedBean
@Path("/categorialivro")
public class CategoriaLivroRestService extends GenericCRUDRestService<CategoriaLivro> implements CategoriaLivroService {

    private static final Logger LOG = LoggerFactory.getLogger(CategoriaLivroService.class);

    @Inject
    private CategoriaLivroDAO categorialivroDAO;

    public CategoriaLivroRestService() {
        super(CategoriaLivro.class);
    }

    /**
     *
     * @param nome
     * @return
     */
    @GET
    @Path("/nome/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    
    public Response getByNome(@PathParam("param") String nome) {
        getLogger().debug("Pesquise o nome da categoria: {}", nome);
        CategoriaLivro found = categorialivroDAO.findByNome(nome);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }


    @Override
    public GenericEntity listToGenericEntity(List<CategoriaLivro> list) {
        return new GenericEntity<List<CategoriaLivro>>(list){};
    }
    
    @Override
    public DAO getDao() {
        return categorialivroDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }
}
