package com.tcs.sample.documentstyle.client_proxy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import com.tcs.sample.documentstyle.endpointimplementation.HelloWorld;
import com.tcs.sample.documentstyle.endpointimplementation.HelloWorldImplService;
import com.tcs.sample.documentstyle.endpointinterface.UserAccount;
import com.tcs.sample.documentstyle.endpointinterface.UserDetails;
import com.tcs.sample.documentstyle.endpointinterface.UserResponse;

public class HelloWorldProxyClient {

	private final static URL WSDL_LOC;
	static {
		URL url = null;
		try {
			url = new URL("http://localhost:8002/ws/hello?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		WSDL_LOC = url;
	}

	private static final QName Q_NAME = new QName("http://endpointImplementation.documentStyle.sample.tcs.com/", "HelloWorldImplService");

	public static void main(String[] args) 
	{

		try
		{
			HelloWorldImplService helloService = new HelloWorldImplService(WSDL_LOC,Q_NAME);
			HelloWorld hello = helloService.getHelloWorldImplPort();

			//Authentication Password for web-service ...
			Map<String, Object> requestContext = ((BindingProvider)hello).getRequestContext();
			requestContext.put("authn_userid", "ABC");
			requestContext.put("authn_password", "PASSWORD");

			System.out.println("\n"+ hello.getHelloWorldAsString("Malli"));	

			UserDetails usrDtls = new UserDetails();
			usrDtls.setName("Basavesh T");
			usrDtls.setAddress("Bangalore");

			UserAccount useAccount = new UserAccount();
			useAccount.setAcnNumber("1233444");
			useAccount.setBalance(1000);

			UserResponse response = hello.getHelloWorldAsObject(usrDtls,useAccount);
			System.out.println("\n" + response.getMsg());	

		} 
		catch (Exception e) {
			System.out.println("Error while processing your web-service request...");
			e.printStackTrace();
		}

		/* After publishing the web-service, run this command to generate the client side artifacts...  
		wsimport -s "D:\MorganStanley\MS-Transfers Workspace\Sample WS-Client\src" http://localhost:8001/ws/hello?wsdl
		wsimport -s "D:\MorganStanley\MS-Transfers Workspace\Sample WS-Client\src" d:/test/HelloWorldImpl.wsdl
		 */
	}
}
