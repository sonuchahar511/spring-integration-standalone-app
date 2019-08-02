package com.chahar.gateway;

import org.springframework.integration.annotation.Gateway;

import com.chahar.domain.Order;

/**
 * Gateway interface. Provides facade to clients of the process pipeline
 * Will place all Orders into the 'orders' channel
 * 
 * @author SonuChahar
 *
 */
public interface ShopGateway {

	@Gateway(requestChannel="ordersChannel")
	void placeOrder(Order order);

}