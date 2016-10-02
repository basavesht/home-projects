
package com.tcs.sample.documentstyle.endpointinterface;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getHelloWorldAsObject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getHelloWorldAsObject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userDetails" type="{http://endpointInterface.documentStyle.sample.tcs.com/}userDetails" minOccurs="0"/>
 *         &lt;element name="userAccount" type="{http://endpointInterface.documentStyle.sample.tcs.com/}userAccount" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getHelloWorldAsObject", propOrder = {
    "userDetails",
    "userAccount"
})
public class GetHelloWorldAsObject {

    protected UserDetails userDetails;
    protected UserAccount userAccount;

    /**
     * Gets the value of the userDetails property.
     * 
     * @return
     *     possible object is
     *     {@link UserDetails }
     *     
     */
    public UserDetails getUserDetails() {
        return userDetails;
    }

    /**
     * Sets the value of the userDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserDetails }
     *     
     */
    public void setUserDetails(UserDetails value) {
        this.userDetails = value;
    }

    /**
     * Gets the value of the userAccount property.
     * 
     * @return
     *     possible object is
     *     {@link UserAccount }
     *     
     */
    public UserAccount getUserAccount() {
        return userAccount;
    }

    /**
     * Sets the value of the userAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserAccount }
     *     
     */
    public void setUserAccount(UserAccount value) {
        this.userAccount = value;
    }

}
