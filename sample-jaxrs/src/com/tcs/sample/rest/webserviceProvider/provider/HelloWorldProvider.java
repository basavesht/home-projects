package com.tcs.sample.rest.webserviceProvider.provider;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;

import com.tcs.sample.rest.webserviceProvider.stubs.userdetailsdocument.Address;
import com.tcs.sample.rest.webserviceProvider.stubs.userdetailsdocument.UserDetails;
import com.tcs.sample.rest.webserviceProvider.stubs.userdetailsresponsedocument.UserDetailsResponse;

@WebServiceProvider
@ServiceMode(value=Service.Mode.PAYLOAD)
public class HelloWorldProvider implements Provider<Source> 
{
	@javax.annotation.Resource(type=Object.class)
	protected WebServiceContext wsContext;
	StreamSource reply = new StreamSource();
	private JAXBContext jc;

	public HelloWorldProvider() {
		try {
			jc = JAXBContext.newInstance("com.tcs.sample.rest.webserviceProvider.provider");
		} 
		catch(JAXBException je) {
			throw new WebServiceException("Cannot create JAXBContext", je);
		}
	}

	public Source invoke(Source source) 
	{
		try
		{
			MessageContext mc = wsContext.getMessageContext();
			String method = (String)mc.get(MessageContext.HTTP_REQUEST_METHOD);
			String path = (String)mc.get(MessageContext.PATH_INFO);
			String replyElement = "" ;
			if (method.equals("GET")) 
				return get(path);
			if (method.equals("POST")) 
				return post(source, mc);
			if (method.equals("PUT")) 
				replyElement =  "<p>JAX-RS (PUT)</p>";
			if (method.equals("DELETE")) 
				replyElement =  "<p>JAX-RS (DELETE)</p>";
			reply = new StreamSource(new StringReader(replyElement));
		} 
		catch(Exception je) {
			throw new WebServiceException(je);
		}
		return reply;
	}

	/**
	 * Handles HTTP POST. 
	 */
	private Source post(Source source, MessageContext mc) throws JAXBException 
	{
		mc.put(MessageContext.HTTP_RESPONSE_CODE, 201);
		Unmarshaller u = jc.createUnmarshaller();
		JAXBElement<UserDetails> o =(JAXBElement<UserDetails>)u.unmarshal(source);
		UserDetails request = o.getValue();
		System.out.println(request.getName());
		UserDetailsResponse response = new UserDetailsResponse();
		response.setMessage("Created successfully");

		return new JAXBSource(jc, new ObjectFactory().createUserDetailsResponseDocument(response));
	}

	/**
	 * Handles HTTP GET. 
	 * @throws JAXBException 
	 */
	private Source get(String userId) throws JAXBException 
	{
		if (userId == null) {
			throw  new WebServiceException("Web Service was passed a null Purchase order");
		} 

		userId.replace("/","");

		Address addrs = new Address();
		addrs.setStreet("1 Main Street");
		addrs.setCity( "Beverly Hills");
		addrs.setState("CA");
		addrs.setZipCode("90210");

		UserDetails response = new UserDetails();
		response.setName("Paul");
		response.setCity("Beverly Hills");
		response.setHomeAddress(addrs);

		return new JAXBSource(jc, new ObjectFactory().createUserDetailsDocument(response));
	}
}
