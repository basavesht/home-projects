
package com.tcs.sample.documentstyle.endpointinterface;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tcs.sample.documentstyle.endpointinterface package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetHelloWorldAsObjectResponse_QNAME = new QName("http://endpointInterface.documentStyle.sample.tcs.com/", "getHelloWorldAsObjectResponse");
    private final static QName _GetHelloWorldAsString_QNAME = new QName("http://endpointInterface.documentStyle.sample.tcs.com/", "getHelloWorldAsString");
    private final static QName _GetHelloWorldAsStringResponse_QNAME = new QName("http://endpointInterface.documentStyle.sample.tcs.com/", "getHelloWorldAsStringResponse");
    private final static QName _GetHelloWorldAsObject_QNAME = new QName("http://endpointInterface.documentStyle.sample.tcs.com/", "getHelloWorldAsObject");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tcs.sample.documentstyle.endpointinterface
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHelloWorldAsObjectResponse }
     * 
     */
    public GetHelloWorldAsObjectResponse createGetHelloWorldAsObjectResponse() {
        return new GetHelloWorldAsObjectResponse();
    }

    /**
     * Create an instance of {@link GetHelloWorldAsStringResponse }
     * 
     */
    public GetHelloWorldAsStringResponse createGetHelloWorldAsStringResponse() {
        return new GetHelloWorldAsStringResponse();
    }

    /**
     * Create an instance of {@link UserDetails }
     * 
     */
    public UserDetails createUserDetails() {
        return new UserDetails();
    }

    /**
     * Create an instance of {@link GetHelloWorldAsObject }
     * 
     */
    public GetHelloWorldAsObject createGetHelloWorldAsObject() {
        return new GetHelloWorldAsObject();
    }

    /**
     * Create an instance of {@link UserAccount }
     * 
     */
    public UserAccount createUserAccount() {
        return new UserAccount();
    }

    /**
     * Create an instance of {@link UserResponse }
     * 
     */
    public UserResponse createUserResponse() {
        return new UserResponse();
    }

    /**
     * Create an instance of {@link GetHelloWorldAsString }
     * 
     */
    public GetHelloWorldAsString createGetHelloWorldAsString() {
        return new GetHelloWorldAsString();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHelloWorldAsObjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpointInterface.documentStyle.sample.tcs.com/", name = "getHelloWorldAsObjectResponse")
    public JAXBElement<GetHelloWorldAsObjectResponse> createGetHelloWorldAsObjectResponse(GetHelloWorldAsObjectResponse value) {
        return new JAXBElement<GetHelloWorldAsObjectResponse>(_GetHelloWorldAsObjectResponse_QNAME, GetHelloWorldAsObjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHelloWorldAsString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpointInterface.documentStyle.sample.tcs.com/", name = "getHelloWorldAsString")
    public JAXBElement<GetHelloWorldAsString> createGetHelloWorldAsString(GetHelloWorldAsString value) {
        return new JAXBElement<GetHelloWorldAsString>(_GetHelloWorldAsString_QNAME, GetHelloWorldAsString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHelloWorldAsStringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpointInterface.documentStyle.sample.tcs.com/", name = "getHelloWorldAsStringResponse")
    public JAXBElement<GetHelloWorldAsStringResponse> createGetHelloWorldAsStringResponse(GetHelloWorldAsStringResponse value) {
        return new JAXBElement<GetHelloWorldAsStringResponse>(_GetHelloWorldAsStringResponse_QNAME, GetHelloWorldAsStringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHelloWorldAsObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpointInterface.documentStyle.sample.tcs.com/", name = "getHelloWorldAsObject")
    public JAXBElement<GetHelloWorldAsObject> createGetHelloWorldAsObject(GetHelloWorldAsObject value) {
        return new JAXBElement<GetHelloWorldAsObject>(_GetHelloWorldAsObject_QNAME, GetHelloWorldAsObject.class, null, value);
    }

}
