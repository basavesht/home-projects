/**
 * 
 */
package com.tcs.sample.documentStyle.endpointInterface;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.tcs.sample.model.UserAccount;
import com.tcs.sample.model.UserDetails;
import com.tcs.sample.model.UserResponse;

@HandlerChain(file = "..\\..\\..\\..\\..\\handler-chain.xml")
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //Default..
public interface HelloWorld {
	@WebMethod 
	String getHelloWorldAsString(@WebParam(name="userName") String name);

	@WebMethod 
	UserResponse getHelloWorldAsObject(@WebParam(name="userDetails")UserDetails usrDtls,@WebParam(name="userAccount")UserAccount usrAcnt);
}
