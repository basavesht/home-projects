package com.tcs.sample.rpcStyle.endpointImplementation;

import javax.jws.WebService;

import com.tcs.sample.rpcStyle.endpointInterface.HelloWorld;

@WebService(endpointInterface = "com.tcs.sample.rpcStyle.endpointInterface.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {
		return "JAX-WS SOAP RPC Style Implementation of HelloWorld (Top-Bottom approach)" + name;
	}
}