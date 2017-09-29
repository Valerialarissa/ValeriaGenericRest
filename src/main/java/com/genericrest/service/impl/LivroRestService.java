/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.service.impl;

import com.genericrest.dao.DAO;
import com.genericrest.model.Livro;
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
import com.genericrest.dao.LivroDAO;
import com.genericrest.service.LivroService;

/**
 *
 * @author valerialarissa
 */
@ManagedBean
@Path("/livro")
public class LivroRestService extends GenericCRUDRestService<Livro> implements LivroService {

    private static final Logger LOG = LoggerFactory.getLogger(LivroRestService.class);

    @Inject
    private LivroDAO livroDAO;

    public LivroRestService() {
        super(Livro.class);
    }

    /**
     *
     * @param titulo
     * @return
     */
    @GET
    @Path("/titulo/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getByTitulo(@PathParam("param") String titulo) {
        getLogger().debug("Pesquise o titulo do livro: {}", titulo);
        Livro found = livroDAO.findByTitulo(titulo);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }


    @Override
    public GenericEntity listToGenericEntity(List<Livro> list) {
        return new GenericEntity<List<Livro>>(list){};
    }
    
    @Override
    public DAO getDao() {
        return livroDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }
}
