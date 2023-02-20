package com.Ravi.sprintbootRavi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
	@Autowired
	OrderDataBaseCon db;
	
	 @GetMapping("/order/{id}")
	 public  OrderData getOrder(@PathVariable int id) {
	    
	    return db.getOrder(id);
	  }
	 
	 @GetMapping("/orders")
	 public  List<OrderData> getOrder() {
	    
	    return db.getOrders();
	  }
	 
	 @PutMapping("/order")
public int updateOrder(@RequestBody OrderData OD) {
		 
		 System.out.println(OD.toString());
		return db.updateOrder(OD);
	 }
	 
	 @PostMapping("/order")
	 public int createOrder(@RequestBody OrderData OD) {
	 		 
	 		 System.out.println(OD.toString());
	 		return db.insertOrder(OD);
	 	 }
	 
	 @DeleteMapping("/order/{order_id}")
	 public int deleteOrder(@PathVariable int order_id) {
	 		 
	 	
	 		return db.deleteOrder(order_id);
	 	 }
	 
	 @PostMapping("/orders")
	 public int createOrders(@RequestBody List<OrderData> OD) { 		 
	 		return db.insertOrders(OD);
	 	 }
}


