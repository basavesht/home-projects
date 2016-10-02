/**
 * 
 */
package com.tcs.sample.documentstyle.client_dispatch;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPBinding;

import com.tcs.sample.soapHandler.DispatchClientHandlerResolver;

/**
 * @author 224703
 *
 */
public class HelloWorldDispatchClient {

	private final static URL ENDPOINT_ADDRESS;
	static {
		URL url = null;
		try {
			url = new URL("http://localhost:8002/ws/hello");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		ENDPOINT_ADDRESS = url;
	}

	private static final QName SERVICE_NAME = new QName("http://endpointImplementation.documentStyle.sample.tcs.com/", "HelloWorldImplService");
	private static final QName PORT_NAME = new QName("http://endpointImplementation.documentStyle.sample.tcs.com/", "HelloWorldImplPort");

	/**
	 * @param args
	 * @throws SOAPException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws SOAPException, IOException
	{
		try {
			//Invoke Operation 2..
			InvokeGetHelloWorldStr();

			//Invoke Operation 2..
			InvokeGetHelloWorldObject();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Operation 1...
	 * @throws SOAPException
	 */
	public static void InvokeGetHelloWorldStr() throws SOAPException
	{
		try 
		{
			// Qnames for service as defined in wsdl.
			QName serviceName = SERVICE_NAME ;

			//QName for Port As defined in wsdl.
			QName portName = PORT_NAME ;

			//Endpoint Address
			String  endpointAddress = ENDPOINT_ADDRESS.toString();

			// Create a dynamic Service instance and Register the the handler resolver (which invokes the SOAP Handler added to the handler chain).. 
			Service service = Service.create(serviceName);
			service.setHandlerResolver(new DispatchClientHandlerResolver()); 

			//Add a port to the Service
			service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);

			//Create a dispatch instance
			Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);

			//Use Dispatch as BindingProvider
			BindingProvider bp = (BindingProvider) dispatch;

			SOAPMessage request = null;

			// Optionally Configure RequestContext to send SOAPAction HTTP Header
			Map<String, Object> rc = bp.getRequestContext();
			rc.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
			rc.put(BindingProvider.SOAPACTION_URI_PROPERTY, "getHelloWorldAsString");
			rc.put("authn_userid", "ABC");
			rc.put("authn_password", "PASSWORD");

			// Obtain a PreConfigured SAAJ MessageFactory
			MessageFactory factory =((SOAPBinding) bp.getBinding()).getMessageFactory();

			// Create SOAPMessage Request
			request = factory.createMessage();
			SOAPPart soapPart = request.getSOAPPart();

			// Obtain the SOAPEnvelope ..
			SOAPEnvelope soapEnv = soapPart.getEnvelope();

			// Obtain the SOAP Header and Body from the SOAP Message
			SOAPHeader header = soapEnv.getHeader();
			SOAPBody body = soapEnv.getBody();

			// Compose the soap:Body (PAYLOAD) for the operation "getHelloWorldAsString" ...
			QName operation_name = new QName("http://endpointInterface.documentStyle.sample.tcs.com/", "getHelloWorldAsString", "tns");
			SOAPBodyElement payload = body.addBodyElement(operation_name);
			QName username = new QName("userName");
			SOAPElement message = payload.addChildElement(username);
			message.addTextNode("Basavesh");


			SOAPMessage response = null;

			try {
				//Invoke Endpoint Operation and read response
				response = dispatch.invoke(request);
			} catch (WebServiceException wse){
				wse.printStackTrace();
			}

			//Print the response...
			response.writeTo(System.out);

			//Process the response...
			SOAPBody respbody = response.getSOAPBody();
			QName responseName = new QName("http://endpointInterface.documentStyle.sample.tcs.com/", "getHelloWorldAsStringResponse");
			SOAPBodyElement bodyElement = (SOAPBodyElement)respbody.getChildElements(responseName).next();
			SOAPElement respMessage = (SOAPElement)bodyElement.getChildElements().next();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Operation 2...
	 * @throws SOAPException
	 */
	public static void InvokeGetHelloWorldObject() throws SOAPException
	{
		try 
		{
			// Qnames for service as defined in wsdl.
			QName serviceName = SERVICE_NAME ;

			//QName for Port As defined in wsdl.
			QName portName = PORT_NAME ;

			//Endpoint Address
			String  endpointAddress = ENDPOINT_ADDRESS.toString();

			// Create a dynamic Service instance and Register the the handler resolver (which invokes the SOAP Handler added to the handler chain).. 
			Service service = Service.create(serviceName);
			service.setHandlerResolver(new DispatchClientHandlerResolver()); 

			//Add a port to the Service
			service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);

			//Create a dispatch instance
			Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);

			//Use Dispatch as BindingProvider
			BindingProvider bp = (BindingProvider) dispatch;

			SOAPMessage request = null;

			// Optionally Configure RequestContext to send SOAPAction HTTP Header
			Map<String, Object> rc = bp.getRequestContext();
			rc.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
			rc.put(BindingProvider.SOAPACTION_URI_PROPERTY, "getHelloWorldAsObject");
			rc.put("authn_userid", "ABC");
			rc.put("authn_password", "PASSWORD");

			// Obtain a PreConfigured SAAJ MessageFactory
			MessageFactory factory =((SOAPBinding) bp.getBinding()).getMessageFactory();

			// Create SOAPMessage Request
			request = factory.createMessage();
			SOAPPart soapPart = request.getSOAPPart();

			// Obtain the SOAPEnvelope ..
			SOAPEnvelope soapEnv = soapPart.getEnvelope();

			// Obtain the SOAP Header and Body from the SOAP Message
			SOAPHeader header = soapEnv.getHeader();
			SOAPBody body = soapEnv.getBody();

			// Compose the soap:Body (PAYLOAD) for the operation "getHelloWorldAsObject" ...
			QName operation_name = new QName("http://endpointInterface.documentStyle.sample.tcs.com/", "getHelloWorldAsObject", "tns");
			SOAPBodyElement payload = body.addBodyElement(operation_name);

			QName childName = new QName("userDetails");
			SOAPElement userDetails = payload.addChildElement(childName);

			childName = new QName("address");
			SOAPElement address = userDetails.addChildElement(childName);
			address.addTextNode("Bangalore");

			childName = new QName("name");
			SOAPElement name = userDetails.addChildElement(childName);
			name.addTextNode("Basavesh T");

			childName = new QName("userAccount");
			SOAPElement userAccount = payload.addChildElement(childName);

			childName = new QName("acnNumber");
			SOAPElement acnNumber = userAccount.addChildElement(childName);
			acnNumber.addTextNode("Bangalore");

			childName = new QName("balance");
			SOAPElement balance = userAccount.addChildElement(childName);
			balance.addTextNode("1000");


			SOAPMessage response = null;

			try {
				//Invoke Endpoint Operation and read response
				response = dispatch.invoke(request);
			} catch (WebServiceException wse){
				wse.printStackTrace();
			}

			//Print the response...
			response.writeTo(System.out);

			//Process the response...
			SOAPBody respbody = response.getSOAPBody();
			QName responseName = new QName("http://endpointInterface.documentStyle.sample.tcs.com/", "getHelloWorldAsObjectResponse");
			SOAPBodyElement bodyElement = (SOAPBodyElement)respbody.getChildElements(responseName).next();
			SOAPElement respMessage = (SOAPElement)bodyElement.getChildElements().next();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
