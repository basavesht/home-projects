package com.tcs.sample.model;

import java.io.Serializable;

public class UserResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg = null;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
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
	    
	    retValue = "UserResponse ( "
	        + super.toString() + TAB
	        + "msg = " + this.msg + TAB
	        + " )";
	
	    return retValue;
	}
}
