package com.tcs.sample.rpcStyle.publish;

import javax.xml.ws.Endpoint;

import com.tcs.sample.rpcStyle.endpointImplementation.HelloWorldImpl;

public class HelloWorldPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8001/ws/hello", new HelloWorldImpl());
		//No Artifacts are required for the RPC style web-service soap.
	}
}
