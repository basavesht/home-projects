package com.tcs.sample.rest.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tcs.sample.rest.webserviceProvider.stubs.userdetailsdocument.Address;
import com.tcs.sample.rest.webserviceProvider.stubs.userdetailsdocument.UserDetails;

@Path("/hello")
public class HelloWorldResource {

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "JAX-RS(Text/Plain) Implementation of HelloWorld";
	}

	// This method is called if XML is request
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> JAX-RS(XML) Implementation of HelloWorld" + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "JAX-RS(HTML) Implementation of HelloWorld" + "</body></h1>" + "</html> ";
	}

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public UserDetails sayAppXMLHello() {
		Address addrs = new Address();
		addrs.setStreet("1 Main Street");
		addrs.setCity( "Beverly Hills");
		addrs.setState("CA");
		addrs.setZipCode("90210");

		UserDetails response = new UserDetails();
		response.setName("Paul");
		response.setCity("Beverly Hills");
		response.setHomeAddress(addrs);

		return response;
	}

}
