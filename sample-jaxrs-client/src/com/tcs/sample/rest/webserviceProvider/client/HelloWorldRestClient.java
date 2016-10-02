package com.tcs.sample.rest.webserviceProvider.client;

import java.io.StringReader;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

public class HelloWorldRestClient
{
	private Service service;
	private static final String url = "http://localhost:8003/hello/world";
	private static final QName qname = new QName("", "");
	private static final String inputXML = "<tns:UserDetailsDocument xmlns:tns=\"urn:UserDetailsDocument\">\n" +
			"<homeAddress>\n" +
			"<street>1 Main Street</street>\n" +
			"<city>Beverly Hills</city>\n" +
			"<state>CA</state>\n" +
			"<zipCode>90210</zipCode>\n" +
			"</homeAddress>\n" +
			"<name>Paul</name>\n" +
			"<city>Beverly Hills</city>\n" +
			"</tns:UserDetailsDocument>";

	public static void main(String[] args) {
		HelloWorldRestClient restClient = new HelloWorldRestClient();
		restClient.getRequest();
		restClient.postRequest();
	}

	//GET the request...
	public void getRequest() {
		try 
		{
			service = Service.create(qname);
			service.addPort(qname, HTTPBinding.HTTP_BINDING, url + "ABC");
			Dispatch<Source> dispatcher = service.createDispatch(qname, Source.class, Service.Mode.PAYLOAD);
			Map<String, Object> requestContext = dispatcher.getRequestContext();
			requestContext.put(MessageContext.HTTP_REQUEST_METHOD, "GET");
			Source result = dispatcher.invoke(null);
			printSource(result);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	//POST the request...
	public void postRequest() {
		try 
		{
			service = Service.create(qname);
			service.addPort(qname, HTTPBinding.HTTP_BINDING, url);
			Dispatch<Source> dispatcher = service.createDispatch(qname, Source.class, Service.Mode.MESSAGE);
			Map<String, Object> requestContext = dispatcher.getRequestContext();
			requestContext.put(MessageContext.HTTP_REQUEST_METHOD, "POST");
			Source result = dispatcher.invoke(new StreamSource(new StringReader(inputXML)));
			printSource(result);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  void printSource(Source s) {
		try 
		{
			System.out.println("============================= Response Received =========================================");
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.transform(s, new StreamResult(System.out));
			System.out.println("\n======================================================================");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
