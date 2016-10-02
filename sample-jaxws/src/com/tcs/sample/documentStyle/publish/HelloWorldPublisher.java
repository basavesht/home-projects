package com.tcs.sample.documentStyle.publish;

import javax.xml.ws.Endpoint;

import com.tcs.sample.documentStyle.endpointImplementation.HelloWorldImpl;


public class HelloWorldPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8002/ws/hello", new HelloWorldImpl());
	}

	//Generate JAX-WS artifacts for document style aritfacts...
	//wsgen -wsdl -s D:\test\ -cp D:\test com.tcs.sample.documentStyle.endpointImplementation.HelloWorldImpl -verbose -d d:/test/
}
