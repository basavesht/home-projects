package com.tcs.sample.documentStyle.endpointImplementation;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.tcs.sample.documentStyle.endpointInterface.HelloWorld;
import com.tcs.sample.model.UserAccount;
import com.tcs.sample.model.UserDetails;
import com.tcs.sample.model.UserResponse;
import com.tcs.sample.soapHandler.AuthenticationHandlerConstants;

@WebService(endpointInterface = "com.tcs.sample.documentStyle.endpointInterface.HelloWorld")
public class HelloWorldImpl implements HelloWorld 
{
	@Resource
	WebServiceContext wsContext;

	@Override
	public String getHelloWorldAsString(String name) {
		return "JAX-WS SOAP Document Style Implementation of HelloWorld (Top-Bottom approach)" + name;
	}

	@Override
	public UserResponse getHelloWorldAsObject(UserDetails userDetails,UserAccount userAccount)
	{
		MessageContext context = wsContext.getMessageContext();
		UserResponse userResponse = new UserResponse();
		Boolean auth_status = (Boolean)context.get(AuthenticationHandlerConstants.AUTHN_STAUTS);
		if(auth_status!=null && auth_status) {
			userResponse.setMsg(userDetails.getName()+ " \nBalance :  " + userAccount.getBalance().toString());
		}
		else {
			userResponse.setMsg("Unauthorised Access");
		}
		return userResponse;
	}
}