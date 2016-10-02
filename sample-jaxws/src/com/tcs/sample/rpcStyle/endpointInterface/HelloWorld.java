/**
 * 
 */
package com.tcs.sample.rpcStyle.endpointInterface;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@HandlerChain(file = "..\\..\\..\\..\\..\\handler-chain.xml")
@WebService
@SOAPBinding(style = Style.RPC)
public interface HelloWorld {
	@WebMethod 
	String getHelloWorldAsString(String name);
}
