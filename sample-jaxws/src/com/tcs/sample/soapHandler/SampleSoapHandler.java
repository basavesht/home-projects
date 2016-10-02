package com.tcs.sample.soapHandler;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.ProtocolException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;


public class SampleSoapHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return false;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) 
	{
		System.out.println("SampleSoapHandler : handleMessage()......");
		Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		boolean exit = false;
		try
		{

			if(!isRequest)
			{
				SOAPMessage soapMess = context.getMessage();
				soapMess.writeTo(System.out);
				
				//Get SOAP envelope from SOAP message
				SOAPEnvelope soapEnvelope = context.getMessage().getSOAPPart().getEnvelope();

				//Get the headers from envelope
				SOAPHeader soapHeader = soapEnvelope.getHeader();
				if (soapHeader == null) {
					exit = false;
				} else {
					exit = processSOAPHeader(soapHeader);
				}

				if (exit){
					context.put(AuthenticationHandlerConstants.AUTHN_STAUTS, true);
				} 
				else {
					throw new ProtocolException();
				}		
				context.setScope(AuthenticationHandlerConstants.AUTHN_STAUTS, MessageContext.Scope.APPLICATION);
			}
			else {
				// Get SOAP envelope from SOAP Response message
				SOAPMessage soapMess = context.getMessage();
				soapMess.writeTo(System.out);
				exit = true;
			}
		} 
		catch(SOAPException e){
			System.out.println("SOAPException");
			exit = false;
		} 
		catch(IOException e){
			System.out.println("IOException");
			exit = false;
		}
		catch(ProtocolException e){
			System.out.println("ProtocolException");
			e.printStackTrace();
			throw new ProtocolException();
			
		}
		return exit;
	}

	/*
	 * Processing SOAP Header...
	 */
	private boolean processSOAPHeader(SOAPHeader sh) 
	{
		boolean authenticated = false;
		Iterator<SOAPElement> childElems = sh.getChildElements(new QName(AuthenticationHandlerConstants.AUTHN_URI,AuthenticationHandlerConstants.AUTHN_LNAME));
		SOAPElement child;

		//Iterate through child elements
		while (childElems.hasNext()) {
			child = childElems.next();
			authenticated = processSOAPHeaderInfo(child);
		}
		return authenticated;
	}

	private boolean processSOAPHeaderInfo(SOAPElement e) 
	{
		SOAPElement child;
		QName name;
		String _id = null;
		String _password = null;

		//Get an iterator on child elements of SOAP element
		Iterator<SOAPElement> childElems = e.getChildElements();

		//Loop through child elements
		while (childElems.hasNext()) {
			//Get next child element
			Object elem = childElems.next();
			if (elem instanceof SOAPElement)
			{
				child = (SOAPElement) elem;
				name = (QName) child.getElementQName();

				//Get the value of id element
				if (name.getLocalPart().equals("id")) {
					_id = child.getValue();
				}

				//Get the value of password element
				if (name.getLocalPart().equals("password")) {
					_password = child.getValue();
				}
			}
		}
		return authenticate(_id, _password);
	}

	/*
	 * In reality, we may login to a DATABASE
	 */
	private boolean authenticate(String _id, String _password)
	{
		//Client authentication information
		final String USERID = "ABC";
		final String PASSWORD = "PASSWORD";

		if (USERID.equals(_id) && PASSWORD.equals(_password)) {
			return true;
		} else {
			System.out.println("Could not authenticate ,WRONG id or password");
		}
		return false;
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}
}
