//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.01.02 at 06:48:09 PM IST 
//


package com.tcs.sample.rest.webserviceProvider.stubs.userdetailsdocument;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="homeAddress" type="{urn:UserDetailsDocument}Address"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserDetails", propOrder = {
		"homeAddress",
		"name",
		"city"
})
public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2867662971746285869L;
	@XmlElement(required = true)
	protected Address homeAddress;
	@XmlElement(required = true)
	protected String name;
	@XmlElement(required = true)
	protected String city;

	/**
	 * Gets the value of the homeAddress property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Address }
	 *     
	 */
	public Address getHomeAddress() {
		return homeAddress;
	}

	/**
	 * Sets the value of the homeAddress property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Address }
	 *     
	 */
	public void setHomeAddress(Address value) {
		this.homeAddress = value;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the city property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the value of the city property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public void setCity(String value) {
		this.city = value;
	}
}