package com.chahar.splitter;

import com.chahar.domain.Order;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;

/**
 * Splits an Order into it's constituent OrderItems
 * 
 * @author SonuChahar
 *
 */
public class OrderSplitter extends AbstractMessageSplitter{

//	private static final Logger log = LogManager.getLogger(OrderSplitter.class);
	private static final Logger log = Logger.getLogger(OrderSplitter.class);

	@Override
	protected Object splitMessage(Message<?> message) {
	
//		log.debug("*** [OrderSplitter] ****");

		log.debug("*** [OrderSplitter] splitting Order into it's constituent OrderItems : number of OrderItems: "+ ((Order)message.getPayload()).getOrderItems().size() + " ****");

		return ((Order)message.getPayload()).getOrderItems();
	}

}
