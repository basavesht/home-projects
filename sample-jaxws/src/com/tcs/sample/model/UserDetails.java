package com.tcs.sample.model;

import java.io.Serializable;

public class UserDetails implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6433586089016316962L;
	private String name = null;
	private String address = null;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
		final String TAB = "    ";

		String retValue = "";

		retValue = "UserDetails ( "
				+ super.toString() + TAB
				+ "name = " + this.name + TAB
				+ "address = " + this.address + TAB
				+ " )";

		return retValue;
	}

}
