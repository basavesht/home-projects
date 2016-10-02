package com.tcs.sample.model;

import java.io.Serializable;

public class UserAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4060773013811872531L;
	private String acnNumber = null;
	private Integer balance = null;
	public String getAcnNumber() {
		return acnNumber;
	}
	public void setAcnNumber(String acnNumber) {
		this.acnNumber = acnNumber;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
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
		final String TAB = "\r\n";

		String retValue = "";

		retValue = "UserAccount ( "
				+ super.toString() + TAB
				+ "acnNumber = " + this.acnNumber + TAB
				+ "balance = " + this.balance + TAB
				+ " )";

		return retValue;
	}

}
