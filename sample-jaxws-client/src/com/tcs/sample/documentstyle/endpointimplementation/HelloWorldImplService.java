
package com.tcs.sample.documentstyle.endpointimplementation;

import java.net.MalformedURLException;
import java.net.URL;

import javax.jws.HandlerChain;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;


/**
 * This class was generated by the JAXWS SI.
 * JAX-WS RI 2.0_02-b08-fcs
 * Generated source version: 2.0
 * 
 */
@HandlerChain(file = "..\\..\\..\\..\\..\\handler-chain.xml")
@WebServiceClient(name = "HelloWorldImplService", targetNamespace = "http://endpointImplementation.documentStyle.sample.tcs.com/", wsdlLocation = "http://localhost:8002/ws/hello?wsdl")
public class HelloWorldImplService
    extends Service
{

    private final static URL HELLOWORLDIMPLSERVICE_WSDL_LOCATION;

    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8002/ws/hello?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HELLOWORLDIMPLSERVICE_WSDL_LOCATION = url;
    }

    public HelloWorldImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWorldImplService() {
        super(HELLOWORLDIMPLSERVICE_WSDL_LOCATION, new QName("http://endpointImplementation.documentStyle.sample.tcs.com/", "HelloWorldImplService"));
    }

    /**
     * 
     * @return
     *     returns HelloWorld
     */
    @WebEndpoint(name = "HelloWorldImplPort")
    public HelloWorld getHelloWorldImplPort() {
        return (HelloWorld)super.getPort(new QName("http://endpointImplementation.documentStyle.sample.tcs.com/", "HelloWorldImplPort"), HelloWorld.class);
    }

}
