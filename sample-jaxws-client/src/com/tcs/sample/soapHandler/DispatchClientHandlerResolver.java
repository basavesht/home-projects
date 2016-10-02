/**
 * 
 */
package com.tcs.sample.soapHandler;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

/**
 * @author 224703
 *
 */
public class DispatchClientHandlerResolver implements HandlerResolver {

	public List<Handler> getHandlerChain(PortInfo portInfo) 
	{
		//Create a list of handler to be invoked... 
		List<Handler> handlerChain = new ArrayList<Handler>();
		SampleDispatchClientSoapHandler authHandler = new SampleDispatchClientSoapHandler();

		QName serviceName = portInfo.getServiceName();
		QName portName = portInfo.getPortName();
		String bindingID = portInfo.getBindingID();

		if (serviceName.getNamespaceURI().equals(
				"http://endpointImplementation.documentStyle.sample.tcs.com/")
				&& serviceName.getLocalPart().equalsIgnoreCase("HelloWorldImplService")) {
			handlerChain.add(authHandler);
		}
		return handlerChain;
	}
}

