/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genericrest.service.impl;

import com.genericrest.dao.DAO;
import com.genericrest.dao.EmprestimoDAO;
import com.genericrest.model.Emprestimo;
import com.genericrest.service.EmprestimoService;
import com.genericrest.service.GenericCRUDRestService;
import java.util.Date;
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

/**
 *
 * @author valerialarissa
 */
@ManagedBean
@Path("/emprestimo")
public class EmprestimoRestService extends GenericCRUDRestService<Emprestimo> implements EmprestimoService {

    private static final Logger LOG = LoggerFactory.getLogger(LivroRestService.class);

    @Inject
    private EmprestimoDAO emprestimoDAO;

    public EmprestimoRestService() {
        super(Emprestimo.class);
    }

    /**
     *
     * @param dataEmprestimo
     * @return
     */
    @GET
    @Path("/dataEmprestimo/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getBydataEmprestimo(@PathParam("param") Date dataEmprestimo) {
        getLogger().debug("Pesquise a data do empréstimo: {}", dataEmprestimo);
        Emprestimo found = emprestimoDAO.findBydataEmprestimo(dataEmprestimo);
        if (found == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(found).build();
    }


    @Override
    public GenericEntity listToGenericEntity(List<Emprestimo> list) {
        return new GenericEntity<List<Emprestimo>>(list){};
    }
    
    @Override
    public DAO getDao() {
        return emprestimoDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }
}