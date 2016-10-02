package com.tcs.sample.soapHandler;

import java.util.Set;

import javax.xml.namespace.QName;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;


public class SampleSoapFaultHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * The Method is invoked if there are any Runtime or Protocol exception thrown from the preceding handler.
	 * @see javax.xml.ws.handler.Handler#handleFault(javax.xml.ws.handler.MessageContext)
	 */
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("Handle fault of the Server side handler...");
		try {
			pushSOAPFaultMessage(context.getMessage(),"Fault Message .... ");
		} 
		catch (Exception e) {

		} 
		return false;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) 
	{
		System.out.println("SampleSoapFaultHandler : handleMessage()......");
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	//SOAP Fault Handling..
	private void pushSOAPFaultMessage(SOAPMessage msg, String reason) throws SOAPException 
	{
		try 
		{
			//Push the SOAP Fault Message...
			SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
			SOAPFault soapFault = soapBody.getFault();
			soapFault.setFaultString(reason);
		}
		catch(SOAPException e) { 
			throw e;
		}
	}
}
