package com.Ravi.sprintbootRavi;

import java.time.LocalDate;

public class OrderData {

	private int order_id;
	private int customer_id;
	private String status;
	private int salesman_id;
	private LocalDate order_Date;
	@Override
	public String toString() {
		return "OrderData [order_id=" + order_id + ", customer_id=" + customer_id + ", status=" + status
				+ ", salesman_id=" + salesman_id + ", order_Date=" + order_Date + "]";
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSalesman_id() {
		return salesman_id;
	}
	public void setSalesman_id(int salesman_id) {
		this.salesman_id = salesman_id;
	}
	public LocalDate getOrder_Date() {
		return order_Date;
	}
	public void setOrder_Date(LocalDate order_Date) {
		this.order_Date = order_Date;
	}
	
	
	
	
}


