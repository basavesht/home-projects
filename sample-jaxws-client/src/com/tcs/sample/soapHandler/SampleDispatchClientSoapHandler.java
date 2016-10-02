package com.tcs.sample.soapHandler;

import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SampleDispatchClientSoapHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean handleFault(SOAPMessageContext context)
	{
		System.out.println("Handle fault of the client side..");
		Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		try {
			validateSOAPErrMessage(context.getMessage(),isRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) 
	{
		System.out.println("Client (WS-Response) : handleMessage()......");
		Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		try
		{
			if(isRequest) //OutBound Message ...
			{

				/* add a header with the authentication info into the SOAP
				 * message:
				 * 
				 * <env:Header> <nsAuthen:authnHeader
				 * xmlns:nsAuthn="http://cardservice.handler.jaxws.company.com/authn">
				 * <nsAuthn:id>ABC</nsAuthn:id> <nsAuthn:password>PASSWORD</nsAuthn:password>
				 * </nsAuthn:authnHeader> </env:Header>
				 * */


				//UserId/Password passed from the client...
				String USERID = (String) context.get(AuthenticationHandlerConstants.REQUEST_USERID);
				String PASSWORD = (String) context.get(AuthenticationHandlerConstants.REQUEST_PASSWORD);

				// Get SOAP envelope from SOAP message
				SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();

				//Create instance of SOAP factory
				SOAPFactory soapFactory = SOAPFactory.newInstance();

				//Create SOAP Authentication elements specifying prefix and URI
				SOAPElement authenticationElm = soapFactory.createElement(AuthenticationHandlerConstants.AUTHN_LNAME,AuthenticationHandlerConstants.AUTHN_PREFIX,AuthenticationHandlerConstants.AUTHN_URI);

				//Create and Attach value to UserId element
				SOAPElement userIdElm = soapFactory.createElement("id",AuthenticationHandlerConstants.AUTHN_PREFIX,AuthenticationHandlerConstants.AUTHN_URI);
				userIdElm.addTextNode(USERID);

				//Create and Attach value to Password element
				SOAPElement passwdElm = soapFactory.createElement("password",AuthenticationHandlerConstants.AUTHN_PREFIX,AuthenticationHandlerConstants.AUTHN_URI);
				passwdElm.addTextNode(PASSWORD);

				//Add child elements to the root element (Authentication element)...
				authenticationElm.addChildElement(userIdElm);
				authenticationElm.addChildElement(passwdElm);

				//Create SOAPHeader instance for SOAP envelope
				SOAPHeader soapHeader = envelope.getHeader();

				// add SOAP element for header to SOAP header object
				soapHeader.addChildElement(authenticationElm);
			} 
			else { //In-bound Message...
				// Get SOAP envelope from SOAP Response message
				SOAPMessage soapMess = context.getMessage();
				soapMess.writeTo(System.out);
			}
		}
		catch(SOAPException e){
			//System.err.println(e);
		} 
		catch(IOException e){
			//System.err.println(e);
		}

		//continue other handler chain
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	//SOAP Fault Handling..
	private void validateSOAPErrMessage(SOAPMessage msg,Boolean msgOutBound) throws IOException 
	{
		try {
			if(!msgOutBound) //InBound Message ...
			{
				System.out.println("Fault SOAP Response");
				msg.writeTo(System.out);

				//Fault response extraction...
				SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
				SOAPFault soapFault = soapBody.getFault();
				System.out.println("\r\n Fault Reason recieved in the response..." + soapFault.getFaultString());
			}
		}
		catch(SOAPException e) { 

		}
	}

}
