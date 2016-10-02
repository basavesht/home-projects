package com.tcs.sample.rpcstyle.client;

import com.tcs.sample.rpcstyle.endpointimplementation.HelloWorld;
import com.tcs.sample.rpcstyle.endpointimplementation.HelloWorldImplService;

public class HelloWorldClient{
 
	public static void main(String[] args) {
		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld hello = helloService.getHelloWorldImplPort();
		System.out.println("\n"+hello.getHelloWorldAsString("Basavesh"));	
		//After publishing the web-service, run this command to generate the client side artifacts...  
        //wsimport -s "D:\MorganStanley\MS-Transfers Workspace\Sample WS-Client\src" http://localhost:8001/ws/hello?wsdl
    }
}