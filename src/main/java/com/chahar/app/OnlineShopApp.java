package com.chahar.app;

import com.chahar.domain.*;
import com.chahar.gateway.ShopGateway;
import org.apache.log4j.Logger;
//import org.springframework.context.Lifecycle;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 * Main class to invoke 
 * @author SonuChahar
 *
 */
public class OnlineShopApp {

//	private static final Logger log = LogManager.getLogger(OnlineShop.class);
	private static final Logger log = Logger.getLogger(OnlineShopApp.class);
	public static void main(String[] args) {

		//Get hold of spring context
		AbstractApplicationContext context =
			new ClassPathXmlApplicationContext("/shop.xml", OnlineShopApp.class);

		//Inject in Shop instance (Gateway)
		ShopGateway shop = (ShopGateway) context.getBean("shop");
		
		final Order order = createOrder();
		
		
		log.debug("*** [OnlineShop] ****");
		shop.placeOrder(order);

		context.registerShutdownHook();
		context.close();

	}

	/*
	 * Create a dummy order
	 */
	private static Order createOrder() {
		Book book = new Book("Mechanics", "Nutan", new BigDecimal("300"), 1991, "D.C.Pandey");
		MusicCD cd = new MusicCD("Off the Wall", "publisher", new BigDecimal("100"), 1975, "Michael Jackson");
		Software macos = new Software("Mavericks1", "publisher", new BigDecimal("100"), 2014, "10.9.3");
		
		OrderItem bookItems = new OrderItem(book);
//		bookItems.incrementQuantity();
		
		OrderItem cdItems = new OrderItem(cd);
//		cdItems.incrementQuantity();
//		cdItems.incrementQuantity();
		
		OrderItem swItems = new OrderItem(macos);
		
		final List<OrderItem> orderItems = new ArrayList<OrderItem>();
		orderItems.add(bookItems);
		orderItems.add(cdItems);
		orderItems.add(swItems);
		
		Order order = new Order();
		order.setOrderItems(orderItems);
		log.debug("Order: " + order);
//		log.debug("Total : "+ order.getTotalCost());

		return order;
	}
}


