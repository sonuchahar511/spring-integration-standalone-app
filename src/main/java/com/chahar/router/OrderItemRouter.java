package com.chahar.router;

import com.chahar.domain.Book;
import com.chahar.domain.MusicCD;
import com.chahar.domain.OrderItem;
import com.chahar.domain.Software;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 * Performs routing based on item type.
 * Will redirect 
 * 				to bookItemsChannel if the item is of type book
 * 				to musicItemsChannel if the item is of type musicCD
 * 				to softwareItemsChannel if the item is of type software
 * 
 * @author SonuChahar
 *
 */
public class OrderItemRouter {

//	private static final Logger log = LogManager.getLogger(OrderItemRouter.class);
	private static final Logger log = Logger.getLogger(OrderItemRouter.class);

	public String routeOrder(OrderItem orderItem) {
		
		log.debug("*** [OrderItemRouter] ****");

		String channel = "";
		if(isBook(orderItem)) {
			channel = "bookItemsChannel";
		}
		else if(isMusic(orderItem)) {
			channel = "musicItemsChannel";
		}
		else if(isSoftware(orderItem)) {
			channel = "softwareItemsChannel";
		}

		log.debug("*** [OrderItemRouter] sending item : " + orderItem.getItem().getTitle() + " to "+ channel +  " ****");

		return channel;
   }
	
	private Boolean isBook(OrderItem orderItem) {
		return orderItem.getItem() instanceof Book;			
	}
	private Boolean isMusic(OrderItem orderItem) {
		return orderItem.getItem() instanceof MusicCD;			
	}
	private Boolean isSoftware(OrderItem orderItem) {
		return orderItem.getItem() instanceof Software;			
	}
}
