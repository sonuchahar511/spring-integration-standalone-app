package com.chahar.aggregator;

import com.chahar.domain.Order;
import com.chahar.domain.OrderItem;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Receives the collection of order items that have been processed
 * for the discount reduction.
 * 
 * @author SonuChahar
 *
 */
public class OrderCompleter {
	
//	private static final Logger log = LogManager.getLogger(OrderCompleter.class);
	private static final Logger log = Logger.getLogger(OrderCompleter.class);
	public Order prepareDelivery(List<OrderItem> orderItems) {
		final Order order = new Order();
		order.setOrderItems(orderItems);
		
//		log.debug("*** [OrderCompleter] CompletedOrder : "
//		+ order +" ****");

		log.debug("*** [OrderCompleter] CompletedOrder Discounted cost: "
		+ order.getTotalDiscountedCost() +" ****");

		return order;
	}
}
