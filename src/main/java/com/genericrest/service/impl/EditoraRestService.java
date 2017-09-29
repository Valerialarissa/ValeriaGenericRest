/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.service.impl;

import com.genericrest.dao.DAO;
import com.genericrest.model.Editora;
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
import com.genericrest.dao.EditoraDAO;
import com.genericrest.service.EditoraService;

/**
 *
 * @author valerialarissa
 */
@ManagedBean
@Path("/editora")
public class EditoraRestService extends GenericCRUDRestService<Editora> implements EditoraService {

    private static final Logger LOG = LoggerFactory.getLogger(EditoraRestService.class);

    @Inject
    private EditoraDAO editoraDAO;

    public EditoraRestService() {
        super(Editora.class);
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
        getLogger().debug("Pesquise o nome da editora: {}", nome);
        Editora found = editoraDAO.findByNome(nome);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }


    @Override
    public GenericEntity listToGenericEntity(List<Editora> list) {
        return new GenericEntity<List<Editora>>(list){};
    }
    
    @Override
    public DAO getDao() {
        return editoraDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

}  
