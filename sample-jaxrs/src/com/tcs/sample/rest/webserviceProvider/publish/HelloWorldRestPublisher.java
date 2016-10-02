package com.tcs.sample.rest.webserviceProvider.publish;

import javax.xml.ws.Endpoint;
import javax.xml.ws.http.HTTPBinding;

import com.tcs.sample.rest.webserviceProvider.provider.HelloWorldProvider;

public class HelloWorldRestPublisher {
	public static void main(String args[]) {
		Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING,
				new HelloWorldProvider());
		e.publish("http://localhost:8003/hello/world");
	}
}
