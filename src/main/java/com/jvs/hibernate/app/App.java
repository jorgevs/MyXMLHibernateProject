package com.jvs.hibernate.app;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jvs.hibernate.config.HibernateUtil;
import com.jvs.hibernate.entity.Item;
import com.jvs.hibernate.entity.Order;

public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		
		Order order = new Order("SILVIA VAZQUEZ");		
				
		Item item = new Item("Cajas");
		item.setPrice(15.22d);		
		
		Item item2 = new Item("Hojas");
		item2.setPrice(33.31d);
		
		Item item3 = new Item("Relojes");
		item3.setPrice(12.11d);
		
		List<Item> listItem = order.getItems();
		listItem.add(item);
		listItem.add(item2);
		listItem.add(item3);
		
		session.save(order);
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
		
		logger.info("----------------------------------------------------------");
		
		printRelationship_OrderItems();
		
		logger.info("----------------------------------------------------------");
		
		printRelationship_ItemOrder();
		
		logger.info("----------------------------------------------------------");
	}

	public static void printRelationship_OrderItems(){
		Session session = HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		
		List<Order> orderList = session.createQuery("FROM Order").list();
		for (Order o : orderList) {
			logger.info(o.toString());
			List<Item> itemList = o.getItems(); 
			for (Item i : itemList) {
				logger.info("   " + i.toString());	
			}			
		}
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}
	
	public static void printRelationship_ItemOrder(){
		Session session = HibernateUtil.getSession();
		HibernateUtil.beginTransaction();
		
		List<Item> itemList = session.createQuery("FROM Item").list();
		for (Item i : itemList) {
			logger.info(i.toString());
			Order order = i.getOrder();	
			logger.info("   " + order.toString());				
		}
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}	
	
}
