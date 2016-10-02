
package com.tcs.sample.documentStyle.endpointInterface.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getHelloWorldAsObject", namespace = "http://endpointInterface.documentStyle.sample.tcs.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getHelloWorldAsObject", namespace = "http://endpointInterface.documentStyle.sample.tcs.com/", propOrder = {
    "userDetails",
    "userAccount"
})
public class GetHelloWorldAsObject {

    @XmlElement(name = "userDetails", namespace = "")
    private com.tcs.sample.model.UserDetails userDetails;
    @XmlElement(name = "userAccount", namespace = "")
    private com.tcs.sample.model.UserAccount userAccount;

    /**
     * 
     * @return
     *     returns UserDetails
     */
    public com.tcs.sample.model.UserDetails getUserDetails() {
        return this.userDetails;
    }

    /**
     * 
     * @param userDetails
     *     the value for the userDetails property
     */
    public void setUserDetails(com.tcs.sample.model.UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    /**
     * 
     * @return
     *     returns UserAccount
     */
    public com.tcs.sample.model.UserAccount getUserAccount() {
        return this.userAccount;
    }

    /**
     * 
     * @param userAccount
     *     the value for the userAccount property
     */
    public void setUserAccount(com.tcs.sample.model.UserAccount userAccount) {
        this.userAccount = userAccount;
    }

}
