
package com.tcs.sample.documentStyle.endpointInterface.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getHelloWorldAsObjectResponse", namespace = "http://endpointInterface.documentStyle.sample.tcs.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getHelloWorldAsObjectResponse", namespace = "http://endpointInterface.documentStyle.sample.tcs.com/")
public class GetHelloWorldAsObjectResponse {

    @XmlElement(name = "return", namespace = "")
    private com.tcs.sample.model.UserResponse _return;

    /**
     * 
     * @return
     *     returns UserResponse
     */
    public com.tcs.sample.model.UserResponse get_return() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void set_return(com.tcs.sample.model.UserResponse _return) {
        this._return = _return;
    }

}
