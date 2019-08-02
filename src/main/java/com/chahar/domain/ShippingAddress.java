package com.chahar.domain;

import java.io.Serializable;

/**
 * Class to represent Shipping Address
 * @author SonuChahar
 *
 */
public class ShippingAddress extends Address implements Serializable{

	private static final long serialVersionUID = 9L;
	
	public ShippingAddress() {
		type = AddressType.SHIPPING_ADDRESS;		
	}
	
	public ShippingAddress(final String firstLineOfAddress, final String city, final String postCode) {		
		super(firstLineOfAddress, city, postCode);
		type = AddressType.SHIPPING_ADDRESS;
	}	

}
