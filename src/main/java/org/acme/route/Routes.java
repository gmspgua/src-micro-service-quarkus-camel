package org.acme.route;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.model.Endereco;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import io.agroal.api.AgroalDataSource;



@ApplicationScoped
public class Routes extends RouteBuilder {
	
	@Inject
	AgroalDataSource dataSource;



	@Override
	public void configure() throws Exception {
		  from("direct:start")
	      .log("${body}")
		  .setProperty("initialPayload",  body())
		  .log("buscando dados: ${exchangeProperty.initialPayload}")
		  .to("direct:route-getInfo") 
		  .unmarshal().json(JsonLibrary.Jackson,Endereco.class)
		  .choice() 
			  .when()
				  .simple("${body.uf} == 'SP'") 
				  .log("Sao Paulo")
				  .log("Enviar para banco de dados") 
				  .to("direct:route-insertDatabase")
			  .otherwise() 
				  .log("Curitiba") 
				  .to("direct:route-insertQueueJms") 
			  .end();
		 
		
		  from("direct:route-getInfo") 
		  .routeId("route-getInfo")
		  .log("Buscando dados do CEP: ${body}") 
		  .setHeader(Exchange.HTTP_METHOD,
		  constant("GET")) 
		  .setHeader(Exchange.HTTP_PATH, simple("${body}/json/"))
		  .to("https://viacep.com.br/ws");
		 
		  
		  
		  from("direct:route-insertQueueJms") 
		  .process(new Processor() {
			  @Override public void process(Exchange exchange) throws Exception { Endereco
				  endereco = exchange.getIn().getBody(Endereco.class);
				  exchange.setProperty("localidade", endereco.getLocalidade());
				  exchange.setProperty("logradouro", endereco.getLogradouro());
				  exchange.setProperty("ddd", endereco.getDdd()); } }) 
				  .setBody( simple("insert into quarkus(localidade, logradouro, ddd) values ('${exchangeProperty.localidade}', '${exchangeProperty.localidade}', '${exchangeProperty.ddd}')"
			  )) 
		  .to("jms:endereco?exchangePattern=InOnly") ;
			 
		  
	 
		
		  from("direct:route-insertDatabase") 
		  .routeId("route-insertDatabase")
		  .process(new Processor() {
			  @Override public void process(Exchange exchange) throws Exception { 
				  Endereco endereco = exchange.getIn().getBody(Endereco.class);
				  exchange.setProperty("localidade", endereco.getLocalidade());
				  exchange.setProperty("logradouro", endereco.getLogradouro());
				  exchange.setProperty("ddd", endereco.getDdd()); } })
				  .setBody(
				  simple("insert into endereco(localidade, logradouro, ddd) values ('${exchangeProperty.localidade}', '${exchangeProperty.localidade}', '${exchangeProperty.ddd}')"
			  ))
		  . log("${body}")
		  . delay(1000)
		  . to("jdbc:dataSource");       
	}
}
