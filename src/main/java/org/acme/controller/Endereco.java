package org.acme.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.acme.model.Cidade;
import org.apache.camel.ProducerTemplate;

@Path("/endereco")
public class Endereco {
	
	@Inject
    ProducerTemplate producer;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON) 
    public ResponseBuilder buscarEndereco(Cidade cidade) {
    	
    	producer.requestBody("direct:start",cidade.getCep());
    	return Response.ok();
    }
}